package base.seekers.converters;

import base.sequencies.ComplexChain;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 23.09.2011
 * Time: 14:19:12
 * To change this template use File | Settings | File Templates.
 */

/**
 * Filters a sequence of signs in compliance with set rules.
 * The filter handles only words
 */
public class Filter {
    protected ComplexChain chain;
    protected String replacement = "";

    public Filter(ComplexChain chain) {
        this.chain = chain.clone();
    }

    /**
     * Removes all specified entry letters in any word
     *
     * @param str specified substring
     * @return number of hints
     */
    public int filterout(String str) {
        int len = chain.toString().length();
        for (int index = chain.length(); --index >= 0;) {
            chain.replace(index, chain.elementAt(index).replaceAll(str, replacement));
            if (chain.elementAt(index).length() == 0) chain.remove(index, 1);
        }
        return hints(len, str);

    }

    private int hints(int len, String str){
        double per =( len -  chain.toString().length()) / (double)(str.length() - replacement.length());
        return (int) per;
    }

    /**
     * Replaces all specified entry letters in any word
     *
     * @param str specified substring
     * @param replacement something that must be replaced
     * @return number of hints
     */
    public int replace(String str, String replacement) {
        int hits;
        this.replacement = replacement;
        hits = filterout(str);
        this.replacement = "";
        
        return hits;
    }

    public ComplexChain getChain() {
        return chain;
    }
}
