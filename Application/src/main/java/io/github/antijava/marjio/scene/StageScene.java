package io.github.antijava.marjio.scene;

import io.github.antijava.marjio.common.IApplication;
import io.github.antijava.marjio.common.IClient;
import io.github.antijava.marjio.common.IInput;
import io.github.antijava.marjio.common.IServer;
import io.github.antijava.marjio.common.graphics.Rectangle;
import io.github.antijava.marjio.common.input.Key;
import io.github.antijava.marjio.common.input.Status;
import io.github.antijava.marjio.constant.SceneObjectConstant;
import io.github.antijava.marjio.network.StatusData;
import io.github.antijava.marjio.scene.sceneObject.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created by Zheng-Yuan on 12/27/2015.
 */
public class StageScene extends SceneBase {
    private final static int START_GAME_COUNTER = 5;
    private int mStartGameCounter;
    private SceneMap mMap;
    UUID mYourPlayerID;
    Map<UUID, Player> mPlayers;

    boolean mIsServer;

    public StageScene(IApplication application, int stage) {
        super(application);
        mMap = new SceneMap(application, stage);
        mStartGameCounter = START_GAME_COUNTER;
    }

    @Override
    public void update() {
        super.update();

        if (mStartGameCounter-- > 0) {
            // TODO: Draw counter on the graphics.
            return ;
        }

        mPlayers.values().forEach(Player::preUpdate);

        checkKeyState();
        checkStatus();
        solveBumps();

        mPlayers.values().forEach(Player::update);

        if (!mIsServer) {
            IClient client = getApplication().getClient();
            StatusData data = mPlayers.get(mYourPlayerID).getStatusData();

            try {
                client.send(new Status(data, Status.Type.ClientMessage));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<Status> getValidStatuses() {
        return getApplication()
                .getInput()
                .getStatuses()
                .stream()
                .filter(st -> st.getData() instanceof StatusData &&
                        mPlayers.containsKey(((StatusData)st.getData()).uuid))
                .collect(Collectors.toList());
    }

    public void checkStatus () {
        List<Status> fetchedStatus = getValidStatuses();
        final IServer server = getApplication().getServer();

        for (Status st : fetchedStatus) {
            StatusData data = (StatusData) st.getData();
            Player player = mPlayers.get(data.uuid);

            switch (st.getType()) {
                case ClientMessage: {
                    if (mIsServer) {
                        if (player.isValidData(data)) {
                            player.preUpdateStatusData(data);

                            final Status new_st = new Status(data,
                                    Status.Type.ServerMessage);

                            if (mIsServer) {
                                try {
                                    server.broadcast(new_st);

                                } catch (Exception ex) {

                                }
                            }

                        } else {
                            data = player.getStatusData();
                            data.query = false;
                            final Status new_st = new Status(data,
                                    Status.Type.ServerVerification);

                            // TODO: Server send to client verify message

                            /*try {
                                server.send(new_st, player.getId());

                            } case (Exception ex) {

                            }*/
                        }
                    }
                    break;
                }

                case ServerMessage: {
                    if (data.uuid != mYourPlayerID)
                        player.preUpdateStatusData(data);

                    break;
                }

                case ServerVerification: {
                    if (!data.query)
                        player.preUpdateStatusData(data);

                    break;
                }

            }

        }
    }

    private void checkKeyState() {
        IInput input = getApplication().getInput();

        Player player = mPlayers.get(mYourPlayerID);

        if (input.isPressed(Key.MOVE_LEFT))
            player.addAccelerationX(-0.05);

        else if (input.isRepeat(Key.MOVE_LEFT))
            player.addAccelerationX(-PhysicsConstant.friction + 0.05);

        else if (input.isReleased(Key.MOVE_LEFT))
            player.setAccelerationX(0.0);


        if (input.isPressed(Key.MOVE_RIGHT))
            player.addAccelerationX(0.05);

        else if (input.isRepeat(Key.MOVE_RIGHT))
            player.addAccelerationX(PhysicsConstant.friction - 0.05);

        else if (input.isReleased(Key.MOVE_RIGHT))
            player.setAccelerationX(0.0);


        if (input.isPressed(Key.JUMP))
            player.setVelocityY(-5.0);


    }

    private void solveBumps() {
        for (Player player : mPlayers.values()) {
            Block block = mMap.getBlock(
                    player.getY() / SceneObjectConstant.BLOCK_SIZE + 1,
                    player.getX() / SceneObjectConstant.BLOCK_SIZE);

            // prevent gravity problem
            if (block.getType() != Block.Type.AIR)
                player.setVelocityY(0.0);

            solveBumpBlock(player);
        }

        //TODO: Elastic collision for each player
        


    }

    private void solveBumpBlock (Player player) {
        List<Block> entityBlocks = mMap.getAdjacentBlocks(player).stream()
                .filter(block -> block.getType() != Block.Type.AIR)
                .collect(Collectors.toList());

        for (Block b : entityBlocks)
            if (bumpTest(player.getOccupiedSpace(), b.getOccupiedSpace())) {
                //TODO: setup reflect direction
            }

    }

    public boolean checkBump(Player player) {
        List<Block> entityBlocks = mMap.getAdjacentBlocks(player).stream()
                .filter(block -> block.getType() != Block.Type.AIR)
                .collect(Collectors.toList());

        final List<SceneObjectObjectBase> objects = new ArrayList<>();
        objects.addAll(entityBlocks);
        objects.addAll(mPlayers.values());
        objects.remove(player);

        for (SceneObjectObjectBase object: objects) {
            if (bumpTest(player.getOccupiedSpace(), object.getOccupiedSpace())) {
                return true;
            }
        }
        return false;
    }

    public static boolean bumpTest(Rectangle a, Rectangle b) {
        return isInsideRectangle(a.x, a.y, b) ||
                isInsideRectangle(a.x, a.y - a.height, b) ||
                isInsideRectangle(a.x + a.width, a.y, b) ||
                isInsideRectangle(a.x + a.width, a.y - a.height, b);
    }

    public static boolean isInsideRectangle(int x, int y, Rectangle rect) {
        return x > rect.x && x < rect.x + rect.width &&
                y > rect.y && y < rect.y + rect.height;
    }
}
