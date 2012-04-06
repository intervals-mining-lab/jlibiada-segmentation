package base.collectors;

import base.sequencies.Chain;
import base.sequencies.ComplexChain;
import base.sequencies.UniformChain;
import extended.Helper;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 13.07.2011
 * Time: 23:42:23
 * To change this template use File | Settings | File Templates.
 */

/**
 * The finite set of unique words were extracted from a sequence of characters.
 */
public class Alphabet implements Cloneable {
    protected HashMap<String, ArrayList<Integer>> words;

    {
        words = new HashMap<String, ArrayList<Integer>>();
    }

    public Alphabet() {
    }

    /**
     * Returns all words positions
     *
     * @return a list of all words positions
     */
    public List<ArrayList<Integer>> getWordsPositions() {
        return new ArrayList<ArrayList<Integer>>(words.values());
    }

    public Map sortByPower() {
        List list = new LinkedList(words.entrySet());
        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry<String, ArrayList<Integer>>) (o1)).getValue().size())
                        .compareTo(((Map.Entry<String, ArrayList<Integer>>) (o2)).getValue().size());
            }
        });

        Map result = new LinkedHashMap();
        Collections.reverse(list);
        for (Iterator it = list.iterator(); it.hasNext(); ) {
            Map.Entry entry = (Map.Entry) it.next();
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }

    /**
     * Returns a list of words of this alphabet.
     * Be careful! The new word can not be added to the end of the list as the data are hashed
     *
     * @return a list of words of this alphabet.
     */
    public List<String> getWords() {
        if (words.isEmpty()) return new ArrayList<String>();
        return new ArrayList<String>(words.keySet());

    }

    /**
     * Looks number of unique elements
     *
     * @param chain chain which will look
     * @return number of unique elements
     */
    public static double power(ComplexChain chain) {
        LinkedHashSet<String> df = new LinkedHashSet<String>(chain.substring(0, chain.length())); // fast
        return df.size();
    }

    /**
     * Returns obviously
     *
     * @param chain chain which will look
     * @return chain power
     */
    public static double power(UniformChain chain) {
        return 1;
    }

    public Alphabet(String str) {
        fill(str);
    }

    public Alphabet(Chain sequence) {
        fill(sequence);
    }

    /**
     * Extracts new words and their places of occurrence from a current word sequence
     *
     * @param sequence the current word sequence
     */
    public void fill(ComplexChain sequence) {
        clear();
        for (int index = 0; index < sequence.length(); index++) {
            put(sequence.elementAt(index), index);
        }
    }

    /**
     * Extracts new chars and their places of occurrence from a current char sequence
     *
     * @param str the current char sequence
     */
    public void fill(String str) {
        clear();
        for (int index = 0; index < str.length(); index++) {
            put(String.valueOf(str.charAt(index)), index);
        }
    }

    /**
     * Maps the specified word to the specified cursorPosition in a sequence.
     *
     * @param str a new word
     * @param pos a cursorPosition of the word in the sequence
     */
    public void put(String str, int pos) {
        try {
            if (str.isEmpty()) return;
            if (!words.containsKey(str)) {
                ArrayList<Integer> wordPositions = new ArrayList<Integer>();
                wordPositions.add(pos);
                words.put(str, wordPositions);
            }
            List<Integer> modified = words.get(str);
            if (!modified.contains(pos)) modified.add(pos);
        } catch (NullPointerException e) {
            System.out.println("Try to put null element");
        }
    }

    /**
     * Returns true if this alphabet contains the specified word.
     * More formally, returns true if and only if this alphabet contains at least one word
     *
     * @param str word whose presence in this alphabet is to be tested
     * @return true if this alphabet contains the specified word
     */
    public boolean contains(String str) {
        return words.containsKey(str);
    }

    /**
     * Returns true if this alphabet contains the specified word.
     * More formally, returns true if and only if this alphabet contains at least one word
     *
     * @param str word is built from letters whose presence in this alphabet is to be tested
     * @return true if this alphabet contains the specified word
     */
    public boolean contains(List<String> str) {
        return words.containsKey(Helper.toString(str));
    }

    /**
     * Returns the list of positions to which the specified word is mapped, or null
     * if this alphabet contains no mapping for the word.
     *
     * @param str the word whose associated the list of positions is to be returned
     * @return the list of positions to which the specified word is mapped, or null
     *         if this alphabet contains no mapping for the word
     */
    public List<Integer> get(String str) {
        try {
            return words.get(str);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Try to get an unknown word");
        }

        return null;
    }

    /**
     * Removes the word (and its corresponding a list of positions) from this alphabet.
     * This method does nothing if the key is not in the alphabet.
     *
     * @param str the word that needs to be removed
     */
    public void remove(String str) {
        try {
            words.remove(str);
        } catch (NullPointerException e) {
            System.out.println("Try to remove an unknown word");
            e.printStackTrace();
        }
    }

    /**
     * Returns the number of words in this alphabet.
     *
     * @return the number of words in this alphabet.
     */
    public final int power() {
        return words.size();
    }

    /**
     * Clears this alphabet so that it contains no words.
     */
    public void clear() {
        words.clear();
    }

    /**
     * Maps the specified word to the specified list of cursorPosition in a sequence.
     *
     * @param str the new word
     * @param pos word's positions in the sequence
     */
    public void add(String str, List<Integer> pos) {
        try {
            words.put(str, new ArrayList<Integer>(pos));
        } catch (NullPointerException e) {
            System.out.println("Try to put null element to dictionary");
            e.printStackTrace();
        }
    }

    @Override
    public Alphabet clone() {
        Alphabet alphabet = new Alphabet();
        for (Iterator<String> e = this.words.keySet().iterator(); e.hasNext(); ) {
            String word = e.next();
            List<Integer> wordPositions = get(word);
            alphabet.add(word, new ArrayList<Integer>(wordPositions));
        }

        return alphabet;
    }

    public boolean equals(Alphabet obj) {
        if (obj.power() != words.size()) return false;
        for (int index = 0; index < power(); index++) {
            if (!(obj.contains(getWord(index)))) return false;
        }

        return true;
    }

    /**
     * Returns the word to the index at a given
     *
     * @param index a specified cursorPosition of word
     * @return the word to the index at a given
     */
    public String getWord(int index) {
        String str = "";
        try {
            str = getWords().get(index);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Try to get an unknown word from alphabet by index");
        }

        return str;
    }

}
