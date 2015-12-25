package io.github.antijava.marjio.input;

import io.github.antijava.marjio.common.Key;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by firejox on 2015/12/25.
 */

interface IKeyConverter {
    Key convert(Object obj) ;
}

public final class KeyConverter  {

    static private final Map<Class, IKeyConverter> convert;

    static {
        convert = new HashMap<>();
        convert.put(java.awt.event.KeyEvent.class, (Object obj) -> {
            java.awt.event.KeyEvent evt = (java.awt.event.KeyEvent) obj;

            switch (evt.getKeyCode()) {

                case java.awt.event.KeyEvent.VK_ENTER:
                    return Key.ENTER;
                case java.awt.event.KeyEvent.VK_BACK_SPACE:
                    return Key.BACK_SPACE;
                case java.awt.event.KeyEvent.VK_TAB:
                    return Key.TAB;
                case java.awt.event.KeyEvent.VK_CANCEL:
                    return Key.CANCEL;
                case java.awt.event.KeyEvent.VK_CLEAR:
                    return Key.CLEAR;
                case java.awt.event.KeyEvent.VK_SHIFT:
                    return Key.SHIFT;
                case java.awt.event.KeyEvent.VK_CONTROL:
                    return Key.CONTROL;
                case java.awt.event.KeyEvent.VK_ALT:
                    return Key.ALT;
                case java.awt.event.KeyEvent.VK_PAUSE:
                    return Key.PAUSE;
                case java.awt.event.KeyEvent.VK_CAPS_LOCK:
                    return Key.CAPS;
                case java.awt.event.KeyEvent.VK_ESCAPE:
                    return Key.ESCAPE;
                case java.awt.event.KeyEvent.VK_SPACE:
                    return Key.SPACE;
                case java.awt.event.KeyEvent.VK_PAGE_UP:
                    return Key.PAGE_UP;
                case java.awt.event.KeyEvent.VK_PAGE_DOWN:
                    return Key.PAGE_DOWN;
                case java.awt.event.KeyEvent.VK_END:
                    return Key.END;
                case java.awt.event.KeyEvent.VK_HOME:
                    return Key.HOME;

                /**
                 * Constant for the non-numpad <b>left</b> arrow key.
                 * @see #VK_KP_LEFT
                 */
                case java.awt.event.KeyEvent.VK_LEFT:
                    return Key.LEFT;

                /**
                 * Constant for the non-numpad <b>up</b> arrow key.
                 * @see #VK_KP_UP
                 */
                case java.awt.event.KeyEvent.VK_UP:
                    return Key.UP;

                /**
                 * Constant for the non-numpad <b>right</b> arrow key.
                 * @see #VK_KP_RIGHT
                 */
                case java.awt.event.KeyEvent.VK_RIGHT:
                    return Key.RIGHT;

                /**
                 * Constant for the non-numpad <b>down</b> arrow key.
                 * @see #VK_KP_DOWN
                 */
                case java.awt.event.KeyEvent.VK_DOWN:
                    return Key.DOWN;

                /**
                 * Constant for the comma key, ","
                 */
                case java.awt.event.KeyEvent.VK_COMMA:
                    return Key.COMMA;

                /**
                 * Constant for the minus key, "-"
                 * @since 1.2
                 */
                case java.awt.event.KeyEvent.VK_MINUS:
                    return Key.MINUS;

                /**
                 * Constant for the period key, "."
                 */
                case java.awt.event.KeyEvent.VK_PERIOD:
                    return Key.PERIOD;

                /**
                 * Constant for the forward slash key, "/"
                 */
                case java.awt.event.KeyEvent.VK_SLASH:
                    return Key.SLASH;

                /** VK_0 thru VK_9 are the same as ASCII '0' thru '9' (0x30 - 0x39) */
                case java.awt.event.KeyEvent.VK_0:
                    return Key.DIGIT0;
                case java.awt.event.KeyEvent.VK_1:
                    return Key.DIGIT1;
                case java.awt.event.KeyEvent.VK_2:
                    return Key.DIGIT2;
                case java.awt.event.KeyEvent.VK_3:
                    return Key.DIGIT3;
                case java.awt.event.KeyEvent.VK_4:
                    return Key.DIGIT4;
                case java.awt.event.KeyEvent.VK_5:
                    return Key.DIGIT5;
                case java.awt.event.KeyEvent.VK_6:
                    return Key.DIGIT6;
                case java.awt.event.KeyEvent.VK_7:
                    return Key.DIGIT7;
                case java.awt.event.KeyEvent.VK_8:
                    return Key.DIGIT8;
                case java.awt.event.KeyEvent.VK_9:
                    return Key.DIGIT9;

                /**
                 * Constant for the semicolon key, ";"
                 */
                case java.awt.event.KeyEvent.VK_SEMICOLON:
                    return Key.SEMICOLON;

                /**
                 * Constant for the equals key, "="
                 */
                case java.awt.event.KeyEvent.VK_EQUALS:
                    return Key.EQUALS;

                /** VK_A thru VK_Z are the same as ASCII 'A' thru 'Z' (0x41 - 0x5A) */
                case java.awt.event.KeyEvent.VK_A:
                    return Key.A;
                case java.awt.event.KeyEvent.VK_B:
                    return Key.B;
                case java.awt.event.KeyEvent.VK_C:
                    return Key.C;
                case java.awt.event.KeyEvent.VK_D:
                    return Key.D;
                case java.awt.event.KeyEvent.VK_E:
                    return Key.E;
                case java.awt.event.KeyEvent.VK_F:
                    return Key.F;
                case java.awt.event.KeyEvent.VK_G:
                    return Key.G;
                case java.awt.event.KeyEvent.VK_H:
                    return Key.H;
                case java.awt.event.KeyEvent.VK_I:
                    return Key.I;
                case java.awt.event.KeyEvent.VK_J:
                    return Key.J;
                case java.awt.event.KeyEvent.VK_K:
                    return Key.K;
                case java.awt.event.KeyEvent.VK_L:
                    return Key.L;
                case java.awt.event.KeyEvent.VK_M:
                    return Key.M;
                case java.awt.event.KeyEvent.VK_N:
                    return Key.N;
                case java.awt.event.KeyEvent.VK_O:
                    return Key.O;
                case java.awt.event.KeyEvent.VK_P:
                    return Key.P;
                case java.awt.event.KeyEvent.VK_Q:
                    return Key.Q;
                case java.awt.event.KeyEvent.VK_R:
                    return Key.R;
                case java.awt.event.KeyEvent.VK_S:
                    return Key.S;
                case java.awt.event.KeyEvent.VK_T:
                    return Key.T;
                case java.awt.event.KeyEvent.VK_U:
                    return Key.U;
                case java.awt.event.KeyEvent.VK_V:
                    return Key.V;
                case java.awt.event.KeyEvent.VK_W:
                    return Key.W;
                case java.awt.event.KeyEvent.VK_X:
                    return Key.X;
                case java.awt.event.KeyEvent.VK_Y:
                    return Key.Y;
                case java.awt.event.KeyEvent.VK_Z:
                    return Key.Z;

                /**
                 * Constant for the open bracket key, "["
                 */
                case java.awt.event.KeyEvent.VK_OPEN_BRACKET:
                    return Key.OPEN_BRACKET;

                /**
                 * Constant for the back slash key, "\"
                 */
                case java.awt.event.KeyEvent.VK_BACK_SLASH:
                    return Key.BACK_SLASH;

                /**
                 * Constant for the close bracket key, "]"
                 */
                case java.awt.event.KeyEvent.VK_CLOSE_BRACKET:
                    return Key.CLOSE_BRACKET;

                case java.awt.event.KeyEvent.VK_NUMPAD0:
                    return Key.NUMPAD0;
                case java.awt.event.KeyEvent.VK_NUMPAD1:
                    return Key.NUMPAD1;
                case java.awt.event.KeyEvent.VK_NUMPAD2:
                    return Key.NUMPAD2;
                case java.awt.event.KeyEvent.VK_NUMPAD3:
                    return Key.NUMPAD3;
                case java.awt.event.KeyEvent.VK_NUMPAD4:
                    return Key.NUMPAD4;
                case java.awt.event.KeyEvent.VK_NUMPAD5:
                    return Key.NUMPAD5;
                case java.awt.event.KeyEvent.VK_NUMPAD6:
                    return Key.NUMPAD6;
                case java.awt.event.KeyEvent.VK_NUMPAD7:
                    return Key.NUMPAD7;
                case java.awt.event.KeyEvent.VK_NUMPAD8:
                    return Key.NUMPAD8;
                case java.awt.event.KeyEvent.VK_NUMPAD9:
                    return Key.NUMPAD9;
                case java.awt.event.KeyEvent.VK_MULTIPLY:
                    return Key.MULTIPLY;
                case java.awt.event.KeyEvent.VK_ADD:
                    return Key.ADD;

                /**
                 * This constant is obsolete, and is included only for backwards
                 * compatibility.
                 * @see #VK_SEPARATOR
                 */
                case java.awt.event.KeyEvent.VK_SEPARATER:
                    return Key.SEPARATOR;

                /**
                 * Constant for the Numpad Separator key.
                 * @since 1.4
                 */

                case java.awt.event.KeyEvent.VK_SUBTRACT:
                    return Key.SUBTRACT;
                case java.awt.event.KeyEvent.VK_DECIMAL:
                    return Key.DECIMAL;
                case java.awt.event.KeyEvent.VK_DIVIDE:
                    return Key.DIVIDE;
                case java.awt.event.KeyEvent.VK_DELETE:
                    return Key.DELETE; /* ASCII DEL */
                case java.awt.event.KeyEvent.VK_NUM_LOCK:
                    return Key.NUM_LOCK;
                case java.awt.event.KeyEvent.VK_SCROLL_LOCK:
                    return Key.SCROLL_LOCK;

                /** Constant for the F1 function key. */
                case java.awt.event.KeyEvent.VK_F1:
                    return Key.F1;

                /** Constant for the F2 function key. */
                case java.awt.event.KeyEvent.VK_F2:
                    return Key.F2;

                /** Constant for the F3 function key. */
                case java.awt.event.KeyEvent.VK_F3:
                    return Key.F3;

                /** Constant for the F4 function key. */
                case java.awt.event.KeyEvent.VK_F4:
                    return Key.F4;

                /** Constant for the F5 function key. */
                case java.awt.event.KeyEvent.VK_F5:
                    return Key.F5;

                /** Constant for the F6 function key. */
                case java.awt.event.KeyEvent.VK_F6:
                    return Key.F6;

                /** Constant for the F7 function key. */
                case java.awt.event.KeyEvent.VK_F7:
                    return Key.F7;

                /** Constant for the F8 function key. */
                case java.awt.event.KeyEvent.VK_F8:
                    return Key.F8;

                /** Constant for the F9 function key. */
                case java.awt.event.KeyEvent.VK_F9:
                    return Key.F9;

                /** Constant for the F10 function key. */
                case java.awt.event.KeyEvent.VK_F10:
                    return Key.F10;

                /** Constant for the F11 function key. */
                case java.awt.event.KeyEvent.VK_F11:
                    return Key.F11;

                /** Constant for the F12 function key. */
                case java.awt.event.KeyEvent.VK_F12:
                    return Key.F12;

                /**
                 * Constant for the F13 function key.
                 * @since 1.2
                 */
    /* F13 - F24 are used on IBM 3270 keyboard; use random range for constants. */
                case java.awt.event.KeyEvent.VK_F13:
                    return Key.F13;

                /**
                 * Constant for the F14 function key.
                 * @since 1.2
                 */
                case java.awt.event.KeyEvent.VK_F14:
                    return Key.F14;

                /**
                 * Constant for the F15 function key.
                 * @since 1.2
                 */
                case java.awt.event.KeyEvent.VK_F15:
                    return Key.F15;

                /**
                 * Constant for the F16 function key.
                 * @since 1.2
                 */
                case java.awt.event.KeyEvent.VK_F16:
                    return Key.F16;

                /**
                 * Constant for the F17 function key.
                 * @since 1.2
                 */
                case java.awt.event.KeyEvent.VK_F17:
                    return Key.F17;

                /**
                 * Constant for the F18 function key.
                 * @since 1.2
                 */
                case java.awt.event.KeyEvent.VK_F18:
                    return Key.F18;

                /**
                 * Constant for the F19 function key.
                 * @since 1.2
                 */
                case java.awt.event.KeyEvent.VK_F19:
                    return Key.F19;

                /**
                 * Constant for the F20 function key.
                 * @since 1.2
                 */
                case java.awt.event.KeyEvent.VK_F20:
                    return Key.F20;

                /**
                 * Constant for the F21 function key.
                 * @since 1.2
                 */
                case java.awt.event.KeyEvent.VK_F21:
                    return Key.F21;

                /**
                 * Constant for the F22 function key.
                 * @since 1.2
                 */
                case java.awt.event.KeyEvent.VK_F22:
                    return Key.F22;

                /**
                 * Constant for the F23 function key.
                 * @since 1.2
                 */
                case java.awt.event.KeyEvent.VK_F23:
                    return Key.F23;

                /**
                 * Constant for the F24 function key.
                 * @since 1.2
                 */
                case java.awt.event.KeyEvent.VK_F24:
                    return Key.F24;

                case java.awt.event.KeyEvent.VK_PRINTSCREEN:
                    return Key.PRINTSCREEN;
                case java.awt.event.KeyEvent.VK_INSERT:
                    return Key.INSERT;
                case java.awt.event.KeyEvent.VK_HELP:
                    return Key.HELP;
                case java.awt.event.KeyEvent.VK_META:
                    return Key.META;

                case java.awt.event.KeyEvent.VK_BACK_QUOTE:
                    return Key.BACK_QUOTE;
                case java.awt.event.KeyEvent.VK_QUOTE:
                    return Key.QUOTE;

                /**
                 * Constant for the numeric keypad <b>up</b> arrow key.
                 * @see #VK_UP
                 * @since 1.2
                 */
                case java.awt.event.KeyEvent.VK_KP_UP:
                    return Key.KP_UP;

                /**
                 * Constant for the numeric keypad <b>down</b> arrow key.
                 * @see #VK_DOWN
                 * @since 1.2
                 */
                case java.awt.event.KeyEvent.VK_KP_DOWN:
                    return Key.KP_DOWN;

                /**
                 * Constant for the numeric keypad <b>left</b> arrow key.
                 * @see #VK_LEFT
                 * @since 1.2
                 */
                case java.awt.event.KeyEvent.VK_KP_LEFT:
                    return Key.KP_LEFT;

                /**
                 * Constant for the numeric keypad <b>right</b> arrow key.
                 * @see #VK_RIGHT
                 * @since 1.2
                 */
                case java.awt.event.KeyEvent.VK_KP_RIGHT:
                    return Key.KP_RIGHT;

    /* For European keyboards */
                /** @since 1.2 */
                case java.awt.event.KeyEvent.VK_DEAD_GRAVE:
                    return Key.DEAD_GRAVE;
                /** @since 1.2 */
                case java.awt.event.KeyEvent.VK_DEAD_ACUTE:
                    return Key.DEAD_ACUTE;
                /** @since 1.2 */
                case java.awt.event.KeyEvent.VK_DEAD_CIRCUMFLEX:
                    return Key.DEAD_CIRCUMFLEX;
                /** @since 1.2 */
                case java.awt.event.KeyEvent.VK_DEAD_TILDE:
                    return Key.DEAD_TILDE;
                /** @since 1.2 */
                case java.awt.event.KeyEvent.VK_DEAD_MACRON:
                    return Key.DEAD_MACRON;
                /** @since 1.2 */
                case java.awt.event.KeyEvent.VK_DEAD_BREVE:
                    return Key.DEAD_BREVE;
                /** @since 1.2 */
                case java.awt.event.KeyEvent.VK_DEAD_ABOVEDOT:
                    return Key.DEAD_ABOVEDOT;
                /** @since 1.2 */
                case java.awt.event.KeyEvent.VK_DEAD_DIAERESIS:
                    return Key.DEAD_DIAERESIS;
                /** @since 1.2 */
                case java.awt.event.KeyEvent.VK_DEAD_ABOVERING:
                    return Key.DEAD_ABOVERING;
                /** @since 1.2 */
                case java.awt.event.KeyEvent.VK_DEAD_DOUBLEACUTE:
                    return Key.DEAD_DOUBLEACUTE;
                /** @since 1.2 */
                case java.awt.event.KeyEvent.VK_DEAD_CARON:
                    return Key.DEAD_CARON;
                /** @since 1.2 */
                case java.awt.event.KeyEvent.VK_DEAD_CEDILLA:
                    return Key.DEAD_CEDILLA;
                /** @since 1.2 */
                case java.awt.event.KeyEvent.VK_DEAD_OGONEK:
                    return Key.DEAD_OGONEK;
                /** @since 1.2 */
                case java.awt.event.KeyEvent.VK_DEAD_IOTA:
                    return Key.DEAD_IOTA;
                /** @since 1.2 */
                case java.awt.event.KeyEvent.VK_DEAD_VOICED_SOUND:
                    return Key.DEAD_VOICED_SOUND;
                /** @since 1.2 */
                case java.awt.event.KeyEvent.VK_DEAD_SEMIVOICED_SOUND:
                    return Key.DEAD_SEMIVOICED_SOUND;

                /** @since 1.2 */
                case java.awt.event.KeyEvent.VK_AMPERSAND:
                    return Key.AMPERSAND;
                /** @since 1.2 */
                case java.awt.event.KeyEvent.VK_ASTERISK:
                    return Key.ASTERISK;
                /** @since 1.2 */
                case java.awt.event.KeyEvent.VK_QUOTEDBL:
                    return Key.QUOTEDBL;
                /** @since 1.2 */
                case java.awt.event.KeyEvent.VK_LESS:
                    return Key.LESS;

                /** @since 1.2 */
                case java.awt.event.KeyEvent.VK_GREATER:
                    return Key.GREATER;
                /** @since 1.2 */
                case java.awt.event.KeyEvent.VK_BRACELEFT:
                    return Key.BRACELEFT;
                /** @since 1.2 */
                case java.awt.event.KeyEvent.VK_BRACERIGHT:
                    return Key.BRACERIGHT;

                /**
                 * Constant for the "@" key.
                 * @since 1.2
                 */
                case java.awt.event.KeyEvent.VK_AT:
                    return Key.AT;

                /**
                 * Constant for the ":" key.
                 * @since 1.2
                 */
                case java.awt.event.KeyEvent.VK_COLON:
                    return Key.COLON;

                /**
                 * Constant for the "^" key.
                 * @since 1.2
                 */
                case java.awt.event.KeyEvent.VK_CIRCUMFLEX:
                    return Key.CIRCUMFLEX;

                /**
                 * Constant for the "$" key.
                 * @since 1.2
                 */
                case java.awt.event.KeyEvent.VK_DOLLAR:
                    return Key.DOLLAR;

                /**
                 * Constant for the Euro currency sign key.
                 * @since 1.2
                 */
                case java.awt.event.KeyEvent.VK_EURO_SIGN:
                    return Key.EURO_SIGN;

                /**
                 * Constant for the "!" key.
                 * @since 1.2
                 */
                case java.awt.event.KeyEvent.VK_EXCLAMATION_MARK:
                    return Key.EXCLAMATION_MARK;

                /**
                 * Constant for the inverted exclamation mark key.
                 * @since 1.2
                 */
                case java.awt.event.KeyEvent.VK_INVERTED_EXCLAMATION_MARK:
                    return Key.INVERTED_EXCLAMATION_MARK;

                /**
                 * Constant for the "(" key.
                 * @since 1.2
                 */
                case java.awt.event.KeyEvent.VK_LEFT_PARENTHESIS:
                    return Key.LEFT_PARENTHESIS;

                /**
                 * Constant for the "#" key.
                 * @since 1.2
                 */
                case java.awt.event.KeyEvent.VK_NUMBER_SIGN:
                    return Key.NUMBER_SIGN;

                /**
                 * Constant for the "+" key.
                 * @since 1.2
                 */
                case java.awt.event.KeyEvent.VK_PLUS:
                    return Key.PLUS;

                /**
                 * Constant for the ")" key.
                 * @since 1.2
                 */
                case java.awt.event.KeyEvent.VK_RIGHT_PARENTHESIS:
                    return Key.RIGHT_PARENTHESIS;

                /**
                 * Constant for the "_" key.
                 * @since 1.2
                 */
                case java.awt.event.KeyEvent.VK_UNDERSCORE:
                    return Key.UNDERSCORE;

                /**
                 * Constant for the Microsoft Windows "Windows" key.
                 * It is used for both the left and right version of the key.
                 * @see #getKeyLocation()
                 * @since 1.5
                 */
                case java.awt.event.KeyEvent.VK_WINDOWS:
                    return Key.WINDOWS;

                /**
                 * Constant for the Microsoft Windows Context Menu key.
                 * @since 1.5
                 */
                case java.awt.event.KeyEvent.VK_CONTEXT_MENU:
                    return Key.CONTEXT_MENU;

    /* for input method support on Asian Keyboards */

    /* not clear what this means - listed in Microsoft Windows API */
                case java.awt.event.KeyEvent.VK_FINAL:
                    return Key.FINAL;

                /** Constant for the Convert function key. */
    /* Japanese PC 106 keyboard, Japanese Solaris keyboard: henkan */
                case java.awt.event.KeyEvent.VK_CONVERT:
                    return Key.CONVERT;

                /** Constant for the Don't Convert function key. */
    /* Japanese PC 106 keyboard: muhenkan */
                case java.awt.event.KeyEvent.VK_NONCONVERT:
                    return Key.NONCONVERT;

                /** Constant for the Accept or Commit function key. */
    /* Japanese Solaris keyboard: kakutei */
                case java.awt.event.KeyEvent.VK_ACCEPT:
                    return Key.ACCEPT;

    /* not clear what this means - listed in Microsoft Windows API */
                case java.awt.event.KeyEvent.VK_MODECHANGE:
                    return Key.MODECHANGE;

    /* replaced by VK_KANA_LOCK for Microsoft Windows and Solaris;
       might still be used on other platforms */
                case java.awt.event.KeyEvent.VK_KANA:
                    return Key.KANA;

    /* replaced by VK_INPUT_METHOD_ON_OFF for Microsoft Windows and Solaris;
       might still be used for other platforms */
                case java.awt.event.KeyEvent.VK_KANJI:
                    return Key.KANJI;

                /**
                 * Constant for the Alphanumeric function key.
                 * @since 1.2
                 */
    /* Japanese PC 106 keyboard: eisuu */
                case java.awt.event.KeyEvent.VK_ALPHANUMERIC:
                    return Key.ALPHANUMERIC;

                /**
                 * Constant for the Katakana function key.
                 * @since 1.2
                 */
    /* Japanese PC 106 keyboard: katakana */
                case java.awt.event.KeyEvent.VK_KATAKANA:
                    return Key.KATAKANA;

                /**
                 * Constant for the Hiragana function key.
                 * @since 1.2
                 */
    /* Japanese PC 106 keyboard: hiragana */
                case java.awt.event.KeyEvent.VK_HIRAGANA:
                    return Key.HIRAGANA;

                /**
                 * Constant for the Full-Width Characters function key.
                 * @since 1.2
                 */
    /* Japanese PC 106 keyboard: zenkaku */
                case java.awt.event.KeyEvent.VK_FULL_WIDTH:
                    return Key.FULL_WIDTH;

                /**
                 * Constant for the Half-Width Characters function key.
                 * @since 1.2
                 */
    /* Japanese PC 106 keyboard: hankaku */
                case java.awt.event.KeyEvent.VK_HALF_WIDTH:
                    return Key.HALF_WIDTH;

                /**
                 * Constant for the Roman Characters function key.
                 * @since 1.2
                 */
    /* Japanese PC 106 keyboard: roumaji */
                case java.awt.event.KeyEvent.VK_ROMAN_CHARACTERS:
                    return Key.ROMAN_CHARACTERS;

                /**
                 * Constant for the All Candidates function key.
                 * @since 1.2
                 */
    /* Japanese PC 106 keyboard - VK_CONVERT + ALT: zenkouho */
                case java.awt.event.KeyEvent.VK_ALL_CANDIDATES:
                    return Key.ALL_CANDIDATES;

                /**
                 * Constant for the Previous Candidate function key.
                 * @since 1.2
                 */
    /* Japanese PC 106 keyboard - VK_CONVERT + SHIFT: maekouho */
                case java.awt.event.KeyEvent.VK_PREVIOUS_CANDIDATE:
                    return Key.PREVIOUS_CANDIDATE;

                /**
                 * Constant for the Code Input function key.
                 * @since 1.2
                 */
    /* Japanese PC 106 keyboard - VK_ALPHANUMERIC + ALT: kanji bangou */
                case java.awt.event.KeyEvent.VK_CODE_INPUT:
                    return Key.CODE_INPUT;

                /**
                 * Constant for the Japanese-Katakana function key.
                 * This key switches to a Japanese input method and selects its Katakana input mode.
                 * @since 1.2
                 */
    /* Japanese Macintosh keyboard - VK_JAPANESE_HIRAGANA + SHIFT */
                case java.awt.event.KeyEvent.VK_JAPANESE_KATAKANA:
                    return Key.JAPANESE_KATAKANA;

                /**
                 * Constant for the Japanese-Hiragana function key.
                 * This key switches to a Japanese input method and selects its Hiragana input mode.
                 * @since 1.2
                 */
    /* Japanese Macintosh keyboard */
                case java.awt.event.KeyEvent.VK_JAPANESE_HIRAGANA:
                    return Key.JAPANESE_HIRAGANA;

                /**
                 * Constant for the Japanese-Roman function key.
                 * This key switches to a Japanese input method and selects its Roman-Direct input mode.
                 * @since 1.2
                 */
    /* Japanese Macintosh keyboard */
                case java.awt.event.KeyEvent.VK_JAPANESE_ROMAN:
                    return Key.JAPANESE_ROMAN;

                /**
                 * Constant for the locking Kana function key.
                 * This key locks the keyboard into a Kana layout.
                 * @since 1.3
                 */
    /* Japanese PC 106 keyboard with special Windows driver - eisuu + Control; Japanese Solaris

     */
                case java.awt.event.KeyEvent.VK_KANA_LOCK:
                    return Key.KANA_LOCK;

    /**
     * Constant for the input method on/off key.
     * @since 1.3
     */
    /* Japanese PC 106 keyboard: kanji. Japanese Solaris keyboard: nihongo */
                case java.awt.event.KeyEvent.VK_INPUT_METHOD_ON_OFF:
                    return Key.INPUT_METHOD_ON_OFF;

    /* for Sun keyboards */
                /** @since 1.2 */
                case java.awt.event.KeyEvent.VK_CUT:
                    return Key.CUT;
                /** @since 1.2 */
                case java.awt.event.KeyEvent.VK_COPY:
                    return Key.COPY;
                /** @since 1.2 */
                case java.awt.event.KeyEvent.VK_PASTE:
                    return Key.PASTE;
                /** @since 1.2 */
                case java.awt.event.KeyEvent.VK_UNDO:
                    return Key.UNDO;
                /** @since 1.2 */
                case java.awt.event.KeyEvent.VK_AGAIN:
                    return Key.AGAIN;
                /** @since 1.2 */
                case java.awt.event.KeyEvent.VK_FIND:
                    return Key.FIND;
                /** @since 1.2 */
                case java.awt.event.KeyEvent.VK_PROPS:
                    return Key.PROPS;
                /** @since 1.2 */
                case java.awt.event.KeyEvent.VK_STOP:
                    return Key.STOP;

                /**
                 * Constant for the Compose function key.
                 * @since 1.2
                 */
                case java.awt.event.KeyEvent.VK_COMPOSE:
                    return Key.COMPOSE;

                /**
                 * Constant for the AltGraph function key.
                 * @since 1.2
                 */
                case java.awt.event.KeyEvent.VK_ALT_GRAPH:
                    return Key.ALT_GRAPH;

                /**
                 * Constant for the Begin key.
                 * @since 1.5
                 */
                case java.awt.event.KeyEvent.VK_BEGIN:
                    return Key.BEGIN;

                default:
                    return Key.UNDEFINED;
            }
        });

    }

    static Key convert(Object obj) {

        return convert
                .getOrDefault(obj.getClass(), (Object o)->Key.UNDEFINED)
                .convert(obj);
    }
}


