package base.seekers;

import base.seekers.Seeker;
import interfaces.ISeeker;
import interfaces.Iterator;

import java.util.List;
import java.util.LinkedList;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 20.09.2011
 * Time: 17:13:47
 * To change this template use File | Settings | File Templates.
 */
public class SeekerSequence extends Seeker implements ISeeker {
    public SeekerSequence(Iterator where) {
        super(where);
    }

    public int seek(List<String> sequence) {
        result = new LinkedList<Integer>();
        while (iterator.hasNext()) {
            if (iterator.next().equals(sequence)) result.add(iterator.position());
        }
        iterator.reset();
        return result.size();
    }
}
