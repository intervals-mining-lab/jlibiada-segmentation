package calculators;

import base.Characteristic;
import base.sequencies.Chain;
import base.sequencies.UniformChain;
import interfaces.Calculable;
import interfaces.Identifiable;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 26.12.2011
 * Time: 23:40:43
 * To change this template use File | Settings | File Templates.
 */

/**
 * This is the sum of the lengths of all words in
 * the chain dividing by the length of the chain
 */
public class WordAverageLength implements Calculable, Identifiable {
    public final Characteristic type;
    {
        type = Characteristic.WORD_AVERAGE_LENGTH;
    }
    @Override
    public double calculate(UniformChain chain) {
        return chain.base.length();
    }

    @Override
    public double calculate(Chain chain) {
        final int chainLength = chain.length();
        int sum = 0;

        for(int index = chainLength; --index >=0; ){
          sum = sum + chain.elementAt(index).length();
        }

        return sum / (double)chainLength;
    }

    @Override
    public String getName() {
        return type.getName();
    }
}
