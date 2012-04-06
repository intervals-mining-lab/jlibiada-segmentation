package calculators;

import base.collectors.Alphabet;
import base.Characteristic;
import base.sequencies.Chain;
import base.sequencies.UniformChain;
import interfaces.Calculable;
import interfaces.Identifiable;

import java.util.Collections;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 12.10.2011
 * Time: 18:19:02
 * To change this template use File | Settings | File Templates.
 */

/**
 * The average distance from one element to another in a quantitative terms, merely thinking
 */
public final class ArithmeticalAverageInterval implements Calculable, Identifiable {
    public final Characteristic type;

    {
        type = Characteristic.ARITHMETIC_AVERAGE_INTERAVAL;
    }

    @Override
    public double calculate(UniformChain chain) {
        final int length = chain.length();
        return length / (double) Collections.frequency(chain.substring(0, length), chain.base);
    }

    @Override
    public double calculate(Chain chain) {
        final double power = Alphabet.power(chain);

        double result = 0.0;

        for (int index = (int) power; --index >=0;) {
            result += calculate(chain.getUniformChain(index));
        }
        return result / power;
    }

    @Override
    public String getName() {
        return type.getName();
    }

    /**
     * Returns arithmetical average interval through the aid of positions of word
     * @return arithmetical average interval
     */
    public final double calculate(List<Integer> positions, int wholeChainLength){
        return wholeChainLength / (double)positions.size();

    }
}
