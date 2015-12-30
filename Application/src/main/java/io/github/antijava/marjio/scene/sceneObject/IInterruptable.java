package io.github.antijava.marjio.scene.sceneObject;

import io.github.antijava.marjio.common.IInput;

/**
 * Created by firejox on 2015/12/29.
 */
public interface IInterruptable {
    boolean check(IInput input, int time_counter);
}
