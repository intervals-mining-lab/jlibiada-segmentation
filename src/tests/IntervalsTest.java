package tests;

import base.collectors.Alphabet;
import base.IntervalType;
import base.Anchor;
import base.sequencies.Arrangement;
import base.sequencies.Chain;
import base.sequencies.Intervals;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 03.09.2011
 * Time: 23:09:17
 * To change this template use File | Settings | File Templates.
 */
public class IntervalsTest extends TestCase {
    private Chain chain = new Chain("AACAGGTGCCCCTTATTT");
    private Chain differentChain = new Chain("AACAGGTGCTTATTT");



    public void testStartDeep(){
        int[] intervals  = {1, 2, 4, 5, 4, 8, 1};
        Arrangement intervalA = new Arrangement(new int[]{1, 8, 1});
        Arrangement intervalBA = new Arrangement(new int[]{2, 4});
        Arrangement intervalC = new Arrangement(new int[]{4});
        Arrangement intervalDD = new Arrangement(new int[]{5});
        
        Chain chain = new Chain(Arrays.asList("A", "BA", "C", "DD", "BA", "A", "A"));
        IntervalType intervalType = IntervalType.DEEP;
        chain.setAnchor(Anchor.START);

        Intervals intervalResult;
        Arrangement result;
        Arrangement target;
        target = new Arrangement(intervals);
        result = intervalResult = chain.intervals(intervalType, Anchor.START);
        assertTrue(intervalA.equals(intervalResult.toUniform("A")));
        assertTrue(intervalBA.equals(intervalResult.toUniform("BA")));
        assertTrue(intervalC.equals(intervalResult.toUniform("C")));
        assertTrue(intervalDD.equals(intervalResult.toUniform("DD")));
        assertTrue(result.equals(target));
    }

    public void testEndDeep(){
        int[] intervals  = {8, 4, 7, 5, 3, 1, 1};
        Arrangement intervalA = new Arrangement(new int[]{8, 1, 1});
        Arrangement intervalBA = new Arrangement(new int[]{4, 3});
        Arrangement intervalC = new Arrangement(new int[]{7});
        Arrangement intervalDD = new Arrangement(new int[]{5});
        Chain chain = new Chain(Arrays.asList("A", "BA", "C", "DD", "BA", "A", "A"));
        IntervalType intervalType = IntervalType.DEEP;
        chain.setAnchor(Anchor.END);

        Arrangement result;
        Arrangement target;
        target = new Arrangement(intervals);
        Intervals intervalResult;
        result = intervalResult = chain.intervals(intervalType, Anchor.END);
//        System.out.println(result.toString());
        assertTrue(intervalA.equals(intervalResult.toUniform("A")));
        assertTrue(intervalBA.equals(intervalResult.toUniform("BA")));
        assertTrue(intervalC.equals(intervalResult.toUniform("C")));
        assertTrue(intervalDD.equals(intervalResult.toUniform("DD")));
        assertTrue(result.equals(target));
    }

    public void testRelativeDeep(){
        int[] intervals  = {1, 1, 1, 1, 5, 9, 2};
        Arrangement intervalA = new Arrangement(new int[]{1, 9, 2});
        Arrangement intervalBA = new Arrangement(new int[]{1, 5});
        Arrangement intervalC = new Arrangement(new int[]{1});
        Arrangement intervalDD = new Arrangement(new int[]{1});

        Chain chain = new Chain(Arrays.asList("A", "BA", "C", "DD", "BA", "A", "A"));
        IntervalType intervalType = IntervalType.DEEP;
        chain.setAnchor(Anchor.START);

        Arrangement result;
        Arrangement target;
        target = new Arrangement(intervals);
        Intervals intervalResult;
        result = intervalResult = chain.intervals(intervalType, Anchor.RELATIVE);
//        System.out.println(result.toString());

        assertTrue(intervalA.equals(intervalResult.toUniform("A")));
        assertTrue(intervalBA.equals(intervalResult.toUniform("BA")));
        assertTrue(intervalC.equals(intervalResult.toUniform("C")));
        assertTrue(intervalDD.equals(intervalResult.toUniform("DD")));
        assertTrue(result.equals(target));
    }

