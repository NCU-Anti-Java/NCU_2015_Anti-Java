package io.github.antijava.marjio.scene.sceneObject;

import io.github.antijava.marjio.common.graphics.Rectangle;
import io.github.antijava.marjio.common.graphics.Viewport;
import io.github.antijava.marjio.network.StatusData;

import java.util.UUID;

/**
 * Created by firejox on 2015/12/28.
 */
public class Player extends SceneObjectObjectBase {

    UUID id;


    int mX;
    int mY;

    double mVelocityX;
    double mVelocityY;

    double mAccelerationX;
    double mAccelerationY;

    boolean Jet;


    public Player(Viewport viewport, UUID id) {
        super(viewport);
        this.id = id;
        mX = getX();
        mY = getY();

        mVelocityX = 0;
        mVelocityY = 0;

        mAccelerationX = 0;
        mAccelerationY = 0;

        Jet = false;
    }


    @Override
    public void update() {
        mX += mVelocityX;
        mY += mVelocityY;

        setX(mX);
        setY(mY);
    }

    public UUID getId() {
        return id;
    }


    public void preUpdateStatusData(StatusData data) {
        mX = data.x;
        mY = data.y;
        mVelocityX = data.vx;
        mVelocityY = data.vy;
        mAccelerationX = data.ax;
        mAccelerationY = data.ay;
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

    public StatusData getStatusData() {
        StatusData data = new StatusData();

        data.uuid = id;
        data.type = StatusData.Player;

        data.x = mX;
        data.y = mY;
        data.vx = mVelocityX;
        data.vy = mVelocityY;
        data.ax = mAccelerationX;
        data.ay = mAccelerationY;

        return data;
    }


    public boolean isValidData (StatusData data) {
        // TODO: need to find good speed limit;

        if (data.type != StatusData.Player)
            return false;

        return false;
    }


    @Override
    public Rectangle getOccupiedSpace() {
        final int real_x = (int)Math.round(getViewport().x + mX + mVelocityX);
        final int real_y = (int)Math.round(getViewport().y + mY + mVelocityY);

        return new Rectangle(real_x - PLAYER_SIZE / 2,
                             real_y + PLAYER_SIZE,
                             PLAYER_SIZE, PLAYER_SIZE);
    }
}
