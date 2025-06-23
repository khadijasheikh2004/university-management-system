package com.example.javagui;

import java.util.ArrayList;

public class Department {
    public Department(HOD hod) {
        this.hod = hod;
        this.labs = new ArrayList<>();
    }
    HOD hod;
    ArrayList<Lab> labs;

    public Department(HOD hod, ArrayList<Lab> labs) {
        this.hod = hod;
        this.labs = labs;
    }

    @Override
    public String toString() {
        return "Department{" +
                "hod=" + hod +
                ", labs=" + labs +
                '}';
    }

    public HOD getHod() {
        return hod;
    }

    public void setHod(HOD hod) {
        this.hod = hod;
    }

    public ArrayList<Lab> getLabs() {
        return labs;
    }

    public void addLab(Lab lab)
    {
        labs.add(lab);
    }

    public void removeLab(Lab lab)
    {
        labs.remove(lab);
    }


}

