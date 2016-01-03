package io.github.antijava.marjio.common.network;

import java.util.UUID;

/**
 * Created by fntsr on 2015/12/31.
 */
public interface Packable {
    UUID getClientID();
    void setClientID(UUID id);
}
