package io.github.antijava.marjio.scene.sceneObject;

import io.github.antijava.marjio.common.graphics.IBitmap;
import io.github.antijava.marjio.common.graphics.Rectangle;
import io.github.antijava.marjio.common.graphics.Viewport;
import io.github.antijava.marjio.graphics.Bitmap;
import io.github.antijava.marjio.resourcemanager.ResourcesManager;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zheng-Yuan on 12/28/2015.
 */
public class Block extends SceneObjectObjectBase {
    // TODO: Different type with different block image.
    // TODO: Need images.
    public enum Type {
        /**
         * Not touchable
         */
        AIR(0),
        /**
         * Not breakable block
         */
        GROUND(1),
        /**
         * breakable block
         */
        WOOD(2);

        private final int mValue;
        Type(int value) {
            mValue = value;
        }

        public int getValue() {
            return mValue;
        }
    }

    private Type mType;

    public Block(int type, int x, int y, Viewport viewport, IBitmap bitMap) {
        super(viewport);
        setType(type);
        setBitmap(bitMap);
        setX(x);
        setY(y);
        setZoomX(BLOCK_SIZE * 1.0D / 16.0D);
        setZoomY(BLOCK_SIZE * 1.0D / 16.0D);
    }

    @Override
    public void update() {
        // TODO:
    }

    @Override
    public Rectangle getOccupiedSpace() {
        return new Rectangle(getX(), getY(), BLOCK_SIZE, BLOCK_SIZE);
    }

    public Type getType() {
        return mType;
    }

    private void setType(int type) {
        switch (type) {
            case 0:
                mType = Type.AIR;
                break;
            case 1:
                mType = Type.GROUND;
                break;
            case 2:
                mType = Type.WOOD;
                break;
        }
    }

}
