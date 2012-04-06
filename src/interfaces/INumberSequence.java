package interfaces;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 19.07.2011
 * Time: 2:12:28
 * To change this template use File | Settings | File Templates.
 */

/**
 * An interface that implements all the standard methods
 * of management given numerical sequence.
 */
public interface INumberSequence {
    /**
     * Returns true if, and only if, length() is 0.
     *
     * @return true if, and only if, length() is 0.
     */
    boolean isEmpty();

    /**
     * Returns the length of this sequence. The length is equal to the number of elements in the array.
     *
     * @return the length of the sequence of numbers represented by this object.
     */
    int length();

    /**
     * Returns the Integer value at the specified index. An index ranges from 0 to length() - 1.
     * The first number value of the sequence is at index 0, the next at index 1, and so on, as for array indexing.
     *
     * @param index the index of the integer value
     * @return the Integer value at the specified index of this sequence. The first sequence value is at index 0.
     */
    int elementAt(int index);

    /**
     * Concatenates the specified INumberSequence sequence to the end of this sequence.
     *
     * @param value the INumberSequence that is concatenated to the end of this numerical sequence
     * @return an INumberSequence that represents the concatenation of this object's figures followed
     *         by the sequence argument's figures.
     */

    INumberSequence concat(INumberSequence value);

    /**
     * Adds the specified value to the end of this sequence.
     *
     * @param value the figure that is concatenated to the end of this numerical sequence
     * @return an INumberSequence that represents the concatenation of this object's figures followed
     *         by the argument's figure.
     */

    INumberSequence add(int value);

    /**
     * Returns a new sequence that is a substring of this sequence. The substring begins at the specified beginIndex
     * and extends to the figures at index endIndex - 1. Thus the length of the substring is endIndex-beginIndex.
     *
     * @param beginIndex the beginning index, inclusive.
     * @param endIndex   the ending index, exclusive.
     * @return the specified numerical substring.
     */
    INumberSequence substring(int beginIndex, int endIndex);

    /**
     * Clear a specified cursorPosition of this sequence and reduces the length of one element.
     *
     * @param index element's cursorPosition
     * @return the reduced sequence
     */
    INumberSequence clearAt(int index);

    void push(int value);
}
