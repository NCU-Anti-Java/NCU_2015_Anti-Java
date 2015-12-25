package io.github.antijava.marjio.input;

import io.github.antijava.marjio.common.Key;

/**
 * Created by firejox on 2015/12/25.
 */


public interface IKeyInfo {
    default Key getKey() {
        return Key.UNDEFINED;
    }
    default KeyState getKeyState() {
        return KeyState.KEY_UNKOWN;
    }
}
