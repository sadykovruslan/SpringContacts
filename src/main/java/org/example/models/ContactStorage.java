package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class ContactStorage {
    public static List<Contact> contacts = new ArrayList<>();

    static {
        contacts.add(1, new Contact("Ivan", "Ivanov", "99998888","1@dsd.ru"));
        contacts.add(2, new Contact("Ilya", "Petrov", "123456789","2@dsd.ru"));
        contacts.add(3, new Contact("Egor", "Sidorov", "987654321","3@dsd.ru"));
        contacts.add(4, new Contact("Artur", "Sergeev", "789132456","14dsd.ru"));
    }

//    public static List<Contact> getContacts(){
//        return contactMap;
//    }
}
