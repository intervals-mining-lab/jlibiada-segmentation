package base.collectors;

import base.iterators.StartIterator;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 23.10.2011
 * Time: 16:48:06
 * To change this template use File | Settings | File Templates.
 */

/**
 * Contains a pair of objects word and its positions
 */
public class DataCollector {
    private HashMap<List<String>, ArrayList<Integer>> dictionary;

    {
        dictionary = new HashMap<List<String>, ArrayList<Integer>>();
    }

    public void add(StartIterator iterator, int disp) {
        final List<String> str = iterator.current();
        final int position = iterator.position();
        add(str, position, disp);
    }

    public void add(List<String> accord, int position, int disp) {
        if (!dictionary.containsKey(accord)) {
            dictionary.put(accord, new ArrayList<Integer>());
        }
        dictionary.get(accord).add(position + disp);
    }

    public int size() {
        return dictionary.size();
    }

    public ArrayList<Integer> positions(List<String> chain) {
        return dictionary.get(chain);
    }


    public Set<Map.Entry<List<String>, ArrayList<Integer>>> entrySet() {
        return dictionary.entrySet();
    }

    public Set<Map.Entry<List<String>, ArrayList<Integer>>> entry() {
        return dictionary.entrySet();
    }
}
