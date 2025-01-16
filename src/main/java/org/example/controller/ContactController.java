package org.example.controller;

import java.util.List;
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

//    @GetMapping("/all")
//    public List<ContactDto> getAllContacts() {
//        return contactFacade.getAllContacts();
//    }

    @GetMapping("/{id}")
    public ContactDto getContact(@PathVariable ("id") String id){
        return contactFacade.getContact(id);
    }

    @PostMapping("/add")
    public void addContact(@RequestParam ("name") String name,
                           @RequestParam ("surname") String surname,
                           @RequestParam ("phone") String phone,
                           @RequestParam ("mail") String mail){
        contactFacade.addContact(name, surname, phone, mail);
    }

    @PutMapping("/change/{id}")
    public void changeContact(@RequestParam ("id") String id,
                              @RequestParam ("name") String name,
                              @RequestParam ("surname") String surname,
                              @RequestParam ("phone") String phoneNumber,
                              @RequestParam ("mail") String mail){
        contactFacade.changeContact(id, name, surname, phoneNumber, mail);
    }
}