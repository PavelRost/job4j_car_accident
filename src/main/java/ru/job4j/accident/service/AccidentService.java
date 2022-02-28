package ru.job4j.accident.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.AccidentMem;
import java.util.Collection;


@Service
public class AccidentService {

    private final AccidentMem accidentMem;

    public AccidentService(AccidentMem accidentMem) {
        this.accidentMem = accidentMem;
    }

    public Collection<Accident> getAllAccidents() {
        return accidentMem.getAllAccidents();
    }

    public Collection<AccidentType> getAllAccidentType() {
        return accidentMem.getAllAccidentType();
    }

    public Collection<Rule> getAllRules() {
        return accidentMem.getAllRules();
    }

    public void add(Accident accident, String[] ids) {
        accidentMem.add(accident, ids);
    }

    public Accident findById(int id) {
        return accidentMem.findById(id);
    }

    public void updateAccident(int id, Accident accident) {
        accidentMem.updateAccident(id, accident);
    }
}
