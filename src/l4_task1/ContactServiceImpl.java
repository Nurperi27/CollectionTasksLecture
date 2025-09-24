package l4_task1;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ContactServiceImpl implements ContactService {
    Map<String, String> contacts = new HashMap<>();

    @Override
    public void addContact(String name, String phoneNumber) {
        contacts.put(name, phoneNumber);
        System.out.println(name + " contact added!");
    }

    @Override
    public String getContact(String name) {
        return contacts.get(name);
        //return "Founded";
    }

    @Override
    public void removeContact(String name) {
        contacts.remove(name);
    }

    @Override
    public Map<String, String> getAllContact() {
        //for(Map<String, String> m : contacts.)
        return contacts;
    }
}
