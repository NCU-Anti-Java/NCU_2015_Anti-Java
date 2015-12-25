package io.github.antijava.marjio.common;

/**
 * Created by firejox on 2015/12/25.
 */
public abstract class Event {
    public abstract Type getType();
    public abstract Object getData();

    public enum Type {
        Keyboard,
        NetworkServer,
        NetWorkClient
    }
}
