package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 24.10.2011
 * Time: 21:59:51
 * To change this template use File | Settings | File Templates.
 */

/**
 * Cleaning all cross words in the sequence
 */
public class PositionFilter {
    /**
     * Returns non cross word's positions
     *
     * @param std         positions of words
     * @param winLen      length of the scanning window
     * @return non cross word's positions
     */
    public List<Integer> filtrate(List<Integer> std, int winLen) {
        if (std.size() == 0) {
            return new ArrayList<Integer>();
        }
        int pos = 1;
        int pred = std.get(0);

        while (std.size() > pos) {
            if ((std.get(pos) - pred) < winLen) std.remove(pos);
            else pred = std.get(pos);
            pos++;
        }
        return std;
    }
}
