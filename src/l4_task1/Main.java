package l4_task1;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ContactService contactService = new ContactServiceImpl();
        contactService.addContact("A", "+996900000000");
        contactService.addContact("Q", "+996901000000");
        contactService.addContact("W", "+996902000000");
        contactService.addContact("P", "+996903000000");
        System.out.println(contactService.getAllContact());
        System.out.println(contactService.getContact("Q"));
        contactService.removeContact("W");
        System.out.println(contactService.getAllContact());
    }
}
