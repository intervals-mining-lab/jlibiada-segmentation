package calculators;

import base.collectors.Alphabet;
import base.Characteristic;
import base.IntervalType;
import base.sequencies.Chain;
import base.sequencies.Intervals;
import base.sequencies.UniformChain;
import interfaces.Calculable;
import interfaces.Identifiable;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 07.10.2011
 * Time: 20:05:00
 * To change this template use File | Settings | File Templates.
 */

/**
 * The multiplication of all intervals
 */
public final class Volume implements Calculable, Identifiable {
    public final Characteristic type;
    private IntervalType intervalType;

    {
        type = Characteristic.VOLUME;
        intervalType = IntervalType.SIMPLE;
    }

    @Override
    public double calculate(UniformChain chain) {
        double result = 1.0;
        Intervals intervals = new Intervals(chain, chain.getAnchor());
        for (int index = 0; index < intervals.length(); index++) {
            result *= intervals.elementAt(index);
        }
        return result;
    }

    @Override
    public double calculate(Chain chain) {
        double value = 1.0;
        Alphabet alphabet = new Alphabet(chain);
        Intervals intervals = chain.intervals(intervalType, chain.getAnchor());

        for (int index = 0; index < chain.length(); index++) {
            value *= intervals.elementAt(index);
        }

        return value;
    }

    @Override
    public String getName() {
        return type.getName();
    }

    public void setIntervalType(IntervalType intervalType){
        this.intervalType = intervalType;
    }
}
