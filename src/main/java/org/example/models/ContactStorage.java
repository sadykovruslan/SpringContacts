package org.example.models;

import java.util.HashMap;
import java.util.Map;

public class ContactStorage {
    private static Map<String, Contact> contactMap = new HashMap<>();

    static {
        contactMap.put("1", new Contact("Ivan", "Ivanov", "99998888","1@dsd.ru"));
        contactMap.put("2", new Contact("Ilya", "Petrov", "123456789","2@dsd.ru"));
        contactMap.put("3", new Contact("Egor", "Sidorov", "987654321","3@dsd.ru"));
        contactMap.put("4", new Contact("Artur", "Sergeev", "789132456","14dsd.ru"));
    }

    public static Map<String, Contact> getContacts(){
        return contactMap;
    }
}
