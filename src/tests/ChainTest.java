package tests;

import base.collectors.Alphabet;
import base.Anchor;
import base.IntervalType;
import base.sequencies.Arrangement;
import base.sequencies.Chain;
import base.sequencies.Intervals;
import base.sequencies.UniformChain;
import junit.framework.TestCase;
import tools.PerformanceProfiler;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 26.07.2011
 * Time: 2:10:50
 * To change this template use File | Settings | File Templates.
 */
public class ChainTest extends TestCase {
    private Chain chain = new Chain("AACAGGTGCCCCTTATTT");
    private Chain differentChain = new Chain("AACAGGTGCTTATTT");
    private UniformChain uniformA = new UniformChain("AA-A----------A---", "A");
    private UniformChain uniformG = new UniformChain("----GG-G----------", "G");
    private UniformChain uniformC = new UniformChain("--C-----CCCC------", "C");
    private UniformChain uniformT = new UniformChain("------T-----TT-TTT", "T");
    private Anchor link;
    private Intervals intervals;
    private static long ts, te;

    
    public void testClone() {
        PerformanceProfiler.start();
        Chain foreignChain = chain.clone();
        PerformanceProfiler.end();
        System.out.println(PerformanceProfiler.result());
        assertNotSame(chain, foreignChain);
        assertTrue(chain.equals(foreignChain));
    }

    
    public void testEquals() {
        Chain foreignChain = chain.clone();

        assertTrue(foreignChain.equals(chain));
        foreignChain.clearAt(0);
        foreignChain.clearAt(0);
        assertTrue(!foreignChain.equals(chain));
    }

    
    public void testIntervalsStart() {
        int[] intervalA = {1, 1, 2, 11};
        int[] intervalG = {5, 1, 2};
        int[] intervalC = {3, 6, 1, 1, 1};
        int[] intervalT = {7, 6, 1, 2, 1, 1};
        chain.setAnchor(Anchor.START);
        intervals = chain.intervals(IntervalType.SIMPLE, Anchor.START);
        testA(intervalA);
        testG(intervalG);
        testC(intervalC);
        testT(intervalT);
    }

    
    public void testUniformCount() {
        link = Anchor.START;
        intervals = chain.intervals(IntervalType.SIMPLE, Anchor.START);
        assertTrue(intervals.length() == 4);
    }

    private void testA(int[] intervalA) {
        LinkedList<Integer> valuesA = new LinkedList<Integer>();
        valuesA.add(intervalA[0]);
        valuesA.add(intervalA[1]);
        valuesA.add(intervalA[2]);
        valuesA.add(intervalA[3]);
        Arrangement sequence = new Arrangement(valuesA);
        assertTrue(intervals.toUniform("A").equals(sequence));
    }

    private void testG(int[] intervalG) {
        LinkedList<Integer> valuesG = new LinkedList<Integer>();
        Arrangement sequence;
        valuesG.add(intervalG[0]);
        valuesG.add(intervalG[1]);
        valuesG.add(intervalG[2]);
        sequence = new Arrangement(valuesG);
        assertTrue(intervals.toUniform("G").equals(sequence));
    }

    private void testC(int[] intervalC) {
        LinkedList<Integer> valuesC = new LinkedList<Integer>();
        Arrangement sequence;
        valuesC.add(intervalC[0]);
        valuesC.add(intervalC[1]);
        valuesC.add(intervalC[2]);
        valuesC.add(intervalC[3]);
        valuesC.add(intervalC[4]);
        sequence = new Arrangement(valuesC);
        assertTrue(intervals.toUniform("C").equals(sequence));
    }

