package model;

import base.collectors.Alphabet;
import base.Formalism;
import base.Parameter;
import base.sequencies.Chain;
import model.criterion.Criterion;
import model.criterion.CriterionFactory;
import model.io.BuilderResultData;
import model.io.ResultDataCreator;
import model.seeker.WordExtractorFactory;
import model.seeker.WordExtractor;
import model.threshold.ThresholdFactory;
import model.threshold.ThresholdVariator;

import java.util.LinkedList;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 18.10.2011
 * Time: 13:35:45
 * To change this template use File | Settings | File Templates.
 */

/**
 * The base algorithm has a model of segmentation
 * based on the difference between actual and expected frequency of occurrence of subwords
 */
public class AlgorithmBase extends Algorithm {
    private Chain chain;
    private Alphabet alphabet;
    private ThresholdVariator threshold;
    private WordExtractor extractor;
    private Criterion criterion;
    private int balance;
    private int windowLen;
    private int windowDec;

    {
        formalismType = Formalism.ALGORITHM_BASE;
    }


    public AlgorithmBase(Input parameters) {
        super(parameters);
        threshold = ThresholdFactory.make(parameters.getThresholdMethod(), parameters);
        criterion = CriterionFactory.make(parameters.getStopCriterion(), threshold, parameters);
        extractor = WordExtractorFactory.getSeeker(parameters.getSeeker());
        balance = parameters.getBalance();
        windowLen = parameters.getWindowlength();
        windowDec = parameters.getWindowdec();
    }

    @Override
    public void slot() {
        SimpleChainSplitter chainConvolutor = null;
        ContentValues params = new ContentValues();
        params.put(Formalism.SEQUENCE, chain = new Chain(inputs.getFirst().getChain(), inputs.getFirst().getChainName()));
        params.put(Formalism.ALPHABET, alphabet = new Alphabet(chain));

        while (criterion.state(chain, alphabet)) {
            System.out.println("Threshold distance" + threshold.distance());
            updateParams(params, threshold.next(criterion));
            chainConvolutor = new SimpleChainSplitter(extractor);
            chain = chainConvolutor.cut(params);
            alphabet = chainConvolutor.getAlphabet();
        }
        chain.updateUniforms();
    }

    private void updateParams(ContentValues params, double nextThreshold) {
        params.put(Formalism.SEQUENCE, chain = new Chain(inputs.getFirst().getChain(), inputs.getFirst().getChainName()));
        chain.setName(inputs.getFirst().getChainName());
        params.put(Parameter.BALANCE, balance);
        params.put(Parameter.WINDOW, windowLen);
        params.put(Parameter.WINDOW_DECREMENT, windowDec);
        params.put(Parameter.CURRENT_THRESHOLD, nextThreshold);
    }

    @Override
    public LinkedList<MainOutputData> upload() {
        BuilderResultData builderResultData = new BuilderResultData(chain, alphabet);
        MainOutputData resultUpdate = builderResultData.create();
        resultUpdate.addInfo(criterion, criterion.getValue());
        resultUpdate.addInfo(threshold, threshold.getValue());
        ResultDataCreator.saveToFile(resultUpdate);

        results.add(resultUpdate);
        return results;
    }

    public String getName() {
        return formalismType.getName();
    }
}
