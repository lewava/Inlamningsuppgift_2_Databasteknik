package repository;

import model.Beställning;
import model.Kund;
import model.Sko;

import java.io.*;
import java.sql.*;
import java.util.*;

public class Repository {

    private Properties properties = new Properties();

    public Repository() {
        try {
            properties.load(new FileInputStream("C:\\Users\\Leon_\\IdeaProjects\\Inlämningsuppgift 2 Databasteknik\\src\\Settings.properties"));

        } catch (IOException ioe) {
            ioe.printStackTrace();

        }
    }

    public List<Kund> getCustomer() {
        List<Kund> customerList = new ArrayList<>();

        try (Connection myConn = DriverManager.getConnection(properties.getProperty("connectionString"),
                properties.getProperty("name"),
                properties.getProperty("password"));
             Statement myStmt = myConn.createStatement();
             ResultSet myRs = myStmt.executeQuery("SELECT * FROM Kund;")) {

            while (myRs.next()) {
                customerList.add(new Kund(myRs.getInt(1), myRs.getNString(2), myRs.getString(3), myRs.getString(4),
                        myRs.getString(5), myRs.getString(6), myRs.getString(7), myRs.getString(8), myRs.getNString(9)));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customerList;
    }

    public HashMap<String, Sko> getSkoInfo() {
        HashMap<String, Sko> skoList = new HashMap<>();

        try (Connection myConn = DriverManager.getConnection(properties.getProperty("connectionString"),
                properties.getProperty("name"),
                properties.getProperty("password"));
             Statement myStmt = myConn.createStatement();
             ResultSet myRs = myStmt.executeQuery("SELECT *\n" +
                     "FROM sko\n" + "INNER JOIN märke\n" + "ON sko.märke_id = märke.id\n" + "INNER JOIN skokategori\n" +
                     "ON skokategori.sko_id = sko.id\n" + "INNER JOIN kategori\n" + "ON kategori.id = skokategori.Kategori_id")) {

            while (myRs.next()) {
                skoList.put(myRs.getString("sko.namn"), new Sko(myRs.getInt("sko.id"),
                        myRs.getString("sko.namn"), myRs.getInt("sko.pris"),
                        myRs.getString("märke.namn"), myRs.getString("sko.färg"),
                        myRs.getInt("sko.storlek"), myRs.getString("kategori.namn")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return skoList;
    }

    public List<String> getShoeNames() {
        List<String> skoName = new ArrayList<>();

        try (Connection myConn = DriverManager.getConnection(properties.getProperty("connectionString"),
                properties.getProperty("name"),
                properties.getProperty("password"));
             Statement myStmt = myConn.createStatement();
             ResultSet myRs = myStmt.executeQuery("SELECT namn FROM sko;")) {

            while (myRs.next()) {
                skoName.add(myRs.getString("namn"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return skoName;
    }

    public HashMap<String, Beställning> getOrders() {
        HashMap<String, Beställning> orderList = new HashMap<>();

        try (Connection myConn = DriverManager.getConnection(properties.getProperty("connectionString"),
                properties.getProperty("name"),
                properties.getProperty("password"));
             Statement myStmt = myConn.createStatement();
             ResultSet myRs = myStmt.executeQuery("SELECT * FROM beställning;")) {

            while (myRs.next()) {
                orderList.put(myRs.getString(2), new Beställning(myRs.getInt(1),
                        myRs.getString(2), myRs.getInt(3), myRs.getInt(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }

    public void addToCart(int kundId, int beställningId, int skoId) {

        try (Connection myConn = DriverManager.getConnection(properties.getProperty("connectionString"),
                properties.getProperty("name"),
                properties.getProperty("password"))) {
            CallableStatement myStmt = myConn.prepareCall("{call AddToCart(?, ?, ?)}");

            myStmt.setInt(1, kundId);
            myStmt.setInt(2, beställningId);
            myStmt.setInt(3, skoId);

            myStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}