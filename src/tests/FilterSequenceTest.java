package tests;

import base.seekers.converters.SequenceCleaner;
import base.sequencies.Chain;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 26.09.2011
 * Time: 15:05:10
 * To change this template use File | Settings | File Templates.
 */
public class FilterSequenceTest extends TestCase {
    @Test
    public void testFilterout() {
        List<String> list1 = Arrays.asList("ABABAB", "ABATAT", "TABABAB", "ABTABAB", "ABABAB", "ABABAB", "ABABAB");
        List<String> listSequence1 = Arrays.asList("ABATAT", "TABABAB");
        List<String> listSequence2 = Arrays.asList("ABABAB", "ABABAB");
        List<String> listSequence3 = Arrays.asList("ABABAB");
        List<String> result1 = Arrays.asList("ABABAB", "ABTABAB", "ABABAB", "ABABAB", "ABABAB");
        List<String> result2 = Arrays.asList("ABABAB", "ABATAT", "TABABAB", "ABTABAB", "ABABAB");
        List<String> result3 = Arrays.asList("ABATAT", "TABABAB", "ABTABAB");
        SequenceCleaner a1Cleaner = null;
        SequenceCleaner a2Cleaner = null;
        SequenceCleaner a3Cleaner = null;

        a1Cleaner = new SequenceCleaner(new Chain(list1));
        a2Cleaner = new SequenceCleaner(new Chain(list1));
        a3Cleaner = new SequenceCleaner(new Chain(list1));

        a1Cleaner.filterout(listSequence1);
        a2Cleaner.filterout(listSequence2);
        a3Cleaner.filterout(listSequence3);

        System.out.println("First chain " + Arrays.toString(list1.toArray()));
        System.out.println("Second chain " + a1Cleaner.getChain().toString("__"));

        System.out.println("First chain " + Arrays.toString(list1.toArray()));
        System.out.println("Second chain " + a2Cleaner.getChain().toString("__"));
        System.out.println("First chain " + Arrays.toString(list1.toArray()));
        System.out.println("Second chain " + a3Cleaner.getChain().toString("__"));

        assertTrue((new Chain(result1)).equals(a1Cleaner.getChain()));
        assertTrue((new Chain(result2)).equals(a2Cleaner.getChain()));
        assertTrue((new Chain(result3)).equals(a3Cleaner.getChain()));
    }

}