    public void testStartSimple(){
        int[] intervals  = {1, 2, 3, 4, 3, 5, 1};
        Arrangement intervalA = new Arrangement(new int[]{1, 5, 1});
        Arrangement intervalBA = new Arrangement(new int[]{2, 3});
        Arrangement intervalC = new Arrangement(new int[]{3});
        Arrangement intervalDD = new Arrangement(new int[]{4});

        Chain chain = new Chain(Arrays.asList("A", "BA", "C", "DD", "BA", "A", "A"));
        IntervalType intervalType = IntervalType.SIMPLE;
        chain.setAnchor(Anchor.START);

        Arrangement result;
        Arrangement target;
        target = new Arrangement(intervals);
        Intervals intervalResult;
        result = intervalResult = chain.intervals(intervalType, Anchor.START);
        assertTrue(intervalA.equals(intervalResult.toUniform("A")));
        assertTrue(intervalBA.equals(intervalResult.toUniform("BA")));
        assertTrue(intervalC.equals(intervalResult.toUniform("C")));
        assertTrue(intervalDD.equals(intervalResult.toUniform("DD")));
        assertTrue(result.equals(target));
    }

    public void testRelativeSimple(){
        int[] intervals  = {1, 1, 1, 1, 4, 6, 2};
        Arrangement intervalA = new Arrangement(new int[]{1, 6, 2});
        Arrangement intervalBA = new Arrangement(new int[]{1, 4});
        Arrangement intervalC = new Arrangement(new int[]{1});
        Arrangement intervalDD = new Arrangement(new int[]{1});
        Chain chain = new Chain(Arrays.asList("A", "BA", "C", "DD", "BA", "A", "A"));
        IntervalType intervalType = IntervalType.SIMPLE;
        chain.setAnchor(Anchor.RELATIVE);

        Arrangement result;
        Arrangement target;
        target = new Arrangement(intervals);
        Intervals intervalResult;
        result = intervalResult = chain.intervals(intervalType, Anchor.RELATIVE);
        assertTrue(intervalA.equals(intervalResult.toUniform("A")));
        assertTrue(intervalBA.equals(intervalResult.toUniform("BA")));
        assertTrue(intervalC.equals(intervalResult.toUniform("C")));
        assertTrue(intervalDD.equals(intervalResult.toUniform("DD")));
//        System.out.println(result.toString());
        assertTrue(result.equals(target));
    }

    public void testEndSimple(){
        int[] intervals  = {5, 3, 5, 4, 3, 1, 1};
        Arrangement intervalA = new Arrangement(new int[]{1, 1, 5});
        Arrangement intervalBA = new Arrangement(new int[]{3, 3});
        Arrangement intervalC = new Arrangement(new int[]{5});
        Arrangement intervalDD = new Arrangement(new int[]{4});
        Chain chain = new Chain(Arrays.asList("A", "BA", "C", "DD", "BA", "A", "A"));
        IntervalType intervalType = IntervalType.SIMPLE;
        chain.setAnchor(Anchor.END);

        Arrangement result;
        Arrangement target;
        target = new Arrangement(intervals);

        Intervals intervalResult;
        result = intervalResult = chain.intervals(intervalType, Anchor.END);
//        System.out.println(result.toString());
//        System.out.println(intervalResult.toUniform("A").toString());
//        System.out.println(intervalResult.toUniform("BA").toString());
//        System.out.println(intervalResult.toUniform("C").toString());
//        System.out.println(intervalResult.toUniform("DD").toString());
        assertTrue(intervalA.equals(intervalResult.toUniform("A")));

        assertTrue(intervalBA.equals(intervalResult.toUniform("BA")));
        assertTrue(intervalC.equals(intervalResult.toUniform("C")));
        assertTrue(intervalDD.equals(intervalResult.toUniform("DD")));

        assertTrue(result.equals(target));
    }

