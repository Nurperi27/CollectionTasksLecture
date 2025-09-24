package l5_task1.service;

import java.util.List;

public interface GeneralService <T> { //<T, E> - если используется два класса
     void addUser(T t);
    List<T> getAllUsers();
    <E> T getUserByValue(E value);
    <E> void updateUserByValue(E value , T t);
    <S> void deleteUserByValue(S value);
}
