package calculators;

import base.Characteristic;
import interfaces.Calculable;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 11.10.2011
 * Time: 14:52:08
 * To change this template use File | Settings | File Templates.
 */

/**
 * Allows you create any available calculator
 * @see base.Parameter too
 */
public final class CharacteristicsFactory {
    public static Calculable get(Characteristic characteristic){
        int id = characteristic.getId();
        switch(id){
            case 0: return new ArithmeticalAverageInterval();
            case 1: return new GeometricAverageInterval();
            case 2: return new Remoteness();
            case 3: return new IdentificationInformation();
            case 4: return new Periodicity();
            case 5: return new Regularity();
            case 6: return null;
            case 7: return null;
            case 8: return null;
            case 9: return null;
            case 10: return new Volume();
            case 11: return new WordAverageLength();
            case 12: return null;
            case 13: return null;
            case 14: return null;
            case 15: return new AlphabetPower();
            case 16: return null;
            case 17: return null;
            case 18: return  new GamutDeep();
            case 19: return new Gamut();
            case 20: return new Length();
            case 21: return  new NumberElementsLength();
            case 22: return new DescriptiveInformation();
            case 23: return null;
        }
        return null;
    }
}
