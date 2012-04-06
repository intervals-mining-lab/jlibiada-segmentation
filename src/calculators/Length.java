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
 * Date: 11.10.2011
 * Time: 17:59:50
 * To change this template use File | Settings | File Templates.
 */

/**
 * Calculates length of the chain
 */
public final class Length implements Calculable, Identifiable {
    public final Characteristic type;

    {
        type = Characteristic.CHAIN_LENGTH;
    }

    @Override
    public double calculate(UniformChain chain) {
        return Collections.frequency(chain.substring(0, chain.length()), chain.base);
    }

    @Override
    public double calculate(Chain chain) {
        return chain.length();
    }

    @Override
    public String getName() {
        return  type.getName();
    }
}
