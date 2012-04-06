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
 * Date: 27.12.2011
 * Time: 13:20:28
 * To change this template use File | Settings | File Templates.
 */

/**
 * The ratio average geometrical interval to the number descriptive information
 */
public class DescriptiveInformation implements Calculable, Identifiable {
    public final Characteristic type;
    private final ArithmeticalAverageInterval arithmeticAvgInterval;
    {
        type = Characteristic.DESCRIPTIVE_INFORMATION;
        arithmeticAvgInterval = new ArithmeticalAverageInterval();
    }
    @Override
    public double calculate(UniformChain chain) {
       return Math.pow(arithmeticAvgInterval.calculate(chain), Calculator.frequency(chain, chain.base));
    }

    @Override
    public double calculate(Chain chain) {
        double result = 1;
        chain.updateUniforms();
        for(int index = 0; index < Alphabet.power(chain); index++){
             result *= calculate(chain.getUniformChain(index));
        }
        return result;
    }

    @Override
    public String getName() {
        return type.getName();
    }

}
