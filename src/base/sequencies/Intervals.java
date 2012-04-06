package base.sequencies;

import base.Anchor;
import base.IntervalType;
import interfaces.INumberSequence;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 19.07.2011
 * Time: 1:41:57
 * To change this template use File | Settings | File Templates.
 */

/**
 * An array of numbers that are prepared by calculation the distance in characters
 * on a specified method of the origin of first distances from the first comer of the new symbol
 */
public class Intervals extends Arrangement {
    private Hashtable<String, INumberSequence> uniforms;
    public final IntervalType intervalType;

    {
        uniforms = new Hashtable<String, INumberSequence>();
    }

    /**
     * Initializes the method of calculating the intervals for the chain
     *
     * @param type   interval type
     * @param chain  chain which the intervals are calculated for
     * @param anchor type of binding for the chain
     */
    public Intervals(IntervalType type, Chain chain, Anchor anchor) {
        intervalType = type;
        switch (intervalType) {
            case DEEP: {
                buildDeep(chain, anchor);
                break;
            }
            case SIMPLE: {
                buildSimple(chain, anchor);
                break;
            }
        }
    }

    /**
     * Initializes the method of calculating the intervals for the uniform chain
     *
     * @param uniformChain chain which the intervals are calculated for
     * @param anchor       type of binding for the chain
     */
    public Intervals(UniformChain uniformChain, Anchor anchor) {
        intervalType = IntervalType.SIMPLE;
        switch (anchor) {
            case START: {
                bindStartUniform(uniformChain);
                break;
            }
            case END: {
                bindEndUniform(uniformChain);
                break;
            }
            case RELATIVE: {
                bindRelativeUniform(uniformChain);
                break;
            }
        }
    }

    private void bindRelativeUniform(UniformChain uniformChain) {
        int lastPosition = 0;
        boolean isFirstOccurrence = true;
        uniforms.put(uniformChain.base, new Arrangement());
        for (int index = 0, interval = 1; index < uniformChain.length(); index++) {
            if (uniformChain.elementAt(index).equals(uniformChain.base)) {
                if (isFirstOccurrence) {
                    lastPosition = index + 1;
                    isFirstOccurrence = false;
                }
                interval = index - lastPosition + 2;
                uniforms.get(uniformChain.base).add(interval);
                values.add(interval);
                lastPosition = index + 1;
            }
        }
    }

    private void bindEndUniform(UniformChain uniformChain) {
        int lastPosition = uniformChain.length() + 1;
        uniforms.put(uniformChain.base, new Arrangement());
        for (int index = uniformChain.length(), interval = 1; index > 0; index--) {
            if (uniformChain.elementAt(index - 1).equals(uniformChain.base)) {
                interval = lastPosition - index;
                uniforms.get(uniformChain.base).add(interval);
                values.add(interval);
                lastPosition = index;
            }
        }
    }

    private void bindStartUniform(UniformChain uniformChain) {
        int lastPosition = 0;
        uniforms.put(uniformChain.base, new Arrangement());
        for (int index = 0, interval = 1; index < uniformChain.length(); index++) {
            if (uniformChain.elementAt(index).equals(uniformChain.base)) {
                interval = index - lastPosition + 1;
                uniforms.get(uniformChain.base).add(interval);
                values.add(interval);
                lastPosition = index + 1;
            }
        }
    }


    private void buildDeep(Chain chain, Anchor anchor) {
        uniforms = new Hashtable<String, INumberSequence>();
        switch (anchor) {
            case START: {
                bindStartDeep(chain);
                break;
            }
            case END: {
                bindEndDeep(chain);
                break;
            }
            case RELATIVE: {
                bindRelativeDeep(chain);
                break;
            }
        }
    }


    /**
     * Builds defined type of intervals from the chain
     *
     * @param anchor defines a rule that calculated intervals
     * @param chain  input character sequence
     */
    private void buildSimple(Chain chain, Anchor anchor) {
        uniforms = new Hashtable<String, INumberSequence>();
        switch (anchor) {
            case START: {
                bindStartSimple(chain);
                break;
            }
            case END: {
                bindEndSimple(chain);
                break;
            }
            case RELATIVE: {
                bindRelativeSimple(chain);
                break;
            }
        }
    }

    private void bindStartDeep(Chain chain) {
        String str;
        Hashtable<String, Integer> alphabet = new Hashtable<String, Integer>();
        for (int index = 0, interval = 1; index < chain.length(); index++) {
            str = chain.elementAt(index);
            if (!alphabet.containsKey(str)) {
                interval = countSymbols(chain.substring(0, index)) + 1;
                alphabet.put(str, index);
                uniforms.put(str, new Arrangement());
            } else {
                interval = countSymbols(chain.substring(alphabet.get(str) + 1, index)) + 1;
                alphabet.put(str, index);
            }
            uniforms.get(str).add(interval);
            values.add(interval);
        }

    }

    private final int countSymbols(List<String> list) {
        int count = 0;
        for (int index = 0; index < list.size(); index++) {
            count += list.get(index).length();
        }
        return count;
    }


