package com.example.javagui;

public class Computer implements java.io.Serializable {
    private String systemId;
    private String systemName;
    private String systemSpeed;
    private String ramSize;
    private String hardDiskSize;
    private String icdMakeModel;

    @Override
    public String toString() {
        return systemName;
    }

    private static int counter=1;
    public Computer(String systemName, String systemSpeed, String ramSize, String hardDiskSize, String icdMakeModel) {
        this.systemId = String.valueOf(counter);
        this.systemName = systemName;
        this.systemSpeed = systemSpeed;
        this.ramSize = ramSize;
        this.hardDiskSize = hardDiskSize;
        this.icdMakeModel = icdMakeModel;
        counter++;
    }

    public String getSystemId() {
        return systemId;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getSystemSpeed() {
        return systemSpeed;
    }

    public void setSystemSpeed(String systemSpeed) {
        this.systemSpeed = systemSpeed;
    }

    public String getRamSize() {
        return ramSize;
    }

    public void setRamSize(String ramSize) {
        this.ramSize = ramSize;
    }

    public String getHardDiskSize() {
        return hardDiskSize;
    }

    public void setHardDiskSize(String hardDiskSize) {
        this.hardDiskSize = hardDiskSize;
    }

    public String getIcdMakeModel() {
        return icdMakeModel;
    }

    public void setIcdMakeModel(String icdMakeModel) {
        this.icdMakeModel = icdMakeModel;
    }

    public String getSystemDetails() {
        return "Computer{" +
                "systemId='" + systemId + '\'' +
                ", systemName='" + systemName + '\'' +
                ", systemSpeed='" + systemSpeed + '\'' +
                ", ramSize='" + ramSize + '\'' +
                ", hardDiskSize='" + hardDiskSize + '\'' +
                ", icdMakeModel='" + icdMakeModel + '\'' +
                '}';
    }
}

