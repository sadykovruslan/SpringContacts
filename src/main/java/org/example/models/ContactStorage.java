package org.example.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactStorage {
    public static Map<String, Contact> contacts = new HashMap();

    static {
        contacts.put("1", new Contact("Ivan", "Ivanov", "99998888","1@dsd.ru"));
        contacts.put("2", new Contact("Ilya", "Petrov", "123456789","2@dsd.ru"));
        contacts.put("3", new Contact("Egor", "Sidorov", "987654321","3@dsd.ru"));
        contacts.put("4", new Contact("Artur", "Sergeev", "789132456","14dsd.ru"));
    }

//    public static List<Contact> getContacts(){
//        return contactMap;
//    }
}
