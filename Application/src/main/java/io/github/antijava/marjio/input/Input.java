package io.github.antijava.marjio.input;

import io.github.antijava.marjio.common.IInput;
import io.github.antijava.marjio.common.input.*;
import io.github.antijava.marjio.common.input.IKeyInfo.KeyState;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by firejox on 2015/12/25.
 */
public final class Input implements IInput {
    static final Map<Key, Key> sKeymap = new EnumMap<>(Key.class);

    static {
        sKeymap.put(Key.JUMP, Key.UP);
        sKeymap.put(Key.MOVE_RIGHT, Key.RIGHT);
        sKeymap.put(Key.MOVE_LEFT, Key.LEFT);
        sKeymap.put(Key.CROUCH, Key.DOWN);
    }

    private boolean  mAnyKeyPressed;
    private Set<Key> mNextKeys;
    private Set<Key> mCurrentKeys;
    private Set<Key> mPreviousKeys;
    private Map<Key, Integer> mKeyRepeatCount;

    private Vector<Status> mStatuses;
    private Vector<Status> mStatusesCached;

    private Vector<Request> mRequests;
    private Vector<Request> mRequestsCached;

    private ReadWriteLock mLock;

    public Input() {
        mAnyKeyPressed = false;

        mNextKeys = EnumSet.noneOf(Key.class);
        mCurrentKeys = EnumSet.noneOf(Key.class);
        mPreviousKeys = EnumSet.noneOf(Key.class);

        mKeyRepeatCount = new EnumMap<>(Key.class);

        mStatuses = new Vector<>();
        mStatusesCached = new Vector<>();
        mRequests = new Vector<>();
        mRequestsCached = new Vector<>();

        mLock = new ReentrantReadWriteLock();
    }

    @Override
    public void update() {
        // Lock for swapping spaces
        mLock.writeLock().lock();

        mPreviousKeys.clear();
        mPreviousKeys.addAll(mNextKeys);

        // Rolling optimized
        final Set<Key> tmpKeys = mPreviousKeys;
        mPreviousKeys = mCurrentKeys;
        mCurrentKeys = mNextKeys;
        mNextKeys = tmpKeys;

        // Switching using Vector for optimization
        final Vector<Request> tmpRequest = mRequestsCached;
        mRequestsCached = mRequests;
        mRequests = tmpRequest;
        mRequests.clear();

        // Switching using Vector for optimization
        final Vector<Status> tmpStatuses = mStatusesCached;
        mStatusesCached = mStatuses;
        mStatuses = tmpStatuses;
        mStatuses.clear();

        // Unlock
        mLock.writeLock().unlock();

        // If Any key Pressed then Exists some key not contain in PreviousKeys
        mAnyKeyPressed = !mPreviousKeys.containsAll(mCurrentKeys);

        // Reset released key's repeat count
        mKeyRepeatCount.keySet().stream()
                .filter(key -> !mCurrentKeys.contains(key))
                .forEach(key -> mKeyRepeatCount.put(key, -1));

        for (final Key key : mCurrentKeys)
            mKeyRepeatCount.put(key, mKeyRepeatCount.getOrDefault(key, -1) + 1);


    }

    @Override
    public boolean isPressing(final Key k) {
        final Key key = getRealKey(k);

        return key != Key.UNDEFINED &&
                (mPreviousKeys.contains(key) &&
                mCurrentKeys.contains(key));
    }

    @Override
    public boolean isPressed(final Key k) {
        final Key key = getRealKey(k);

        if (key == Key.UNDEFINED)
            return false;

        if (key == Key.ANY)
            return mAnyKeyPressed;

        return (!mPreviousKeys.contains(key) &&
                mCurrentKeys.contains(key));
    }

    @Override
    public boolean isReleased(final Key k) {
        final Key key = getRealKey(k);

        return key != Key.UNDEFINED &&
                (mPreviousKeys.contains(key) &&
                !mCurrentKeys.contains(key));
    }

    @Override
    public boolean isTrigger(Key key) {
        return isPressed(key) || isReleased(key);
    }

    @Override
    public boolean isRepeat(final Key k) {
        final Key key = getRealKey(k);
        final int count = mKeyRepeatCount.getOrDefault(key, -1);

        if (key == Key.UNDEFINED || count < 0) // Invalid key or not pressing
            return false;

        if (count == 0) // Just pressed, give it a repeat.
            return true;

        return (count >= key_start_ticks) &&
                (0 == ((count - key_start_ticks) % key_repeat_ticks));
    }

    @Override
    public List<Status> getStatuses() {
        return mStatusesCached;
    }

    @Override
    public List<Request> getRequest() {
        return mRequestsCached;
    }

    @Override
    public void triggerEvent(Event evt) {
        mLock.readLock().lock();

        switch (evt.getType()) {
            case Keyboard: {
                final IKeyInfo info = (IKeyInfo) evt.getData();

                if (info.getKeyState() == KeyState.KEY_PRESSED)
                    mNextKeys.add(info.getKey());
                else if (info.getKeyState() == KeyState.KEY_RELEASED)
                    mNextKeys.remove(info.getKey());

                break;
            }

            // TODO: Data to Status
            case NetWorkClient:
            case NetworkServer: {
                Object data = evt.getData();
                if (data instanceof Status) {
                    mStatuses.add((Status) data);
                } else if (data instanceof Request) {
                    mRequests.add((Request) data);
                }
                break;
            }

        }

        mLock.readLock().unlock();
    }

    private Key getRealKey(final Key k) {
        return sKeymap.getOrDefault(k, k);
    }
}
