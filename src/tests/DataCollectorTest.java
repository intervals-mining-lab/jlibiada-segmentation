package tests;

import org.junit.Test;
import junit.framework.TestCase;
import base.collectors.DataCollector;
import base.sequencies.Chain;
import base.iterators.StartIterator;

import tools.PerformanceProfiler;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 23.10.2011
 * Time: 17:30:28
 * To change this template use File | Settings | File Templates.
 */
public class DataCollectorTest extends TestCase {
    private Chain chain = new Chain("AACAGGTGCCCCTTATTT");
    private Chain vchain = new Chain("AACAGGTGCCCCTTATTT");
    @Test
    public void testAdd() {
        DataCollector collector;
        StartIterator iterator;
        StartIterator viterator;
        iterator = new StartIterator(chain, 2, 1);
        viterator = new StartIterator(chain, 2, 1);
        iterator.next();
        collector = new DataCollector();
        viterator.next();
        collector.add(viterator, 0);
        collector.add(iterator, 0);
        iterator.reset();
        iterator.next();
        collector.add(iterator, 0);
        iterator.next();
        collector.add(iterator, 0);


        iterator.next();
        iterator.next();
        iterator.next();
        PerformanceProfiler.start();
        collector.add(iterator, 0);
        PerformanceProfiler.end();
        iterator.reset();
        for (int index = 0; index < collector.size(); index++){
            System.out.println(collector.positions(iterator.next()));
        }
        System.out.println(PerformanceProfiler.result());
    }

    @Test
    public void testSize() {

    }

    @Test
    public void testPositions() {

    }
}