    public void testUniformStartSimple(){
        Arrangement intervalA = new Arrangement(new int[]{1, 5, 1});
        Arrangement intervalBA = new Arrangement(new int[]{2, 3});
        Arrangement intervalC = new Arrangement(new int[]{3});
        Arrangement intervalDD = new Arrangement(new int[]{4});
        Chain chain = new Chain(Arrays.asList("A", "BA", "C", "DD", "BA", "A", "A"));
        IntervalType intervalType = IntervalType.SIMPLE;
        chain.setAnchor(Anchor.START);

        Arrangement result;


        Intervals intervalResultA = new Intervals(chain.getUniformChain("A"), Anchor.START);
        Intervals intervalResultBA = new Intervals(chain.getUniformChain("BA"), Anchor.START);
        Intervals intervalResultC = new Intervals(chain.getUniformChain("C"), Anchor.START);
        Intervals intervalResultDD = new Intervals(chain.getUniformChain("DD"), Anchor.START);
//        System.out.println(intervalResultA.values().toString());
        assertTrue(intervalResultA.equals(intervalA));
        assertTrue(intervalResultBA.equals(intervalBA));
        assertTrue(intervalResultC.equals(intervalC));
        assertTrue(intervalResultDD.equals(intervalDD));

    }
    public void testUniformEndSimple(){
        Arrangement intervalA = new Arrangement(new int[]{1, 1, 5});
        Arrangement intervalBA = new Arrangement(new int[]{3, 3});
        Arrangement intervalC = new Arrangement(new int[]{5});
        Arrangement intervalDD = new Arrangement(new int[]{4});
        Chain chain = new Chain(Arrays.asList("A", "BA", "C", "DD", "BA", "A", "A"));
        IntervalType intervalType = IntervalType.SIMPLE;
        chain.setAnchor(Anchor.END);

        Arrangement result;

        Intervals intervalResultA = new Intervals(chain.getUniformChain("A"), Anchor.END);
        Intervals intervalResultBA = new Intervals(chain.getUniformChain("BA"), Anchor.END);
        Intervals intervalResultC = new Intervals(chain.getUniformChain("C"), Anchor.END);
        Intervals intervalResultDD = new Intervals(chain.getUniformChain("DD"), Anchor.END);
/*        System.out.println(intervalResultA.values().toString());
        System.out.println(intervalResultBA.values().toString());
        System.out.println(intervalResultC.values().toString());
        System.out.println(intervalResultDD.values().toString());*/
        assertTrue(intervalResultA.equals(intervalA));
        assertTrue(intervalResultBA.equals(intervalBA));
        assertTrue(intervalResultC.equals(intervalC));
        assertTrue(intervalResultDD.equals(intervalDD));

    }

    public void testUniformRelativeSimple(){
        Arrangement intervalA = new Arrangement(new int[]{1, 6, 2});
        Arrangement intervalBA = new Arrangement(new int[]{1, 4});
        Arrangement intervalC = new Arrangement(new int[]{1});
        Arrangement intervalDD = new Arrangement(new int[]{1});
        Chain chain = new Chain(Arrays.asList("A", "BA", "C", "DD", "BA", "A", "A"));
        IntervalType intervalType = IntervalType.SIMPLE;
        chain.setAnchor(Anchor.RELATIVE);

        Arrangement result;

        Intervals intervalResultA = new Intervals(chain.getUniformChain("A"), Anchor.RELATIVE);
        Intervals intervalResultBA = new Intervals(chain.getUniformChain("BA"), Anchor.RELATIVE);
        Intervals intervalResultC = new Intervals(chain.getUniformChain("C"), Anchor.RELATIVE);
        Intervals intervalResultDD = new Intervals(chain.getUniformChain("DD"), Anchor.RELATIVE);
       /* System.out.println(intervalResultA.values().toString());
        System.out.println(intervalResultBA.values().toString());
        System.out.println(intervalResultC.values().toString());
        System.out.println(intervalResultDD.values().toString());*/
        assertTrue(intervalResultA.equals(intervalA));
        assertTrue(intervalResultBA.equals(intervalBA));
        assertTrue(intervalResultC.equals(intervalC));
        assertTrue(intervalResultDD.equals(intervalDD));

    }


 


    public void testToUniform() {
        int[] intervalA = {1, 1, 2, 11};
        int[] intervalG = {5, 1, 2};
        int[] intervalC = {3, 6, 1, 1, 1};
        int[] intervalT = {7, 6, 1, 2, 1, 1};
        
        Alphabet alphabet;
        Arrangement intervals;
        Arrangement intervals2;

        alphabet = new Alphabet(chain);
        intervals =  chain.intervals(IntervalType.SIMPLE, Anchor.START).toUniform("A");
        intervals2 = new Arrangement(intervalA);
        assertTrue(intervals.equals(intervals2));

        intervals =  chain.intervals(IntervalType.SIMPLE, Anchor.START).toUniform("G");
        intervals2 = new Arrangement(intervalG);
        assertTrue(intervals.equals(intervals2));

        intervals =  chain.intervals(IntervalType.SIMPLE, Anchor.START).toUniform("C");
        intervals2 = new Arrangement(intervalC);
        assertTrue(intervals.equals(intervals2));

        intervals =  chain.intervals(IntervalType.SIMPLE, Anchor.START).toUniform("T");
        intervals2 = new Arrangement(intervalT);
        assertTrue(intervals.equals(intervals2));
       


    }

    @Test
    public void testLength() {
        Alphabet alphabet;
        Intervals intervals;
        alphabet = new Alphabet(chain);
        intervals = chain.intervals(IntervalType.SIMPLE, Anchor.START);
        assertTrue(alphabet.power() == intervals.length());

        intervals = chain.intervals(IntervalType.SIMPLE, Anchor.START);
        assertTrue(alphabet.power() == intervals.length());
  
        intervals = chain.intervals(IntervalType.SIMPLE, Anchor.START);
        assertTrue(alphabet.power() == intervals.length());
    }
}
