package org.example;
import org.example.models.Contact;
import org.example.models.ContactStorage;
import java.util.List;


public class InMemoryContactOperations implements ContactOperations {

    @Override
    public List<Contact> getAllContacts() {
        return ContactStorage.contacts
        .stream()
        .toList();
    }

    @Override
    public Contact getContact(int id) {
        return ContactStorage.contacts.get(id);
    }

    @Override
    public void addContact(String name, String surname, String phone, String mail) {
        Contact contact = new Contact();
        contact.setName(name);
        contact.setSurname(surname);
        contact.setPhone(phone);
        contact.setMail(mail);

        ContactStorage.contacts.add(ContactStorage.contacts.size()+1, contact); //добавляем в конец мапы. Поэтому ключ: size+1
    }

    @Override
    public void changeContacts(int id, String name, String surname, String phone, String mail) {
        Contact contact = new Contact();
        contact.setName(name);
        contact.setSurname(surname);
        contact.setPhone(phone);
        contact.setMail(mail);
        ContactStorage.contacts.add(id, contact);
    }
}
