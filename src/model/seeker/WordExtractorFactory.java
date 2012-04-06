package model.seeker;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 02.12.2011
 * Time: 16:50:31
 * To change this template use File | Settings | File Templates.
 */

/**
 * Creates a method for extracting a word in the chain based on a concrete rule
 */
public class WordExtractorFactory {
    public static final WordExtractor getSeeker(int index){
        switch(index){
            case 0: return new ProbabilityExtractor();
            case 1: return new DifferenceAverageIntervalExtractor();
            case 2: return null;
        }
        return null;
    }

    public static final WordExtractor getSeeker(WordExtractor object){
       if (object instanceof ProbabilityExtractor) return getSeeker(0);
       if (object instanceof DifferenceAverageIntervalExtractor) return getSeeker(1);
        return null;
    }
}
