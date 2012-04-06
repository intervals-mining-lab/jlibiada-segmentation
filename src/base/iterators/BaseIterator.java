package base.iterators;

import extended.ConflictData;
import interfaces.Iterator;

import base.sequencies.ComplexChain;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 06.09.2011
 * Time: 3:57:25
 * To change this template use File | Settings | File Templates.
 */

/**
 * Describes a behavior and a structure of  a simple iterator
 */
public abstract class BaseIterator implements Iterator {
    /**
     * Current cursor cursorPosition
     */
    protected int cursorPosition;
    /**
     * The number of elements through which the pointer will jump at the next iteration
     */
    protected int step;
    /**
     * Length of a word (window of cutting)
     */
    protected int windowLength;
    /**
     * Amount of offsets for current sequence
     */
    protected int maxShifts;
    /**
     * An iterate sequence
     */
    protected ComplexChain chain;

    {
        cursorPosition = -1;
        currentCut = new LinkedList<String>();
    }

    /**
     * The currentCut composed sequence was extracted from a chain
     */
    protected List<String> currentCut;

    /**
     * Initializes a main options of an iterator.
     *
     * @param chain  An iterate sequence
     * @param length Length of a word (window of cutting)
     * @param step   The number of elements through which the pointer will jump at the next iteration
     */
    public BaseIterator(ComplexChain chain, int length, int step) {
        init(chain, length, step);
    }

    private void init(ComplexChain chain, int windowLength, int step){
        try{
            int chainLength = chain.length(); 
            
            if ((chainLength < windowLength) || (windowLength == 0)
                    || ((step < 1) || (step > chainLength)))
                throw new ConflictData();    
        }catch (NullPointerException e){
            e.printStackTrace();
        }catch (ConflictData e){
            e.printStackTrace();
        }

        this.chain = chain.clone();
        this.windowLength = windowLength;
        this.step = step;
        this.cursorPosition = -step;
        maxShifts();
    }

    /**
     * Returns maximum number of iterations on this chain
     *
     * @return Maximum number of iterations on this chain
     */
    public int getMaxShifts() {
        return maxShifts;
    }

    /**
     * Returns current cursor cursorPosition
     *
     * @return Current cursor cursorPosition
     */
    public int getCursorPosition() {
        return cursorPosition;
    }

    /**
     * Returns number of shifts at this moment
     *
     * @return number of shifts
     */
    public int shifts() {
        return (cursorPosition / step) + 1;
    }

    /**
     * Calculates count of shifts
     *
     * @return count of shifts
     */
    private void maxShifts() {
        maxShifts = (chain.length() - windowLength) / step + 1;
    }

    /**
     * Moves a pointer to specified cursorPosition
     *
     * @param position a cursorPosition in a chain subject to a cutting window
     * @return true if moving is available, false - otherwise
     */
    public abstract boolean move(int position);



}
