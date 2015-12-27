package io.github.antijava.marjio.common;

import java.net.InetAddress;

/**
 * Created by fntsr on 2015/12/23.
 */
public interface IClient {

    /**
     * 連線到指定 IP 的 Host。要做例外處理
     * @param hostIP Host 的 IP Address
     */
    void start(InetAddress hostIP);

    /**
     * 停止 Client 的收訊功能與發送功能。
     */
    void stop();

    /**
     * 發送訊息給 Host
     * @param packableObject 可以打包的物件
     */
    void send(Packable packableObject);

    /**
     * 檢查 Client 運行狀況
     * @return 是否正在運行
     */
    boolean isRunning();

    /**
     * 檢查 Client 連線狀況
     * @return 是否有連線成功過
     */
    boolean isConnected();
}
