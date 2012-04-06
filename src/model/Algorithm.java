package model;

import base.Formalism;
import interfaces.Identifiable;

import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 05.10.2011
 * Time: 16:01:58
 * To change this template use File | Settings | File Templates.
 */

/**
 * Model of an algorithm which it will be executed.
 */
public class Algorithm extends Observable implements Identifiable, Runnable {
    protected LinkedList<MainOutputData> results;
    protected LinkedList<Input> inputs;
    protected Formalism formalismType;
    {
        inputs = new LinkedList<Input>();
        results = new LinkedList<MainOutputData>();
    }

    /**
     * Executes segmentation in a separate thread with notifying all observers
     */
    @Override
    public void run() {
        slot();
        setChanged();
        notifyObservers(results);
    }


    public Algorithm(List<Input> parameters) {
        inputs = new LinkedList<Input>(parameters);
    }

    public Algorithm(Input input) {
        inputs.add(input);
    }
    public Algorithm(){}

    public void add(List<Input> input){
        inputs.addAll(input);
    }

    /**
     * Execute segmentation
     */
    public void slot() {
        for (Input input : inputs) {
            Algorithm algorithm = AlgorithmFactory.make(input.getAlgorithm(), input);
            algorithm.slot();
            results.add(algorithm.upload().pop());
        }
    }

    /**
     * Returns characteristics of the chains and its
     *
     * @return list of characteristics
     */
    public LinkedList<MainOutputData> upload() {
        return results;
    }

    @Override
    public String getName() {
        return formalismType.getName();
    }
}
