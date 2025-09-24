package l1_task1;

import l1_task1.enums.Group;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> arrayList = new ArrayList<>();
        arrayList.add(new Student("A", 15, Group.JAVA));
        arrayList.add(new Student("B", 16, Group.JAVA));
        arrayList.add(new Student("C", 17, Group.JAVA));
        arrayList.add(new Student("D", 18, Group.JAVA));
        arrayList.add(new Student("E", 19, Group.JAVA));
        arrayList.add(new Student("F", 20, Group.JAVA_SCRIPT));
        arrayList.add(new Student("G", 21, Group.JAVA_SCRIPT));
        arrayList.add(new Student("H", 22, Group.JAVA_SCRIPT));
        arrayList.add(new Student("I", 23, Group.JAVA_SCRIPT));
        arrayList.add(new Student("J", 24, Group.JAVA_SCRIPT));
        System.out.println(arrayList);
        ArrayList<Student> arrayJava = new ArrayList<>();
        for(Student s : arrayList){
            if(s.getGroup().equals(Group.JAVA)){
                arrayJava.add(s);
            }
        }
        System.out.println("Java group:\n" + arrayJava);
        ArrayList<Student> arrayJS = new ArrayList<>();
        for(Student j : arrayList){
            if(j.getGroup().equals(Group.JAVA_SCRIPT)){
                arrayJS.add(j);
            }
        }
        System.out.println("\nJavaScript group:\n" + arrayJS);
        ArrayList<Student> ageSort = new ArrayList<>();
        //addAll() - используется, чтобы добавить элементы из олной коллекции в другую
        //filter(element -> условие) - используется для фильтрации элементов коллекции по определённым условиям
        //stream() - нужен для того, чтобы получить поток, чтобы далее использовать filter(), sorted(), map()
        //a метод toList() или collect() - превращает поток обратно в список (или сбор результата)
        ageSort.addAll(arrayList.stream().filter(a -> a.getAge() >=19 && a.getAge() <=23).toList());
        System.out.println("\nAge from 19 to 23:\n" + ageSort);
        ArrayList<Student> nameA = new ArrayList<>();
        nameA.addAll(arrayList);
        nameA.stream().sorted(); //sorted() - сортирует по возрастанию
        System.out.println("\nName start with 'A':" + nameA.getFirst()); //после сортировки получаем первый элемент
    }
}