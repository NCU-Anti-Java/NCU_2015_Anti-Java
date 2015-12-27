package io.github.antijava.marjio.common;

import java.util.List;

/**
 * Created by fntsr on 2015/12/23.
 */
public interface IServer {

    /**
     * 開啟伺服器
     */
    void start();

    /**
     * 關閉伺服器
     */
    void stop();

    /**
     * 廣播資訊
     * @param packableObject
     */
    void broadcast(Packable packableObject);

    /**
     * 取得連線玩家資訊
     * @return IP 清單，暫定是 String List
     */
    List getClients();

    /**
     * @return 伺服器是否已經啟動
     */
    boolean isRunning();
}
