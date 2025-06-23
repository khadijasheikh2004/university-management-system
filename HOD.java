package com.example.javagui;

public class HOD extends Employee{

    String name;
    String grade;

    String email;

    String password;
    public HOD(String name, String grade , String email , String password) {
        super(name, grade , email , password);
        this.name = name;
        this.grade = grade;
        this.email = email;
        this.password = password;
    }

    public HOD(String name, String grade) {
        super(name, grade);
        this.name = name;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "HOD " + name + " " + grade;
    }
}

