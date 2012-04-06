package tests;

import base.collectors.Alphabet;
import base.sequencies.Chain;
import junit.framework.TestCase;

import java.util.Arrays;
import static java.util.Arrays.asList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 09.08.2011
 * Time: 23:07:49
 * To change this template use File | Settings | File Templates.
 */
public class AlphabetTest extends TestCase {
    private Chain chain = new Chain("AACAGGTGCCCCTTATTT");


    public void testPut() {
        Alphabet alphabet = new Alphabet(chain);
        String word = "string";
        String unknown = "WOW";
        int pos = 20;
        alphabet.put(word, pos);

        assertTrue(alphabet.contains(word));
        assertTrue(!alphabet.contains(unknown));
    }

    
    public void testContains() {
        Alphabet alphabet = new Alphabet(chain);
        String[] words = {"A", "G", "C", "T", "WORD", "AG"};
        assertTrue(alphabet.contains(words[0]));
        assertTrue(alphabet.contains(words[1]));
        assertTrue(alphabet.contains(words[2]));
        assertTrue(alphabet.contains(words[3]));
        assertTrue(!alphabet.contains(words[4]));
        assertTrue(!alphabet.contains(words[5]));
    }

    
    public void testGet() {                                     //AACAGGTGCCCCTTATTT
        Alphabet alphabet = new Alphabet(chain);
        String[] words = {"A", "G", "C", "T", "WORD", "AG"};
        int[] positionsA = {0, 1, 3, 14};
        int[] positionsG = {4, 5, 7};
        int[] positionsC = {2, 8, 9, 10, 11};
        int[] positionsT = {6, 12, 13, 15, 16, 17};
        assertTrue((alphabet.get(words[0])).toString().equals(Arrays.toString(positionsA)));
        assertTrue((alphabet.get(words[1])).toString().equals(Arrays.toString(positionsG)));
        assertTrue((alphabet.get(words[2])).toString().equals(Arrays.toString(positionsC)));
        assertTrue((alphabet.get(words[3])).toString().equals(Arrays.toString(positionsT)));
    }

    
    public void testRemove() {
        Alphabet alphabet = new Alphabet(chain);
        String[] words = {"A", "G", "C", "T", "WORD", "AG"};
        alphabet.remove(words[0]);
        assertTrue(!alphabet.contains(words[0]));
        alphabet.remove(words[1]);
        assertTrue(!alphabet.contains(words[1]));
        alphabet.remove(words[2]);
        assertTrue(!alphabet.contains(words[2]));
        alphabet.remove(words[3]);
        assertTrue(!alphabet.contains(words[3]));
        assertTrue(alphabet.power() == 0);
    }

    
    public void testGetWords() {
        Alphabet alphabet = new Alphabet(chain);
        String[] words = {"A", "G", "C", "T"};
        List<String> alphabetWords = alphabet.getWords();

        assertTrue(alphabetWords.containsAll(asList(words)));

    }

    
    public void testFill1() {
        String str = chain.toString();
        Alphabet alphabet1 = new Alphabet(str);
        Alphabet alphabet2 = new Alphabet(chain);
        assertTrue(alphabet1.equals(alphabet2));


    }

    
    public void testFill2() {
        testFill1();
    }

    
    public void testPower() {
        Alphabet alphabetChain = new Alphabet(chain);
        int power = 4;
        assertTrue(alphabetChain.power() == power);
        assertTrue(Alphabet.power(chain.getUniformChain(0)) == 1);
    }

    
    public void testClear() {
        Alphabet alphabet = new Alphabet(chain);
        alphabet.clear();
        assertTrue(alphabet.power() == 0);
    }

    
    public void testAdd() {
        Alphabet alphabet = new Alphabet();
        Alphabet alphabetTest = new Alphabet(chain);
        String[] words = {"A", "G", "C", "T"};
        int power = 1;
        alphabet.add(words[0], alphabetTest.get(words[0]));
        alphabet.add(words[0], alphabetTest.get(words[0]));
        assertTrue(alphabet.contains(words[0]) && alphabet.power() == power);
    }

    
    public void testClone() {
        String str = chain.toString();
        Alphabet alphabet1 = new Alphabet(str);
        Alphabet alphabet2 = new Alphabet(chain);
        Alphabet alphabet3 = (Alphabet) alphabet2.clone();
        assertTrue(alphabet1.equals(alphabet2) && alphabet3.equals(alphabet1));
    }

    
    public void testEquals() {
        String str = chain.toString();
        Alphabet alphabet1 = new Alphabet(str);
        Alphabet alphabet2 = new Alphabet(chain);
        assertTrue(alphabet1.equals(alphabet2));
        alphabet1.remove(alphabet1.getWord(1));
        assertTrue(!alphabet1.equals(alphabet2));

    }

    
    public void testGetWord() {
        Alphabet alphabet = new Alphabet(chain);
        for (int index = 0; index < alphabet.power(); index++) {
            assertTrue(alphabet.contains(alphabet.getWord(index)));
        }

    }
}
