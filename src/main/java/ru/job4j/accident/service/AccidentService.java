package ru.job4j.accident.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.AccidentJdbcTemplate;
import ru.job4j.accident.repository.AccidentMem;
import java.util.Collection;
import java.util.List;


@Service
public class AccidentService {

    private final AccidentMem accidentMem;
    private final AccidentJdbcTemplate accidents;


    public AccidentService(AccidentMem accidentMem, AccidentJdbcTemplate accidents) {
        this.accidentMem = accidentMem;
        this.accidents = accidents;
    }

    public List<Accident> getAllAccidentsJDBC() {
        return accidents.getAll();
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
