package com.example.javagui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import java.util.ArrayList;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class University implements java.io.Serializable{


    public String Connect()
    {
        String url = "jdbc:mysql://localhost:3306/university";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url , "root", "Legend030012345@");
            System.out.println("Connection to SQLite has been established.");
            return "Connection to SQL has been established.";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                    return "Connection to SQL has been closed.";
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                return ex.getMessage();
            }
        }
    }

    String name;
    ArrayList<Campus> campuses;


    University(String name, ArrayList<Campus> campuses) {
        this.name = name;
        this.campuses = campuses;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Campus> getCampuses() {
        return campuses;
    }

    public void setCampuses(ArrayList<Campus> campuses) {
        this.campuses = campuses;
    }


    public void addCampus(Campus campus) {
        campuses.add(campus);
    }

    public void removeCampus(Campus campus) {
        campuses.remove(campus);
    }

    public ArrayList<Campus> getCampus() {
        return campuses;
    }

    public void saveData(){
    }

    @Override
    public String toString() {
        return "University{" +
                "name='" + name + '\'' +
                ", campuses=" + campuses +
                '}';
    }
}
