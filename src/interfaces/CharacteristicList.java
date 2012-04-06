package interfaces;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 17.03.12
 * Time: 22:00
 * To change this template use File | Settings | File Templates.
 */

import base.Characteristic;

/**
 * Allows you to get a list of characteristic
 * from a concrete data structure
 *
 */
public interface CharacteristicList {
    Characteristic[] getCharacteristics();

}
