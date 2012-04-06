package model.criterion;

import base.collectors.Alphabet;
import base.Formalism;
import base.sequencies.Chain;
import interfaces.Definable;
import interfaces.Verifiable;
import model.threshold.ThresholdVariator;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 05.10.2011
 * Time: 20:29:34
 * To change this template use File | Settings | File Templates.
 */

/**
 * The criterion of break. Defines the best mode of segmentation.
 * Allows you to handle how long will the process do something.
 */
public abstract class Criterion implements Definable, Verifiable {
    protected double precisionOfDifference;
    protected double lastDistortion;
    protected Alphabet alphabet;
    protected Chain chain;
    protected ThresholdVariator thresholdToStop;
    protected Formalism formalismType;
    /**
     * init
     *
     * @param threshold A rule for handle a threshold value
     * @param precision additional value to 
     */
    public Criterion(ThresholdVariator threshold, double precision) {
        this.thresholdToStop = threshold;
        this.precisionOfDifference = precision;
    }

    /**
     * Returns the state of criterion. True, if everithing is done, false - otherwise
     *
     * @param chain  chain
     * @param alphabet its alphabet
     * @return the state of criterion
     */
    public abstract boolean state(Chain chain, Alphabet alphabet);

    /**
     * Returns distortion between necessary and calculated value
     * For example between theoretical and practical values
     * @return distortion
     */
    public abstract double distortion(Chain chain, Alphabet alphabet);

    /**
     * Returns distortion between necessary and calculated value inside of criterion
     * For example between theoretical and practical values
     * @return distortion
     */
    public final double distortion(){
        return distortion(chain, alphabet);
    }
    /**
     * Updates data for computing a new value of the criterion
     *
     * @param chain a new chain
     * @param alphabet a new alphabet
     */
    public void renew(Chain chain, Alphabet alphabet) {
        this.chain = chain;
        this.alphabet = alphabet;
    }


    public final Chain getChain() {
        return chain;
    }

    public String getName(){
        return formalismType.getName();
    }

    public double getValue(){
        return lastDistortion;
    }
}
