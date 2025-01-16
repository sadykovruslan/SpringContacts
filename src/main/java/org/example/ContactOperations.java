package org.example;

import org.example.models.Contact;

public interface ContactOperations {

    void getAllContacts();
    Contact getContact(String id);
    void addContact(String name,String surname,String phoneNumber, String mail);
    void changeContacts(String id, String name,String surname,String phoneNumber, String mail);
}
