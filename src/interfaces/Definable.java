package interfaces;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 26.10.2011
 * Time: 15:30:19
 * To change this template use File | Settings | File Templates.
 */

/**
 * Provides the best found value
 */
public interface Definable extends Identifiable{
    /**
     * Returns the best value for this case
     *
     * @return the best value for this case
     */
    double getValue();
}
