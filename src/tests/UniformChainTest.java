package tests;

import org.junit.Test;
import base.sequencies.Chain;
import base.sequencies.UniformChain;
import junit.framework.TestCase;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 03.09.2011
 * Time: 21:13:45
 * To change this template use File | Settings | File Templates.
 */
public class UniformChainTest extends TestCase {
    private Chain chain = new Chain("AACAGGTGCCCCTTATTT");
    private UniformChain uniformA = new UniformChain("AA-A----------A---", "A");
    private UniformChain uniformG = new UniformChain("----GG-G----------", "G");
    private UniformChain uniformC = new UniformChain("--C-----CCCC------", "C");
    private UniformChain uniformT = new UniformChain("------T-----TT-TTT", "T");


    @Test
    public void testClone() {
       UniformChain uniformA,
               uniformG,
               uniformC,
               uniformT;
        uniformA = (UniformChain)this.uniformA.clone();
        uniformG = (UniformChain)this.uniformG.clone();
        uniformC = (UniformChain)this.uniformC.clone();
        uniformT = (UniformChain)this.uniformT.clone();
        asserts(uniformA, uniformG, uniformC, uniformT);

    }

    @Test
    public void testEquals() {
         UniformChain uniformA,
                uniformG,
                uniformC,
                uniformT;
        String b1 = "A", b2 = "G", b3 = "C", b4 = "T";
        uniformA = new UniformChain(chain, b1);
        uniformG = new UniformChain(chain, b2);
        uniformC = new UniformChain(chain, b3);
        uniformT = new UniformChain(chain, b4);
        asserts(uniformA, uniformG, uniformC, uniformT);
    }

    private void asserts(UniformChain uniformA, UniformChain uniformG, UniformChain uniformC, UniformChain uniformT) {
        assertTrue(uniformA.equals(this.uniformA));
        assertTrue(uniformG.equals(this.uniformG));
        assertTrue(uniformC.equals(this.uniformC));
        assertTrue(uniformT.equals(this.uniformT));
    }
}
