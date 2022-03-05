package com.agendaxqo.dao;

import com.agendaxqo.model.Contact;

import java.io.*;
import java.util.HashMap;

public class ContactDAO {

    private HashMap<String, Contact> contactMap;
    private File file;
    private FileReader fileReader;
    private BufferedReader bufferedReader;
    private FileWriter fileWriter;
    private PrintWriter printWriter;
    public String dir;
    public String contactFile;

    public ContactDAO(String dir, String contactFile) throws IOException {

        this.contactMap = new HashMap<>();
        this.dir = dir;
        this.contactFile = contactFile;
        this.file = new File(dir + contactFile);

    }

    public boolean save(Contact contact) {

        if (!contactMap.containsKey(contact.getPhone())) {
            contactMap.put(contact.getPhone(), contact);
            persist();
            return true;
        } else {
            return false;
        }

    }

    public boolean delete(String phoneNumber) {

        if (contactMap.remove(phoneNumber) != null) {
            persist();
            return true;
        }
        return false;
    }


    public int show(int findBy, String findThis) {

        int foundContats = 0;

        if (findBy == 2) {

            if (exists(findThis) != null) {
                System.out.println(contactMap.get(findThis));
                foundContats++;
            }

            return foundContats;
        }

        for (Contact contact : contactMap.values()) {

            if (contact.getName().equalsIgnoreCase(findThis)) {
                System.out.println(contact);
                foundContats++;
            }

        }
        return foundContats;
    }

    public int size() {
        return contactMap.size();
    }

    public HashMap<String, Contact> allContacts() {
        return contactMap;
    }

    public boolean load() {

        try {

            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            String nextContact;
            while ((nextContact = bufferedReader.readLine()) != null) {
                Contact contact = new Contact();
                contact.setPhone(nextContact);
                contact.setName(bufferedReader.readLine());
                contact.setCity(bufferedReader.readLine());
                if (bufferedReader.readLine().equals("1")) {
                    contact.setMobile(true);
                } else {
                    contact.setMobile(false);
                }
                save(contact);
            }

            if (fileReader != null) fileReader.close();
            if (bufferedReader != null) bufferedReader.close();

            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }

    public Contact exists(String key) {
        return contactMap.get(key);
    }

    public void persist() {

        try {
            this.fileWriter = new FileWriter(this.file, false); //true -> end | false-> beginning
            this.printWriter = new PrintWriter(this.fileWriter, true);

            for (Contact contact : contactMap.values()) {
                int isMobile = contact.isMobile() ? 1 : 0;
                printWriter.println(contact.getPhone());
                printWriter.println(contact.getName());
                printWriter.println(contact.getCity());
                printWriter.println(isMobile);
            }

            if (fileWriter != null) fileWriter.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
