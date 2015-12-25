package io.github.antijava.marjio.input;

import io.github.antijava.marjio.common.Key;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by firejox on 2015/12/25.
 */
public class AWTKeyInfo implements IKeyInfo {
    static final Map<Integer, Key> code_map;

    static {
        code_map = new HashMap<>();

        code_map.put(java.awt.event.KeyEvent.VK_ENTER,Key.ENTER);
        code_map.put(java.awt.event.KeyEvent.VK_BACK_SPACE,Key.BACK_SPACE);
        code_map.put(java.awt.event.KeyEvent.VK_TAB,Key.TAB);
        code_map.put(java.awt.event.KeyEvent.VK_CANCEL,Key.CANCEL);
        code_map.put(java.awt.event.KeyEvent.VK_CLEAR,Key.CLEAR);
        code_map.put(java.awt.event.KeyEvent.VK_SHIFT,Key.SHIFT);
        code_map.put(java.awt.event.KeyEvent.VK_CONTROL,Key.CONTROL);
        code_map.put(java.awt.event.KeyEvent.VK_ALT,Key.ALT);
        code_map.put(java.awt.event.KeyEvent.VK_PAUSE,Key.PAUSE);
        code_map.put(java.awt.event.KeyEvent.VK_CAPS_LOCK,Key.CAPS);
        code_map.put(java.awt.event.KeyEvent.VK_ESCAPE,Key.ESCAPE);
        code_map.put(java.awt.event.KeyEvent.VK_SPACE,Key.SPACE);
        code_map.put(java.awt.event.KeyEvent.VK_PAGE_UP,Key.PAGE_UP);
        code_map.put(java.awt.event.KeyEvent.VK_PAGE_DOWN,Key.PAGE_DOWN);
        code_map.put(java.awt.event.KeyEvent.VK_END,Key.END);
        code_map.put(java.awt.event.KeyEvent.VK_HOME,Key.HOME);

        /**
         * Constant for the non-numpad <b>left</b> arrow key.
         * @see #VK_KP_LEFT
         */
        code_map.put(java.awt.event.KeyEvent.VK_LEFT,Key.LEFT);

        /**
         * Constant for the non-numpad <b>up</b> arrow key.
         * @see #VK_KP_UP
         */
        code_map.put(java.awt.event.KeyEvent.VK_UP,Key.UP);

        /**
         * Constant for the non-numpad <b>right</b> arrow key.
         * @see #VK_KP_RIGHT
         */
        code_map.put(java.awt.event.KeyEvent.VK_RIGHT,Key.RIGHT);

        /**
         * Constant for the non-numpad <b>down</b> arrow key.
         * @see #VK_KP_DOWN
         */
        code_map.put(java.awt.event.KeyEvent.VK_DOWN,Key.DOWN);

        /**
         * Constant for the comma key, ","
         */
        code_map.put(java.awt.event.KeyEvent.VK_COMMA,Key.COMMA);

        /**
         * Constant for the minus key, "-"
         * @since 1.2
         */
        code_map.put(java.awt.event.KeyEvent.VK_MINUS,Key.MINUS);

        /**
         * Constant for the period key, "."
         */
        code_map.put(java.awt.event.KeyEvent.VK_PERIOD,Key.PERIOD);

        /**
         * Constant for the forward slash key, "/"
         */
        code_map.put(java.awt.event.KeyEvent.VK_SLASH,Key.SLASH);

        /** VK_0 thru VK_9 are the same as ASCII '0' thru '9' (0x30 - 0x39) */
        code_map.put(java.awt.event.KeyEvent.VK_0,Key.DIGIT0);
        code_map.put(java.awt.event.KeyEvent.VK_1,Key.DIGIT1);
        code_map.put(java.awt.event.KeyEvent.VK_2,Key.DIGIT2);
        code_map.put(java.awt.event.KeyEvent.VK_3,Key.DIGIT3);
        code_map.put(java.awt.event.KeyEvent.VK_4,Key.DIGIT4);
        code_map.put(java.awt.event.KeyEvent.VK_5,Key.DIGIT5);
        code_map.put(java.awt.event.KeyEvent.VK_6,Key.DIGIT6);
        code_map.put(java.awt.event.KeyEvent.VK_7,Key.DIGIT7);
        code_map.put(java.awt.event.KeyEvent.VK_8,Key.DIGIT8);
        code_map.put(java.awt.event.KeyEvent.VK_9,Key.DIGIT9);

        /**
         * Constant for the semicolon key, ";"
         */
        code_map.put(java.awt.event.KeyEvent.VK_SEMICOLON,Key.SEMICOLON);

        /**
         * Constant for the equals key, "="
         */
        code_map.put(java.awt.event.KeyEvent.VK_EQUALS,Key.EQUALS);

        /** VK_A thru VK_Z are the same as ASCII 'A' thru 'Z' (0x41 - 0x5A) */
        code_map.put(java.awt.event.KeyEvent.VK_A,Key.A);
        code_map.put(java.awt.event.KeyEvent.VK_B,Key.B);
        code_map.put(java.awt.event.KeyEvent.VK_C,Key.C);
        code_map.put(java.awt.event.KeyEvent.VK_D,Key.D);
        code_map.put(java.awt.event.KeyEvent.VK_E,Key.E);
        code_map.put(java.awt.event.KeyEvent.VK_F,Key.F);
        code_map.put(java.awt.event.KeyEvent.VK_G,Key.G);
        code_map.put(java.awt.event.KeyEvent.VK_H,Key.H);
        code_map.put(java.awt.event.KeyEvent.VK_I,Key.I);
        code_map.put(java.awt.event.KeyEvent.VK_J,Key.J);
        code_map.put(java.awt.event.KeyEvent.VK_K,Key.K);
        code_map.put(java.awt.event.KeyEvent.VK_L,Key.L);
        code_map.put(java.awt.event.KeyEvent.VK_M,Key.M);
        code_map.put(java.awt.event.KeyEvent.VK_N,Key.N);
        code_map.put(java.awt.event.KeyEvent.VK_O,Key.O);
        code_map.put(java.awt.event.KeyEvent.VK_P,Key.P);
        code_map.put(java.awt.event.KeyEvent.VK_Q,Key.Q);
        code_map.put(java.awt.event.KeyEvent.VK_R,Key.R);
        code_map.put(java.awt.event.KeyEvent.VK_S,Key.S);
        code_map.put(java.awt.event.KeyEvent.VK_T,Key.T);
        code_map.put(java.awt.event.KeyEvent.VK_U,Key.U);
        code_map.put(java.awt.event.KeyEvent.VK_V,Key.V);
        code_map.put(java.awt.event.KeyEvent.VK_W,Key.W);
        code_map.put(java.awt.event.KeyEvent.VK_X,Key.X);
        code_map.put(java.awt.event.KeyEvent.VK_Y,Key.Y);
        code_map.put(java.awt.event.KeyEvent.VK_Z,Key.Z);

        /**
         * Constant for the open bracket key, "["
         */
        code_map.put(java.awt.event.KeyEvent.VK_OPEN_BRACKET,Key.OPEN_BRACKET);

        /**
         * Constant for the back slash key, "\"
         */
        code_map.put(java.awt.event.KeyEvent.VK_BACK_SLASH,Key.BACK_SLASH);

        /**
         * Constant for the close bracket key, "]"
         */
        code_map.put(java.awt.event.KeyEvent.VK_CLOSE_BRACKET,Key.CLOSE_BRACKET);

        code_map.put(java.awt.event.KeyEvent.VK_NUMPAD0,Key.NUMPAD0);
        code_map.put(java.awt.event.KeyEvent.VK_NUMPAD1,Key.NUMPAD1);
        code_map.put(java.awt.event.KeyEvent.VK_NUMPAD2,Key.NUMPAD2);
        code_map.put(java.awt.event.KeyEvent.VK_NUMPAD3,Key.NUMPAD3);
        code_map.put(java.awt.event.KeyEvent.VK_NUMPAD4,Key.NUMPAD4);
        code_map.put(java.awt.event.KeyEvent.VK_NUMPAD5,Key.NUMPAD5);
        code_map.put(java.awt.event.KeyEvent.VK_NUMPAD6,Key.NUMPAD6);
        code_map.put(java.awt.event.KeyEvent.VK_NUMPAD7,Key.NUMPAD7);
        code_map.put(java.awt.event.KeyEvent.VK_NUMPAD8,Key.NUMPAD8);
        code_map.put(java.awt.event.KeyEvent.VK_NUMPAD9,Key.NUMPAD9);
        code_map.put(java.awt.event.KeyEvent.VK_MULTIPLY,Key.MULTIPLY);
        code_map.put(java.awt.event.KeyEvent.VK_ADD,Key.ADD);

        /**
         * This constant is obsolete, and is included only for backwards
         * compatibility.
         * @see #VK_SEPARATOR
         */
        code_map.put(java.awt.event.KeyEvent.VK_SEPARATER,Key.SEPARATOR);

        /**
         * Constant for the Numpad Separator key.
         * @since 1.4
         */

        code_map.put(java.awt.event.KeyEvent.VK_SUBTRACT,Key.SUBTRACT);
        code_map.put(java.awt.event.KeyEvent.VK_DECIMAL,Key.DECIMAL);
        code_map.put(java.awt.event.KeyEvent.VK_DIVIDE,Key.DIVIDE);
        code_map.put(java.awt.event.KeyEvent.VK_DELETE,Key.DELETE); /* ASCII DEL */
        code_map.put(java.awt.event.KeyEvent.VK_NUM_LOCK,Key.NUM_LOCK);
        code_map.put(java.awt.event.KeyEvent.VK_SCROLL_LOCK,Key.SCROLL_LOCK);

        /** Constant for the F1 function key. */
        code_map.put(java.awt.event.KeyEvent.VK_F1,Key.F1);

        /** Constant for the F2 function key. */
        code_map.put(java.awt.event.KeyEvent.VK_F2,Key.F2);

        /** Constant for the F3 function key. */
        code_map.put(java.awt.event.KeyEvent.VK_F3,Key.F3);

        /** Constant for the F4 function key. */
        code_map.put(java.awt.event.KeyEvent.VK_F4,Key.F4);

        /** Constant for the F5 function key. */
        code_map.put(java.awt.event.KeyEvent.VK_F5,Key.F5);

        /** Constant for the F6 function key. */
        code_map.put(java.awt.event.KeyEvent.VK_F6,Key.F6);

        /** Constant for the F7 function key. */
        code_map.put(java.awt.event.KeyEvent.VK_F7,Key.F7);

        /** Constant for the F8 function key. */
        code_map.put(java.awt.event.KeyEvent.VK_F8,Key.F8);

        /** Constant for the F9 function key. */
        code_map.put(java.awt.event.KeyEvent.VK_F9,Key.F9);

        /** Constant for the F10 function key. */
        code_map.put(java.awt.event.KeyEvent.VK_F10,Key.F10);

        /** Constant for the F11 function key. */
        code_map.put(java.awt.event.KeyEvent.VK_F11,Key.F11);

        /** Constant for the F12 function key. */
        code_map.put(java.awt.event.KeyEvent.VK_F12,Key.F12);

        /**
         * Constant for the F13 function key.
         * @since 1.2
         */
    /* F13 - F24 are used on IBM 3270 keyboard; use random range for constants. */
        code_map.put(java.awt.event.KeyEvent.VK_F13,Key.F13);

        /**
         * Constant for the F14 function key.
         * @since 1.2
         */
        code_map.put(java.awt.event.KeyEvent.VK_F14,Key.F14);

        /**
         * Constant for the F15 function key.
         * @since 1.2
         */
        code_map.put(java.awt.event.KeyEvent.VK_F15,Key.F15);

        /**
         * Constant for the F16 function key.
         * @since 1.2
         */
        code_map.put(java.awt.event.KeyEvent.VK_F16,Key.F16);

        /**
         * Constant for the F17 function key.
         * @since 1.2
         */
        code_map.put(java.awt.event.KeyEvent.VK_F17,Key.F17);

        /**
         * Constant for the F18 function key.
         * @since 1.2
         */
        code_map.put(java.awt.event.KeyEvent.VK_F18,Key.F18);

        /**
         * Constant for the F19 function key.
         * @since 1.2
         */
        code_map.put(java.awt.event.KeyEvent.VK_F19,Key.F19);

        /**
         * Constant for the F20 function key.
         * @since 1.2
         */
        code_map.put(java.awt.event.KeyEvent.VK_F20,Key.F20);

        /**
         * Constant for the F21 function key.
         * @since 1.2
         */
        code_map.put(java.awt.event.KeyEvent.VK_F21,Key.F21);

        /**
         * Constant for the F22 function key.
         * @since 1.2
         */
        code_map.put(java.awt.event.KeyEvent.VK_F22,Key.F22);

        /**
         * Constant for the F23 function key.
         * @since 1.2
         */
        code_map.put(java.awt.event.KeyEvent.VK_F23,Key.F23);

        /**
         * Constant for the F24 function key.
         * @since 1.2
         */
        code_map.put(java.awt.event.KeyEvent.VK_F24,Key.F24);

        code_map.put(java.awt.event.KeyEvent.VK_PRINTSCREEN,Key.PRINTSCREEN);
        code_map.put(java.awt.event.KeyEvent.VK_INSERT,Key.INSERT);
        code_map.put(java.awt.event.KeyEvent.VK_HELP,Key.HELP);
        code_map.put(java.awt.event.KeyEvent.VK_META,Key.META);

        code_map.put(java.awt.event.KeyEvent.VK_BACK_QUOTE,Key.BACK_QUOTE);
        code_map.put(java.awt.event.KeyEvent.VK_QUOTE,Key.QUOTE);

        /**
         * Constant for the numeric keypad <b>up</b> arrow key.
         * @see #VK_UP
         * @since 1.2
         */
        code_map.put(java.awt.event.KeyEvent.VK_KP_UP,Key.KP_UP);

        /**
         * Constant for the numeric keypad <b>down</b> arrow key.
         * @see #VK_DOWN
         * @since 1.2
         */
        code_map.put(java.awt.event.KeyEvent.VK_KP_DOWN,Key.KP_DOWN);

        /**
         * Constant for the numeric keypad <b>left</b> arrow key.
         * @see #VK_LEFT
         * @since 1.2
         */
        code_map.put(java.awt.event.KeyEvent.VK_KP_LEFT,Key.KP_LEFT);

        /**
         * Constant for the numeric keypad <b>right</b> arrow key.
         * @see #VK_RIGHT
         * @since 1.2
         */
        code_map.put(java.awt.event.KeyEvent.VK_KP_RIGHT,Key.KP_RIGHT);

    /* For European keyboards */
        /** @since 1.2 */
        code_map.put(java.awt.event.KeyEvent.VK_DEAD_GRAVE,Key.DEAD_GRAVE);
        /** @since 1.2 */
        code_map.put(java.awt.event.KeyEvent.VK_DEAD_ACUTE,Key.DEAD_ACUTE);
        /** @since 1.2 */
        code_map.put(java.awt.event.KeyEvent.VK_DEAD_CIRCUMFLEX,Key.DEAD_CIRCUMFLEX);
        /** @since 1.2 */
        code_map.put(java.awt.event.KeyEvent.VK_DEAD_TILDE,Key.DEAD_TILDE);
        /** @since 1.2 */
        code_map.put(java.awt.event.KeyEvent.VK_DEAD_MACRON,Key.DEAD_MACRON);
        /** @since 1.2 */
        code_map.put(java.awt.event.KeyEvent.VK_DEAD_BREVE,Key.DEAD_BREVE);
        /** @since 1.2 */
        code_map.put(java.awt.event.KeyEvent.VK_DEAD_ABOVEDOT,Key.DEAD_ABOVEDOT);
        /** @since 1.2 */
        code_map.put(java.awt.event.KeyEvent.VK_DEAD_DIAERESIS,Key.DEAD_DIAERESIS);
        /** @since 1.2 */
        code_map.put(java.awt.event.KeyEvent.VK_DEAD_ABOVERING,Key.DEAD_ABOVERING);
        /** @since 1.2 */
        code_map.put(java.awt.event.KeyEvent.VK_DEAD_DOUBLEACUTE,Key.DEAD_DOUBLEACUTE);
        /** @since 1.2 */
        code_map.put(java.awt.event.KeyEvent.VK_DEAD_CARON,Key.DEAD_CARON);
        /** @since 1.2 */
        code_map.put(java.awt.event.KeyEvent.VK_DEAD_CEDILLA,Key.DEAD_CEDILLA);
        /** @since 1.2 */
        code_map.put(java.awt.event.KeyEvent.VK_DEAD_OGONEK,Key.DEAD_OGONEK);
        /** @since 1.2 */
        code_map.put(java.awt.event.KeyEvent.VK_DEAD_IOTA,Key.DEAD_IOTA);
        /** @since 1.2 */
        code_map.put(java.awt.event.KeyEvent.VK_DEAD_VOICED_SOUND,Key.DEAD_VOICED_SOUND);
        /** @since 1.2 */
        code_map.put(java.awt.event.KeyEvent.VK_DEAD_SEMIVOICED_SOUND,Key.DEAD_SEMIVOICED_SOUND);

        /** @since 1.2 */
        code_map.put(java.awt.event.KeyEvent.VK_AMPERSAND,Key.AMPERSAND);
        /** @since 1.2 */
        code_map.put(java.awt.event.KeyEvent.VK_ASTERISK,Key.ASTERISK);
        /** @since 1.2 */
        code_map.put(java.awt.event.KeyEvent.VK_QUOTEDBL,Key.QUOTEDBL);
        /** @since 1.2 */
        code_map.put(java.awt.event.KeyEvent.VK_LESS,Key.LESS);

        /** @since 1.2 */
        code_map.put(java.awt.event.KeyEvent.VK_GREATER,Key.GREATER);
        /** @since 1.2 */
        code_map.put(java.awt.event.KeyEvent.VK_BRACELEFT,Key.BRACELEFT);
        /** @since 1.2 */
        code_map.put(java.awt.event.KeyEvent.VK_BRACERIGHT,Key.BRACERIGHT);

        /**
         * Constant for the "@" key.
         * @since 1.2
         */
        code_map.put(java.awt.event.KeyEvent.VK_AT,Key.AT);

        /**
         * Constant for the ":" key.
         * @since 1.2
         */
        code_map.put(java.awt.event.KeyEvent.VK_COLON,Key.COLON);

        /**
         * Constant for the "^" key.
         * @since 1.2
         */
        code_map.put(java.awt.event.KeyEvent.VK_CIRCUMFLEX,Key.CIRCUMFLEX);

        /**
         * Constant for the "$" key.
         * @since 1.2
         */
        code_map.put(java.awt.event.KeyEvent.VK_DOLLAR,Key.DOLLAR);

        /**
         * Constant for the Euro currency sign key.
         * @since 1.2
         */
        code_map.put(java.awt.event.KeyEvent.VK_EURO_SIGN,Key.EURO_SIGN);

        /**
         * Constant for the "!" key.
         * @since 1.2
         */
        code_map.put(java.awt.event.KeyEvent.VK_EXCLAMATION_MARK,Key.EXCLAMATION_MARK);

        /**
         * Constant for the inverted exclamation mark key.
         * @since 1.2
         */
        code_map.put(java.awt.event.KeyEvent.VK_INVERTED_EXCLAMATION_MARK,Key.INVERTED_EXCLAMATION_MARK);

        /**
         * Constant for the "(" key.
         * @since 1.2
         */
        code_map.put(java.awt.event.KeyEvent.VK_LEFT_PARENTHESIS,Key.LEFT_PARENTHESIS);

        /**
         * Constant for the "#" key.
         * @since 1.2
         */
        code_map.put(java.awt.event.KeyEvent.VK_NUMBER_SIGN,Key.NUMBER_SIGN);

        /**
         * Constant for the "+" key.
         * @since 1.2
         */
        code_map.put(java.awt.event.KeyEvent.VK_PLUS,Key.PLUS);

        /**
         * Constant for the ")" key.
         * @since 1.2
         */
        code_map.put(java.awt.event.KeyEvent.VK_RIGHT_PARENTHESIS,Key.RIGHT_PARENTHESIS);

        /**
         * Constant for the "_" key.
         * @since 1.2
         */
        code_map.put(java.awt.event.KeyEvent.VK_UNDERSCORE,Key.UNDERSCORE);

        /**
         * Constant for the Microsoft Windows "Windows" key.
         * It is used for both the left and right version of the key.
         * @see #getKeyLocation()
         * @since 1.5
         */
        code_map.put(java.awt.event.KeyEvent.VK_WINDOWS,Key.WINDOWS);

        /**
         * Constant for the Microsoft Windows Context Menu key.
         * @since 1.5
         */
        code_map.put(java.awt.event.KeyEvent.VK_CONTEXT_MENU,Key.CONTEXT_MENU);

    /* for input method support on Asian Keyboards */

    /* not clear what this means - listed in Microsoft Windows API */
        code_map.put(java.awt.event.KeyEvent.VK_FINAL,Key.FINAL);

        /** Constant for the Convert function key. */
    /* Japanese PC 106 keyboard, Japanese Solaris keyboard: henkan */
        code_map.put(java.awt.event.KeyEvent.VK_CONVERT,Key.CONVERT);

        /** Constant for the Don't Convert function key. */
    /* Japanese PC 106 keyboard: muhenkan */
        code_map.put(java.awt.event.KeyEvent.VK_NONCONVERT,Key.NONCONVERT);

        /** Constant for the Accept or Commit function key. */
    /* Japanese Solaris keyboard: kakutei */
        code_map.put(java.awt.event.KeyEvent.VK_ACCEPT,Key.ACCEPT);

    /* not clear what this means - listed in Microsoft Windows API */
        code_map.put(java.awt.event.KeyEvent.VK_MODECHANGE,Key.MODECHANGE);

    /* replaced by VK_KANA_LOCK for Microsoft Windows and Solaris;
       might still be used on other platforms */
        code_map.put(java.awt.event.KeyEvent.VK_KANA,Key.KANA);

    /* replaced by VK_INPUT_METHOD_ON_OFF for Microsoft Windows and Solaris;
       might still be used for other platforms */
        code_map.put(java.awt.event.KeyEvent.VK_KANJI,Key.KANJI);

        /**
         * Constant for the Alphanumeric function key.
         * @since 1.2
         */
    /* Japanese PC 106 keyboard: eisuu */
        code_map.put(java.awt.event.KeyEvent.VK_ALPHANUMERIC,Key.ALPHANUMERIC);

        /**
         * Constant for the Katakana function key.
         * @since 1.2
         */
    /* Japanese PC 106 keyboard: katakana */
        code_map.put(java.awt.event.KeyEvent.VK_KATAKANA,Key.KATAKANA);

        /**
         * Constant for the Hiragana function key.
         * @since 1.2
         */
    /* Japanese PC 106 keyboard: hiragana */
        code_map.put(java.awt.event.KeyEvent.VK_HIRAGANA,Key.HIRAGANA);

        /**
         * Constant for the Full-Width Characters function key.
         * @since 1.2
         */
    /* Japanese PC 106 keyboard: zenkaku */
        code_map.put(java.awt.event.KeyEvent.VK_FULL_WIDTH,Key.FULL_WIDTH);

        /**
         * Constant for the Half-Width Characters function key.
         * @since 1.2
         */
    /* Japanese PC 106 keyboard: hankaku */
        code_map.put(java.awt.event.KeyEvent.VK_HALF_WIDTH,Key.HALF_WIDTH);

        /**
         * Constant for the Roman Characters function key.
         * @since 1.2
         */
    /* Japanese PC 106 keyboard: roumaji */
        code_map.put(java.awt.event.KeyEvent.VK_ROMAN_CHARACTERS,Key.ROMAN_CHARACTERS);

        /**
         * Constant for the All Candidates function key.
         * @since 1.2
         */
    /* Japanese PC 106 keyboard - VK_CONVERT + ALT: zenkouho */
        code_map.put(java.awt.event.KeyEvent.VK_ALL_CANDIDATES,Key.ALL_CANDIDATES);

        /**
         * Constant for the Previous Candidate function key.
         * @since 1.2
         */
    /* Japanese PC 106 keyboard - VK_CONVERT + SHIFT: maekouho */
        code_map.put(java.awt.event.KeyEvent.VK_PREVIOUS_CANDIDATE,Key.PREVIOUS_CANDIDATE);

        /**
         * Constant for the Code Input function key.
         * @since 1.2
         */
    /* Japanese PC 106 keyboard - VK_ALPHANUMERIC + ALT: kanji bangou */
        code_map.put(java.awt.event.KeyEvent.VK_CODE_INPUT,Key.CODE_INPUT);

        /**
         * Constant for the Japanese-Katakana function key.
         * This key switches to a Japanese input method and selects its Katakana input mode.
         * @since 1.2
         */
    /* Japanese Macintosh keyboard - VK_JAPANESE_HIRAGANA + SHIFT */
        code_map.put(java.awt.event.KeyEvent.VK_JAPANESE_KATAKANA,Key.JAPANESE_KATAKANA);

        /**
         * Constant for the Japanese-Hiragana function key.
         * This key switches to a Japanese input method and selects its Hiragana input mode.
         * @since 1.2
         */
    /* Japanese Macintosh keyboard */
        code_map.put(java.awt.event.KeyEvent.VK_JAPANESE_HIRAGANA,Key.JAPANESE_HIRAGANA);

        /**
         * Constant for the Japanese-Roman function key.
         * This key switches to a Japanese input method and selects its Roman-Direct input mode.
         * @since 1.2
         */
    /* Japanese Macintosh keyboard */
        code_map.put(java.awt.event.KeyEvent.VK_JAPANESE_ROMAN,Key.JAPANESE_ROMAN);

        /**
         * Constant for the locking Kana function key.
         * This key locks the keyboard into a Kana layout.
         * @since 1.3
         */
    /* Japanese PC 106 keyboard with special Windows driver - eisuu + Control; Japanese Solaris

     */
        code_map.put(java.awt.event.KeyEvent.VK_KANA_LOCK,Key.KANA_LOCK);

        /**
         * Constant for the input method on/off key.
         * @since 1.3
         */
    /* Japanese PC 106 keyboard: kanji. Japanese Solaris keyboard: nihongo */
        code_map.put(java.awt.event.KeyEvent.VK_INPUT_METHOD_ON_OFF,Key.INPUT_METHOD_ON_OFF);

    /* for Sun keyboards */
        /** @since 1.2 */
        code_map.put(java.awt.event.KeyEvent.VK_CUT,Key.CUT);
        /** @since 1.2 */
        code_map.put(java.awt.event.KeyEvent.VK_COPY,Key.COPY);
        /** @since 1.2 */
        code_map.put(java.awt.event.KeyEvent.VK_PASTE,Key.PASTE);
        /** @since 1.2 */
        code_map.put(java.awt.event.KeyEvent.VK_UNDO,Key.UNDO);
        /** @since 1.2 */
        code_map.put(java.awt.event.KeyEvent.VK_AGAIN,Key.AGAIN);
        /** @since 1.2 */
        code_map.put(java.awt.event.KeyEvent.VK_FIND,Key.FIND);
        /** @since 1.2 */
        code_map.put(java.awt.event.KeyEvent.VK_PROPS,Key.PROPS);
        /** @since 1.2 */
        code_map.put(java.awt.event.KeyEvent.VK_STOP,Key.STOP);

        /**
         * Constant for the Compose function key.
         * @since 1.2
         */
        code_map.put(java.awt.event.KeyEvent.VK_COMPOSE,Key.COMPOSE);

        /**
         * Constant for the AltGraph function key.
         * @since 1.2
         */
        code_map.put(java.awt.event.KeyEvent.VK_ALT_GRAPH,Key.ALT_GRAPH);

        /**
         * Constant for the Begin key.
         * @since 1.5
         */
        code_map.put(java.awt.event.KeyEvent.VK_BEGIN,Key.BEGIN);

    }

    Key key = Key.UNDEFINED;
    KeyState state = KeyState.KEY_UNKOWN;

    AWTKeyInfo(KeyEvent evt, KeyState state) {
        key = code_map.getOrDefault(evt.getKeyCode(), Key.UNDEFINED);
        this.state = state;
    }

    @Override
    public Key getKey() {
        return key;
    }

    @Override
    public KeyState getKeyState() {
        return state;
    }
}
