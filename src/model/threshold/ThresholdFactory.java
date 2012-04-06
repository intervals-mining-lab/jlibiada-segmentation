package model.threshold;

import model.threshold.ThresholdVariator;
import model.Input;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 18.10.2011
 * Time: 12:49:40
 * To change this template use File | Settings | File Templates.
 */

/**
 * Creates one of available threshold method
 */
public class ThresholdFactory {
    public static ThresholdVariator make(int index, Input input){
        switch(index){
            case 0: return new ThresholdLinear(input.getLeftBound(), input.getRightBound(), input.getStep());
            case 1: return new ThresholdDichotomic(input.getLeftBound(), input.getRightBound());
            case 2: return new ThresholdRandom(input.getLeftBound(), input.getRightBound());
            case 3: return null; // Experemental threshold based on any log function
        }
        return null;
    }
}
