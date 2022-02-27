package ru.job4j.accident.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentMem;
import java.util.Collection;


@Service
public class AccidentService {

    @Autowired
    private AccidentMem accidentMem;

    public AccidentService() {
    }

    public Collection<Accident> getAllAccidents() {
        return accidentMem.getAllAccidents();
    }
}
