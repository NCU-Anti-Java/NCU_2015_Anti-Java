package io.github.antijava.marjio.common.input;

import io.github.antijava.marjio.common.network.Packable;

import java.util.UUID;

/**
 * Created by firejox on 2015/12/25.
 */
public class Status implements Packable{
    Types mType;
    Object mObject;
    UUID mId;

    public Status(SceneObjectStatus obj, Types type) {
        mType = type;
        mObject = obj;
        mId = obj.uuid;
    }

    @Override
    public UUID getClientID() {
        return mId;
    }

    @Override
    public void setClientID(UUID id) {
        mId = id;
    }

    public enum Types {
        ServerMessage,
        ServerVerification,
        ClientMessage;
    }

    public Types getType() {
        return mType;
    }

    public Object getData() {
        return mObject;
    }
}
