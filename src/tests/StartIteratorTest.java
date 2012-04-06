package tests;

import base.sequencies.Chain;
import base.iterators.StartIterator;
import extended.Helper;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 15.09.2011
 * Time: 1:23:48
 * To change this template use File | Settings | File Templates.
 */
public class StartIteratorTest extends TestCase {
    private Chain chain = new Chain("AACAGGTGCCCCTTATTT");
    private static long ts, te;


    public void testHasNext() {
        int lengthCut = 3;
        int step = 1;
        int countSteps = 0;
        StartIterator iterator = null;
        LinkedList<String> cut = null;

        iterator = new StartIterator(chain, lengthCut, step);
        while(iterator.hasNext()){
            iterator.next();
            countSteps = countSteps + 1;
        }
            assertTrue(countSteps == iterator.getMaxShifts());

//        System.out.println("Count steps " + countSteps);
        countSteps = 0;
        iterator = new StartIterator(chain, lengthCut, step + 1);
        while(iterator.hasNext()){
            iterator.next();
            countSteps = countSteps + 1;
        }
        assertTrue(countSteps == iterator.getMaxShifts());
//        System.out.println("Count steps " + countSteps);
    }


    public void TimeFromToEnd(){
        int length = 3;
        int step = 1;
        int countSteps = 0;
        double amountTime;
        StartIterator iterator = null;
        List<String> cut = null;
        Chain chain = new Chain("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        iterator = new StartIterator(chain, length, step);
        ts = System.nanoTime();
        while(iterator.hasNext()){
            iterator.next();
            //countSteps = countSteps + 1;
        }
        te =System.nanoTime();
        amountTime = (te - ts)/1e6;
//        System.out.println("Length = " + chain.length() + " "+ amoutTime + " ms" + "\n" + amoutTime / chain.length() + " per shift");

    }


    public void testNext() {
        StartIterator iterator = null;
        List<String> cut = null;
        String[] triplesForStepOne = {"AAC", "ACA", "CAG", "AGG",
                            "GGT", "GTG", "TGC", "GCC",
                            "CCC", "CCC", "CCT", "CTT",
                            "TTA", "TAT", "ATT", "TTT"};
        String[] triplesForStepTwo = {"AAC", "CAG", "GGT", "TGC", "CCC", "CCT", "TTA",  "ATT"};
        int lengthCut = 3;
        int step = 1;

        iterator = new StartIterator(chain, lengthCut, step);

        for (int i = 0; i < iterator.getMaxShifts(); i++) {
            cut = iterator.next();
//            System.out.println(triplesForStepOne[i] + " vs " + cut);
            assertTrue(Helper.toString(cut).equals(triplesForStepOne[i]));
        }

        iterator = new StartIterator(chain, lengthCut, step + 1);

        for (int i = 0; i < iterator.getMaxShifts(); i++) {
            cut = iterator.next();
            assertTrue(Helper.toString(cut).equals(triplesForStepTwo[i]));
        }


        }


        public void testReset()
        {
            StartIterator iterator = null;
            int length = 2;
            int step = 1;
            iterator = new StartIterator(chain, length, step);
            if (iterator.move(3)) {
                iterator.reset();
            }
            assertTrue(iterator.getCursorPosition() == -step);
        }


        public void testMove()
        {
            StartIterator iterator = null;
            int length = 2;
            int step = 1;
            int position = 3;
            iterator = new StartIterator(chain, length, step);
            iterator.move(position);
            assertTrue(iterator.getCursorPosition() == position);


            position = 100;
            iterator.move(position);
            assertTrue(iterator.getCursorPosition() != position);

            position = chain.length() / 2;
            iterator.move(position);
            assertTrue(iterator.getCursorPosition() == position);

            position = -1;
            iterator.move(position);
            assertTrue(iterator.getCursorPosition() != position);

            length = 3;
            step = 2;
            position = 3;
            final String triple = "GTG";
            iterator = new StartIterator(chain, length, step);
            iterator.move(position);
            iterator.next();
            assertEquals(triple, Helper.toString(iterator.current()));
//            System.out.println(triple + " vs " + Helper.toString(iterator.current()));
        }


        public void testGetMaxShifts()
        {
            StartIterator iterator = null;
            int lengthCut = 3;
            int step = 1;
            int maxShifts = 16;
            iterator = new StartIterator(chain, lengthCut, step);
            assertTrue(iterator.getMaxShifts() == maxShifts);
        }


        public void testGetPosition()
        {
            StartIterator iterator = null;
            int lengthCut = 2;
            int step = 1;
            iterator = new StartIterator(chain, lengthCut, step);
            iterator.next();
            assertTrue(iterator.getCursorPosition() == 0);
            iterator.next();
            assertTrue(iterator.getCursorPosition() == 1);
            for (int index = 2; index < iterator.getMaxShifts(); index++)
                iterator.next();
            assertTrue(iterator.getCursorPosition() == 16);

        }
    }
