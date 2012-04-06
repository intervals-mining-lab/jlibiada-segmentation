package base.iterators;

import base.sequencies.ComplexChain;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 26.09.2011
 * Time: 23:59:03
 * To change this template use File | Settings | File Templates.
 */

/**
 * An iterator shifts its pointer through a chain right to left
 * until it reach the beginning of the chain.
 */
public final class EndIterator extends BaseIterator {

    /**
     * Initializes a main options of an iterator.
     *
     * @param chain  An iterable sequence
     * @param length Length of a word (window of cutting)
     * @param step   The number of elements through which the pointer will jump at the next iteration
     */
    public EndIterator(ComplexChain chain, int length, int step) {
        super(chain, length, step);
        cursorPosition = chain.length() - windowLength + 1;
    }


    public boolean hasNext() {
        if ((cursorPosition - step) >= 0) return true;
        return false;
    }

    public List<String> next() {
        cursorPosition = cursorPosition - step;
        try {
            currentCut = chain.substring(cursorPosition, cursorPosition + windowLength);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return currentCut;
    }

    public void reset() {
        cursorPosition = maxShifts;
    }

    public int position() {
        return cursorPosition;
    }

    public List<String> current() {
        return currentCut;
    }

    public boolean move(int position) {
        if ((position >= 0) && (chain.length() >= windowLength + position)) {
            cursorPosition = position;
            return true;
        }
        return false;
    }
}
