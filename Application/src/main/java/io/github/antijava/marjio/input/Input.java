package io.github.antijava.marjio.input;

import io.github.antijava.marjio.common.Event;
import io.github.antijava.marjio.common.IApplication;
import io.github.antijava.marjio.common.IInput;
import io.github.antijava.marjio.common.Key;
import io.github.antijava.marjio.common.Status;

import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;


/**
 * Created by firejox on 2015/12/25.
 */
public class Input implements IInput {
    private static final Map<Key, Key> keys_map;

    static {
        keys_map = new EnumMap(Key.class);

        keys_map.put(Key.JUMP, Key.UP);
        keys_map.put(Key.MOVE_RIGHT, Key.RIGHT);
        keys_map.put(Key.MOVE_LEFT, Key.LEFT);
        keys_map.put(Key.CROUCH, Key.DOWN);
    }


    IApplication app;

    Set<Key> pro_keys;
    Set<Key> cur_keys;
    Set<Key> pre_keys;
    Vector<Status> statuses;
    Vector<Status> statuses_cached;


    Input(IApplication app) {
        this.app = app;

        pro_keys = Collections.synchronizedSet(EnumSet.noneOf(Key.class));
        cur_keys = Collections.synchronizedSet(EnumSet.noneOf(Key.class));
        pre_keys = Collections.synchronizedSet(EnumSet.noneOf(Key.class));

        statuses_cached = new Vector<>();
        statuses = new Vector<>();
    }

    @Override
    public void update() {
        pre_keys.clear();
        pre_keys.addAll(cur_keys);

        cur_keys.clear();
        cur_keys.addAll(pro_keys);

        statuses_cached.clear();
        statuses_cached.addAll(statuses);
        statuses.clear();
    }

    @Override
    public boolean isPressing(Key key) {
        key = keys_map.getOrDefault(key, key);

        return  key != Key.UNDEFINED &&
                !pre_keys.contains(key) &&
                cur_keys.contains(key);
    }

    @Override
    public boolean isPressed(Key key) {
        key = keys_map.getOrDefault(key, key);

        return key != Key.UNDEFINED &&
                (pre_keys.contains(key) &&
                cur_keys.contains(key));
    }

    @Override
    public boolean isReleased(Key key) {
        key = keys_map.getOrDefault(key, key);

        return  key != Key.UNDEFINED &&
                (pre_keys.contains(key) &&
                !cur_keys.contains(key));
    }

    @Override
    public boolean isTrigger(Key key) {

        return isPressed(key) || isPressed(key);
    }

    @Override
    public List<Status> getStatuses() {

        return statuses_cached;
    }

    @Override
    public void triggerEvent(Event evt) {
        switch (evt.getType()) {
            case Keyboard: {
                KeyInfo info = (KeyInfo)evt.getData();

                if (info.st == KeyInfo.State.DOWN)
                    pro_keys.add(KeyConverter.convert(info.obj));
                else
                    pro_keys.remove(KeyConverter.convert(info.obj));

                break;
            }

            case NetWorkClient:
            case NetworkServer: {
                statuses.add((Status) evt.getData());
                break;
            }

        }
    }
}


