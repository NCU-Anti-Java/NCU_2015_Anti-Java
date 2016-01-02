package io.github.antijava.marjio.scene.sceneObject;

import io.github.antijava.marjio.common.graphics.Rectangle;
import io.github.antijava.marjio.common.graphics.Viewport;
import io.github.antijava.marjio.common.input.Key;
import io.github.antijava.marjio.common.input.Status;

import java.util.UUID;

/**
 * Created by firejox on 2015/12/28.
 */
public class Player extends SceneObjectObjectBase {
    public static final Key[] action_keys = {
       Key.MOVE_LEFT, Key.MOVE_RIGHT, Key.JUMP, Key.CAST
    };

    UUID mId;

    int mTick;

    int mX;
    int mY;

    double mVelocityX;
    double mVelocityY;

    double mAccelerationX;
    double mAccelerationY;

    boolean Jet;


    public Player(Viewport viewport, UUID id) {
        super(viewport);
        mId = id;

        mTick = 0;

        mX = super.getX();
        mY = super.getY();

        mVelocityX = 0;
        mVelocityY = 0;

        mAccelerationX = 0;
        mAccelerationY = 0;

        Jet = false;
    }

    public void reset() {
        mX = 0;
        mY = 0;

        mVelocityX = 0;
        mVelocityY = 0;

        mAccelerationX = 0;
        mAccelerationY = 0;

        Jet = false;
    }

    @Override
    public void update() {

        mX += Math.round(mVelocityX);
        mY += Math.round(mVelocityY);

        super.setX(mX);
        super.setY(mY);

        mTick++;
    }

    public UUID getmId() {
        return mId;
    }

    public void setTick(int tick) {
        mTick = tick;
    }

    public int getTick() {
        return mTick;
    }


    @Override
    public void setX(int x)  {
        mX = x;
    }

    @Override
    public void setY(int y) {
        mY = y;
    }

    @Override
    public int getX() {
        return mX;
    }

    @Override
    public int getY() {
        return mY;
    }

    public int getNextX() {
        return mX + (int)Math.round(mVelocityX);
    }

    public int getNextY() {
        return mY + (int)Math.round(mVelocityY);
    }


    public double getVelocityX (){
        return mVelocityX;
    }

    public double getVelocityY (){
        return mVelocityY;
    }

    public void setVelocityX (double vx) {
        mVelocityX = vx;
    }

    public void setVelocityY (double vy) {
        mVelocityY = vy;
    }

    public void setAccelerationX (double ax) {
        mAccelerationX = ax;
    }

    public void addAccelerationX (double ax) {
        mAccelerationX += ax;
    }

    public void addAccelerationY (double ay) {
        mAccelerationY += ay;
    }

    public void setAccelerationY (double ay) {
        mAccelerationY = ay;
    }

    public void preUpdate() {

        mVelocityX += mAccelerationX;

        if (Math.abs(mVelocityX) <= PhysicsConstant.friction)
            mVelocityX = 0.0;
        else
            mVelocityX = Math.signum(mVelocityX) *
                    (Math.abs(mVelocityX) - PhysicsConstant.friction);

        mVelocityY += mAccelerationY + PhysicsConstant.gravity;
    }

    public void preUpdateStatus(Status data) {
        mTick = data.tick;
        mX = data.x;
        mY = data.y;
        mVelocityX = data.vx;
        mVelocityY = data.vy;
        mAccelerationX = data.ax;
        mAccelerationY = data.ay;
    }

    public Status getStatus() {
        Status data = new Status(Status.DataTypes.Player);

        data.setClientID(mId);

        data.tick = mTick;
        data.x = mX;
        data.y = mY;
        data.vx = mVelocityX;
        data.vy = mVelocityY;
        data.ax = mAccelerationX;
        data.ay = mAccelerationY;

        return data;
    }


    public boolean isValidData (Status data) {
        if (data.getDataType() != Status.DataTypes.Player)
            return false;

        return data.isValidKeySets();
    }

    public void normalizeVelocity(double lim) {
        if (mVelocityX < 0)
            mVelocityX = Math.max(mVelocityX, -lim);
        else
            mVelocityX = Math.min(mVelocityX, lim);

        mVelocityY = Math.min(mVelocityY, lim);

    }


    @Override
    public Rectangle getOccupiedSpace() {
        final int real_x = Math.round(getViewport().x + mX);
        final int real_y = Math.round(getViewport().y + mY);

        return new Rectangle(real_x - PLAYER_SIZE / 2,
                             real_y + PLAYER_SIZE,
                             PLAYER_SIZE, PLAYER_SIZE);
    }

    @Override
    public String toString() {
        return "player x:" + mX +" y:" + mY +
                " vx: " + mVelocityX + " vy:" + mVelocityY +
                " ax: " + mAccelerationX + " ay:" + mAccelerationY;
    }
}
