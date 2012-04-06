package calculators;

import base.Characteristic;
import base.IntervalType;
import base.sequencies.Chain;
import base.sequencies.UniformChain;
import interfaces.Calculable;
import interfaces.Identifiable;

import java.util.Collections;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 14.10.2011
 * Time: 17:13:26
 * To change this template use File | Settings | File Templates.
 */
/**
 * The average distance from one element to another in terms information, merely thinking
 */
public final class GeometricAverageInterval implements Calculable, Identifiable {
    public final Characteristic type;
    private Gamut gamut;

    {
        type = Characteristic.GEOMETRIC_AVERAGE_INTERAVAL;
        gamut = new Gamut();
    }

    @Override
    public double calculate(UniformChain chain) {
        final double f = Collections.frequency(chain.substring(0, chain.length()), chain.base);
        return Math.pow(2, gamut.calculate(chain)  / f);
    }

    @Override
    public double calculate(Chain chain) {
        return Math.pow(2.0, gamut.calculate(chain) / chain.length());
    }

    @Override
    public String getName() {
        return type.getName();
    }

    public double calculate(List<Integer> positions) {
        int firstStart = positions.get(0) + 1;
        long mult = firstStart;
        for(int index = 1; index < positions.size(); index++){
            mult *= positions.get(index) - positions.get(index - 1);
        }
        return Math.pow(mult, 1 / (double) positions.size());
    }

    public void setIntervalType(IntervalType intervalType){
        switch (intervalType){
            case SIMPLE: gamut = new Gamut(); return;
            case DEEP: gamut = new GamutDeep(); return;
        }
        return;
    }
}
