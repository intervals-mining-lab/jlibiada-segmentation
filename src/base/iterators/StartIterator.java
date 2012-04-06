package base.iterators;

import base.sequencies.ComplexChain;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 13.09.2011
 * Time: 1:13:33
 * To change this template use File | Settings | File Templates.
 */

/**
 * An iterator shifts its pointer through a chain left to right
 * until it reach the end of the chain.
 */
public final class StartIterator extends BaseIterator {
    /**
     * Initializes a main options of an iterator.
     *
     * @param chain  An iterable sequence
     * @param windowLength Length of a word (window of cutting)
     * @param step   The number of elements through which the pointer will jump at the next iteration
     */
    public StartIterator(ComplexChain chain, int windowLength, int step) {
        super(chain, windowLength, step);
    }


    public boolean hasNext() {
        if (windowLength + cursorPosition + step > chain.length()) return false;
        return true;
    }

    public List<String> next() {
        try{
            cursorPosition = cursorPosition + step;
            currentCut = chain.substring(cursorPosition, cursorPosition + windowLength);    
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        
        return currentCut;
    }

    public void reset() {
        cursorPosition = -step;
    }

    
    public int position() {
        return cursorPosition;
    }

    
    public List<String> current() {
        return currentCut;
    }


    public boolean move(int position){
        if ((position >= 0) && (chain.length() >= windowLength + position)){
            cursorPosition = position;
            return true;
        }
        return false;
    }
}
