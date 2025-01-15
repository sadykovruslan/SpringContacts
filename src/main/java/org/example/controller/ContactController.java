package org.example.controller;

import org.example.ContactDto;
import org.example.facade.ContactFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private final ContactFacade contactFacade;

    @Autowired
    public ContactController(ContactFacade contactFacade) {
        this.contactFacade = contactFacade;
    }

    @GetMapping("/all")
    public void getAllContacts(){
        contactFacade.getAllContacts();
    }

    @GetMapping("/{id}")
    public ContactDto getContact(@PathVariable int id){
        return contactFacade.getContact(id);
    }

    @PostMapping("/add")
    public void addContact(String name,String surname,String phone, String mail){
        contactFacade.addContact(name, surname, phone, mail);
    }

    @PutMapping("/change/{id}")
    public void changeContact(int id, String name, String surname, String phoneNumber, String mail){
        contactFacade.changeContact(id, name, surname, phoneNumber, mail);
    }
}
