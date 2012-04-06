package base.sequencies;

import base.Anchor;
import interfaces.Identifiable;
import interfaces.StringSequence;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 12.07.2011
 * Time: 0:22:58
 * To change this template use File | Settings | File Templates.
 */

/**
 * This is a basic class for any composite sequence.
 * Its manages and stores the elements in the established order.
 */
public abstract class ComplexChain implements StringSequence, Identifiable {
    protected String name;
    protected List<String> sequence;
    protected Anchor anchor;
    protected transient StringBuilder temporarySplice;

    public ComplexChain(){
        init();
    }

    private void init() {
        temporarySplice = new StringBuilder();
        name = "Тестовая цепь";
        anchor = Anchor.START;
        sequence = new LinkedList<String>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Anchor getAnchor(){
        return anchor;
    }

    public void setAnchor(Anchor anchor){
        this.anchor = anchor;
    }

    protected ComplexChain(String sequence) {
        init();
        for (int index = 0; index < sequence.length(); index++) {
            this.sequence.add(String.valueOf(sequence.charAt(index)));
        }
    }

    protected ComplexChain(List<String> sequence) {
        init();
        this.sequence = new LinkedList<String>(sequence);
        Collections.copy(this.sequence, sequence);

    }

    public String elementAt(int index) {
        String sequence = null;
        try {
            sequence = this.sequence.get(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Try to get an unknown element of sequence");
        }
        return sequence;
    }

    public List<String> substring(int beginIndex, int endIndex) {
        List<String> sequence = null;
        try {
            sequence = new LinkedList<String>(this.sequence.subList(beginIndex, endIndex));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Try to get an illegal range from sequence");
        }

        return sequence;
    }


    public ComplexChain clearAt(int index) {
        try {
            sequence.remove(index);
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Try to get an unknown element of sequence");
        }

        return this;

    }

    public abstract ComplexChain clone();
    public abstract boolean equals(ComplexChain complexChain);

    public ComplexChain toUpperCase() {
        for (int index = 0; index < sequence.size(); index++) {
            sequence.set(index, sequence.get(index).toUpperCase());
        }

        return this;
    }

    public ComplexChain toLowerCase() {
        for (int index = 0; index < sequence.size(); index++) {
            sequence.set(index, sequence.get(index).toLowerCase());
        }

        return this;
    }

    public ComplexChain concat(String str) {
        if (str.isEmpty()) return this;
        sequence.add(str);

        return this;
    }

    public ComplexChain concat(ComplexChain sequence) {
        int startIndex = 0;
        if (sequence.isEmpty())
            return this;
        this.sequence.addAll(sequence.substring(startIndex, sequence.length()));

        return this;
    }

    public int length() {
        return sequence.size();
    }

    public boolean isEmpty() {
        return sequence.isEmpty();
    }

    /**
     * Changes an element in index position
     *
     * @param index a position in a chain
     * @param str a new element
     */
    public void replace(int index, String str) {
        sequence.set(index, str);
    }

    /**
     *
     * @return a string representation of the sequence
     */
    @Override
    public String toString() {
        temporarySplice.setLength(0);

        for (String aSequence : sequence) {
            temporarySplice.append(aSequence);
        }

        return temporarySplice.toString();
    }

    /**
     * Returns divided string by delimiter
     *
     * @param delimiter any string
     * @return divided string
     */
    public String toString(String delimiter) {
       temporarySplice.setLength(0);

        for (String aSequence : sequence) {
            temporarySplice.append(aSequence).append(delimiter);
        }
        temporarySplice.delete(temporarySplice.length() - delimiter.length(), temporarySplice.length());
        return temporarySplice.toString();
    }

    /**
     * Identify whether is there  a chain contains the specified element
     *
     * @param word sequence which is part of a chain
     * @return true if chain contains the specified element
     */
    public boolean isElement(String word) {
        return sequence.contains(word);
    }

    /**
     * Cuts a range of words from pos to pos + len cursorPosition
     * @param pos start cursorPosition
     * @param len count of words cut out
     */
    public void remove(int pos, int len) {
        if ((pos + len) > (sequence.size())) return;
        for (int index = pos; index < len + pos; index++) {
            sequence.remove(pos);
        }
    }

    /**
     * Joins some elements of the sequence to whole composed string
     *
     * @param pos cursorPosition in the sequence at which to begin the gluing
     * @param len how many words need to join including first word
     */
    public final void join(int pos, final int len) {
        final int wordEnd = pos + len;

        temporarySplice.setLength(0);
        if (wordEnd > sequence.size()) return;
        for (int index = pos; index < wordEnd; index++) {
            temporarySplice.append(sequence.get(index));
        }
        sequence.subList(pos, wordEnd - 1).clear();
        sequence.set(pos, temporarySplice.toString());
    }

    /**
     * Joins all hits from start chain to whole composed string
     * Very fast for long sequence, because there is no index check!
     * @param word list of letters to compose
     */
    public void joinAll(List<String> word) {
        final int length = word.size();
        int index = 0;
        while(1==1){
           try{
             if (sequence.subList(index, index + length).equals(word)) join(index, length);
             index++;
           }catch (IndexOutOfBoundsException e){
             return;
           }
        }
    }
}
