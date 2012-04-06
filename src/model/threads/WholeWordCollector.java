package model.threads;

import base.iterators.StartIterator;
import base.collectors.DataCollector;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 18.12.2011
 * Time: 14:32:42
 * To change this template use File | Settings | File Templates.
 */
public class WholeWordCollector implements Runnable {
    protected DataCollector fullEntry;
    protected StartIterator it;

    public WholeWordCollector(StartIterator it) {
        fullEntry = new DataCollector();
        this.it = it;
    }

    @Override
    public void run() {
//        PerformanceProfiler.start();
        while (it.hasNext()) {
            it.next();
            fullEntry.add(it, 0);
        }
//        PerformanceProfiler.end();
//        System.out.println("Thread DONE!!!! " + PerformanceProfiler.result());
    }
}
