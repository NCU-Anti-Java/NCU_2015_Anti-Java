package io.github.antijava.marjio.network;

import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.JsonSerialization;
import com.esotericsoftware.kryonet.Server;
import io.github.antijava.marjio.common.IApplication;
import io.github.antijava.marjio.common.IClient;
import io.github.antijava.marjio.common.IServer;
import io.github.antijava.marjio.common.input.Request;
import io.github.antijava.marjio.common.input.Status;
import io.github.antijava.marjio.common.network.ClientInfo;
import io.github.antijava.marjio.common.network.Packable;
import io.github.antijava.marjio.common.network.RequestData;
import io.github.antijava.marjio.constant.Constant;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * Network Module
 * Created by fntsr on 2015/12/30.
 */
public class Network implements IClient, IServer, Constant {

    // Common Fields
    private IApplication mApplication;
    private boolean mRunningFlag;
    private boolean mConnectedFlag;
    private Server mServer;
    private Client mClient;

    // Server Fields
    private UUID mMyId;
    private List<ClientInfo> mClientList;
    private HashMap<UUID, Connection> mConnectionMap;

    public Network(IApplication application) {
        mApplication = application;
        mRunningFlag = false;
        mConnectedFlag = true;
        mServer = new Server(NET_WRITE_BUFFER_SIZE, NET_OBJECT_BUFFER_SIZE, new JsonSerialization());
        mClient = new Client(NET_WRITE_BUFFER_SIZE, NET_OBJECT_BUFFER_SIZE, new JsonSerialization());
        mConnectionMap = new HashMap<>();
        mClientList = new ArrayList<>();
    }

    @Override
    public void start() {
        if (mRunningFlag) {
            throw new UnsupportedOperationException();
        }

        try {
            mServer.start();
            mServer.bind(NET_TCP_PORT, NET_UDP_PORT);
            mServer.addListener(new ServerReceiver(mApplication, mConnectionMap, mClientList));
            mRunningFlag = true;
            mMyId = UUID.randomUUID();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void start(InetAddress hostAddress) throws IOException {
        if (mRunningFlag) {
            throw new UnsupportedOperationException();
        }

        try {
            mClient.start();
            mClient.addListener(new ClientReceiver(mApplication));
            mClient.connect(NET_TIMEOUT, hostAddress, NET_TCP_PORT, NET_UDP_PORT);

            mRunningFlag = true;
        } catch (IOException e) {
            throw e;
        }
    }

    @Override
    public void stop() throws InterruptedException, UnsupportedOperationException {
        mRunningFlag = false;
        mServer.stop();
        if (mClient != null) {
            mClient.stop();
        }
    }

    @Override
    public boolean isRunning() {
        return mRunningFlag;
    }

    @Override
    public boolean isConnected() {
        return mConnectedFlag;
    }

    @Override
    public void send(Packable packableObj) throws Exception {
        mClient.sendUDP(Packer.PackableToData(packableObj));
    }

    @Override
    public void sendTCP(Packable packableObj) throws Exception {
        mApplication.getLogger().info("Client send message");
        mClient.sendTCP(Packer.PackableToData(packableObj));
    }

    @Override
    public void send(Packable packableObj, UUID clientID) throws Exception {
        Connection connection = mConnectionMap.get(clientID);
        connection.sendUDP(Packer.PackableToData(packableObj));
    }

    @Override
    public void sendTCP(Packable packableObj, UUID clientID) throws Exception {
        Connection connection = mConnectionMap.get(clientID);
        connection.sendTCP(Packer.PackableToData(packableObj));
    }

    @Override
    public void broadcast(Packable packableObj) throws Exception {
        mServer.sendToAllUDP(packableObj);
    }

    @Override
    public List<ClientInfo> getClients() {
        return mClientList;
    }

    @Override
    public void setMyId(UUID mMyId) {
        this.mMyId = mMyId;
    }

    @Override
    public UUID getMyId() {

        return mMyId;
    }

}
