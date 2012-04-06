package interfaces;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 06.09.2011
 * Time: 3:18:15
 * To change this template use File | Settings | File Templates.
 */

/**
 * An iterator's simple capability.
 */
public interface Iterator {
    /**
     * Returns true if the iteration has more elements.
     *
     * @return true if the iterator has more elements.
     */
    boolean hasNext();

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration.
     */
    List<String> next();

    /**
     * Moves a cursor before the beginning of sequence.
     */
    void reset();

    /**
     * Returns current cursorPosition
     *
     * @return current cursorPosition
     */
    int position();

    /**
     * Returns current element
     * 
     * @return current element
     */
    List<String> current();

}
