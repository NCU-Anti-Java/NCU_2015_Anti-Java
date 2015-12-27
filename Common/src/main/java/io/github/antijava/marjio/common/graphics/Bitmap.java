package io.github.antijava.marjio.common.graphics;

import io.github.antijava.marjio.common.IGraphics;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

/**
 * Created by Jason on 2015/12/26.
 */
public class Bitmap implements IBitmap {
    BufferedImage mImage;
    Graphics2D mGraphics2D;
    IGraphics mGraphics;
    IFont mFont;
    Font textFont;
    FontRenderContext frc;

    public Bitmap(IGraphics graphics, int width, int height) {
        mGraphics = graphics;
        mImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        mGraphics2D = mImage.createGraphics();
        mGraphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Font properties
        setFont(mGraphics.getDefaultFont());
        frc = new FontRenderContext(null, true, true);
    }

    // region Drawing
    /**
     * Clears the entire bitmap.
     */
    @Override
    public void clear() {
        clearRect(0, 0, mImage.getWidth(), mImage.getHeight());
    }

    /**
     * Clears the specified rectangle area of the bitmap
     *
     * @param x The x coordinate for the upper-left corner.
     * @param y The y coordinate for the upper-left corner.
     * @param width The width of the rectangle to clear.
     * @param height The height of the rectangle to clear.
     */
    @Override
    public void clearRect(int x, int y, int width, int height) {
        Color transparent = new Color(0, 0, 0, 0);

        fillRect(x, y, width, height, transparent);
    }

    /**
     * Clears the specified rectangle area of the bitmap
     *
     * @param rect The rectangle.
     */
    @Override
    public void clearRect(Rectangle rect) {
        clearRect(rect.x, rect.y, rect.width, rect.height);
    }

    /**
     * Draws the outline text on the bitmap.
     *
     * @param text The text that will be drawn.
     * @param color The color of the text.
     * @param x The x coordinate for the left of the text.
     * @param y The y coordinate for the top of the text.
     * @param maxWidth The maximum allowed width of the text. -1 for unlimited.
     * @param lineHeight The height of the text line.
     * @param align The alignment of the text.
     */
    @Override
    public void drawText(CharSequence text, int x, int y, int maxWidth, int lineHeight, Color color, TextAlign align) {
        TextLayout layout = new TextLayout(text.toString(), textFont, frc);
        mGraphics2D.setColor(new java.awt.Color(color.toIntBits()));
        layout.draw(mGraphics2D, x, y);
    }

    /**
     * {@code color} defaults to {@link Color::BLACK}.
     *
     * @see #drawText(CharSequence, int, int, int, int, Color, TextAlign)
     */
    @Override
    public void drawText(CharSequence text, int x, int y, int maxWidth, int lineHeight, TextAlign align) {
        drawText(text, x, y, maxWidth, lineHeight, Color.BLACK, align);
    }

    /**
     * {@code align} defaults to {@link TextAlign#LEFT}.
     *
     * @see #drawText(CharSequence, int, int, int, int, Color, TextAlign)
     */
    @Override
    public void drawText(CharSequence text, int x, int y, int maxWidth, int lineHeight, Color color) {
        drawText(text, x, y, maxWidth, lineHeight, color, TextAlign.LEFT);
    }

    /**
     * {@code color} defaults to {@link Color::BLACK}.
     * {@code align} defaults to {@link TextAlign#LEFT}.
     *
     * @see #drawText(CharSequence, int, int, int, int, Color, TextAlign)
     */
    @Override
    public void drawText(CharSequence text, int x, int y, int maxWidth, int lineHeight) {
        drawText(text, x, y, maxWidth, lineHeight, Color.BLACK, TextAlign.LEFT);
    }

    /**
     * Returns a rectangle contains the outline text.
     *
     * @param text The text.
     * @param lineHeight The height of the text line.
     *
     * @return The rectangle measured.
     */
    @Override
    public Rectangle measureText(CharSequence text, int lineHeight) {
        TextLayout layout = new TextLayout(text.toString(), textFont, frc);
        Rectangle2D bounds = layout.getBounds();
        return new Rectangle((int)bounds.getX(), (int)bounds.getY(), (int)bounds.getWidth(), (int)bounds.getHeight());
    }

    /**
     * Fills the entire bitmap with specified color.
     *
     * @param color The color of the rectangle.
     */
    @Override
    public void fillAll(Color color) {
        fillRect(0, 0, mImage.getWidth(), mImage.getHeight(), color);
    }

    /**
     * Fills the specified rectangle with specified color.
     *
     * @param x The x coordinate for the upper-left corner.
     * @param y The y coordinate for the upper-left corner
     * @param width The width of the rectangle to fill.
     * @param height The height of the rectangle to fill.
     * @param color The color of the rectangle.
     */
    @Override
    public void fillRect(int x, int y, int width, int height, Color color) {
        for (int i = x; i <= x + width; i++)
            for (int j = y; j <= y + height; j++)
                mImage.setRGB(i, j, color.toIntBits());
    }

