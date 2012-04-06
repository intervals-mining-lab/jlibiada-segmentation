package base;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 05.10.2011
 * Time: 16:09:24
 * To change this template use File | Settings | File Templates.
 */

import interfaces.Identifiable;

/**
 * Contains input parameters
 */
public enum Parameter implements Identifiable {
    BALANCE("Коэффициент баланса", 0),
    PRECISION("Точность", 1),
    THRESHOLD_STEP("Шаг порога", 2),
    WINDOW("Начальная длина окна", 3),
    CURRENT_THRESHOLD("Порог", 4),
    WINDOW_DECREMENT("Декремент окна", 5),
    LEFT("Граница слева", 6),
    RIGHT("Граница справа", 7),
    CRITERION("Критерий останова", 8);

    private final String name;
    private final int id;

    Parameter(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    /**
     * Returns an unique value for the parameter
     *
     * @return value
     */
    public int getId() {
        return id;
    }

}
