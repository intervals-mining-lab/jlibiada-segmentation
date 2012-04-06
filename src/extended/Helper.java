package extended;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 06.11.2011
 * Time: 20:38:33
 * To change this template use File | Settings | File Templates.
 */

/**
 * Contains methods that will facilitate your work
 */
public final class Helper {

    /**
     * Designed for fast conversion a collection to the String object without
     * delimiters
     *
     * @param list convertible sequence of words
     * @return string composed of items in the collection
     */
    public static String toString(List<String> list) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < list.size(); i++) result.append(list.get(i));
        return result.toString();
    }

}
