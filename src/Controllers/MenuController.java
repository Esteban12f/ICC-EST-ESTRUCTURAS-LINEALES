package Controllers;

import Views.ConsoleView;
import models.Contact;

public class MenuController {
    private ContactManager contactManager;
    private ConsoleView consoleView;

    

    public MenuController() {
        this.contactManager = new ContactManager();
        this.consoleView = new ConsoleView();
    }


    public void showMenu(){
        boolean exit = false;
        while (!exit) {
            consoleView.displayMenu();
            String opcion = consoleView.getInput("");
            switch (opcion) {
                case "1":
                    addContact();
                    break;
            
                case "2":
                    findContact();
                    break;

                case "3":
                    deleteContact();
                    break;

                case "4":
                    printList();
                    break;

                case "5":
                    exit = true;
                    consoleView.showMessage("Exiting .....");
                    break;
                    
                default:
                    consoleView.showMessage("Invalid option.");
                    break;
            }
        }
    }

    private void addContact (){
        String name = consoleView.getInput("Enter name: ");
        String phone = consoleView.getInput("Enter phone: ");
        Contact<String,String> contact = new Contact<String,String>(name, phone);
        contactManager.addContact(contact);
        consoleView.showMessage("Conctact added");
    }

    private void findContact(){

    }

    private void deleteContact(){

    }

    private void printList(){
        contactManager.prinyList();
    }

}