package io.github.antijava.marjio.input;

import io.github.antijava.marjio.common.Event;
import io.github.antijava.marjio.common.Key;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.Button;
import java.awt.event.KeyEvent;

/**
 * Created by firejox on 2015/12/26.
 */
public class InputTest {
    Event pressed_evt;
    Event released_evt;
    Input input;

    @Before
    public void setup() throws Throwable {
        pressed_evt = new Event() {
            AWTKeyInfo info = new AWTKeyInfo(
                    new KeyEvent(
                            new Button(),
                            KeyEvent.KEY_PRESSED,
                            0,
                            0,
                            KeyEvent.VK_A,
                            'a'));

            @Override
            public Type getType() {
                return Type.Keyboard;
            }

            @Override
            public Object getData() {
                return info;
            }
        };
        released_evt = new Event() {
            AWTKeyInfo info = new AWTKeyInfo(
                    new KeyEvent(
                            new Button(),
                            KeyEvent.KEY_RELEASED,
                            0,
                            0,
                            KeyEvent.VK_A,
                            'a'));

            @Override
            public Type getType() {
                return Type.Keyboard;
            }

            @Override
            public Object getData() {
                return info;
            }
        };

        input = new Input();
    }

    @Test
    public void test_triggerEventKeyPressedSafty() {
        input.triggerEvent(pressed_evt);
        input.update();

        Assert.assertTrue(input.isPressed(Key.A));
        Assert.assertFalse(input.isPressing(Key.A));
        Assert.assertFalse(input.isReleased(Key.A));
        Assert.assertTrue(input.isTrigger(Key.A));
    }

    @Test
    public void test_triggerEventKeyPressingSafty() {
        input.triggerEvent(pressed_evt);
        input.update();
        input.update();

        Assert.assertFalse(input.isPressed(Key.A));
        Assert.assertTrue(input.isPressing(Key.A));
        Assert.assertFalse(input.isReleased(Key.A));
        Assert.assertFalse(input.isTrigger(Key.A));

    }

    @Test
    public void test_triggerEventKeyReleasedSafty() {
        input.triggerEvent(pressed_evt);
        input.update();
        input.triggerEvent(released_evt);
        input.update();

        Assert.assertFalse(input.isPressed(Key.A));
        Assert.assertFalse(input.isPressing(Key.A));
        Assert.assertTrue(input.isReleased(Key.A));
        Assert.assertTrue(input.isTrigger(Key.A));

    }

    @Test
    public void test_triggerEventKeyEventLeaveSafty() {
        input.triggerEvent(pressed_evt);
        input.update();
        input.triggerEvent(released_evt);
        input.update();
        input.update();

        Assert.assertFalse(input.isPressed(Key.A));
        Assert.assertFalse(input.isPressing(Key.A));
        Assert.assertFalse(input.isReleased(Key.A));
        Assert.assertFalse(input.isTrigger(Key.A));

    }

    @Test
    public void test_KeyStatusAtStart() {
        for (Key o : Key.values()) {
            Assert.assertFalse(input.isPressed(Key.A));
            Assert.assertFalse(input.isPressing(Key.A));
            Assert.assertFalse(input.isReleased(Key.A));
            Assert.assertFalse(input.isTrigger(Key.A));
        }
    }


}
