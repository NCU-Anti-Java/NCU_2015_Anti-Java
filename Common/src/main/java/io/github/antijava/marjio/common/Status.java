package io.github.antijava.marjio.common;

/**
 * Created by firejox on 2015/12/25.
 */
public abstract class Status {
    public abstract Type getType();
    public abstract Object getData();

    enum Type {
        ServerMessage,
        ServerVerification,
        ClientMessage
    }
}
