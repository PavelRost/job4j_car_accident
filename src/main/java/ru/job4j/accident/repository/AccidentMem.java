package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


@Repository
public class AccidentMem {

    private final HashMap<Integer, Accident> accidents = new HashMap<>();

    private final HashMap<Integer, AccidentType> types = new HashMap<>();

    private final HashMap<Integer, Rule> rules = new HashMap<>();

    private AtomicInteger id = new AtomicInteger(1);

    public AccidentMem() {
        accidents.putIfAbsent(id.getAndAdd(1), new Accident(1, "Oleg", "Превышение скорости", "Москва"));
        accidents.putIfAbsent(id.getAndAdd(1), new Accident(2, "Alex", "Пьяный был", "Вологда"));
        types.putIfAbsent(1, AccidentType.of(1, "Две машины"));
        types.putIfAbsent(2, AccidentType.of(2, "Машина и человек"));
        types.putIfAbsent(3, AccidentType.of(3, "Машина и велосипед"));
        rules.putIfAbsent(1, Rule.of(1, "Статья. 1"));
        rules.putIfAbsent(2, Rule.of(1, "Статья. 2"));
        rules.putIfAbsent(3, Rule.of(1, "Статья. 3"));
    }

    public Collection<Accident> getAllAccidents() {
        return accidents.values();
    }

    public Collection<AccidentType> getAllAccidentType() {
        return types.values();
    }

    public Collection<Rule> getAllRules() {
        return rules.values();
    }

    public void add(Accident accident) {
        accident.setType(types.get(accident.getType().getId()));
        accident.setId(id.get());
        accidents.putIfAbsent(id.getAndAdd(1), accident);
    }

    public Accident findById(int id) {
        return accidents.get(id);
    }

    public void updateAccident(int id, Accident accident) {
        accidents.replace(id, accident);
    }
}

