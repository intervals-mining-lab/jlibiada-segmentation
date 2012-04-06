package calculators;

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
 * Date: 11.10.2011
 * Time: 18:54:59
 * To change this template use File | Settings | File Templates.
 */

/**
 * The amount of information to identify any element of the chain by intervals between words
 */
public class Gamut implements Calculable, Identifiable {
    protected Characteristic characteristicType;
    protected IntervalType intervalType;


    {
        characteristicType = Characteristic.GAMUT_SIMPLE;
        intervalType = IntervalType.SIMPLE;
    }

    @Override
    public double calculate(UniformChain chain) {
        double result = 0.0;
        Intervals intervals = new Intervals(chain, chain.getAnchor());

        for (int index = 0; index < chain.countBase(); index++) {
            result += Calculator.log2(intervals.elementAt(index));
        }
        return result;
    }


    @Override
    public double calculate(Chain chain) {
        double result = 0;
        Intervals intervals = chain.intervals(intervalType, chain.getAnchor());
        
        for (int index = 0; index < chain.length(); index++) {
            result += Calculator.log2(intervals.elementAt(index));
        }
        return result;
    }

    @Override
    public String getName() {
        return characteristicType.getName();
    }

    public void setIntervalType(IntervalType intervalType) {
        this.intervalType = intervalType;
    }
}
