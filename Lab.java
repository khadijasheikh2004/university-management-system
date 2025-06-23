package com.example.javagui;

import java.util.ArrayList;

public class Lab implements java.io.Serializable {
    LabStaff incharge;
    boolean hasProjector;
    ArrayList<Computer> computers;
    ArrayList<LabStaff> labStaff;

    public Lab(LabStaff incharge, boolean hasProjector, ArrayList<Computer> computers, ArrayList<LabStaff> labStaff) {
        this.incharge = incharge;
        this.hasProjector = hasProjector;
        this.computers = computers;
        this.labStaff = labStaff;
    }

    public LabStaff getIncharge() {
        return incharge;
    }

    public void setIncharge(LabStaff labStaffIncharge) {
        this.incharge = labStaffIncharge;
    }

    public boolean isHasProjector() {
        return hasProjector;
    }

    public void setHasProjector(boolean hasProjector) {
        this.hasProjector = hasProjector;
    }

    public ArrayList<Computer> getComputers() {
        return computers;
    }

    public void setComputers(ArrayList<Computer> computers) {
        this.computers = computers;
    }

    public ArrayList<LabStaff> getLabStaff() {
        return labStaff;
    }

    public void setLabStaff(ArrayList<LabStaff> labStaff) {
        this.labStaff = labStaff;
    }

    public void addComputer(Computer computer) {
        computers.add(computer);
    }

    public void removeComputer(Computer computer) {
        computers.remove(computer);
    }

    public Computer getComputer(int ComputerID) {
        for (Computer computer : computers) {
            int ID = Integer.parseInt(computer.getSystemId());
            if (ID == ComputerID) {
                return computer;
            }
        }
        System.out.println("Computer not found");
        return null;
    }

    @Override
    public String toString() {
        return "Lab{" +
                "incharge=" + incharge +
                ", hasProjector=" + hasProjector +
                ", computers=" + computers +
                ", labStaff=" + labStaff +
                '}';
    }
}
