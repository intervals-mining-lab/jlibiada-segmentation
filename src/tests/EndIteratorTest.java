package tests;

import base.iterators.StartIterator;
import base.sequencies.Chain;
import base.iterators.EndIterator;
import extended.Helper;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 27.09.2011
 * Time: 0:18:17
 * To change this template use File | Settings | File Templates.
 */
public class EndIteratorTest extends TestCase {
    private Chain chain = new Chain("AACAGGTGCCCCTTATTT");

    public void testHasNext() {
        int lengthCut = 3;
        int step = 1;
        int countSteps = 0;
        EndIterator iterator = null;
        LinkedList<String> cut = null;

        iterator = new EndIterator(chain, lengthCut, step);
        while(iterator.hasNext()){
            iterator.next();
            countSteps = countSteps + 1;
        }
        assertEquals(countSteps, iterator.getMaxShifts());

//        System.out.println("Count steps " + countSteps);
        countSteps = 0;
        iterator = new EndIterator(chain, lengthCut, step + 1);
        while(iterator.hasNext()){
            iterator.next();
            countSteps = countSteps + 1;
        }
        assertTrue(countSteps == iterator.getMaxShifts());
//        System.out.println("Count steps " + countSteps);
    }

    public void testNext() {
        EndIterator iterator = null;
        List<String> cut = null;
        String[] triplesForStepOne = {"AAC", "ACA", "CAG", "AGG",
                "GGT", "GTG", "TGC", "GCC",
                "CCC", "CCC", "CCT", "CTT",
                "TTA", "TAT", "ATT", "TTT"};
        String[] triplesForStepTwo = {"AAC", "CAG", "GGT", "TGC", "CCC", "CCT", "TTA",  "ATT"};
        int lengthCut = 3;
        int step = 1;

        iterator = new EndIterator(chain, lengthCut, step);

        for (int i = iterator.getMaxShifts() - 1; i >= 0 ; i--) {
            cut = iterator.next();
//            System.out.println(triplesForStepOne[i] + " vs " + cut);
            assertTrue(Helper.toString(cut).equals(triplesForStepOne[i]));
        }

        iterator = new EndIterator(chain, lengthCut, step + 1);

        for (int i = iterator.getMaxShifts() - 1; i >= 0 ; i--) {
            cut = iterator.next();
            assertTrue(Helper.toString(cut).equals(triplesForStepTwo[i]));
        }

    }

    public void testReset() {
        EndIterator iterator = null;
        Chain chain = null;
        List<String> list = null;
        int lengthCut = 2;
        int step = 1;
        int index = 0;
        int position = 6;
        List<String> list1 = Arrays.asList("ABABAB", "ABATAT", "TABABAB", "ABTABAB", "ABABAB", "ABABAB", "ABABAB");
        chain = new Chain(list1);
        iterator = new EndIterator(chain, lengthCut, step);
        while (iterator.hasNext()) {
            iterator.next();
            index = index + 1;
        }
        iterator.reset();

        assertTrue(iterator.position() == position);

    }

    public void testGetMaxShifts()
    {
        EndIterator iterator = null;
        int lengthCut = 3;
        int step = 1;
        int maxShifts = 16;
        iterator = new EndIterator(chain, lengthCut, step);
        assertTrue(iterator.getMaxShifts() == maxShifts);
    }

    public void testMove() {
        EndIterator iterator = null;
        Chain chain = null;
        List<String> list = null;
        int len = 2;
        int step = 1;
        int index = 0;
        int from = 1, to = 3;
        List<String> list1 = Arrays.asList("ABABAB", "ABATAT", "TABABAB", "ABTABAB", "ABABAB", "ABABAB", "ABABAB");
        list = list1.subList(from, to);
        chain = new Chain(list1);
        iterator = new EndIterator(chain, len, step);
        iterator.move(2);
//        System.out.println(Arrays.toString(list.toArray()));
        assertTrue(list.equals(iterator.next()));

    }
}
