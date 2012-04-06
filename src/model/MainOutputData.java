package model;

import base.collectors.Alphabet;
import base.sequencies.Chain;
import base.sequencies.Order;
import interfaces.Definable;
import interfaces.Identifiable;

import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 14.03.12
 * Time: 23:37
 * To change this template use File | Settings | File Templates.
 */

/**
 * The results of the experiment. Contains information about the I / O data.
 * The experimental results are expandable more information about the experiment
 */
public class MainOutputData {
    private Chain chain;
    private Alphabet alphabet;
    private Order order;
    private HashMap<String, String> parameters;

    {
        parameters = new HashMap<String, String>();
    }

    public String getChainName(){
        return chain.getName();
    }
    public Chain getChain() {
        return chain;
    }

    public void setChain(Chain chain) {
        this.chain = chain;
    }

    public Alphabet getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(Alphabet alphabet) {
        this.alphabet = alphabet;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public HashMap<String, String> getParameters() {
        return parameters;
    }

    /**
     * Allows you add an additional information about research
     *
     * @param what parameter name
     * @param value string value
     */
    public void addInfo(Identifiable what, Identifiable value){
        parameters.put(what.getName(), value.getName());
    }
    /**
     * Allows you add an additional information about research
     *
     * @param what parameter name
     * @param value digit value
     */
    public void addInfo(Identifiable what, Definable value){
        parameters.put(what.getName(), String.valueOf(value.getValue()));
    }

    /**
     * Allows you add an additional information about research
     *
     * @param what parameter name
     * @param value digit calculated value
     */
    public void addInfo(Identifiable what, Double value){
        parameters.put(what.getName(), String.valueOf(value));
    }
}
