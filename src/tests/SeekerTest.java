package tests;

import base.seekers.Seeker;
import base.sequencies.Chain;
import base.iterators.StartIterator;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 20.09.2011
 * Time: 15:48:21
 * To change this template use File | Settings | File Templates.
 */
public class SeekerTest extends TestCase {
    private Chain chain = new Chain("AACAGGTGCCCCTTATTT");

    @Test
    public void testSeek() {
        int length = 1;
        int step = 1;
        Seeker seek = null;
        List<String> list = null;
        String required1 = "A";
        String required2 = "C";
        String required3 = "T";
        String required4 = "G";

        seek = new Seeker(new StartIterator(chain, length, step));
        seek.seek(Arrays.asList(required1));
        assertTrue(seek.arrangement().size() == 4);

        seek.seek(Arrays.asList(required2));
        assertTrue(seek.arrangement().size() == 5);

        seek.seek(Arrays.asList(required3));
        assertTrue(seek.arrangement().size() == 6);

        seek.seek(Arrays.asList(required4));
        assertTrue(seek.arrangement().size() == 3);
    }

    @Test
    public void testSeek2() {
        int length = 1;
        int step = 1;
        Seeker seek = null;
        List<String> list = null;
        String required1 = "AA";
        String required2 = "C";
        String required3 = "TTA";
        list = java.util.Arrays.asList("AA", "AAAT", "AJJTTA");

        seek = new Seeker(new StartIterator(new Chain(list), length, step));
        seek.seek(Arrays.asList(required1));
        assertTrue(seek.arrangement().size() == 1);

        seek.seek(Arrays.asList(required2));
        assertTrue(seek.arrangement().size() == 0);

        seek.seek(Arrays.asList(required3));
        assertTrue(seek.arrangement().size() == 0);

    }

    @Test
    public void testGetMatch() {
        int length = 1;
        int step = 1;
        Seeker seek = null;
        String required1 = "A";
        seek = new Seeker(new StartIterator(chain, length, step));
        seek.seek(Arrays.asList(required1));
        assertTrue(seek.arrangement().size() == 4);
    }
}
