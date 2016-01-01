package io.github.antijava.marjio.common;

import io.github.antijava.marjio.common.graphics.IBitmap;
import io.github.antijava.marjio.common.graphics.IFont;
import io.github.antijava.marjio.common.graphics.Viewport;

import java.nio.file.NoSuchFileException;

/**
 * Created by fntsr on 2015/12/23.
 */
public interface IGraphics {
    void update();
    /**
     * Get default font of the Graphics.
     * @return Default font.
     */
    IFont getDefaultFont();

    /**
     * Get default viewport of the Graphics.
     *
     * @return Default viewport.
     */
    Viewport getDefaultViewport();

    /**
     * Allocate a bitmap of declared size.
     *
     * @param width The width of the bitmap.
     * @param height The height of the bitmap.
     *
     * @return The bitmap. If failed, returns {@code null}.
     */
    IBitmap createBitmap(int width, int height);

    /**
     * Load bitmap from file.
     *
     * @param path The path of the file should be loaded.
     *
     * @return The bitmap.
     */
    IBitmap loadBitmap(String path) throws NoSuchFileException;

    /**
     * Create a viewport.
     *
     * @return The viewport.
     */
    Viewport createViewport();
}
