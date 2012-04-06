package interfaces;

import base.sequencies.ComplexChain;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 11.07.2011
 * Time: 22:36:46
 * To change this template use File | Settings | File Templates.
 */

/**
 * An interface that implements all the standard methods
 * of management given character sequence. It can be strings, symbols,
 * numbers and so on.
 */
public interface StringSequence {
   
    /**
     * Returns true if, and only if, length() is 0.
     *
     * @return true if, and only if, length() is 0.
     */
    boolean isEmpty();

    /**
     * Returns the length of this sequence. The length is equal to the number of elements in the array.
     *
     * @return the length of the sequence of characters represented by this object.
     */
    int length();

    /**
     * Returns the string value at the specified index. An index ranges from 0 to length() - 1.
     * The first string value of the sequence is at index 0, the next at index 1, and so on, as for array indexing.
     *
     * @param index the index of the String value
     * @return the string value at the specified index of this sequence. The first sequence value is at index 0.
     */
    String elementAt(int index);

    /**
     * Concatenates the specified sequence to the end of this sequence.
     *
     * @param value that is concatenated to the end of this String
     * @return sequence that represents the concatenation of this object's characters followed
     *         by the string argument's characters.
     */
    ComplexChain concat(ComplexChain value);

    /**
     * Concatenates the specified string sequence to the end of this sequence.
     *
     * @param str the string that is concatenated to the end of this String
     * @return sequence that represents the concatenation of this object's characters followed
     *         by the string argument's characters.
     */
    ComplexChain concat(String str);

    /**
     * Returns a new sequence that is a substring of this sequence. The substring begins at the specified beginIndex
     * and extends to the character at index endIndex - 1. Thus the length of the substring is endIndex-beginIndex.
     *
     * @param beginIndex the beginning index, inclusive.
     * @param endIndex   the ending index, exclusive.
     * @return the specified substring.
     */
    List<String> substring(int beginIndex, int endIndex);

    /**
     * Converts all of the characters in this sequence to upper case using the rules of the default locale.
     *
     * @return the String, converted to uppercase.
     */
    ComplexChain toUpperCase();

    /**
     * Converts all of the characters in this sequence to lower case using the rules of the default locale.
     *
     * @return the String, converted to lowercase.
     */
    ComplexChain toLowerCase();

    /**
     * Clear a specified cursorPosition of this sequence and reduces the length of one element.
     *
     * @param index element's cursorPosition
     * @return the reduced sequence  
     */
    ComplexChain clearAt(int index);
}