    private void bindEndDeep(Chain chain) {
        String str;
        Hashtable<String, Integer> alphabet = new Hashtable<String, Integer>();
        Arrangement intervals;
        for (int index = chain.length() - 1, interval = 1; index >= 0; index--) {
            str = chain.elementAt(index);
            if (!alphabet.containsKey(str)) {
                interval = countSymbols(chain.substring(index + 1, chain.length())) + 1;
                alphabet.put(str, index);
                uniforms.put(str, new Arrangement());
            } else {
                interval = countSymbols(chain.substring(index + 1, alphabet.get(str))) + 1;
                alphabet.put(str, index);
            }
            uniforms.get(str).push(interval);
            values.push(interval);
        }
    }

    private void bindRelativeDeep(ComplexChain chain) {
        String str = null;
        Hashtable<String, Integer> alphabet = new Hashtable<String, Integer>();
        for (int index = 0, interval = 1; index < chain.length(); index++) {
            str = chain.elementAt(index);

            if (!alphabet.containsKey(str)) {
                alphabet.put(str, index);
                uniforms.put(str, new Arrangement());
            } else {
                interval = countSymbols(chain.substring(alphabet.get(str) + 1, index)) + 2;
                alphabet.put(str, index);
            }
            uniforms.get(str).add(interval);
            values.add(interval);
        }
    }

    /**
     * Calculates the intervals from the beginning of the chain to the last element
     *
     * @param chain input character sequence
     */
    private void bindStartSimple(ComplexChain chain) {
        String str;
        Hashtable<String, Integer> alphabet = new Hashtable<String, Integer>();
        for (int index = 0, interval = 1; index < chain.length(); index++) {
            str = chain.elementAt(index);
            if (str.equals(UniformChain.EMPTINESS)) continue;
            if (!alphabet.containsKey(str)) {
                interval = index + 1;
                alphabet.put(str, index);
                uniforms.put(str, new Arrangement());
            } else {
                interval = index - alphabet.get(str);
                alphabet.put(str, index);
            }
            uniforms.get(str).add(interval);
            values.add(interval);
        }

    }


    /**
     * Calculates the interval from the end of the chain to the first element
     *
     * @param chain input character sequence
     */
    private void bindEndSimple(Chain chain) {
        String str;
        Hashtable<String, Integer> alphabet = new Hashtable<String, Integer>();
        for (int index = chain.length(), interval = 1; index > 0; index--) {
            str = chain.elementAt(index - 1);
            if (!alphabet.containsKey(str)) {
                interval = chain.length() - index + 1;
                alphabet.put(str, interval);
                uniforms.put(str, new Arrangement());
            } else {
                interval = (chain.length() - index + 1) - alphabet.get(str);
                alphabet.put(str, chain.length() - index + 1);
            }
            uniforms.get(str).add(interval);
            values.push(interval);
        }
    }

    /**
     * Calculates the intervals from the beginning of the chain to the last element,
     * and each new character has an interval equal to one
     *
     * @param chain input character sequence
     */
    private void bindRelativeSimple(ComplexChain chain) {
        String str = null;
        Hashtable<String, Integer> alphabet = new Hashtable<String, Integer>();
        for (int index = 0, interval = 1; index < chain.length(); index++) {
            str = chain.elementAt(index);

            if (!alphabet.containsKey(str)) {
                interval = 1;
                alphabet.put(str, index);
                uniforms.put(str, new Arrangement());
            } else {
                interval = chain.substring(alphabet.get(str) + 1, index).size() + 2;
                alphabet.put(str, index);
            }
            uniforms.get(str).add(interval);
            values.add(interval);
        }
    }

    /**
     * Extracts a range of numbers from an interval sequence.
     *
     * @param beginIndex a start index
     * @param endIndex   an end index
     * @return range of numbers
     */
    public INumberSequence substring(int beginIndex, int endIndex) {
        Intervals intervals = null;
        //    intervals = new Intervals(sublist(beginIndex, endIndex), intervalType);
        return intervals;
    }

    private void add(LinkedList<Integer> list) {
        values.addAll(list);
    }


    /**
     * Returns intervals for a received word
     *
     * @param str word in the sequence
     * @return intervals for a received word
     */
    public Arrangement toUniform(String str) {
        if (!uniforms.containsKey(str)) return new Arrangement();
        return (Arrangement) uniforms.get(str);
    }

    /**
     * Returns number of unique uniform sequences
     *
     * @return number of unique uniform sequences
     */
    @Override
    public int length() {
        return uniforms.size();
    }

    public boolean equals(Intervals uIntervals) {
        if (uIntervals.length() != length()) return false;
        if (!uniforms.keySet().equals(uIntervals.wordSet())) return false;
        if (!uniforms.values().equals(uIntervals.values())) return false;

        return true;
    }

    public Set<String> wordSet() {
        return uniforms.keySet();
    }

    public Collection<INumberSequence> values() {
        return uniforms.values();
    }
}
