package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import java.util.HashMap;
import java.util.Map;

@Repository
public class AccidentMem {

    private final HashMap<Integer, Accident> accidents = new HashMap<>();
    {
        accidents.putIfAbsent(1, new Accident(1, "Oleg", "Превышение скорости", "Москва"));
        accidents.putIfAbsent(2, new Accident(2, "Alex", "Пьяный был", "Вологда"));
    }


    public AccidentMem() {
    }

    private static final class Lazy {
        private static final AccidentMem INST = new AccidentMem();
    }

    public static AccidentMem instOf() {
        return Lazy.INST;
    }

    public HashMap<Integer, Accident> getAccidents() {
        return new HashMap<>(accidents);
    }
}

