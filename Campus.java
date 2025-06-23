package com.example.javagui;

import java.util.ArrayList;

public class Campus {
    private String name;
    private String address;
    private Director director;
    ArrayList<Department> departments;

    public Campus(String name, String address, Director director, ArrayList<Department> departments) {
        this.name = name;
        this.address = address;
        this.director = director;
        this.departments = departments;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Campus{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", director=" + director +
                ", departments=" + departments +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(ArrayList<Department> departments) {
        this.departments = departments;
    }

    public void addDepartment(Department department) {

    }
    public void removeDepartment(Department department){

    }
    public ArrayList<Department> getDepartment() {
        return departments;
    }
}
