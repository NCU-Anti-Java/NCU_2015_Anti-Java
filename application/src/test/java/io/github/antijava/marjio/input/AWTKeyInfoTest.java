package io.github.antijava.marjio.input;

import io.github.antijava.marjio.common.Key;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by firejox on 2015/12/25.
 */
public class AWTKeyInfoTest {
    AWTKeyInfo key;

    @Before
    public void setup() throws Throwable {
        key = new AWTKeyInfo(
                new KeyEvent(new Button(),
                        KeyEvent.KEY_PRESSED,
                        0,
                        0,
                        KeyEvent.VK_A, 'a'));

    }

    @Test
    public void test_key_is_A() {

        Assert.assertTrue(key.getKey() == Key.A);
        Assert.assertTrue(key.getKeyState() == KeyState.KEY_PRESSED);
    }


}
