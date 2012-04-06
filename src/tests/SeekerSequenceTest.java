package tests;

import base.seekers.SeekerSequence;
import org.junit.Test;

import java.util.List;

import base.iterators.StartIterator;
import base.sequencies.Chain;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 20.09.2011
 * Time: 17:33:51
 * To change this template use File | Settings | File Templates.
 */
public class SeekerSequenceTest extends SeekerTest {
    @Test
    public void testSeek() {
        int length = 2;
        int step = 1;
        SeekerSequence seek = null;
        List<String> list1 = null;
        List<String> list2 = null;
        StartIterator iterator = null;

        list1 = java.util.Arrays.asList("ABAC", "A", "A", "A", "ABAC", "A", "ABC", "AC", "ABC", "AG", "ABC", "A", "AB", "A", "ABC","ABAC", "A" );
        list2 = java.util.Arrays.asList("ABAC", "A");
        seek = new SeekerSequence(new StartIterator(new Chain(list1), length, step));
        assertTrue(seek.seek(list2) == 3);

    }
}
