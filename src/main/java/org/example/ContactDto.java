package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.models.Contact;

public class ContactDto {

    @JsonProperty("contactName")
    private final String contactName;

    @JsonProperty("contactSurname")
    private final String contactSurname;

    @JsonProperty("contactPhone")
    private final String contactPhone;

    @JsonProperty("contactMail")
    private final String contactMail;

    public ContactDto(Contact contact) {
        this.contactName = contact.getName();
        this.contactSurname = contact.getSurname();
        this.contactPhone = contact.getPhone();
        this.contactMail = contact.getMail();
    }

    public String getContactName(){
        return contactName;
    }

    public String getContactSurname() {
        return contactSurname;
    }

    public String getContactPhone(){
        return  contactPhone;
    }

    public String getContactMail(){
        return contactMail;
    }
}
