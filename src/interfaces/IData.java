package interfaces;

import base.sequencies.Arrangement;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 20.09.2011
 * Time: 13:37:05
 * To change this template use File | Settings | File Templates.
 */

/**
 * Allows you to get a data result
 */
public interface IData {
    /**
     * Returns searchable sequence
     * @return searchable sequence
     */
    List<String> getRequired();

    /**
     * Returns a sequence of positions
     * @return
     */
    Arrangement getArrangement();

    /**
     * Returns count of hits
     * @return count of hits
     */
    int getCountHit();
    
}
