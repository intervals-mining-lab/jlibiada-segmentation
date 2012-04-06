package calculators;

import base.Characteristic;
import base.sequencies.Chain;
import base.iterators.StartIterator;
import base.sequencies.ComplexChain;
import base.sequencies.UniformChain;
import interfaces.Calculable;

import java.util.Collections;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 13.10.2011
 * Time: 12:32:17
 * To change this template use File | Settings | File Templates.
 */

/**
 * Frequency invoke functions
 */
public final class Calculator {

    /**
     * Returns the frequency of element in the specified chain equal to the specified word.
     *
     * @param chain any chain
     * @param word  required word
     * @return frequency of word
     */
    public final static double frequency(ComplexChain chain, String word) {
        return Collections.frequency(chain.substring(0, chain.length()), word) / (double)chain.length();
    }

    /**
     * Returns the frequency of element in the specified chain
     *
     * @param chain any chain
     * @return frequency of word
     */
    public final static double frequency(UniformChain chain) {
        return Collections.frequency(chain.substring(0, chain.length()), chain.base) / (double)chain.length();
    }

    /**
     * Returns the frequency of collection in the specified chain equal to the specified collection.
     *
     * @param chain any chain
     * @param list  required
     * @return frequency of collection
     */
    public final static double frequency(Chain chain, List<String> list) {
        int count = 0;
        int step = 1;
        int listsize = list.size();
        StartIterator iterator = new StartIterator(chain, listsize, step);

        for(int index = 0; iterator.hasNext(); index++){
            if (iterator.next().equals(list)){
             count++;
             iterator.move(iterator.position() + listsize);
            }
        }
        return count  / (double)(chain.length() / listsize);
    }



/**
     * Returns the logarithm (base 2) of a double value.
     *
     * @param num any value
     * @return the logarithm (base 2) of a double value.
     */
    public final static  double log2(double num) {
        return Math.log(num) / Math.log(2);
    }
    /**
     * Computes the specified characteristic for the chain
     *
     * @param characteristic Concrete characteristic
     * @param chain sequence
     * @return a value of characteristic
     */
    public final static double calculate(Characteristic characteristic, Chain chain){
        return CharacteristicsFactory.get(characteristic).calculate(chain);
    }

    /**
     * Computes the specified characteristic for the chain
     *
     * @param characteristic Concrete characteristic
     * @param chain sequence
     * @return a value of characteristic
     */
    public final static double calculate(Calculable characteristic, Chain chain){
        return characteristic.calculate(chain);
    }
    /**
     * Computes the specified characteristic for the uniform chain
     *
     * @param characteristic Concrete characteristic
     * @param uChain sequence
     * @return a value of characteristic
     */
    public final static double calculate(Characteristic characteristic, UniformChain uChain){
        return CharacteristicsFactory.get(characteristic).calculate(uChain);
    }
    
}
