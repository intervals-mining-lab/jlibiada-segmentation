package interfaces;

import base.sequencies.Chain;
import base.sequencies.UniformChain;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 18.07.2011
 * Time: 23:43:54
 * To change this template use File | Settings | File Templates.
 */

/**
 * This interface allows you to calculate the certain characteristics
 * for a given character sequence.
 */
public interface Calculable {
    /**
     * Calculate a specified characteristic of an uniform chain using a data of binding
     * NOTE!!!: For Deep interval type intervals EQUALS to Simple interval type
     * @param chain  the specified chain
     * @return a value of certain characteristic
     */
    double calculate(UniformChain chain);

    /**
     * Calculate a specified characteristic of a chain using a data of binding
     *
     * @param chain  the specified chain
     * @return a value of certain characteristic
     */
    double calculate(Chain chain);

}
