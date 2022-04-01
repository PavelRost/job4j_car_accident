package ru.job4j.accident.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;

import java.util.Collection;
import java.util.List;

/**
 * @Repository
 */
public class AccidentJdbcTemplate {

    private final JdbcTemplate jdbc;

    public AccidentJdbcTemplate(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Accident saveAccident(Accident accident) {
        jdbc.update("insert into accident (name) values (?)",
                accident.getName());
        return accident;
    }

    public List<Accident> getAllAccidents() {
        return jdbc.query("select id, name from accident",
                (rs, row) -> {
                    Accident accident = new Accident();
                    accident.setId(rs.getInt("id"));
                    accident.setName(rs.getString("name"));
                    return accident;
                });
    }

    public void updateAccident(int id, Accident accident) {
        jdbc.update(
                "update accident set name = ?, text = ?, address = ? where id = ?",
                accident.getName(),
                accident.getText(),
                accident.getAddress(),
                id
        );
    }

    public Accident findByIdAccident(int id) {
        return jdbc.queryForObject(
                "select name, text, address from accident where id = ?",
                (rs, rowNum) -> {
                    Accident accident = new Accident();
                    accident.setName(rs.getString("name"));
                    accident.setText(rs.getString("text"));
                    accident.setAddress(rs.getString("address"));
                    return accident;
                });
    }

    public List<AccidentType> getAllAccidentType() {
        return jdbc.query("select id, name from accident_type",
                (rs, row) -> {
                    AccidentType accidentType = new AccidentType();
                    accidentType.setId(rs.getInt("id"));
                    accidentType.setName(rs.getString("name"));
                    return accidentType;
                });
    }

    public List<Rule> getAllRules() {
        return jdbc.query("select id, name from accident_rules",
                (rs, row) -> {
                    Rule rule = new Rule();
                    rule.setId(rs.getInt("id"));
                    rule.setName(rs.getString("name"));
                    return rule;
                });
    }
}
