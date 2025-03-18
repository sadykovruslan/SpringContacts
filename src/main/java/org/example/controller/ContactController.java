package org.example.controller;

import java.util.List;
import org.example.ContactDto;
import org.example.facade.ContactFacade;
import org.example.models.ContactStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<ContactDto>> getAllContacts() {
        return new ResponseEntity<>(contactFacade.getAllContacts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ContactDto getContact(@PathVariable ("id") String id){
        return contactFacade.getContact(id);
    }

    @PostMapping("/add")
    public ContactDto addContact(@RequestParam ("name") String name,
                           @RequestParam ("surname") String surname,
                           @RequestParam ("phone") String phone,
                           @RequestParam ("mail") String mail){
        return contactFacade.addContact(name, surname, phone, mail);
    }

    @PutMapping("/change/{id}")
    public void changeContact(@PathVariable ("id") String id,
                              @RequestParam ("name") String name,
                              @RequestParam ("surname") String surname,
                              @RequestParam ("phone") String phoneNumber,
                              @RequestParam ("mail") String mail){
        contactFacade.changeContact(id, name, surname, phoneNumber, mail);
    }
}