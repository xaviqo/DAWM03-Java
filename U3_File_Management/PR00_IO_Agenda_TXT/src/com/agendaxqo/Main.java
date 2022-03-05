package com.agendaxqo;

import com.agendaxqo.dao.ContactDAO;
import com.agendaxqo.generators.Generator;
import com.agendaxqo.model.Contact;
import com.agendaxqo.utilconsole.UtilConsole;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    // CFG //
    private static String dir = "/src/com/agendaxqo/db/";
    private static String file = "agenda";

    static ContactDAO contactDAO = daoCfg();

    public static void main(String[] args) {

        if (!contactDAO.load()) {
            System.out.println();
            System.err.println("An error ocurred loading " + contactDAO.contactFile);
            System.err.println("Is " + contactDAO.contactFile + " in the correct folder?");
            System.err.println(contactDAO.dir);
        }

        System.out.println("TXT-Agenda by Xavi Quiñones");
        System.out.println();

        do {

            System.out.println("1 - Insert contact");
            System.out.println("2 - List all contacts");
            System.out.println("3 - Find contact");
            System.out.println("4 - Delete contact");
            System.out.println("? - h1dd3n 0p710n");
            System.out.println("0 - Close agenda");

            System.out.print("Input: ");

        } while (userOption());

        System.exit(0);

    }

    private static boolean userOption() {

        boolean continueLoop = true;

        try {
            switch (UtilConsole.inputInt()) {
                case 1:
                    if (createContact()) {
                        System.out.println("Contact created");
                    } else {
                        System.out.println("Error creating contact");
                    }
                    break;
                case 2:
                    if (contactDAO.size() < 1) {
                        System.out.println("Your agenda is empty!");
                        break;
                    }
                    showAllContacts();
                    break;
                case 3:
                    int contactsAmount = findContacts();
                    if (contactsAmount == 0) {
                        System.out.println("Contact not found");
                        break;
                    }
                    if (contactsAmount > 1) {
                        System.out.println("You have " + contactsAmount + " with the same name");
                    }
                    break;
                case 4:
                    Boolean success = deleteContact();
                    if (success) {
                        System.out.println("Contact succesfully deleted");
                    } else if (!success) {
                        System.out.println("Contact not found!");
                    }
                    break;
                case 1337:
                    System.out.print("Generate random contacts (amount): ");
                    generateRandomContacts(UtilConsole.inputInt());
                    break;
                case 0:
                    continueLoop = false;
                    break;
                default:
                    userOption();
                    break;
            }
        } catch (Exception e) {

        }

        return continueLoop;

    }

    private static boolean createContact() {

        Contact contact = new Contact();

        System.out.print("Name: ");
        contact.setName(UtilConsole.inputString());
        do {
            System.out.print("Phone: ");
            contact.setPhone(UtilConsole.inputString());
        } while ((contactDAO.exists(contact.getPhone())) != null);
        System.out.print("City: ");
        contact.setCity(UtilConsole.inputString());
        contact.setMobile(UtilConsole.yesOrNo("It's a mobile number?"));

        return contactDAO.save(contact);

    }

    private static void showAllContacts() {

        int option = 0;
        int count = 0;
        String contactType = "";

        do {

            System.out.println("[1] - All contacts | [2] - Mobile contacts | [3] - Landline contacts");
            System.out.print("Input: ");

            switch (option = UtilConsole.inputInt()) {
                case 2:
                    contactType = " mobile";
                    break;
                case 3:
                    contactType = " landline";
                    break;
            }

        } while (option < 0 || option > 3);


        for (Contact contact : contactDAO.allContacts().values()) {
            if (option == 2) {
                if (contact.isMobile()) {
                    System.out.println(contact);
                    count++;
                }
            } else if (option == 3) {
                if (!contact.isMobile()) {
                    System.out.println(contact);
                    count++;
                }
            } else {
                System.out.println(contact);
                count++;
            }
        }

        System.out.println("You have a total of " + count + contactType + " contacts in your agenda");

    }

    private static int findContacts() {


        int findBy = findBy();

        System.out.print("Input: ");
        return contactDAO.show(findBy, UtilConsole.inputString());

    }

    private static int findBy() {

        int findBy = 0;

        do {
            System.out.print("[1] - By name [2] - By phone: ");
            findBy = UtilConsole.inputInt();
        } while (findBy > 2 || findBy < 1);

        return findBy;
    }

    private static Boolean deleteContact() {


        System.out.println("Type '0' to leave");
        System.out.println("Type 'find' if you don't know the phone number");
        System.out.print("Input phone number: ");
        String userInput = UtilConsole.inputString();

        if (userInput.equalsIgnoreCase("FIND")) {
            findContacts();
            System.out.println();
            deleteContact();
        } else if (userInput.equals("0")) return null;

        return contactDAO.delete(userInput);

    }

    private static ContactDAO daoCfg() {

        ContactDAO contactDAO;

        try {
            return contactDAO = new ContactDAO(System.getProperty("user.dir") + dir, file + ".txt");
        } catch (FileNotFoundException fnfe) {
            System.out.println("Directory or file name is not correct");
            System.err.println(fnfe);
        } catch (IOException ioe) {
            System.out.println("Input/Output error. Probablly a file-system permissions error");
            System.err.println(ioe);
        }
        return null;

    }

    private static void generateRandomContacts(int amount) {

        for (int i = 0; i < amount; i++) {
            contactDAO.save(Generator.generateContact());
        }


    }

}
