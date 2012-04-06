package model.seeker;

import base.collectors.DataCollector;
import base.iterators.StartIterator;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 28.11.2011
 * Time: 16:10:51
 * To change this template use File | Settings | File Templates.
 */

/**
 * Holds all methods that will use for segmentation with subwords
 */
public abstract class SubwordExtractor extends WordExtractor {
    protected DataCollector minusOneEntry;
    protected DataCollector minusTwoEntry;
    {
        minusOneEntry = new DataCollector();
        minusTwoEntry = new DataCollector();
    }
    
    /**
     * Do not ask any questions, because it realy very fast and redundant is also to the point
     * Please do learn java performance
     *
     * @param it only iterator from start
     */
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
