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
 * Date: 27.12.2011
 * Time: 11:43:29
 * To change this template use File | Settings | File Templates.
 */
public class Remoteness implements Calculable, Identifiable {
    public final Characteristic type;
    private GeometricAverageInterval geoAvgInterval;

    {
        geoAvgInterval = new GeometricAverageInterval();
        type = Characteristic.REMOTENESS;
    }
    @Override
    public double calculate(UniformChain chain) {
        return Calculator.log2(geoAvgInterval.calculate(chain));
    }

    @Override
    public double calculate(Chain chain) {
        return Calculator.log2(geoAvgInterval.calculate(chain));
    }

    @Override
    public String getName() {
        return type.getName();
    }
    
    public void setIntervalType(IntervalType intervalType){
        geoAvgInterval.setIntervalType(intervalType);
    }
}
