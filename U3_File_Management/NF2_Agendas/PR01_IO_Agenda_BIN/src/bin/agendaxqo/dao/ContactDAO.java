package bin.agendaxqo.dao;

import bin.agendaxqo.model.Contact;

import java.io.*;
import java.util.HashMap;

public class ContactDAO {

    private HashMap<String, Contact> contactMap;
    private File file;
    private FileOutputStream fileOutputStream;
    private ObjectOutputStream objectOutputStream;
    private FileInputStream fileInputStream;
    private ObjectInputStream objectInputStream;
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

        int foundContacts = 0;

        if (findBy == 2) {

            if (exists(findThis) != null) {
                System.out.println(contactMap.get(findThis));
                foundContacts++;
            }

            return foundContacts;
        }

        for (Contact contact : contactMap.values()) {

            if (contact.getName().equalsIgnoreCase(findThis)) {
                System.out.println(contact);
                foundContacts++;
            }

        }
        return foundContacts;
    }

    public int size() {
        return contactMap.size();
    }

    public HashMap<String, Contact> allContacts() {
        return contactMap;
    }

    public boolean load() {

        try {

            fileInputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(fileInputStream);

            while (fileInputStream.available() > 0) {
                Contact contact = (Contact) objectInputStream.readObject();
                save(contact);
            }

            if (fileInputStream != null) fileInputStream.close();
            if (objectInputStream != null) objectInputStream.close();

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

            this.fileOutputStream = new FileOutputStream(this.file);
            this.objectOutputStream = new ObjectOutputStream(this.fileOutputStream);

            for (Contact contact : contactMap.values()) {
                objectOutputStream.writeObject(contact);
            }

            if (fileOutputStream != null) fileOutputStream.close();
            if (objectOutputStream != null) objectOutputStream.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
