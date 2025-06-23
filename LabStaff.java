package com.example.javagui;
import java.io.Serializable;
public class LabStaff extends Employee{

    @Override
    public String toString() {
        return "LabStaff{ name = " + getName() + ", grade = " + getGrade() + " }";
    }

    public LabStaff(String name, String grade , String email , String password) {
        super(name, grade , email , password);
    }

    public LabStaff(String name, String grade) {
        super(name, grade);
    }
}
