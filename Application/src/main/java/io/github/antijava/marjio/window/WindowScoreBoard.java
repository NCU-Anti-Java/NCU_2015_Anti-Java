package io.github.antijava.marjio.window;

import io.github.antijava.marjio.application.Application;
import io.github.antijava.marjio.common.IApplication;
import io.github.antijava.marjio.common.graphics.Color;
import io.github.antijava.marjio.common.graphics.IBitmap;
import io.github.antijava.marjio.common.graphics.Rectangle;
import io.github.antijava.marjio.resourcemanager.ResourcesManager;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.UUID;

/**
 * Created by Zheng-Yuan on 12/30/2015.
 */
public class WindowScoreBoard extends WindowBase {
    private final static int MAX_PRINT = 4;
    private final static int WIDTH = 300;
    private final static int HEIGHT = 400;
    private final UUID mYourPlayerUUID;
    private final UUID[] mRankTable;

    /**
     *
     * @param application The application.
     * @param yourPlayerUUID Your player's UUID
     * @param rankTable As an array, the index i is rank i + 1, and the content
     *                  is the UUID of the i th rank.
     */
    public WindowScoreBoard(@NotNull final IApplication application, UUID yourPlayerUUID, UUID[] rankTable) {
        super(application, WIDTH, HEIGHT);
        mYourPlayerUUID = yourPlayerUUID;
        mRankTable = rankTable;
        refresh();
    }

    /**
     * Draw at most 4 mario including yourself racing result on the scoreboard.
     */
    private void refresh() {
        // TODO: Replace image to mario!
        final ResourcesManager resourcesManager = ((Application)getApplication()).getResourcesManager();
        final IBitmap yourMario = resourcesManager.tile("default.png", 1, 2);
        final IBitmap opMario = resourcesManager.tile("default.png", 1, 8);
        final IBitmap content = getContent();
        boolean youAreDrawn = false;
        content.clear();

        setX(250);
        setY(100);
        for (int i = 0; i < mRankTable.length; i++) {
            // Reserve one row for yourself if you are not drawn
            // Only 4 mario be drawn
            if (i >= MAX_PRINT || (i >= MAX_PRINT - 1 && !youAreDrawn))
                break;

            if (mRankTable[i] == mYourPlayerUUID) {
                String text = "Me";
                youAreDrawn = true;
                content.blt(40, 30 + i * 75, yourMario, yourMario.getRect(), 0);
                content.drawText(text, 100, i * 75, 50, 75, Color.WHITE, IBitmap.TextAlign.CENTER);
            }
            else {
                content.blt(40, 30 + i * 75, opMario, opMario.getRect(), 0);
            }
            content.drawText(getRankText(i + 1), 175,  i * 75, 125, 75, Color.WHITE, IBitmap.TextAlign.CENTER);
        }
        if (!youAreDrawn) {
            int yourPlayerRank;
            for (yourPlayerRank = 0; yourPlayerRank < mRankTable.length; yourPlayerRank++)
                if (mRankTable[yourPlayerRank] == mYourPlayerUUID)
                    break;
            String text = "Me";
            content.drawText(text, 100, 3 * 75, 50, 75, Color.WHITE);
            content.blt(40, 30 + 3 * 75, yourMario, yourMario.getRect(), 0);
            content.drawText(getRankText(yourPlayerRank + 1), 175,  3 * 75, 125, 75, Color.WHITE, IBitmap.TextAlign.CENTER);
        }
        content.drawText("Press any key to continue", 0, HEIGHT - 100, WIDTH, 75, Color.WHITE, IBitmap.TextAlign.CENTER);
    }

    private String getRankText(final int rank) {
        switch (rank) {
            case 1:
                return "1 st";
            case 2:
                return "2 nd";
            case 3:
                return "3 rd";
            default:
                return rank + " th";
        }
    }

}
