package org.example;

import org.example.models.Contact;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

@Primary
@Repository
public class JdbcContactOperations implements ContactOperations{

    private static final String GET_ALL_CONTACTS_SQL = "" +
            "SELECT " +
            "   ID," +
            "   AMOUNT " +
            "FROM ACCOUNT";

    private static final String GET_CONTACT_SQL = "" +
            "SELECT" +
            "   ID, " +
            "FROM ACCOUNT " +
            "WHERE ID = ?";

    private static final String CREATE_CONTACT_SQL = "" +
            "INSERT INTO CONTACT (NAME, SURNAME, PHONE, MAIL)" +
            "VALUES(?,?,?,?)";

    private static final String SET_CONTACT_SQL = "" +
            "UPDATE CONTACT " +
            "SET NAME, SURNAME, PHONE, MAIL " +
            "WHERE ID = ?";

    private static final RowMapper <Contact> CONTACT_ROW_MAPPER =
            (rs, i) -> new Contact (rs.getString("name"),
                    rs.getString("surname"),
                    rs.getString("phone"),
                    rs.getString("mail"));

    private final JdbcTemplate jdbcTemplate;

    public JdbcContactOperations(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Contact> getAllContacts() {
        return jdbcTemplate.query(GET_ALL_CONTACTS_SQL, CONTACT_ROW_MAPPER);
    }

        @Override
    public Contact getContact(String id) {
        return jdbcTemplate.queryForObject(GET_CONTACT_SQL, CONTACT_ROW_MAPPER, id);
    }

    @Override
    public Contact addContact(String name, String surname, String phone, String mail) {
        jdbcTemplate.update(
                "INSERT INTO CONTACT (NAME, SURNAME, PHONE, NAME) VALUES(?, ?, ?, ?)",  name, surname, phone, mail);
        return new Contact(name, surname, phone,mail);
    }

    @Override
    public void changeContacts(String id, String name, String surname, String phone, String mail) {
        jdbcTemplate.update(SET_CONTACT_SQL, name, surname, phone, mail);
    }
}