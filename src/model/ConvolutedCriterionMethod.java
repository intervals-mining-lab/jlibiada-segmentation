package model;

import model.criterion.CriterionMethod;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 24.10.2011
 * Time: 13:47:42
 * To change this template use File | Settings | File Templates.
 */

/**
 * Calculatet frequency for convoluted chain
 */
public class ConvolutedCriterionMethod extends CriterionMethod {
    @Override
    public final double frequncy(ArrayList<Integer> std, int chainLength, int windowLength) {
        return  probability(std.size(),(chainLength - (std.size() * (windowLength - 1))));
    }
}
