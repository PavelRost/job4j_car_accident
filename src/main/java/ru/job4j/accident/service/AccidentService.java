package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.*;
import ru.job4j.accident.repository.*;
import java.util.ArrayList;
import java.util.List;


@Service
public class AccidentService {

    private final AccidentRepository accidentsRep;
    private final TypeRepository typeRep;
    private final RuleRepository ruleRep;
    private final UserRepository users;
    private final AuthorityRepository authorities;

    public AccidentService(AccidentRepository accidentsRep,
                           TypeRepository typeRep,
                           RuleRepository ruleRep,
                           UserRepository users,
                           AuthorityRepository authorities) {
        this.accidentsRep = accidentsRep;
        this.typeRep = typeRep;
        this.ruleRep = ruleRep;
        this.users = users;
        this.authorities = authorities;
    }

    public Authority findByAuthority(String authority) {
        return authorities.findByAuthority(authority);
    }

    public void save(User user) {
        users.save(user);

    }

    public List<Accident> getAllAccidentRep() {
        List<Accident> res = new ArrayList<>();
        accidentsRep.findAll().forEach(res::add);
        return res;
    }

    public List<AccidentType> getAllAccidentTypeRep() {
        List<AccidentType> res = new ArrayList<>();
        typeRep.findAll().forEach(res::add);
        return res;
    }

    public List<Rule> getAllRulesRep() {
        List<Rule> res = new ArrayList<>();
        ruleRep.findAll().forEach(res::add);
        return res;
    }

    public void addRep(Accident accident, String[] ids) {
         List<Rule> rules = getAllRulesRep();
         for (String id : ids) {
             accident.addRule(rules.get(Integer.parseInt(id) - 1));
         }
        List<AccidentType> types = getAllAccidentTypeRep();
        accident.setType(types.get(accident.getType().getId() - 1));
        accidentsRep.save(accident);
    }

    public Accident findByIdRep(int id) {
        return accidentsRep.findById(id).get();
    }

    public void updateAccidentRep(int id, Accident accident) {
        accidentsRep.updateAccidentRep(accident.getName(), accident.getText(), accident.getAddress(), id);
    }



    /**
     *     public List<Accident> getAllAccidentsHbn() {
     *         return accidentHibernate.getAllAccidents();
     *     }
     *
     *     public List<AccidentType> getAllAccidentTypeHbn() {
     *         return accidentHibernate.getAllAccidentType();
     *     }
     *
     *     public List<Rule> getAllRulesHbn() {
     *         return accidentHibernate.getAllRules();
     *     }
     *
     *     public void addHbn(Accident accident, String[] ids) {
     *         accidentHibernate.add(accident, ids);
     *     }
     *
     *     public Accident findByIdHbn(int id) {
     *         return accidentHibernate.findById(id);
     *     }
     *
     *     public void updateAccidentHbn(int id, Accident accident) {
     *         accidentHibernate.updateAccident(id, accident);
     *     }
     *
     *     public Collection<Accident> getAllAccidents() {
     *         return accidentMem.getAllAccidents();
     *     }
     *
     *     public Collection<AccidentType> getAllAccidentType() {
     *         return accidentMem.getAllAccidentType();
     *     }
     *
     *     public Collection<Rule> getAllRules() {
     *         return accidentMem.getAllRules();
     *     }
     *
     *     public void add(Accident accident, String[] ids) {
     *         accidentMem.add(accident, ids);
     *     }
     *
     *     public Accident findById(int id) {
     *         return accidentMem.findById(id);
     *     }
     *
     *     public void updateAccident(int id, Accident accident) {
     *         accidentMem.updateAccident(id, accident);
     *     }
     */


}
