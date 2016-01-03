package io.github.antijava.marjio.network;

import com.esotericsoftware.kryonet.*;

import io.github.antijava.marjio.common.IApplication;
import io.github.antijava.marjio.common.IInput;
import io.github.antijava.marjio.common.IServer;
import io.github.antijava.marjio.common.input.Request;
import io.github.antijava.marjio.common.input.SceneObjectStatus;
import io.github.antijava.marjio.common.input.Status;
import io.github.antijava.marjio.common.network.RequestData;
import io.github.antijava.marjio.common.network.StatusData;
import io.github.antijava.marjio.constant.Constant;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.UUID;
import java.util.logging.Logger;

import static org.mockito.Mockito.*;


public class NetworkTest implements Constant{
    private final UUID clientId = UUID.randomUUID();

    private SceneObjectStatus mPlayerStatus;
    private Status mStatus;

    @Before
    public void setUp() throws Exception {
        mPlayerStatus = new SceneObjectStatus();
        mPlayerStatus.uuid = clientId;
        mPlayerStatus.type = SceneObjectStatus.Types.Player;
        mPlayerStatus.x = 0;
        mPlayerStatus.y = 0;
        mPlayerStatus.vx = 55;
        mPlayerStatus.vy = 66;
        mPlayerStatus.ax = 77;
        mPlayerStatus.ay = 88;

        mStatus = new Status(mPlayerStatus, Status.Types.ClientMessage);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testSendRequest() throws Exception {
        Request request = new Request(clientId, Request.Types.ClientWannaJoinRoom);

        IApplication application = mock(IApplication.class);
        IInput input = mock(IInput.class);

        when(application.getInput()).thenReturn(input);
        when(application.getLogger()).thenReturn(Logger.getLogger(LOGGER_NAME));

        IServer server = new Network(application);
        Client client = new Client(16384, 8192, new JsonSerialization());

        server.start();
        client.start();
        client.connect(5000, "127.0.0.1", NET_TCP_PORT, NET_UDP_PORT);

        client.sendTCP(Packer.RequestToData(request));

        Thread.sleep(1000);

        // TODO: More accurately assert
        verify(input, atLeastOnce()).triggerEvent(anyObject());

        server.stop();
        client.stop();
    }


    @Test
    public void testKryoSendRequest() throws Exception {
        Client client = new Client(16384, 8192, new JsonSerialization());
        Server server = new Server(16384, 8192, new JsonSerialization());

        server.start();
        server.bind(NET_TCP_PORT, NET_UDP_PORT);
        server.addListener(new Listener() {

            @Override
            public void received (Connection connection, Object object) {
                if (object instanceof RequestData) {
                    Request request = Packer.DataToRequest((RequestData)object);

                    if (request.getType() == Request.Types.ClientWannaJoinRoom) {
                        Request response = new Request(clientId, Request.Types.ClientCanJoinRoom);
                        connection.sendTCP(Packer.RequestToData(response));
                        return;
                    }
                }
                Assert.assertTrue(false);
            }

        });

        client.start();
        client.connect(5000, "127.0.0.1", NET_TCP_PORT, NET_UDP_PORT);
        client.addListener(new Listener() {

            @Override
            public void received (Connection connection, Object object) {
                if (object instanceof RequestData) {
                    Request response = Packer.DataToRequest((RequestData)object);

                    if (response.getType() == Request.Types.ClientCanJoinRoom) {
                        Assert.assertTrue(true);
                        return;
                    }
                }
                Assert.assertTrue(false);
            }
        });

        Request request = new Request(clientId, Request.Types.ClientWannaJoinRoom);
        client.sendTCP(Packer.RequestToData(request));

        Thread.sleep(2000);

        client.stop();
        server.stop();
        client.close();
        server.close();
    }

    @Test
    public void testKryoSendStatus() throws Exception {
        Client client = new Client(16384, 8192, new JsonSerialization());
        Server server = new Server(16384, 8192, new JsonSerialization());

        server.start();
        server.bind(NET_TCP_PORT, NET_UDP_PORT);
        server.addListener(new Listener() {
            @Override
            public void received (Connection connection, Object object) {
                if (object instanceof StatusData) {
                    Status receiveStatus = Packer.DataToStatus((StatusData) object);

                    // TODO: More accurately compare with status.equals(anotherStatus);
                    if (receiveStatus.getClientID().toString().equals(clientId.toString())) {
                        Assert.assertTrue(true);
                        return;
                    }
                }
                Assert.assertTrue(false);
            }
        });


        client.start();
        client.connect(5000, "127.0.0.1", NET_TCP_PORT, NET_UDP_PORT);

        client.sendTCP(Packer.StatustToData(mStatus));

        Thread.sleep(2000);

        client.stop();
        server.stop();
        client.close();
        server.close();
    }

}