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
 * Time: 15:11:09
 * To change this template use File | Settings | File Templates.
 */

/**
 * The ratio of geometric average intervals and arithmetic average intervals
 */
public class Periodicity implements Calculable, Identifiable {
    public final Characteristic type;
    private GeometricAverageInterval geoAvgInterval;
    private ArithmeticalAverageInterval arithmAvgInterval;

    {
        type = Characteristic.PERIODICITY;
        geoAvgInterval = new GeometricAverageInterval();
        arithmAvgInterval = new ArithmeticalAverageInterval();
    }



    @Override
    public double calculate(UniformChain chain) {
        return geoAvgInterval.calculate(chain) / arithmAvgInterval.calculate(chain);
    }

    @Override
    public double calculate(Chain chain) {
        return geoAvgInterval.calculate(chain)/arithmAvgInterval.calculate(chain);
    }

    @Override
    public String getName() {
        return type.name();
    }

    public void setIntervalType(IntervalType intervalType){
        geoAvgInterval.setIntervalType(intervalType);
    }
}
