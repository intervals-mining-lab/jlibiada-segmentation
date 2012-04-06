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
 * Date: 07.11.2011
 * Time: 0:51:09
 * To change this template use File | Settings | File Templates.
 */

/**
 * The criterion of "minimum of symmetry." Calculates the minimum value of the symmetry of the chain.
 * This is not a master criterion, since, as meron uses the same elements as in the calculation of taxons.
 *
 */
public final class CriterionMinSymmetryByShrader extends Criterion {
    {
        formalismType = Formalism.CRITERION_MIN_SYMMETRY_SHREDER;
        lastDistortion = Double.MAX_VALUE;
    }

    public CriterionMinSymmetryByShrader(ThresholdVariator threshold, double precision) {
        super(threshold, precision);
    }

    @Override
    public boolean state(Chain chain, Alphabet alphabet) {
        double current = symmetry(alphabet);
        if (lastDistortion > current) {
            lastDistortion = current;
            this.chain = chain.clone();
            this.alphabet = alphabet.clone();
            thresholdToStop.saveBest();
        }
        return (thresholdToStop.distance() > ThresholdVariator.PRECISION);
    }

    private double symmetry(Alphabet alphabet) {
        double taxons = 0;
        double merons = 0;
        int arrayMaxLength = 0;
        List<ArrayList<Integer>> positions = alphabet.getWordsPositions();

        for (int index = 0, arraySize; index < alphabet.power(); index++) {
            int countT = positions.get(index).size();
            taxons += Math.log(countT) * countT - countT;
            if (arrayMaxLength < (arraySize = positions.get(index).size())) arrayMaxLength = arraySize;
        }

        for (int meronIndex = 0, countM = 0; meronIndex < arrayMaxLength; meronIndex++) {
            for (int index = 0; index < alphabet.power(); index++) {
                if (positions.get(index).size() >= meronIndex) countM = countM + 1;
            }
            merons += Math.log(countM) * countM - countM;
            countM = 0;
        }
        return (taxons + merons);
    }

    @Override
    public double distortion(Chain chain, Alphabet alphabet) {
        return -1;
    }
}
