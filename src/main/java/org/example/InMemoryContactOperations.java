package org.example;

import java.util.HashMap;
import java.util.Map;

public class InMemoryPersonOperations implements PersonOperations {

    private long contactId = 1L;
    private final Map <Long, Contact> contactMap;

    public InMemoryPersonOperations() {
        this.contactMap = new HashMap<>();
    }

    @Override
    public void getAllContacts() {
        for (int i = 0; i < contactMap.size(); i++){
            System.out.println(contactMap.get(i));
        }
    }

    @Override
    public Contact getContact(long contactId) {
        return  contactMap.get(contactId);
    }

    @Override
    public void addContact(String name, String phone, String email) {
        Contact contact = new Contact(name, phone, email);
        contactMap.put(contactId++, contact);

    }

    @Override
    public Contact correctCurrentContact(long contactId, String name, String phone, String email) {
        Contact newContact = new Contact(name, phone, email);
        contactMap.put(contactId, newContact);
        return new Contact(name, phone, email);
    }
}
