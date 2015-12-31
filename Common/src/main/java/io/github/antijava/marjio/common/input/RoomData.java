package io.github.antijava.marjio.common.input;

import io.github.antijava.marjio.common.network.ClientInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fntsr on 2015/12/31.
 */
public class RoomData {
    List<ClientInfo> mList;

    public RoomData(List<ClientInfo> list) {
        mList = new ArrayList<>();

        for (ClientInfo client : list) {
            if (client.getIsJoined()) {
                mList.add(client);
            }
        }
    }

    public List<ClientInfo> getList() {
        return mList;
    }
}