    private void testT(int[] intervalT) {
        List<Integer> valuesT = new LinkedList<Integer>();
        Arrangement sequence = null;
        valuesT.add(intervalT[0]);
        valuesT.add(intervalT[1]);
        valuesT.add(intervalT[2]);
        valuesT.add(intervalT[3]);
        valuesT.add(intervalT[4]);
        valuesT.add(intervalT[5]);
        sequence = new Arrangement(valuesT);
        assertTrue(intervals.toUniform("T").equals(sequence));
    }

    
    public void testIntervalsEnd() {       // AACAGGTGCCCCTTATTT
        int[] intervalA = {4, 11, 2, 1};
        int[] intervalG = {11, 2, 1};
        int[] intervalC = {7, 1, 1, 1, 6};
        int[] intervalT = {1, 1, 1, 2, 1, 6};
        chain.setAnchor(Anchor.END);
        intervals = chain.intervals(IntervalType.SIMPLE, Anchor.START);
        testA(intervalA);
        testG(intervalG);
        testC(intervalC);
        testT(intervalT);
    }

    
    public void testIntervalsRelative() {
        int[] intervalA = {1, 10, 2, 11};
        int[] intervalG = {1, 1, 2};
        int[] intervalC = {1, 6, 1, 1, 1};
        int[] intervalT = {1, 6, 1, 2, 1, 1};
        chain.setAnchor(Anchor.RELATIVE);
        intervals = chain.intervals(IntervalType.SIMPLE, Anchor.START);
        testA(intervalA);
        testG(intervalG);
        testC(intervalC);
        testT(intervalT);
    }

    
    public void testElementAt() {
        String str1 = "A";
        String str2 = "G";
        String str3 = "C";

        assertTrue(str1.equals(chain.elementAt(0)));
        assertTrue(str2.equals(chain.elementAt(4)));
        assertTrue(str3.equals(chain.elementAt(2)));
    }

    
    public void testSubstring() {
        int start = 0, end = 2;
        Chain thirdChain = new Chain("AA");
        Chain foreignChain = new Chain(chain.substring(start, end));

        assertTrue(thirdChain.equals(foreignChain));
    }

    
    public void testClearAt() {
        Chain secondChain = new Chain("AGTC");
        Chain firstChain = new Chain("ATC");
        secondChain.clearAt(1);
        assertTrue(firstChain.equals(secondChain));
    }

    
    public void testToUpperCase() {
        Chain secondChain = new Chain("aacaggtgccccttattt");
        System.out.println("Current " + secondChain.toString());
        System.out.println("Target " + chain.toString());
        assertTrue(chain.equals(secondChain.toUpperCase()));
    }

    
    public void testToLowerCase() {
        testToUpperCase();
    }

    
    public void testConcat1() {
        int start = 0, end;
        end = chain.length();

        Chain firstChain = new Chain(chain.substring(start, end / 2));
        Chain secondChain = new Chain(chain.substring(end / 2, end));
        assertTrue((firstChain.concat(secondChain)).equals(chain));
    }

    
    public void testConcat2() {
        int start = 0, end;
        end = chain.length();

        Chain firstChain = new Chain(chain.substring(start, end - 1));
        Chain secondChain = new Chain(chain.substring(end - 1, end));

        assertTrue((firstChain.concat(secondChain.toString())).equals(chain));
    }

    
    public void testLength() {
        Chain foreignChain = chain.clone();

        assertTrue(chain.length() != differentChain.length());
        assertTrue(chain.length() == foreignChain.length());
        foreignChain.clearAt(0);
        assertTrue(chain.length() != foreignChain.length());
    }

    
    public void testIsEmpty() {
        String str = "s";
        Chain chain = new Chain("");
        assertTrue(chain.isEmpty());
        chain.concat(str);
        assertTrue(!chain.isEmpty());
        chain.clearAt(0);
        assertTrue(chain.isEmpty());
    }

    
    public void testupdateUniforms() {
        Alphabet alphabet;
        Chain clonedChain;
        clonedChain = chain.clone();

        alphabet = new Alphabet(chain);
        chain.updateUniforms();
        clonedChain.updateUniforms();
        chain.clearAt(0);
        clonedChain.clearAt(0);
        assertTrue(chain.equals(clonedChain));
    }

    
    public void testgetUniformChain() {
        chain.updateUniforms();
        assertTrue(uniformA.equals(chain.getUniformChain(0)));
        assertTrue(uniformA.equals(chain.getUniformChain("A")));
        assertTrue(uniformG.equals(chain.getUniformChain(2)));
        assertTrue(uniformG.equals(chain.getUniformChain("G")));
        assertTrue(uniformC.equals(chain.getUniformChain(1)));
        assertTrue(uniformC.equals(chain.getUniformChain("C")));
        assertTrue(uniformT.equals(chain.getUniformChain(3)));
        assertTrue(uniformT.equals(chain.getUniformChain("T")));
    }

    
    public void testintervals() {

    }

    
    public void testjoin(){
        Chain clon = chain.clone();
        List<String> list1 = Arrays.asList("AAC", "A", "G", "G", "T", "G", "C", "C", "C", "C", "T", "T", "A", "T", "T", "T");
        List<String> list2 = Arrays.asList("AAC", "A", "G", "G", "TGC", "C", "C", "C", "T", "T", "A", "T", "T", "T");
        List<String> list3 =  Arrays.asList("AACAGGTGC", "C", "C", "C", "T", "T", "A", "T", "T", "T");
        List<String> list4 =  Arrays.asList("AACAGGTGC", "C", "C", "C", "T", "T", "A", "T", "TT");
        clon.join(0, 3);
        assertTrue((new Chain(list1)).equals(clon));

        System.out.println("Original "+ chain.toString("-"));
        System.out.println("Modified "+ clon.toString("-"));
        clon.join(4, 3);
        assertTrue((new Chain(list2)).equals(clon));
        System.out.println("Modified "+ clon.toString("-"));
        ts = System.nanoTime();
        clon.join(0, 5);
        assertTrue((new Chain(list3)).equals(clon));
        te =System.nanoTime();
        double amoutTime = (te - ts) / 1e6;
        System.out.println("Modified "+ clon.toString("-") +"\n" + amoutTime + " ms" + "\n");
        clon.join(8, 2);
        assertTrue((new Chain(list4)).equals(clon));
        System.out.println("Modified "+ clon.toString("-"));
    }
     
    public void testjoinAll(){
        List<String> list1 = Arrays.asList("A", "A", "G", "G", "T", "G", "C", "A", "A", "A", "A", "T", "A", "T", "A", "A", "A");
        Chain clon = new Chain(list1);
        List<String> list2 = Arrays.asList("A", "A");
        System.out.println(clon.toString("-"));
        clon.joinAll(list2);
        System.out.println(clon.toString("-"));
    }

}
