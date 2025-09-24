package l5_task1;

import l5_task1.models.User;
import l5_task1.service.GeneralService;
import l5_task1.service.impl.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        GeneralService<User> userService = new UserServiceImpl();
        userService.addUser(new User("diamond", "d@gmail.com", "A", "U", 18));
        System.out.println(userService.getAllUsers());
        System.out.println(userService.getAllUsers());
        System.out.println(userService.getUserByValue("diamond"));
        userService.updateUserByValue("diamond", new User("goodBoy", "test@gmail.com", "Test", "Test", 19));
        System.out.println("Delete: ");
        userService.deleteUserByValue("goodBoy");


    }
}
