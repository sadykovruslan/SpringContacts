package org.example;

import org.example.models.Contact;
import org.example.models.ContactStorage;

public class InMemoryContactOperations implements ContactOperations {


    @Override
    public void getAllContacts() {
        for (int i = 0; i < ContactStorage.getContacts().size(); i++) {
            ContactStorage.getContacts().get(i);
        }
    }

    @Override
    public Contact getContact(int id) {
        return ContactStorage.getContacts().get(id);
    }

    @Override
    public void addContact(String name,String surname,String phone, String mail) {
        Contact contact = new Contact(name, surname, phone,mail);
        ContactStorage.getContacts().put(ContactStorage.getContacts().size()+1, contact); //добавляем в конец мапы. Поэтому ключ: size+1
    }

    @Override
    public void changeContacts(int id, String name, String surname, String phoneNumber, String mail) {
        Contact contact = new Contact(name, surname, phoneNumber,mail); //создаем новый контакт и перезаписываем его по тому же ключу
        ContactStorage.getContacts().put(id, contact);
    }
}
