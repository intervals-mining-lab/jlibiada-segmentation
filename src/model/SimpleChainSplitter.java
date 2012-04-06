package model;

import base.collectors.Alphabet;
import base.Formalism;
import base.Parameter;
import base.sequencies.Chain;
import extended.Helper;
import model.seeker.WordExtractorFactory;
import model.seeker.WordExtractor;

import java.util.ArrayList;

import static java.util.Collections.reverse;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 18.10.2011
 * Time: 14:44:58
 * To change this template use File | Settings | File Templates.
 */

/**
 * This class cuts and convoluts all occurences of the found word
 */
public final class SimpleChainSplitter extends ChainSplitter {
    private WordExtractor extractor;

    public SimpleChainSplitter(WordExtractor extractor) {
        this.extractor = extractor;
    }

    /**
     * @param params current parameters for segmentation
     * @return a convoluted chain
     */
    public final Chain cut(ContentValues params) {
        final int maxWindowLen = (Integer) params.get(Parameter.WINDOW);
        final int windowDec = (Integer) params.get(Parameter.WINDOW_DECREMENT);
        boolean flag = true;
        WordEntry pair = null;

        convoluted = ((Chain) params.get(Formalism.SEQUENCE));
        alphabet = new Alphabet();

        for (int winLen = maxWindowLen; (winLen >= windowDec) && (winLen > 1); winLen -= windowDec) {
            flag = true;
            while (flag) {
                updateParams(params, winLen);
                pair = WordExtractorFactory.getSeeker(extractor).find(params);
                flag = pair != null;
                if (flag) {
                    reverse(pair.getValue());
                    for (Integer position : pair.getValue()) convoluted.join(position, winLen);
                    convoluted.updateUniforms();
                    alphabet.add(Helper.toString(pair.getKey()), pair.getValue());
                }
            }
        }
        findLastWords();

        return convoluted;
    }

    private void updateParams(ContentValues params, int winLen) {
        params.put(Formalism.SEQUENCE, convoluted);
        params.put(Formalism.ALPHABET, alphabet);
        params.put(Parameter.WINDOW, winLen);
    }

    private void findLastWords() {
        String letter;
        for (int index = 0; index < convoluted.length(); index++) {
            if ((letter = convoluted.elementAt(index)).length() == 1) {
                if (!alphabet.contains(letter)) alphabet.add(letter, new ArrayList<Integer>());
                this.alphabet.get(letter).add(index);
            }
        }

    }


}
