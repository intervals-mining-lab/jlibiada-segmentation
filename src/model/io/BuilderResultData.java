package model.io;

import base.collectors.Alphabet;
import base.Characteristic;
import base.sequencies.Chain;
import base.sequencies.Order;
import calculators.Calculator;
import interfaces.CharacteristicList;
import model.MainOutputData;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 14.03.12
 * Time: 23:49
 * To change this template use File | Settings | File Templates.
 */

/**
 * An output data builder. Creates and build output data based on accepted characteristic
 * and any parameters list
 */
public class BuilderResultData extends ResultDataCreator {
    private Chain chain;
    private Alphabet alphabet;

    private CharacteristicList characteristicList;

    {
       characteristicList = StandardCharacteristicList.ALPHABET_POWER;
    }


    public BuilderResultData(Chain chain, Alphabet alphabet) {
        this.chain = chain;
        this.alphabet = alphabet;
    }

    public void setCharacteristicList(CharacteristicList characteristicList){
        this.characteristicList = characteristicList;
    }

    @Override
    public MainOutputData create() {
        MainOutputData result = new MainOutputData();
        result.setChain(chain);
        result.setAlphabet(alphabet);
        result.setOrder(new Order(chain));

        for (Characteristic characteristic: characteristicList.getCharacteristics()){
            result.addInfo(characteristic, Calculator.calculate(characteristic, chain));
        }

        return result;
    }

    /**
     * Structure for characteristic
     */
    public enum StandardCharacteristicList implements CharacteristicList {
        CHAIN_LENGTH(Characteristic.CHAIN_LENGTH),
        ALPHABET_POWER(Characteristic.ALPHABET_POWER),
        GAMUT_SIMPLE(Characteristic.GAMUT_SIMPLE),
        GAMUT_DEEP(Characteristic.GAMUT_DEEP),
        PERIODICITY(Characteristic.PERIODICITY),
        REGULARITY(Characteristic.REGULARITY),
        NUMBER_OF_ALONE(Characteristic.NUMBER_FOR_LENGTH),
        ARITHMETIC_AVG_INTERVAL(Characteristic.ARITHMETIC_AVERAGE_INTERAVAL),
        GEOMETRIC_AVG_INTERVAL(Characteristic.GEOMETRIC_AVERAGE_INTERAVAL),
        WORD_AVG_LENGTH(Characteristic.WORD_AVERAGE_LENGTH);

        private Characteristic characteristic;

        public Characteristic getValue() {
            return characteristic;
        }


        StandardCharacteristicList(Characteristic characteristic) {
            this.characteristic = characteristic;
        }


        @Override
        public Characteristic[] getCharacteristics() {
            Characteristic[] characteristics = new Characteristic[values().length];
            System.out.println(Arrays.toString(values()));
            int index = 0;
            for (StandardCharacteristicList e : values())
                characteristics[index++] = e.getValue();
            return characteristics;
        }
    }



}
