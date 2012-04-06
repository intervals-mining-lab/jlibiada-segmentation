package base.seekers;

import interfaces.ISeeker;
import interfaces.Iterator;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 20.09.2011
 * Time: 13:27:48
 * To change this template use File | Settings | File Templates.
 */

/**
 * Searching for occurrences of a sequence
 */
public class Seeker implements ISeeker {
    final int first = 0;
    protected List<Integer> result;
    protected Iterator iterator;
    protected Iterator current;

    public Seeker(Iterator where) {
        this.iterator = where;
    }

    @Override
    public int seek(List<String> required) {
        int index = 0;
        List<String> sequence = null;
        result = new LinkedList<Integer>();
        while (iterator.hasNext()) {
            sequence = iterator.next();
            for (java.util.Iterator iter = sequence.iterator(); iter.hasNext(); index++) {
                if ((iter.next()).equals(required.get(first))) result.add(index);
            }
        }
        iterator.reset();
        return result.size();
    }

    @Override
    public List<Integer> arrangement() {
        return result;
    }

    public void customIterator(Iterator iterator){
       this.iterator = iterator;
    }

}
