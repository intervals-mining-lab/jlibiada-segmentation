package interfaces;

import base.collectors.Alphabet;
import base.sequencies.Chain;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 23.03.12
 * Time: 22:52
 * To change this template use File | Settings | File Templates.
 */

/**
 * You can check on the fulfillment of specific conditions
 */
public interface Verifiable {
    boolean state(Chain chain, Alphabet alphabet);
}
