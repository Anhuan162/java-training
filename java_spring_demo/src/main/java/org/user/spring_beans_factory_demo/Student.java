package org.user.spring_beans_factory_demo;

// POJO class
public class Student {

    // Member variables
    private String name;
    private String age;

    // Constructor 1
    public Student() {
    }

    // Constructor 2
    public Student(String name, String age) {
        this.name = name;
        this.age = age;
    }

    // Method inside POJO class
    @Override
    public String toString() {

        // Print student class attributes
        return "Student{" + "name='" + name + '\'' + ", age='" + age + '\'' + '}';
    }
}
