package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.AccidentHibernate;
import ru.job4j.accident.repository.AccidentMem;
import ru.job4j.accident.repository.AccidentRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
public class AccidentService {

    private final AccidentMem accidentMem;
    private final AccidentHibernate accidentHibernate;
    private final AccidentRepository accidentRepository;


    public AccidentService(AccidentMem accidentMem, AccidentHibernate accidentHibernate, AccidentRepository accidentRepository) {
        this.accidentMem = accidentMem;
        this.accidentHibernate = accidentHibernate;
        this.accidentRepository = accidentRepository;
    }

    public List<Accident> getAllAccidentsRep() {
        List<Accident> rsl = new ArrayList<>();
        accidentRepository.findAll().forEach(rsl::add);
        return rsl;
    }

    public List<AccidentType> getAllAccidentTypeRep() {
        return null;
    }

    public List<Rule> getAllRulesRep() {
        return null;
    }

    public void addRep(Accident accident, String[] ids) {
        accidentRepository.save(accident);
    }

    public Accident findByIdRep(int id) {
        return accidentRepository.findById(id).get();
    }

    public void updateAccidentRep(int id, Accident accident) {
        accidentRepository.updateAccidentRep(accident.getName(), accident.getText(), accident.getAddress(), id);
    }



    public List<Accident> getAllAccidentsHbn() {
        return accidentHibernate.getAllAccidents();
    }

    public List<AccidentType> getAllAccidentTypeHbn() {
        return accidentHibernate.getAllAccidentType();
    }

    public List<Rule> getAllRulesHbn() {
        return accidentHibernate.getAllRules();
    }

    public void addHbn(Accident accident, String[] ids) {
        accidentHibernate.add(accident, ids);
    }

    public Accident findByIdHbn(int id) {
        return accidentHibernate.findById(id);
    }

    public void updateAccidentHbn(int id, Accident accident) {
        accidentHibernate.updateAccident(id, accident);
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
