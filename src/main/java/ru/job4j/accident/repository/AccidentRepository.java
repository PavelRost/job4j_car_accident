package ru.job4j.accident.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.accident.model.Accident;

public interface AccidentRepository extends CrudRepository<Accident, Integer> {

    @Transactional
    @Modifying
    @Query("update Accident a set a.name = ?1, a.text = ?2, a.address = ?3 where a.id = ?4")
    void updateAccidentRep(String name, String text, String address, int id);

}
