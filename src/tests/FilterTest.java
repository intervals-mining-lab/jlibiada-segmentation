package tests;

import base.seekers.converters.Filter;
import base.sequencies.Chain;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 23.09.2011
 * Time: 16:11:08
 * To change this template use File | Settings | File Templates.
 */
public class FilterTest extends TestCase {
    final String str1 = "A";
    final String str2 = "TA";
    List<String> list = Arrays.asList("ABABAB","ABATAT","TABABAB","ABTABAB","ABABAB","ABABAB","ABABAB");
    @Test
    public void testFilterout() {
        Filter filter = null;
        Chain chain = null;
        String result, buf;
        int hits;
        chain = new Chain(list);
        filter = new Filter(chain);
        hits = filter.filterout(str1);

        StringBuilder sb = new StringBuilder();
        for (String s : list) sb.append(s);
        result = filter.getChain().toString();
        buf = chain.toString();
        System.out.println("First chain " + buf + " len " + buf.length());
        System.out.println("Modif chain " + result + " len " + result.length());
        assertTrue(buf.length() - result.length() == hits);

        filter = new Filter(chain);
        hits = filter.filterout(str2);

        result = filter.getChain().toString();
        buf = chain.toString();
        System.out.println("First chain " + buf + " len " + buf.length());
        System.out.println("Modif chain " + result + " len " + result.length());
        assertTrue(3 == hits);
    }

    @Test
    public void testReplace() {
        Filter filter = null;
        Chain chain = null;
        String result, buf;
        int hits;
        chain = new Chain(list);
        filter = new Filter(chain);
        hits = filter.replace(str2, "-");

        StringBuilder sb = new StringBuilder();
        for (String s : list) sb.append(s);
        result = filter.getChain().toString();
        buf = chain.toString();
        System.out.println("First chain " + buf + " len " + buf.length());
        System.out.println("Modif chain " + result + " len " + result.length());
        System.out.println("Modif chain " + hits);
        assertTrue(buf.length() - result.length() == hits);
    }

    @Test
    public void testHits() {
        Filter filter = new Filter(new Chain(list));
        System.out.println(filter.filterout("AB"));
        System.out.println(filter.getChain().toString("-"));
        System.out.println(filter.getChain().length());
    }
}
