package model;

import base.collectors.Alphabet;
import base.sequencies.Chain;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 29.11.2011
 * Time: 9:45:41
 * To change this template use File | Settings | File Templates.
 */

/**
 * Used as a base for all kinds of word splitters for a chain
 */
public abstract class ChainSplitter {
    protected Alphabet alphabet;
    protected Chain convoluted;

    public abstract Chain cut(ContentValues params);


    public final Alphabet getAlphabet() {
        return alphabet;
    }
}
