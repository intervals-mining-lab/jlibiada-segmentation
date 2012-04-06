package tools;

import java.util.concurrent.TimeUnit;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 12.10.2011
 * Time: 17:42:02
 * To change this template use File | Settings | File Templates.
 */
public final class PerformanceProfiler {
    private static long ts, te;
    public static void start(){
        ts = System.nanoTime();
    }
    public static void end(){
        te = System.nanoTime();
    }

    public static double result(){
        return (te - ts)/1e6;
    }
}
