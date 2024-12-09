package Controllers;

import models.Contact;
import models.LinkedList;

public class ContactManager {
    private LinkedList<Contact<?,?>> contacts;

    

    public ContactManager() {
        this.contacts = new LinkedList<>();
    }

    public void addContact (Contact<?,?> contact){
        contacts.appendToTail(contact);
    }


    public Contact<?,?> findContactByName (String name){
        return null;
    }

    public void deleteContactByName (String name){

    }

    public void prinyList(){
        contacts.print();
    }
}
