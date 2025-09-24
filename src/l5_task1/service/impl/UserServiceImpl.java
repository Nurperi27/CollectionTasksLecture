package l5_task1.service.impl;

import ExtraSession1.db.Database;
import l5_task1.models.User;
import l5_task1.service.GeneralService;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements GeneralService <User> {
    List<User> database = new ArrayList<>();
    @Override
    public void addUser(User user) {
        database.add(user);
    }

    @Override
    public List<User> getAllUsers() {
        return database;
    }

    @Override
    public <E> User getUserByValue(E value) {
        for(User u : database){
            if(u.getUsername().equals(value)){
                return u;
            }
        }
        return null;
    }

    @Override
    public <E> void updateUserByValue(E value, User user) {
        User oldUser = getUserByValue(value);
        oldUser.setUsername(user.getUsername());
        oldUser.setEmail(user.getEmail());
    }

    @Override
    public <S> void deleteUserByValue(S value) {
        User deleteUser = getUserByValue(value);
        database.remove(deleteUser);
    }
}
