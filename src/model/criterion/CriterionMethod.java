package model.criterion;

import base.Anchor;
import base.collectors.DataCollector;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 24.10.2011
 * Time: 9:38:29
 * To change this template use File | Settings | File Templates.
 */

/**
 * Calculates actual and estimated characteristics of the subject word in the sequence
 */
public abstract class CriterionMethod {
    /**
     * Calculates frequency for convoluted or no convoluted chain
     * An actual characteristic of occurrence of the subject word in the sequence
     *
     * @param std          all positions of occurrence the word in the sequence
     * @param chainLength  length of whole sequence
     * @param windowLength length of the scanning window
     * @return Frequency for convoluted or no convoluted chain
     */
    public abstract double frequncy(ArrayList<Integer> std, final int chainLength, final int windowLength);

    /**
     * An estimated characteristic of occurrence of the subject word in the sequence
     *
     * @param accord      checking word
     * @param chainLength length of whole sequence
     * @param winLen      length of the scanning window
     * @param minusOne    data for "minus one" subword
     * @param mid         data for "minus two" subword
     * @return disign characteristic of occurence of the word
     */
    public final double designExpected(List<String> accord, final int chainLength, final int winLen,
                                       final DataCollector minusOne, final DataCollector mid) {
        final int step = 1;
        final int shortWord = 2;
        final int midlLength = winLen - 2;
        final int minusLength = winLen - 1;

        ArrayList<Integer> left = null;
        ArrayList<Integer> right = null;
        ArrayList<Integer> middle = null;
        left = minusOne.positions(accord.subList(0, accord.size() - 1));
        right = minusOne.positions(accord.subList(1, accord.size()));
        if (midlLength != 0)  middle = mid.positions(accord.subList(1, accord.size() - 1));
        else middle = new ArrayList<Integer>();
       
        
        double criteria = -1;
        if (winLen == shortWord) {
            criteria = frequncy(left, chainLength, minusLength) * frequncy(right, chainLength, minusLength);
        }
        else if (middle != null) criteria = (frequncy(left, chainLength, minusLength) * frequncy(right, chainLength, minusLength)) /
                frequncy(middle, chainLength, midlLength);

        return criteria;
    }

    /**
     * Calculates frequency for convoluted or no convoluted chain by an interval estimation
     * An actual characteristic of occurrence of the subject word in the sequence
     *
     * @param stdData     positions of word
     * @param chainLength length of whole sequence
     * @param winLen      length of the scanning window
     * @param anchor      binding to the chain
     * @return interval characteristic of occurence of the word
     */
    public final double intervalEstimate(List<Integer> stdData, final int chainLength, final int winLen, Anchor anchor) {
        if (stdData.size() == 0) return 0;
        final int minusLength = winLen - 1;
        int start = stdData.get(0) + 1;
        int end = chainLength - stdData.get(stdData.size() - 1) - minusLength;
        int pred = stdData.get(0);
        int j = 1;
        double multiplicate = 1;

        if (stdData.size() > 1) {
            for (j = 1; j < stdData.size(); j++) {
                int current = stdData.get(j);
                multiplicate *= (current - pred - minusLength);
                pred = current;
            }
        }
        // System.out.println("Multipl = "+ multiplicate);
        switch (anchor) {
            case START:
                return (1 / Math.pow(multiplicate * start, 1 / (double) j));
            case END:
                return 1 / Math.pow(multiplicate * end, 1 / (double) (j));
            case RELATIVE:
                return 0;//1/Math.pow(multiplicate*start*end, 1/(double)(j + 1));
            default:
                try {
                    throw new Exception("WOW");
                } catch (Exception e) {
                }
                return 0;
        }

    }

    /**
     * Calculates a probability
     *
     * @param count    occurances
     * @param chainLen all events
     * @return probability
     */
    public double probability(int count, int chainLen) {
        return count / (double) chainLen;
    }
}