    /**
     * Fills the specified rectangle with specified color.
     *
     * @param rect The rectangle to fill.
     * @param color The color of the rectangle.
     */
    @Override
    public void fillRect(Rectangle rect, Color color) {
        fillRect(rect.x, rect.y, rect.width, rect.height, color);
    }

    /**
     * Returns pixel color at the specified point.
     *
     * @param x The x coordinate of the pixel in the bitmap.
     * @param y The y coordinate of the pixel in the bitmap.
     *
     * @return The pixel color.
     */
    @Override
    public Color getPixel(int x, int y) {
        return new Color(mImage.getRGB(x, y));
    }

    /**
     * Changes pixel color to the specified point.
     *
     * @param x The x coordinate of the pixel in the bitmap.
     * @param y The y coordinate of the pixel in the bitmap.
     * @param color The pixel color.
     */
    @Override
    public void setPixel(int x, int y, Color color) {
        mImage.setRGB(x, y, color.toIntBits());
    }

    /**
     * Performs a block transfer from the {@param src} box {@param srcRect} to specified coordinates.
     *
     * @param x The x coordinate for the left-top corner.
     * @param y The y coordinate for the left-top corner.
     * @param src The source bitmap.
     * @param srcRect The source rectangle for the bitmap.
     * @param opacity Opacity can be set from 0 to 255.
     */
    @Override
    public void blt(int x, int y, IBitmap src, Rectangle srcRect, int opacity) {
        for (int i = x; i <= x + srcRect.width; i++) {
            for (int j = y; j <= y + srcRect.height; j++) {
                Color srcColor = src.getPixel(srcRect.x + i, srcRect.y + j).mul((float) opacity / 255);
                Color dstColor = getPixel(i, j).mul(1 - (float) opacity / 255);
                mImage.setRGB(i, j, dstColor.add(srcColor).toIntBits());
            }
        }
    }

    /**
     * Performs a block transfer from the {@param src} box {@param srcRect} to destination rect.
     *
     * @param x The x coordinate for the left-top corner of destination rectangle.
     * @param y The y coordinate for the left-top corner of destination rectangle.
     * @param width The width of destination rectangle.
     * @param height The height of destination rectangle.
     * @param src The source bitmap.
     * @param srcRect The source rectangle for the bitmap.
     * @param opacity Opacity can be set from 0 to 255.
     */
    @Override
    public void stretch_blt(int x, int y, int width, int height, IBitmap src, Rectangle srcRect, int opacity) {
        src.resize(width, height);
        blt(x, y, src, srcRect, opacity);
    }

    /**
     * Performs a block transfer from the {@param src} box {@param srcRect} to destination rect.
     *
     * @param rect The destination rectangle.
     * @param src The source bitmap.
     * @param srcRect The source rectangle for the bitmap.
     * @param opacity Opacity can be set from 0 to 255.
     */
    @Override
    public void stretch_blt(Rectangle rect, IBitmap src, Rectangle srcRect, int opacity) {
        stretch_blt(rect.x, rect.y, rect.width, rect.height, src, srcRect, opacity);
    }

    /**
     * Resizes the bitmap.
     *
     * @param width The new width of the bitmap.
     * @param height The new height of the bitmap.
     */
    @Override
    public void resize(int width, int height) {
        Image tmp = mImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        mImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        mGraphics2D = mImage.createGraphics();
        mGraphics2D.drawImage(tmp, 0, 0, null);
    }
    // endregion Drawing

    // region Setter
    /**
     * Set the font use to {@link #drawText} and {@link #measureText}.
     *
     * @param font The font.
     */
    @Override
    public void setFont(IFont font) {
        mFont = font;

        int fontStyle = Font.PLAIN;
        if (font.isBold())
            fontStyle = fontStyle | Font.BOLD;

        if (font.isItalic())
            fontStyle = fontStyle | Font.ITALIC;

        textFont = new Font(font.getName(), fontStyle, font.getSize());
    }
    // endregion Setter

    // region Getter
    /**
     * Returns the height of the bitmap.
     */
    @Override
    public int getHeight() {
        return mImage.getHeight();
    }

    /**
     * Returns the width of the bitmap.
     */
    @Override
    public int getWidth() {
        return mImage.getWidth();
    }

    /**
     * Returns the font set to {@link #drawText} and {@link #measureText}.
     * Defaults to {@link IGraphics#getDefaultFont()}.
     */
    @Override
    public IFont getFont() {
        return mFont;
    }

    /**
     * Returns the rectangle of the bitmap.
     */
    @Override
    public Rectangle getRect() {
        return new Rectangle(mImage.getWidth(), mImage.getHeight());
    }
    // endregion Getter

    @Override
    public void dispose() {
        mGraphics = null;
        mGraphics2D.dispose();
        mImage = null;
    }

    @Override
    public boolean isDisposed() {
        return mImage == null;
    }
}
