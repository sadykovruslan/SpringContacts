package org.example;

import org.example.models.Contact;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NamedJdbcContactOperations implements ContactOperations {

    private final NamedParameterJdbcTemplate namedJdbcTemplate;

    public NamedJdbcContactOperations(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedJdbcTemplate = namedParameterJdbcTemplate;
    }


    @Override
    public List<Contact> getAllContacts() {
        return namedJdbcTemplate.query("SELECT ID, NAME FROM CONTACT",
                (rs, i) -> new Contact(
                        rs.getString("NAME"),
                        rs.getString("SURNAME"),
                        rs.getString("PHONE"),
                        rs.getString("MAIL")
                )
        );
    }

    @Override
    public Contact getContact(String id) {
        return namedJdbcTemplate.queryForObject("SELECT ID FROM CONTACT WHERE ID= :id",
                new MapSqlParameterSource("id", id),
                (rs, i) -> new Contact(
                        rs.getString("NAME"),
                        rs.getString("SURNAME"),
                        rs.getString("PHONE"),
                        rs.getString("MAIL")
                )
        );
    }

    @Override
    public Contact addContact(String name, String surname, String phone, String mail) {
        namedJdbcTemplate.update("INSERT INTO CONTACT (NAME, SURNAME, PHONE, MAIL) VALUES (:name, :surname, :phone, :mail)",
        new MapSqlParameterSource()
                .addValue("name", name)
                .addValue("surname", surname)
                .addValue("phone", phone)
                .addValue("mail", mail)
                );
        return new Contact(name, surname, phone, mail);
    }

    @Override
    public void changeContacts(String id, String name, String surname, String phone, String mail) {
        namedJdbcTemplate.update(
                "UPDATE CONTACT SET NAME, SURNAME, PHONE, MAIL = :NAME, :SURNAME, :PHONE, :MAIL WHERE ID = :id",
                new MapSqlParameterSource()
                        .addValue("id", id)
                        .addValue("name", name)
                        .addValue("surname", surname)
                        .addValue("phone", phone)
                        .addValue("mail", mail)
                );
    }
}
