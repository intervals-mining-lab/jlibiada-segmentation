package calculators;

import base.Characteristic;
import base.IntervalType;
import base.sequencies.Chain;
import base.sequencies.UniformChain;
import interfaces.Calculable;
import interfaces.Identifiable;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 26.02.12
 * Time: 16:11
 * To change this template use File | Settings | File Templates.
 */

/**
 * Regularity is a measure of comparison of actual data circuit with a "virtual" regular information chain.
 */
public class Regularity implements Calculable, Identifiable {
    protected Characteristic characteristicType;
    private GeometricAverageInterval geometricAverageInterval;
    private DescriptiveInformation descriptiveInformation;
    {
        characteristicType = Characteristic.REGULARITY;
        geometricAverageInterval = new GeometricAverageInterval();
        descriptiveInformation = new DescriptiveInformation();

    }
    @Override
    public double calculate(UniformChain chain) {
        return geometricAverageInterval.calculate(chain) / descriptiveInformation.calculate(chain);
    }

    @Override
    public double calculate(Chain chain) {
        return geometricAverageInterval.calculate(chain) / descriptiveInformation.calculate(chain);
    }

    @Override
    public String getName() {
        return characteristicType.getName();
    }

    public void setIntervalType(IntervalType intervalType){
        geometricAverageInterval.setIntervalType(intervalType);
    }
}
