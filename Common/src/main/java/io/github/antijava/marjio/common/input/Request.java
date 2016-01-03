package io.github.antijava.marjio.common.input;

import io.github.antijava.marjio.common.network.Packable;
import java.util.UUID;

/**
 * Created by fntsr on 2015/12/31.
 */
public class Request implements Packable {
    private UUID mUUID;

    private Types mType;

    public Request(Types type) {
        mType = type;
    }

    public Request(UUID id, Types type) {
        mUUID = id;
        mType = type;
    }

    @Override
    public UUID getClientID() {
        return mUUID;
    }

    @Override
    public void setClientID(UUID id) {
        mUUID = id;
    }

    public Types getType() {
        return mType;
    }

    public enum Types {
        ClientWannaJoinRoom,
        ClientCanJoinRoom,
        ClientWannaExitRoom,
        ClientExitedRoom;
    }
}
