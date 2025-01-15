package org.example;

import org.example.models.Contact;

public interface ContactOperations {

    void getAllContacts();
    Contact getContact(int id);
    void addContact(String name,String surname,String phoneNumber, String mail);
    void changeContacts(int id, String name,String surname,String phoneNumber, String mail);
}
