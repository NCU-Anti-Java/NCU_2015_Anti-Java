package io.github.antijava.marjio.network;

import io.github.antijava.marjio.common.input.Event;
import io.github.antijava.marjio.common.input.Request;
import io.github.antijava.marjio.common.input.SceneObjectStatus;
import io.github.antijava.marjio.common.input.Status;
import io.github.antijava.marjio.common.network.PackData;
import io.github.antijava.marjio.common.network.Packable;
import io.github.antijava.marjio.common.network.RequestData;
import io.github.antijava.marjio.common.network.StatusData;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by Date on 2015/12/28.
 */
public class Packer {
    /*
     * @Param statusData
     * @Param type:
     *             tag Types.NetworkServer:
     *                 when Server recv packet from Client, and Server need pass Event to Input Module
     *             tag Types.NetworkClient:
     *                 when Client recv packet from Server, and need pass Event to Input Module
     */
    public static Event toEvent(Packable packableObject , Event.Type type) {
        return new Event(packableObject, type);
    }

    public static Packable DataToPackable(PackData data) {
        if (data instanceof RequestData) {
            return DataToRequest((RequestData) data);
        } else if (data instanceof StatusData) {
            return DataToStatus((StatusData) data);
        }

        throw new IllegalArgumentException();
    }


    public static PackData PackableToData(Packable packableObj) {
        if (packableObj instanceof Request) {
            return RequestToData((Request) packableObj);
        } else if (packableObj instanceof Status) {
            return StatustToData((Status) packableObj);
        }

        throw new IllegalArgumentException();
    }


    public static RequestData RequestToData(Request request) {
        RequestData data = new RequestData();
        if (data.uuid != null) {
            data.uuid = request.getClientID().toString();
        }
        data.type = request.getType().name();
        return data;
    }

    public static Request DataToRequest(RequestData data) {
        UUID uuid = UUID.randomUUID();
        if (data.uuid != null) {
            uuid = UUID.fromString(data.uuid);
        }
        Request.Types type = Request.Types.valueOf(data.type);

        return new Request(uuid, type);
    }

    public static StatusData StatustToData(Status status) {
        SceneObjectStatus info = (SceneObjectStatus) status.getData();
        StatusData data = new StatusData();
        data.uuid = status.getClientID().toString();
        data.sourceType = status.getType().toString();
        data.objectType = info.type.toString();
        data.id = info.id;
        data.action_id = info.action_id;
        data.time_counter = info.time_counter;
        data.st_x = info.st_x;
        data.st_y = info.st_y;
        data.x = info.x;
        data.y = info.y;
        data.vx = info.vx;
        data.vy = info.vy;
        data.ax = info.ax;
        data.ay = info.ay;
        data.query = info.query;
        return data;
    }

    public static Status DataToStatus(StatusData data) {
        SceneObjectStatus info = new SceneObjectStatus();
        info.uuid = UUID.fromString(data.uuid);
        info.type = SceneObjectStatus.Types.valueOf(data.objectType);
        info.id = data.id;
        info.action_id = data.action_id;
        info.time_counter = data.time_counter;
        info.st_x = data.st_x;
        info.st_y = data.st_y;
        info.x = data.x;
        info.y = data.y;
        info.vx = data.vx;
        info.vy = data.vy;
        info.ax = data.ax;
        info.ay = data.ay;
        info.query = data.query;

        return new Status(info, Status.Types.valueOf(data.sourceType));
    }

}
