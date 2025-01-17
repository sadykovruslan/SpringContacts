package org.example;
import org.example.models.Contact;
import java.util.List;

public interface ContactOperations {

    List<Contact> getAllContacts();
    Contact getContact(int id);
    void addContact(String name,String surname,String phoneNumber, String mail);
    void changeContacts(int id, String name,String surname,String phoneNumber, String mail);
}
