package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.models.Contact;

public class ContactDto {

    @JsonProperty("name")
    private final String name;

    @JsonProperty("surname")
    private final String surname;

    @JsonProperty("phone")
    private final String phone;

    @JsonProperty("mail")
    private final String mail;

    public ContactDto(Contact contact) {
        this.name = contact.getName();
        this.surname = contact.getSurname();
        this.phone = contact.getPhone();
        this.mail = contact.getMail();
    }

    public String getName(){
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone(){
        return phone;
    }

    public String getMail(){
        return mail;
    }
}
