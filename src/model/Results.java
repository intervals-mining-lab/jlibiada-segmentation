package model;

import base.collectors.Alphabet;
import base.Characteristic;
import base.Formalism;
import base.sequencies.Chain;
import base.sequencies.Order;
import calculators.CharacteristicsFactory;
import interfaces.Definable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 16.10.2011
 * Time: 14:26:13
 * To change this template use File | Settings | File Templates.
 */

/**
 * Contains all possible calculated characteristics and chain's property
 */
public class Results {
    protected List<String> names;
    protected List<String> values;
    protected ContentValues objects;

    {
        names = new ArrayList<String>(20);
        values = new ArrayList<String>(20);
        objects = new ContentValues();
    }

    public Results(Chain chain) {
        add(Formalism.ORDER.getName(), (new Order(chain)).toString());
        add(Formalism.LABLE.getName(), chain.getName());
        add(Formalism.SEQUENCE.getName(), chain.toString("-"));
        add(Characteristic.ALPHABET_POWER.getName(), String.valueOf(CharacteristicsFactory.get(Characteristic.ALPHABET_POWER).calculate(chain)));
        add(Characteristic.CHAIN_LENGTH.getName(), String.valueOf(CharacteristicsFactory.get(Characteristic.CHAIN_LENGTH).calculate(chain)));
        add(Characteristic.GAMUT_SIMPLE.getName(), String.valueOf(CharacteristicsFactory.get(Characteristic.GAMUT_SIMPLE).calculate(chain)));
        add(Characteristic.NUMBER_FOR_LENGTH.getName(), String.valueOf(CharacteristicsFactory.get(Characteristic.NUMBER_FOR_LENGTH).calculate(chain)));
        objects.put(Formalism.ALPHABET, new Alphabet(chain));
    }
    private void add(String name, String value){
        names.add(name);
        values.add(value);
    }
    
    public Alphabet getAlphabet(){
        return (Alphabet) objects.get(Formalism.ALPHABET);
    }

    public void add(Definable best){
       add(best.getName(), String.valueOf(best.getValue()));
    }

    /**
     * Returns a resulted chain
     *
     * @return String implementation of the chain
     */
    public String getChain() {
        return values.get(names.indexOf(Formalism.SEQUENCE.getName()));
    }

    /**
     * Returns chain's name
     *
     * @return chain's name
     */
    public String getName() {
//        System.out.println(values.get(names.indexOf(NAME.getName())));
        return values.get(names.indexOf(Formalism.LABLE.getName()));
    }

    /**
     * Returns an order of the chain
     *
     * @return String type implementation of an order
     */
    public String getOrder() {
        return values.get(names.indexOf(Formalism.ORDER.getName()));
    }

    public String getValue(int index) {
        System.out.println(values.get(index));
        return values.get(index);
    }
    public String getName(int index) {
        System.out.println(names.get(index));
        return names.get(index);
    }

    public int size() {
        return values.size();
    }
}
