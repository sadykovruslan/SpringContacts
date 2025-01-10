package org.example;

public interface PersonOperations {

    void getAllContacts();
    Contact getContact(long contactId);
    void addContact(String name, String phone, String email);
    Contact correctCurrentContact(long contactId, String name, String phone, String email);
}
