package base.sequencies;

import interfaces.INumberSequence;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 19.07.2011
 * Time: 1:42:06
 * To change this template use File | Settings | File Templates.
 */

/**
 * The class implements the system of chain messages, which is obtained by relating to each component
 * of a certain chain of natural numbers so that the identical grounds for the selected components appear
 * with the same number.
 */
public final class Order extends Arrangement {
    public Order(Chain chain) {
        build(chain);
    }

    private Order(LinkedList<Integer> value) {
        build(value);
    }

    private void build(LinkedList<Integer> value) {
        values.addAll(value);
    }

    /**
     * Built the order of the chain
     *
     * @param chain input character sequence
     */
    private void build(Chain chain) {
        String str;
        HashMap<String, Integer> alphabet = new HashMap<String, Integer>();

        for (int index = 0, num = 0; index < chain.length(); index++) {
            str = chain.elementAt(index);
            if (alphabet.containsKey(str)) {
                values.add(alphabet.get(str));
            } else {
                num = num + 1;
                values.add(num);
                alphabet.put(str, num);
            }
        }

    }


    public INumberSequence substring(int beginIndex, int endIndex) {
        Order order = null;

        order = new Order(sublist(beginIndex, endIndex));
        return order;
    }


    public String toString(String emptiness) {
        return null;
    }
}
