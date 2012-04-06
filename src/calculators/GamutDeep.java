package calculators;

import base.Characteristic;
import base.IntervalType;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 16.12.2011
 * Time: 13:39:05
 * To change this template use File | Settings | File Templates.
 */
/**
 * The amount of information to identify any element of the chain by intervals between chars
 */
public class GamutDeep extends Gamut {
    {
        characteristicType = Characteristic.GAMUT_DEEP;
        intervalType = IntervalType.DEEP; // only
    }

}
