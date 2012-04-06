package model.seeker;

import base.collectors.Alphabet;
import base.Formalism;
import base.Parameter;
import base.iterators.StartIterator;
import base.sequencies.Chain;
import calculators.ArithmeticalAverageInterval;
import calculators.GeometricAverageInterval;
import model.ContentValues;
import model.PositionFilter;
import model.WordEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 24.11.2011
 * Time: 23:28:43
 * To change this template use File | Settings | File Templates.
 */

/**
 * That's the seeker for allocate words with characteristic differences of the arithmetic mean
 * and geometric mean of the interval
 */
public class DifferenceAverageIntervalExtractor extends WordExtractor {
    {
        wordPriority = new TreeMap<Double, Map.Entry<List<String>, ArrayList<Integer>>>();
    }

    public final WordEntry find(ContentValues params) {
        final Chain convoluted = (Chain) params.get(Formalism.SEQUENCE);
        final int windowLen = (Integer) params.get(Parameter.WINDOW);
        final Alphabet alphabet = (Alphabet) params.get(Formalism.ALPHABET);
        final double level = (Double) params.get(Parameter.CURRENT_THRESHOLD);

        final int scanStep = 1;
        final int disp = 0;
        StartIterator it;
        PositionFilter filter;

        it = new StartIterator(convoluted, windowLen, scanStep);
        filter = new PositionFilter();

        while (it.hasNext()) {
            it.next();
            fullEntry.add(it, disp);
        }
        calcStd(convoluted, windowLen, filter);

        return discardCompositeWords(alphabet, level);
    }

    public void calcStd(Chain convoluted, int windowLen, PositionFilter filter) {
        GeometricAverageInterval gAvgInterval = new GeometricAverageInterval();
        ArithmeticalAverageInterval aAvgInterval = new ArithmeticalAverageInterval();

        for (Map.Entry<List<String>, ArrayList<Integer>> accord : fullEntry.entrySet()) {
            filter.filtrate(accord.getValue(), windowLen);
            double geometric = gAvgInterval.calculate(accord.getValue());
            double arithmetic = aAvgInterval.calculate(accord.getValue(), convoluted.length());
            double std = 1 - (1 / Math.abs(arithmetic - geometric));
            if (!wordPriority.containsKey(std)) wordPriority.put(std, accord);
        }
    }
}
