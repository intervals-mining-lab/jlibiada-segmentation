package tests;

import junit.framework.TestCase;
import org.junit.Test;
import base.sequencies.Chain;
import base.sequencies.Order;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 03.09.2011
 * Time: 22:47:32
 * To change this template use File | Settings | File Templates.
 */
public class OrderTest extends TestCase {
    private Chain chain = new Chain("AACAGGTGCCCCTTATTT");
                                     
    @Test
    public void testsubstring(){
    Order builtOrder1, builtOrder2;
    Chain chain;
        builtOrder1 = new Order(this.chain);
        chain = new Chain("112133432222441444");
        builtOrder2 = new Order(chain);
       assertTrue(builtOrder1.equals(builtOrder2));

    }
}
