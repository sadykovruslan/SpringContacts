package org.example.facade;

import org.example.ContactDto;
import org.example.ContactOperations;
import org.example.models.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactFacade {
    private final ContactOperations contactOperations;

    @Autowired
    public ContactFacade(ContactOperations contactOperations) {
        this.contactOperations = contactOperations;
    }

    public List<ContactDto> getAllContacts(){
        return contactOperations.getAllContacts().stream()
                .map(ContactDto::new)
                .toList();
    }

    public ContactDto getContact(String id){
        Contact contact = contactOperations.getContact(id);
        return new ContactDto(contact);
    }


    public ContactDto addContact(String name,String surname,String phone, String mail){
        Contact contact = contactOperations.addContact(name, surname, phone,mail);
        return new ContactDto(contact);
    }

    public void changeContact(String id, String name, String surname, String phoneNumber, String mail){
        contactOperations.changeContacts(id, name, surname, phoneNumber, mail);
    }
}
