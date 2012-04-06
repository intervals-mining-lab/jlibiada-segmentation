package calculators;

import base.Characteristic;
import base.sequencies.Chain;
import base.sequencies.UniformChain;
import interfaces.Calculable;
import interfaces.Identifiable;

import java.util.Collections;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 04.12.2011
 * Time: 19:12:35
 * To change this template use File | Settings | File Templates.
 */

/**
 * Calculates the number of elements of a given length occurring in the chain
 */
public class NumberElementsLength implements Calculable, Identifiable {
    public final Characteristic type;
    private int wordLength;

    {
        type = Characteristic.NUMBER_FOR_LENGTH;
        wordLength = 1;
    }

    @Override
    public double calculate(UniformChain chain) {
        if (chain.base.length() != wordLength) return 0;
        return Collections.frequency(chain.substring(0, chain.length()), chain.base);

    }

    @Override
    public double calculate(Chain chain) {
        final int len = chain.length();
        int index = 0;
        int count = 0;
        while (index < len ){
            if (chain.elementAt(index).length() == wordLength) count++;
            index++;
        }

        return count;
    }

    @Override
    public String getName() {
        return type.getName();
    }

    public void setLength(int newWordLength){
        wordLength = newWordLength;
    }
}
