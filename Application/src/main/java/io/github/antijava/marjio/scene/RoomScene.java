package io.github.antijava.marjio.scene;

import io.github.antijava.marjio.common.*;
import io.github.antijava.marjio.common.input.Key;
import io.github.antijava.marjio.common.input.Request;
import io.github.antijava.marjio.common.input.RoomData;
import io.github.antijava.marjio.common.input.Status;
import io.github.antijava.marjio.common.network.ClientInfo;

import java.util.List;
import java.util.UUID;

/**
 * Created by Zheng-Yuan on 12/27/2015.
 */
public class RoomScene extends SceneBase {
    private final String[] MENU_TEXT = {"Start Game", "Exit Room"};
    private final int START_GAME = 0;
    private final int EXIT_ROOM = 1;
    private final boolean mIsServer;
    private int mCurrentChoice;

    public RoomScene(IApplication application, boolean isServer) {
        super(application);
        mIsServer = isServer;
        mCurrentChoice = 0;
    }

    @Override
    public void update() {
        super.update();
        checkKeyState();
        checkStatus();
    }

    private void checkClient() throws Exception {
        final IInput input = getApplication().getInput();
        final IServer server = getApplication().getServer();

        List<Request> requests = input.getRequest();
        List<ClientInfo> clients = server.getClients();

        for (Request request : requests) {
            if (request.getType() == Request.Types.ClientWannaJoinRoom) {
                clients.stream().filter(client -> client.getClientID() == request.getClientID()).forEach(client -> {
                    client.setIsJoined(true);
                });
            } else if (request.getType() == Request.Types.ClientWannaExitRoom) {
                clients.stream().filter(client -> client.getClientID() == request.getClientID()).forEach(client -> {
                    client.setIsJoined(false);
                });
            }
        }

        RoomData roomData = new RoomData(server.getClients());
        Status status = new Status(roomData, Status.Types.ServerMessage);
        server.broadcast(status);
    }

    private void checkKeyState() {
        final IInput input = getApplication().getInput();

        if (input.isPressed(Key.LEFT) || input.isPressing(Key.LEFT)) {
            if (--mCurrentChoice < 0)
                mCurrentChoice = 0;
        }
        else if(input.isPressed(Key.RIGHT) || input.isPressing(Key.RIGHT)) {
            if (++mCurrentChoice >= MENU_TEXT.length)
                mCurrentChoice = MENU_TEXT.length - 1;
        }
        else if(input.isPressed(Key.ENTER) || input.isPressing(Key.ENTER)) {
            select();
        }
    }

    public void checkStatus () {
        List<Status> fetchedStatus = getApplication().getInput().getStatuses();
    }

    private void select() {
        switch(mCurrentChoice) {
            case EXIT_ROOM: {
                final ISceneManager sceneManager = getApplication().getSceneManager();
                if (mIsServer) {
                    final IServer server = getApplication().getServer();
                    // TODO: Server should broadcast to clients that the room is canceled.
                    try {
                        server.stop();
                    } catch (InterruptedException e) {
                        // TODO
                    } catch (UnsupportedOperationException e) {
                        // TODO
                    }
                }
                else {
                    final IClient client = getApplication().getClient();
                    // TODO: Client should send message to server that I quit.
                    try {
                        client.stop();
                    } catch (InterruptedException e) {
                        // TODO
                    } catch (UnsupportedOperationException e) {
                        // TODO
                    }

                }
                sceneManager.translationTo(new MainScene(getApplication()));
                break;
            }
            case START_GAME: {
                // TODO: Only server can start game, then server broadcast to clients to start game.
                break;
            }
        }
    }
}
