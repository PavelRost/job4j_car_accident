package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import java.util.Collection;
import java.util.HashMap;


@Repository
public class AccidentMem {

    private final HashMap<Integer, Accident> accidents = new HashMap<>();

    private int id = 0;

    public AccidentMem() {
        accidents.putIfAbsent(id++, new Accident(1, "Oleg", "Превышение скорости", "Москва"));
        accidents.putIfAbsent(id++, new Accident(2, "Alex", "Пьяный был", "Вологда"));
    }

    public Collection<Accident> getAllAccidents() {
        return accidents.values();
    }

    public void add(Accident accident) {
        accident.setId(id);
        accidents.putIfAbsent(id++, accident);
    }
}

