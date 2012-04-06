package base.sequencies;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 18.07.2011
 * Time: 23:53:57
 * To change this template use File | Settings | File Templates.
 */

/**
 * Type of a chain which is contained of an alphabet in one element and a pseudo value.
 * Every different element in a chain is a pseudo value.
 */
public final class UniformChain extends ComplexChain {
    public static final String EMPTINESS;
    public final String base;

    static{
        EMPTINESS = "-";
    }

    public UniformChain(String sequence, String word) {
        super(sequence);
        base = word;
        init();
    }

    public UniformChain(List<String> sequence, String word) {
        super(sequence);
        base = word;
        init();
    }

     public UniformChain(Chain sequence, String word) {
        super(sequence.substring(0, sequence.length()));
        base = word;
        init();
    }


    /**
     * Replaces every element in the sequence that is different from base
     */
    private void init() {
        for (int index = 0; index < sequence.size(); index++) {
            if (!sequence.get(index).equals(base)) sequence.set(index, EMPTINESS);
        }
    }

    public UniformChain clone() {
        return new UniformChain(sequence, base);
    }

    public boolean equals(ComplexChain uniform) {
        int index = 0;

        if (length() != uniform.length()) return false;
        for (String aSequence : sequence) {
            if (!(uniform.elementAt(index).equals(aSequence))) return false;
            index = index + 1;
        }
        return true;
    }

    /**
     * Returns count of base elements in the chain
     *
     * @return count of base elements
     */
    public int countBase(){
        int countBase = 0;
        for (int index = sequence.size(); --index >=0 ;) {
            if (sequence.get(index).equals(base)) countBase = countBase + 1;
        }

        return countBase;
    }

}
