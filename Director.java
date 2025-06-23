package com.example.javagui;


public class Director extends Employee{
    @Override
    public String toString() {
        return "Director{}";
    }

    public Director(String name, String grade , String email , String password) {
        super(name, grade , email , password);
    }

    public Director(String name, String grade) {
        super(name, grade);
    }


}
