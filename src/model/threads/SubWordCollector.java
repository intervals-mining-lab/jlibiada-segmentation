package model.threads;

import base.iterators.StartIterator;
import base.collectors.DataCollector;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 16.12.2011
 * Time: 16:09:46
 * To change this template use File | Settings | File Templates.
 */

public final class SubWordCollector implements Runnable {
    private DataCollector minusOneEntry;
    private DataCollector minusTwoEntry;
    private StartIterator it;

    public SubWordCollector(StartIterator it) {
        this.minusOneEntry = new DataCollector();
        this.minusTwoEntry = new DataCollector();
        this.it = it;
    }

    @Override
    public void run() {
//        PerformanceProfiler.start();
        while (it.hasNext()) {
            
            it.next();
           int zero = 0;
           int minLength = 2;
           List<String> accord = it.current();
           int length = accord.size();
           int position = it.position();

            // for less one
            if (position == zero) { // first less one
                minusOneEntry.add(accord.subList(0, length - 1), position, 0);
                minusOneEntry.add(accord.subList(1, length), position, 0);
            } else {  // common less one
                minusOneEntry.add(accord.subList(1, length), position, 0);
            }
            // for less two
            if (length == minLength) {//do not handle words of length 2
                break;
            }
            if (position == zero) { // first less two
                minusTwoEntry.add(accord.subList(1, length - 1), position, 0);
                continue;
            }
            if (it.getMaxShifts() == it.shifts()) { // last less two
                minusTwoEntry.add(accord.subList(0, length - 2), position, 0);
            } else { // common less two
                minusTwoEntry.add(accord.subList(1, length - 1), position, 0);
            }
        }
//        PerformanceProfiler.end();

//        System.out.println("Thread DONE!!!! " + PerformanceProfiler.result());
    }

    protected final void findLess(final StartIterator it) {
        final int zero = 0;
        final int minLength = 2;
        final List<String> accord = it.current();
        final int length = accord.size();
        final int position = it.position();

        // for less one
        if (position == zero) { // first less one
            minusOneEntry.add(accord.subList(0, length - 1), position, 0);
            minusOneEntry.add(accord.subList(1, length), position, 0);
        } else {  // common less one
            minusOneEntry.add(accord.subList(1, length), position, 0);
        }
        // for less two
        if (length == minLength) {//do not handle words of length 2
            return;
        }
        if (position == zero) { // first less two
            minusTwoEntry.add(accord.subList(1, length - 1), position, 0);
            return;
        }
        if (it.getMaxShifts() == it.shifts()) { // last less two
            minusTwoEntry.add(accord.subList(0, length - 2), position, 0);
        } else { // common less two
            minusTwoEntry.add(accord.subList(1, length - 1), position, 0);
        }
    }
}
