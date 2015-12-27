package io.github.antijava.marjio.common;

import java.util.List;

/**
 * Created by fntsr on 2015/12/23.
 */
public interface IInput {
    /**
     * Input polling.
     */
    void update();

    boolean isPressing(Key key);
    boolean isPressed(Key key);
    boolean isReleased(Key key);
    boolean isTrigger(Key key);

    List<Status> getStatuses();

    void triggerEvent(Event evt);
}
