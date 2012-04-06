package base.seekers.converters;

import base.iterators.EndIterator;
import base.sequencies.ComplexChain;
import interfaces.ISeeker;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 23.09.2011
 * Time: 21:05:29
 * To change this template use File | Settings | File Templates.
 */

/**
 * Removes all occupancies of sequence
 */
public class SequenceCleaner extends Filter {
    public SequenceCleaner(ComplexChain chain) {
        super(chain);
    }

    public int filterout(List<String> sequence){
        int hits = 0;
        EndIterator iterator = null;
        iterator = new EndIterator(chain, sequence.size(), ISeeker.step);

        while (iterator.hasNext()){
            if (iterator.next().equals(sequence)) {
                chain.remove(iterator.position(), sequence.size());
                hits = hits + 1;
            }
        }
        return hits;
    }
}
