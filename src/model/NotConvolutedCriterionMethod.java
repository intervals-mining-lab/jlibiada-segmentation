package model;

import model.criterion.CriterionMethod;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 24.10.2011
 * Time: 14:03:24
 * To change this template use File | Settings | File Templates.
 */

/**
 * Calculates frequency for not convoluted chain
 */
public class NotConvolutedCriterionMethod extends CriterionMethod {
    @Override
    public final double frequncy(ArrayList<Integer> std, int chainLength, int windowLength) {
        return probability(std.size(), chainLength);  
    }
}
