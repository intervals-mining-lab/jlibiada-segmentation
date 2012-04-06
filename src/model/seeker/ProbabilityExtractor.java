package model.seeker;

import base.collectors.Alphabet;
import base.Formalism;
import base.Parameter;
import base.iterators.StartIterator;
import base.sequencies.Chain;
import base.collectors.DataCollector;
import model.ContentValues;
import model.ConvolutedCriterionMethod;
import model.PositionFilter;
import model.WordEntry;
import model.criterion.CriterionMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 18.10.2011
 * Time: 17:38:06
 * To change this template use File | Settings | File Templates.
 */

/**
 * Finds hits of word and calculates its characteristics to select the most perfect occurence
 * for a fixed window length. Calculates the characteristics of the occurrence of subwords of words found for.
 */
public final class ProbabilityExtractor extends SubwordExtractor {

    public final WordEntry find(ContentValues params) {
        final Chain convoluted = ((Chain) params.get(Formalism.SEQUENCE));
        final double pbalance = (Integer) params.get(Parameter.BALANCE) / 100.0;
        final int windowLen = (Integer) params.get(Parameter.WINDOW);
        final Alphabet alphabet = (Alphabet) params.get(Formalism.ALPHABET);
        final double level = (Double) params.get(Parameter.CURRENT_THRESHOLD);
        final int scanStep = 1;
        final int disp = 0;
        final int length = convoluted.length();

        StartIterator it;
        CriterionMethod criteriaCalculator = null;

        this.fullEntry = new DataCollector();
        this.minusOneEntry = new DataCollector();
        this.minusTwoEntry = new DataCollector();

        it = new StartIterator(convoluted, windowLen, scanStep);
        criteriaCalculator = new ConvolutedCriterionMethod();

        while (it.hasNext()) {
            it.next();
            fullEntry.add(it, disp);
            findLess(it);
        }
        calcStd(convoluted, pbalance, windowLen, length, criteriaCalculator);

        return discardCompositeWords(alphabet, level);
    }

    public final void calcStd(Chain convoluted, double pbalance, int windowLen, int length, CriterionMethod criteriaCalculator) {
        PositionFilter filter = new PositionFilter();
        for (Map.Entry<List<String>, ArrayList<Integer>> accord : fullEntry.entrySet()) {
            filter.filtrate(accord.getValue(), windowLen);
            double frequency = criteriaCalculator.frequncy(accord.getValue(), length, windowLen);
            double design = criteriaCalculator.designExpected(accord.getKey(), length, windowLen, minusOneEntry, minusTwoEntry);
            double interval = criteriaCalculator.intervalEstimate(accord.getValue(), length, windowLen, convoluted.getAnchor());
            double std = (Math.abs(pbalance * interval + (1 - pbalance) * frequency - design)) / Math.sqrt(design);
            if (!wordPriority.containsKey(std)) wordPriority.put(std, accord);
        }
    }


}
