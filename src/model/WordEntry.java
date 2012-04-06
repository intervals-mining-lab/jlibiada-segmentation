package model;

import java.util.ArrayList;
import java.util.Map;
import java.util.AbstractMap;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 19.10.2011
 * Time: 13:48:22
 * To change this template use File | Settings | File Templates.
 */

/**
 * An Entry maintaining a key(word) and a value(a list of the occurrences of the word).
 * The value may be changed using the setValue method.
 * This class facilitates the process of building custom map implementations.
 */
public final class WordEntry extends AbstractMap.SimpleEntry<List<String>,ArrayList<Integer>> {
    public WordEntry(List<String> key, ArrayList<Integer> value) {
        super(key, value);
    }

    public WordEntry(Map.Entry<? extends List<String>, ? extends ArrayList<Integer>> entry) {
        super(entry);
    }

}
