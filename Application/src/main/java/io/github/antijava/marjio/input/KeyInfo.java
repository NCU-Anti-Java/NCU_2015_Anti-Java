package io.github.antijava.marjio.input;

/**
 * Created by firejox on 2015/12/25.
 */
public class KeyInfo {
    Object obj;
    State st;

    KeyInfo(Object obj, State st) {
        this.obj = obj;
        this.st = st;
    }


    enum State {
        UP,
        DOWN
    }
}
