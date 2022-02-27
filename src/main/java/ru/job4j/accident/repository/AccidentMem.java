package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import java.util.Collection;
import java.util.HashMap;


@Repository
public class AccidentMem {

    private final HashMap<Integer, Accident> accidents = new HashMap<>();

    public AccidentMem() {
        accidents.putIfAbsent(1, new Accident(1, "Oleg", "Превышение скорости", "Москва"));
        accidents.putIfAbsent(2, new Accident(2, "Alex", "Пьяный был", "Вологда"));
    }

    public Collection<Accident> getAllAccidents() {
        return accidents.values();
    }
}

