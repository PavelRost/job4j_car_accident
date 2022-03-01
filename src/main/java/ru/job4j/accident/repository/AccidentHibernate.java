package ru.job4j.accident.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;

import java.util.Collection;
import java.util.List;

@Repository
public class AccidentHibernate {

    private final SessionFactory sf;

    public AccidentHibernate(SessionFactory sf) {
        this.sf = sf;
    }

    public List<Accident> getAllAccidents() {
        Session session = sf.openSession();
        session.beginTransaction();
        List<Accident> rsl = session.createQuery("from Accident").list();
        session.getTransaction().commit();
        session.close();
        return rsl;
    }

    public List<AccidentType> getAllAccidentType() {
        Session session = sf.openSession();
        session.beginTransaction();
        List<AccidentType> rsl = session.createQuery("from AccidentType").list();
        session.getTransaction().commit();
        session.close();
        return rsl;
    }

    public List<Rule> getAllRules() {
        Session session = sf.openSession();
        session.beginTransaction();
        List<Rule> rsl = session.createQuery("from Rule").list();
        session.getTransaction().commit();
        session.close();
        return rsl;
    }

    public void add(Accident accident, String[] ids) {
        Session session = sf.openSession();
        session.beginTransaction();
        List<Rule> rules = getAllRules();
        List<AccidentType> types = getAllAccidentType();
        for (String id : ids) {
            accident.addRule(rules.get(Integer.parseInt(id) - 1));
        }
        accident.setType(types.get(accident.getType().getId() - 1));
        session.save(accident);
        session.getTransaction().commit();
        session.close();
    }

    public Accident findById(int id) {
        Session session = sf.openSession();
        session.beginTransaction();
        Accident rsl = (Accident) session.createQuery("from Accident a where a.id = :paramId").setParameter("paramId", id).uniqueResult();
        session.getTransaction().commit();
        return rsl;
    }

    public void updateAccident(int id, Accident accident) {
        Session session = sf.openSession();
        session.beginTransaction();
        Query query = session.createQuery("update Accident a set a.name = :newName, a.text = :newText, a.address = :newAddress where a.id = :fId");
        query.setParameter("newName", accident.getName());
        query.setParameter("newText", accident.getText());
        query.setParameter("newAddress", accident.getAddress());
        query.setParameter("fId", id);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}
