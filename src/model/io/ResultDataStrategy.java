package model.io;

import model.MainOutputData;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 14.03.12
 * Time: 23:47
 * To change this template use File | Settings | File Templates.
 */

/**
 * The way to create a result
 */
public interface ResultDataStrategy {
    MainOutputData create();
}
