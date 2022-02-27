package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;


@Repository
public class AccidentMem {

    private final HashMap<Integer, Accident> accidents = new HashMap<>();

    private final List<AccidentType> types = List.of(
            AccidentType.of(1, "Две машины"),
            AccidentType.of(2, "Машина и человек"),
            AccidentType.of(3, "Машина и велосипед"));


    private int id = 1;

    public AccidentMem() {
        accidents.putIfAbsent(id++, new Accident(1, "Oleg", "Превышение скорости", "Москва"));
        accidents.putIfAbsent(id++, new Accident(2, "Alex", "Пьяный был", "Вологда"));
    }

    public Collection<Accident> getAllAccidents() {
        return accidents.values();
    }

    public void add(Accident accident) {
        accident.setType(types.get(accident.getType().getId() - 1));
        accident.setId(id);
        accidents.putIfAbsent(id++, accident);
    }

    public Accident findById(int id) {
        return accidents.get(id);
    }

    public void updateAccident(int id, Accident accident) {
        accidents.replace(id, accident);
    }
}

