package model;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 24.10.2011
 * Time: 13:37:42
 * To change this template use File | Settings | File Templates.
 */

/**
 * Defines how to calculate some of the characteristics for the sequence:
 * use of a given sequence of characters as one character (convoluted chain)
 * or as a word consists of the characters.
 */
public enum Method {
    CONVOLUTED,
    NOT_CONVOLUTED
}
