package base;

import interfaces.Identifiable;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 28.02.12
 * Time: 10:25
 * To change this template use File | Settings | File Templates.
 */
public enum Formalism implements Identifiable {
    SEQUENCE("Цепь"),
    ALPHABET("Алфавит"),
    CRITERION_PARTIAL_ORLOV("Частичный критерий Орлова"),
    CRITERION_MIN_REGULARITY("Минимальная регулярность"),
    CRITERION_MIN_SYMMETRY_SHREDER("Минимум симметрии"),
    CRITERION_MIN_SYMMETRY_INTERVALS("Минимум симметрии по интервалам"),
    CRITERION_ATTITUDE_REMOTENESS("Отношение удаленностей"),
    CRITERION_EQUALITY_DEPTHS("Равенство глубин"),
    THRESHOLD_DICHOTOMIC_METHOD("Дихотомический закон изменения порога"),
    THRESHOLD_LINEAR_METHOD("Линейный закон изменения порога"),
    THRESHOLD_RANDOM_METHOD("Случайный закон изменения порога"),
    ALGORITHM_BASE("Базовый алгоритм сегментации"),
    ORDER("Строй цепи"),
    LABLE("Название"),
    CRITERION_GOLDEN_RATIO("Золотое сечение");

    private final String name;


    private Formalism(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}

