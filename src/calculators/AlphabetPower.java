package calculators;

import interfaces.Calculable;
import base.*;
import base.sequencies.Chain;
import base.sequencies.UniformChain;
import interfaces.Identifiable;

import static base.collectors.Alphabet.power;
/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 11.10.2011
 * Time: 15:22:32
 * To change this template use File | Settings | File Templates.
 */

/**
 * Counts number of unique elements in the chain.
 */
public final class AlphabetPower implements Calculable, Identifiable {
    public final Characteristic type;

    {
        type = Characteristic.ALPHABET_POWER;
    }

    @Override
    public double calculate(UniformChain chain) {
        return power(chain);
    }

    @Override
    public double calculate(Chain chain) {
        return power(chain);
    }

    @Override
    public String getName() {
        return type.getName();
    }
}
