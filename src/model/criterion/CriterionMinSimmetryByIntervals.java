package model.criterion;

import base.collectors.Alphabet;
import base.Formalism;
import base.sequencies.Chain;
import model.threshold.ThresholdVariator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 15.11.2011
 * Time: 17:32:53
 * To change this template use File | Settings | File Templates.
 */

/**
 * The criterion of "minimum symmetry by  intervals".
 * As taxons are the words of the intervals and merons - parts word intervals.
 */
public final class CriterionMinSimmetryByIntervals extends Criterion {

    {
        formalismType = Formalism.CRITERION_MIN_SYMMETRY_INTERVALS;
    }

    public CriterionMinSimmetryByIntervals(ThresholdVariator threshold, double precision) {
        super(threshold, precision);

    }

    public double getTaxonsValue(Alphabet alphabet) {
        double taxons = 0;

        List<ArrayList<Integer>> positions = alphabet.getWordsPositions();

        for (int index = 0; index < alphabet.power(); index++) {
            int countT = positions.get(index).size();
            taxons += Math.log(countT) * countT - countT;
        }
        return taxons;
    }

    public double getMeronsValue(Alphabet alphabet){
        double merons = 0;

        return merons;
    }

    @Override
    public boolean state(Chain chain, Alphabet alphabet) {
        return false;
    }

    @Override
    public double distortion(Chain chain, Alphabet alphabet) {
        return -1;
    }
}
