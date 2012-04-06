package base;

import interfaces.Identifiable;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 17.02.12
 * Time: 16:24
 * To change this template use File | Settings | File Templates.
 */

/**
 * Contains types calculated characteristics
 */
public enum Characteristic implements Identifiable {
    ARITHMETIC_AVERAGE_INTERAVAL("Средний арифметический интервал", 0),
    GEOMETRIC_AVERAGE_INTERAVAL("Средний геометрический интервал", 1),
    REMOTENESS("Удалённость", 2),
    IDENTIFICATION_INFORMATION("Число идентифицирующих информаций отдельного сообщения", 3),
    PERIODICITY("Периодичность", 4),
    REGULARITY("Регулярность", 5),
    PRACTICAL_VOLUME("Практический объем", 6),
    THEORETICAL_VOLUME("Теоритический объем", 7),
    PROBABILITY("Вероятность", 8),
    UNKNOWN("Unknown", 9),
    VOLUME("Объем", 10),
    WORD_AVERAGE_LENGTH("Средняя длина слова", 11),
    FREQUENCY("Частота", 12),
    EXPECTATION("Математическое ожидание", 13),
    STANDARD_DEVIATION("СКО", 14),
    ALPHABET_POWER("Мощность алфавита", 15),
    UNKNOWN_1("Минимум симметрии",16),
    UNKNOWN_2("Максимум диссимметрии", 17),
    GAMUT_DEEP("Глубина посимвольно", 18),
    GAMUT_SIMPLE("Глубина", 19),
    CHAIN_LENGTH("Длина цепи", 20),
    NUMBER_FOR_LENGTH("Количество слов заданной длины", 21),
    DESCRIPTIVE_INFORMATION("Число описательных информаций", 22);


    private final String name;
    private final int id;

    Characteristic(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    /**
     * Returns an unique value for the characteristic
     *
     * @return value
     */
    public int getId(){
        return id;
    }
}
