package interfaces;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 20.09.2011
 * Time: 13:28:20
 * To change this template use File | Settings | File Templates.
 */

/**
 * Provides search an entry one object to other
 */
public interface ISeeker {
    final int step = 1;

    /**
     * Returns number of hits required word from a sequence
     *
     * @param required searchable word
     * @return number of hits
     */
    int seek(List<String> required);

    /**
     * Finds the cursorPosition of the location of the element
     *
     * @return Numbers places where the word
     */
    List<Integer> arrangement();
}                                           
