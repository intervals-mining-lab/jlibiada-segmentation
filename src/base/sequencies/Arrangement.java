package base.sequencies;

import interfaces.INumberSequence;

import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 19.07.2011
 * Time: 1:47:21
 * To change this template use File | Settings | File Templates.
 */

/**
 * The class is designed for storing and processing numeric sequences.
 *  Not tied to any notion of order a chain.
 */
public class Arrangement implements INumberSequence {
    protected LinkedList<Integer> values;
    protected String delimiter = "-";

    public Arrangement(List<Integer> values){
        build(values);
    }

    public Arrangement() {
        this.values = new LinkedList<Integer>();
    }

     public Arrangement(int[] values) {
        this.values = new LinkedList<Integer>();
         for (int index = 0; index < values.length; index++){
             this.values.add(values[index]);
         }
    }

    /**
     * Maps taken to the value of the object
     *
     * @param values input numeric sequence
     */
    private void build(List<Integer> values) {
        this.values = new LinkedList<Integer>();
        if (values.isEmpty()){
            List<Integer> list = new LinkedList<Integer>();
            this.values.addAll(list);
            return;
        }
        this.values.addAll(values);
    }

    public boolean isEmpty() {

        return values.isEmpty();
    }

    public int length() {
        return values.size();
    }

    public int elementAt(int index) {
        try {
            return values.get(index);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Try to get an unknown element of sequence");
        }
        return -1;
    }

    public INumberSequence concat(INumberSequence value) {
        try {
            if (!value.isEmpty()) {
                for (int index = 0; index < value.length(); index++) {
                    values.add(value.elementAt(index));
                }
            }
        }
        catch (NullPointerException e) {
            System.out.println("A null numerical sequence");
        }

        return this;
    }

    public INumberSequence add(int value) {
        values.add(value);
        return this;
    }

    public INumberSequence substring(int beginIndex, int endIndex) {
        Arrangement arrangement = null;
            arrangement = new Arrangement(sublist(beginIndex, endIndex));
        return arrangement;  
    }

    public INumberSequence clearAt(int index) {
        try {
            values.remove(index);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Try to clear an unknown element of sequence");
        }
        return this;
    }

    /**
     * Returns a new sequence that is a sublist of the current sequence. The substring begins at the specified beginIndex
     * and extends to the figures at index endIndex - 1. Thus the length of the substring is endIndex-beginIndex.
     *
     * @param beginIndex the beginning index, inclusive.
     * @param endIndex   the ending index, exclusive.
     * @return the specified numerical substring.
     */
    protected LinkedList<Integer> sublist(int beginIndex, int endIndex) {
        List<Integer> sublist = null;

        try {
            sublist =  values.subList(beginIndex, endIndex);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Try to get an illegal range from sequence");
        }

        return new LinkedList<Integer>(sublist);
    }

    public boolean equals(Arrangement sequence) {
        if (sequence.length() != values.size()) return false;
        for(int index = 0; index < sequence.length(); index++){
            if ( values.get(index) != sequence.elementAt(index))
                return false;
        }
        return true;
    }

    @Override
    public String toString(){
      StringBuilder str = new StringBuilder();

            for(Iterator iter = this.values.iterator(); iter.hasNext();){
                str.append(iter.next() + delimiter);
            }
        str.deleteCharAt(str.length() - 1);
        return str.toString();
    }
    
    public void push(int value){
        values.push(value);
    }

    public void clear(){
        values.clear();
    }

    
}
