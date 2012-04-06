package calculators;

import base.collectors.Alphabet;
import base.Characteristic;
import base.sequencies.Chain;
import base.sequencies.UniformChain;
import interfaces.Calculable;
import interfaces.Identifiable;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 26.02.12
 * Time: 18:07
 * To change this template use File | Settings | File Templates.
 */

/**
 * The number of descriptive information requested by Shannon
 */
public class IdentificationInformation implements Calculable, Identifiable {
    public final Characteristic type;

    {
        type = Characteristic.IDENTIFICATION_INFORMATION;
    }

    @Override
    public double calculate(UniformChain chain) {
        return Calculator.log2(new ArithmeticalAverageInterval().calculate(chain));
    }

    @Override
    public double calculate(Chain chain) {
        double result = 0;
        for (int index = 0; index < Alphabet.power(chain); index++){
            UniformChain uniformChain = chain.getUniformChain(index);
            double probability = Calculator.frequency(uniformChain);
            result += probability * calculate(uniformChain);
        }
        return result;
    }

    @Override
    public String getName() {
        return type.getName();
    }
}
