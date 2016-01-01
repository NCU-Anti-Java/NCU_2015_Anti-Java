package io.github.antijava.marjio.window;

import io.github.antijava.marjio.common.IApplication;
import io.github.antijava.marjio.common.graphics.Color;
import io.github.antijava.marjio.common.graphics.IBitmap;
import io.github.antijava.marjio.common.graphics.IBitmap.TextAlign;
import io.github.antijava.marjio.common.graphics.Rectangle;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Davy on 2015/12/29.
 */
public class WindowPlayerList extends WindowSelectableBase {
    private final List<String> mPlayerList;

    public WindowPlayerList(@NotNull final IApplication application, final int width, final int height) {
        super(application, width, height);

        mPlayerList = new ArrayList<>();

        setItemMax(0);
        refresh();
        setIndex(0);
    }

    private void refresh() {
        final IBitmap content = getContent();
        content.clear();
        for (int i = 0; i < mPlayerList.size(); ++i)
            drawItem(i, true);
        dirty();
    }

    private void drawItem(final int index, final boolean enabled) {
        final IBitmap content = getContent();
        final Rectangle rect = getItemRect(index);
        final Color color = Color.WHITE; // TODO: enabled color?
        rect.x += 4;
        rect.width -= 8;
        content.clearRect(rect);
        content.drawText(mPlayerList.get(index), rect, color, TextAlign.CENTER);
    }

    public void addPlayer(final String player) {
        mPlayerList.add(player);
        setItemMax(mPlayerList.size());
        refresh();
    }

    public void setPlayerList(List playerList) {

        mPlayerList.clear();
        mPlayerList.addAll(playerList);
    }
}
