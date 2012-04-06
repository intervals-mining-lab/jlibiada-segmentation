package interfaces;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 23.09.2011
 * Time: 14:20:05
 * To change this template use File | Settings | File Templates.
 */
public interface IFilter {
    /** Removes from the chain all elements which are present in a given sequence*/
    void filterout();

    /** Replaces from the chain all elements which are present in a given sequence*/
    void replace();
    
    /** Returns number of hits */
    int hits();
}
