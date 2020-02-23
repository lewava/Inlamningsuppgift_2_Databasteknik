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

    public List<Login> getLogin() {
        List<Login> loginList = new ArrayList<>();

        try (Connection myConn = DriverManager.getConnection(properties.getProperty("connectionString"),
                properties.getProperty("name"),
                properties.getProperty("password"));
             Statement myStmt = myConn.createStatement();
             ResultSet myRs = myStmt.executeQuery("SELECT Förnamn, Lösenord FROM Kund;")) {

            while (myRs.next()) {
                loginList.add(new Login(myRs.getString("Förnamn"), myRs.getString("Lösenord")));

            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return loginList;
    }

    public HashMap<String, Sko> getSkoInfo() {
        HashMap<String, Sko> skoList = new HashMap<>();

        try (Connection myConn = DriverManager.getConnection(properties.getProperty("connectionString"),
                properties.getProperty("name"),
                properties.getProperty("password"));
             Statement myStmt = myConn.createStatement();
             ResultSet myRs = myStmt.executeQuery("SELECT sko.id, sko.namn, sko.pris, märke.namn, sko.färg, sko.storlek, kategori.namn\n" +
                     "FROM sko\n" + "INNER JOIN märke\n" + "ON sko.märke_id = märke.id\n" + "INNER JOIN skokategori\n" +
                     "ON skokategori.sko_id = sko.id\n" + "INNER JOIN kategori\n" + "ON kategori.id = skokategori.Kategori_id")) {

            while (myRs.next()) {
                skoList.put(myRs.getString("sko.namn"), new Sko(myRs.getInt("sko.id"),
                        myRs.getString("sko.namn"),
                        myRs.getInt("sko.pris"), myRs.getString("märke.namn"),
                        myRs.getString("sko.färg"), myRs.getInt("sko.storlek"),
                        myRs.getString("kategori.namn")));
            }
        } catch (SQLException se2) {
            se2.printStackTrace();
        }
        return skoList;
    }

    public List<String> getSkoName() {
        List<String> skoName = new ArrayList<>();

        try (Connection myConn = DriverManager.getConnection(properties.getProperty("connectionString"),
                properties.getProperty("name"),
                properties.getProperty("password"));
             Statement myStmt = myConn.createStatement();
             ResultSet myRs = myStmt.executeQuery("SELECT namn FROM sko;")) {

            while (myRs.next()) {
                skoName.add(myRs.getString("namn"));
            }
        } catch (SQLException se2) {
            se2.printStackTrace();
        }
        return skoName;
    }
}
