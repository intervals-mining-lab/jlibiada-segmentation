package base.sequencies;

import base.collectors.Alphabet;
import base.Anchor;
import base.IntervalType;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 13.07.2011
 * Time: 0:09:01
 * To change this template use File | Settings | File Templates.
 */

/**
 * The key class to work with a sequence of strings. Contains information
 * about the elements of the sequence and their relative positions.
 * The class provides a chain of words in the sequence.
 */
public final class Chain extends ComplexChain {
    private transient LinkedList<UniformChain> uniforms;

    {
        uniforms = new LinkedList<UniformChain>();
    }
    public Chain(){
        temporarySplice = new StringBuilder();
    }

    public Chain(String sequence) {
        super(sequence);
        updateUniforms();
    }

    public Chain(List<String> sequence) {
        super(sequence);
        updateUniforms();
    }
    
    public Chain(String sequence, String chainName){
        super(sequence);
        updateUniforms();
        name = chainName;
    }

    /**
     * Returns a chain splitted by chars
     *
     * @return a chain splitted by chars
     */
    public Chain original(){
      return new Chain(toString());
    }

    /**
     * Recount uniform chains after an original chain have changed
     * This method performs to avoid redundant computing during conversion current chain
     *
     * @return count of uniform chains
     */
    public final int updateUniforms() {
        String str;
        Alphabet alphabet;
        UniformChain uniformChain;

        alphabet = new Alphabet();
        uniforms.clear();
        for (int index = 0; index < sequence.size(); index++) {
            str = sequence.get(index);
            if (!alphabet.contains(str)) {
                uniformChain = new UniformChain(sequence, str);
                uniforms.add(uniformChain);
                alphabet.put(str, alphabet.power());
            }
        }
        return uniforms.size();
    }

    /**
     * Returns an uniform chain constructed of a received sequence
     *
     * @param index a number of an uniform chain in list 
     * @return an uniform chain
     */
    public UniformChain getUniformChain(int index) {
        UniformChain uniform = null;
        try {
            uniform = uniforms.get(index);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Try to get an unknown element of a sequence");
        }
 
        return uniform;
    }

    /**
     * Return an uniform chain constructed of a received sequence
     *
     * @param word the sequence that comprises a chain of words
     * @return an uniform chain
     */
    public UniformChain getUniformChain(String word) {
        updateUniforms();

        for (UniformChain currentUniform : uniforms) {
            if (currentUniform.base.equals(word))
                return currentUniform;
        }

        return null;
    }

    /**
     * Returns a chain copy
     *
     * @return  a chain copy
     */
    @Override
    public Chain clone() {
        if (isEmpty()) return null;
        Chain chain = new Chain(sequence);
        chain.setName(name);
        chain.setAnchor(anchor);

        return chain;
    }

    /**
     * Compares only links for elements in the chain.
     * Compares the elements of the chain one by one/
     *
     * @param sequence compared sequence
     * @return true if chains are equal, othervise - false
     */

    public final boolean equals(ComplexChain sequence) {
        if (sequence.length() != length())
            return false;
        for (int index = 0; index < sequence.length(); index++) {
            if (!this.sequence.get(index).equals(sequence.elementAt(index)))
                return false;
        }

        return true;
    }

    /**
     * Calculates intervals for the chain
     * 
     *
     * @param type interval type
     * @param anchor type of binding for the chain
     * @return intervals
     */
    public final Intervals intervals(IntervalType type, Anchor anchor){
        return new Intervals(type, this, anchor);
    }


}

