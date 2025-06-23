package com.example.javagui;

public class Employee implements java.io.Serializable{
    private String name;
    private String grade;

    private String email;

    private String password;

    public Employee(String name, String grade , String email , String password) {
        this.name = name;
        this.grade = grade;
        this.email = email;
        this.password = password;
    }

    public Employee(String name, String grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getEmployeeDetails() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
