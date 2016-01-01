package io.github.antijava.marjio.scene;

import io.github.antijava.marjio.common.IApplication;
import io.github.antijava.marjio.common.IClient;
import io.github.antijava.marjio.common.IInput;
import io.github.antijava.marjio.common.ISceneManager;
import io.github.antijava.marjio.common.graphics.Color;
import io.github.antijava.marjio.common.graphics.IBitmap;
import io.github.antijava.marjio.common.input.Key;
import io.github.antijava.marjio.common.input.Request;
import io.github.antijava.marjio.constant.Constant;
import io.github.antijava.marjio.window.WindowBase;
import io.github.antijava.marjio.window.WindowCommand;
import io.github.antijava.marjio.window.WindowIPAddressInput;

/**
 * Created by Zheng-Yuan on 12/24/2015.
 */
public class JoinScene extends SceneBase implements Constant {
    private WindowBase mWindowBack;
    private WindowIPAddressInput mWindowIPAddressInput;
    private WindowCommand mWindowCommand;

    public JoinScene(IApplication application) {
        super(application);

        initWindows();
        moveWindows((GAME_WIDTH - mWindowBack.getWidth()) / 2,
                (GAME_HEIGHT - mWindowBack.getHeight()) / 2);
    }

    @Override
    public void update() {
        super.update();

        final IInput input = getApplication().getInput();

        mWindowBack.update();
        if (input.isPressed(Key.ENTER)) {
            if (mWindowCommand.isActive()) {
                if (processOption())
                    return;
            }
        }
        if (input.isRepeat(Key.LEFT)) {
            if (mWindowIPAddressInput.isActive() && mWindowIPAddressInput.getIndex() == 0) {
                mWindowIPAddressInput.setActive(false);
                mWindowCommand.setActive(true);
            } else if (mWindowCommand.isActive()) {
                mWindowCommand.setActive(false);
                mWindowIPAddressInput.setIndex(14);
                mWindowIPAddressInput.update();
                mWindowIPAddressInput.setActive(true);
                return;
            }
        }
        if (input.isRepeat(Key.RIGHT)) {
            if (mWindowIPAddressInput.isActive() && mWindowIPAddressInput.getIndex() == 14) {
                mWindowIPAddressInput.setActive(false);
                mWindowCommand.setActive(true);
            } else if (mWindowCommand.isActive()) {
                mWindowCommand.setActive(false);
                mWindowIPAddressInput.setIndex(0);
                mWindowIPAddressInput.update();
                mWindowIPAddressInput.setActive(true);
                return;
            }
        }
        mWindowIPAddressInput.update();
        mWindowCommand.update();
    }

    @Override
    public void dispose() {
        super.dispose();

        mWindowBack.dispose();
        mWindowCommand.dispose();
        mWindowIPAddressInput.dispose();
    }

    private boolean processOption() {
        switch (mWindowCommand.getIndex()) {
            case 0: {
                try {
                    final ISceneManager sceneManager = getApplication().getSceneManager();
                    final IInput input = getApplication().getInput();
                    final IClient client = getApplication().getClient();
                    final Request joinRequest = new Request(Request.Types.ClientWannaJoinRoom);
                    client.send(joinRequest);
                    // TODO: Let user know we are waiting response

                    Thread thread = new Thread(() -> {
                        boolean waitingFlag = true;
                        final int timeOut = 1000;
                        long startTime = System.currentTimeMillis();

                        while (waitingFlag) {
                            if (System.currentTimeMillis() - startTime > timeOut) {
                                waitingFlag = false;
                            }
                            for (Request request : input.getRequest() ) {
                                if (request.getType() == Request.Types.ClientCanJoinRoom)
                                    sceneManager.translationTo(new RoomScene(getApplication(), false));
                            }
                        }
                        // TODO: Let user know we are timeout, can keep do something
                    });
                    thread.start();

                    return true;
                }
                catch (Exception ex) {
                    // TODO: Show Error.
                }
                return false;
            }
            case 1: {
                final ISceneManager sceneManager = getApplication().getSceneManager();
                sceneManager.translationTo(new MainScene(getApplication(), 1));
                return true;
            }
        }
        return false;
    }

    private void initWindows() {
        final IApplication application = getApplication();

        mWindowIPAddressInput = new WindowIPAddressInput(application);
        mWindowCommand = new WindowCommand(application, 140, new String[] {"確定", "返回"});
        mWindowBack = new WindowBase(application,
                mWindowIPAddressInput.getWidth() + mWindowCommand.getWidth(),
                mWindowCommand.getHeight()) {
            @Override
            public void update() {
                super.update();

                final IBitmap readmeContent = getContent();
                readmeContent.clear();
                readmeContent.drawText("輸入伺服器 IP: ", 0, 0, -1, 24, Color.WHITE);
            }
        };

        mWindowIPAddressInput.setBackgroundOpacity(255);
        mWindowIPAddressInput.setZ(10);
        mWindowCommand.setIndex(1);
        mWindowCommand.setBackgroundOpacity(255);
        mWindowCommand.setZ(10);

        mWindowIPAddressInput.setActive(true);
    }

    private void moveWindows(final int x, final int y) {
        mWindowBack.setX(x);
        mWindowBack.setY(y);
        mWindowIPAddressInput.setX(x);
        mWindowIPAddressInput.setY(y + 24);
        mWindowCommand.setX(mWindowIPAddressInput.getWidth() + x);
        mWindowCommand.setY(y);
    }
}
