package io.github.antijava.marjio.common.network;

import java.util.UUID;

/**
 * Created by fntsr on 2016/1/2.
 */
public class StatusData implements PackData{
    public String uuid;
    public String sourceType;
    public String objectType;
    public int id;
    public int action_id;
    public int time_counter;
    public int st_x;
    public int st_y;
    public int x;
    public int y;
    public double vx;
    public double vy;
    public double ax;
    public double ay;
    public boolean query;
}
