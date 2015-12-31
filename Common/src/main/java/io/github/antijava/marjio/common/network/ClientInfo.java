package io.github.antijava.marjio.common.network;

import java.net.InetAddress;
import java.util.UUID;

/**
 * Created by fntsr on 2015/12/28.
 */
public class ClientInfo {
    private int mIndex;
    private UUID mClientID;
    private Object mTag;
    private boolean mIsJoined;

    public ClientInfo(UUID uuid, int index) {
        mClientID = uuid;
        mIndex = index;
    }
    
    public UUID getClientID() {
        return mClientID;
    }

    public int getIndex() {
        return mIndex;
    }

    public void setIsJoined(boolean mIsJoined) {
        this.mIsJoined = mIsJoined;
    }

    public boolean getIsJoined() {
        return mIsJoined;
    }

    public Object getTag() {
        return mTag;
    }

    public void setTag(Object tag) {
        mTag = tag;
    }
}