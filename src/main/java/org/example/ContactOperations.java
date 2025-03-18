package org.example;
import org.example.models.Contact;
import java.util.List;

public interface ContactOperations {

    List<Contact> getAllContacts();
    Contact getContact(String id);
    Contact addContact(String name,String surname,String phoneNumber, String mail);
    void changeContacts(String id, String name,String surname,String phoneNumber, String mail);
}
