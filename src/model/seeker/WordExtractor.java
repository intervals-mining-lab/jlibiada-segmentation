package model.seeker;

import base.collectors.Alphabet;
import extended.Helper;
import model.ContentValues;
import base.collectors.DataCollector;
import model.WordEntry;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 24.11.2011
 * Time: 23:10:14
 * To change this template use File | Settings | File Templates.
 */

/**
 * Used as a base for all kinds of word seekers for a chain
 */
public abstract class WordExtractor {
    protected SortedMap<Double, Map.Entry<List<String>, ArrayList<Integer>>> wordPriority;
    protected DataCollector fullEntry;

    {
        wordPriority = new TreeMap<Double, Map.Entry<List<String>, ArrayList<Integer>>>();
        fullEntry = new DataCollector();
    }

    /**
     * Finds a word based on current parameters
     *
     * @param params current segmentation parameters
     * @return
     */
    public abstract WordEntry find(ContentValues params);

    /**
     * Discards all words which enter in the alphabet and contains compound words
     *
     * @param alphabet
     * @param level filtrate level
     * @return
     */
    protected final WordEntry discardCompositeWords(Alphabet alphabet, double level) {
        double bestStd;
        ArrayList<Double> stds = new ArrayList<Double>(wordPriority.keySet());
        ArrayList<Map.Entry<List<String>, ArrayList<Integer>>> entries = new ArrayList<Map.Entry<List<String>, ArrayList<Integer>>>(wordPriority.values());
        for (int index = entries.size(); --index >= 0;) {
            List<String> entry = entries.get(index).getKey();
            String entryS;
            if (!alphabet.contains(entryS = Helper.toString(entry)) && (entry.size() == entryS.length())) {
                bestStd = stds.get(index);
                if (bestStd > level) {
                    return new WordEntry(wordPriority.get(bestStd));
                }
            }
        }
        return null;
    }
}
