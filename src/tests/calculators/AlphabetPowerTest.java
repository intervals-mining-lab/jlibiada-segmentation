package tests.calculators;

import base.collectors.Alphabet;
import base.Characteristic;
import base.sequencies.Chain;
import base.sequencies.UniformChain;
import calculators.Calculator;
import calculators.CharacteristicsFactory;
import junit.framework.TestCase;
import org.junit.Test;
import tools.PerformanceProfiler;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 11.10.2011
 * Time: 15:47:14
 * To change this template use File | Settings | File Templates.
 */
public class AlphabetPowerTest extends TestCase {
    private Chain chain = new Chain("AACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAGGTGAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTTAACAGGTGCCCCTT");
    private UniformChain uchain;
    private static long ts, te;

    @Test
    public void testCalculate1() {
        double power;
        Alphabet alphabet;
        alphabet = new Alphabet();
        PerformanceProfiler.start();
        power = alphabet.power(chain);
        PerformanceProfiler.end();
      /*  System.out.println("Power = "+  power);
        System.out.println(PerformanceProfiler.result());*/
        ts = System.nanoTime();
        Calculator.calculate(CharacteristicsFactory.get(Characteristic.ALPHABET_POWER), chain);
        te = System.nanoTime();
//        System.out.println((te - ts)/1e6);
        assertTrue(Alphabet.power(chain) == power);
    }

    @Test
    public void testCalculate2() {
        int power = 1;
        uchain = chain.getUniformChain(0);
        assertTrue(Alphabet.power(uchain) == power);
    }
}