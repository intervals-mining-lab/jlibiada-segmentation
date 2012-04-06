package model;

import model.Algorithm;
import model.Input;
import model.AlgorithmBase;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 18.10.2011
 * Time: 13:46:39
 * To change this template use File | Settings | File Templates.
 */
public class AlgorithmFactory {
    public static Algorithm make(int index, Input input){
         switch(index){
            case 0: return new AlgorithmBase(input);
            case 1: return null;
        }
        return null;
    }
}
