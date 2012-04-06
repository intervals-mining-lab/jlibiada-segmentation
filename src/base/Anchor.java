package base;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 13.07.2011
 * Time: 1:20:25
 * To change this template use File | Settings | File Templates.
 */

/**
 * The set of possible ways to calculate the intervals between occurrences of the words.
 * Example: A B A A C C
 */
public enum Anchor {
    /**
     * For calculating the intervals from the beginning to the end (to next occurrence) of the sequence.
     * Example: 1 2 2 1 5 1
     */
    START,
    /**
     * For calculating the intervals from the end to the beginning (to next occurrence) of the sequence.
     * Example: 2 5 1 3 1 1
     */
	END,
    /**
     * Calculate the intervals from first element (or start of the sequence) to end (to next occurrence) of the sequence.
     * Note: pseudo relative because it exists with end binding yet
     * Example: 1 1 3 2 1 2
     */
	RELATIVE
}
