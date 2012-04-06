package base;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 15.12.2011
 * Time: 13:26:02
 * To change this template use File | Settings | File Templates.
 */

import interfaces.Identifiable;

/**
 * An interval type.
 */
public enum IntervalType implements Identifiable {
    SIMPLE("Интервалы по словам"), DEEP("Интервалы по буквам");

    private String name;

    IntervalType(String s) {
        this.name = s;
    }

    @Override
    public String getName() {
        return name;
    }
}
