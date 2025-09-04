package l1_task1;

import l1_task1.enums.Group;

public class Student {
    private String name;
    private int age;
    private Group group;
    public Student(){}
    public Student(String name, int age, Group group) {
        this.name = name;
        this.age = age;
        this.group = group;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Group getGroup() {
        return group;
    }
    public void setGroup(Group group) {
        this.group = group;
    }
    @Override
    public String toString() {
        return "\nStudent{" +
                "Name: " + name + '\'' +
                ", Age: " + age +
                ", Group: " + group +
                '}';
    }
}
