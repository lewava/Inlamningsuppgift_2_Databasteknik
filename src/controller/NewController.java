package controller;

import model.Kund;
import model.Sko;
import repository.Repository;
import view.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

public class NewController implements ActionListener {
    private JFrame loginFrame;
    private JFrame selectOrderFrame;
    private JFrame shoppingCartFrame;
    private Container loginContainer;
    private JLabel loginNameLabel;
    private JLabel loginPasswordLabel;
    private JTextField loginUserTextField;
    private JPasswordField loginPasswordField;
    private JButton loginButton;
    private JComboBox SelectOrderOrders;
    private JButton selectOrderNext;
    private JLabel shoppingCartLabel;
    private JComboBox shoppingCartProduct;
    private JTextArea shoppingCartInfo;
    private JButton shoppingCartAddToCart;
    private View view;
    private Repository repository = new Repository();
    private int shoppingCartShoeId;

    public NewController(View view, JFrame loginFrame, JFrame selectOrderFrame, JFrame shoppingCartFrame,
                         JLabel loginNameLabel, JLabel loginPasswordLabel, JTextField loginUserTextField,
                         JPasswordField loginPasswordField, JButton loginButton, JComboBox selectOrderOrders,
                         JButton selectOrderNext, JLabel shoppingCartLabel, JComboBox shoppingCartProduct,
                         JTextArea shoppingCartInfo, JButton shoppingCartAddToCart) {
        this.view = view;
        this.loginFrame = loginFrame;
        this.selectOrderFrame = selectOrderFrame;
        this.shoppingCartFrame = shoppingCartFrame;
        this.loginNameLabel = loginNameLabel;
        this.loginPasswordLabel = loginPasswordLabel;
        this.loginUserTextField = loginUserTextField;
        this.loginPasswordField = loginPasswordField;
        this.loginButton = loginButton;
        this.SelectOrderOrders = selectOrderOrders;
        this.selectOrderNext = selectOrderNext;
        this.shoppingCartLabel = shoppingCartLabel;
        this.shoppingCartProduct = shoppingCartProduct;
        this.shoppingCartInfo = shoppingCartInfo;
        this.shoppingCartAddToCart = shoppingCartAddToCart;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            checkLogin();
        }else if (e.getSource() == selectOrderNext) {
            selectOrderFrame.setVisible(false);
            shoppingCartFrame.setVisible(true);
        }else if (e.getSource() == shoppingCartProduct) {
            getShoeInfo();
        }
    }

    public void checkLogin() {
        List<Kund> customerList = repository.getCustomer();

        for (Kund l : customerList) {
            if (loginUserTextField.getText().equalsIgnoreCase(l.getFörnamn()) && String.valueOf(loginPasswordField.getPassword()).equals(l.getLösenord())) {
                loginFrame.setVisible(false);
                selectOrderFrame.setVisible(true);
                view.fillComboBoxForSelectOrder(l.getId());
                break;
            }
            if (!loginUserTextField.getText().equalsIgnoreCase(l.getFörnamn()) && !String.valueOf(loginPasswordField.getPassword()).equals(l.getLösenord())) {
                JOptionPane.showMessageDialog(null, "Fel användarnamn eller lösenord.");
                break;
            }
        }
    }

    public void getShoeInfo() {
        HashMap<String, Sko> skoLista = repository.getSkoInfo();
        String selectedItem = (String) shoppingCartProduct.getSelectedItem();

        switch (selectedItem) {
            case "Bubblegum":
                for (String i : skoLista.keySet()) {
                    if (selectedItem.equalsIgnoreCase(i)) {
                        shoppingCartInfo.setText("Namn: " + skoLista.get(i).getNamn() +
                                "\nPris: " + skoLista.get(i).getPris() + ":-" +
                                "\nMärke: " + skoLista.get(i).getMärkeNamn() +
                                "\nFärg: " + skoLista.get(i).getFärg() +
                                "\nStorlek: " + skoLista.get(i).getStorlek() +
                                "\nkategori: " + skoLista.get(i).getKategoriNamn());
                        shoppingCartShoeId = skoLista.get(i).getId();
                    }
                }
                break;
            case "Air Max":
                for (String i : skoLista.keySet()) {
                    if (selectedItem.equalsIgnoreCase(i)) {
                        shoppingCartInfo.setText("Namn: " + skoLista.get(i).getNamn() +
                                "\nPris: " + skoLista.get(i).getPris() + ":-" +
                                "\nMärke: " + skoLista.get(i).getMärkeNamn() +
                                "\nFärg: " + skoLista.get(i).getFärg() +
                                "\nStorlek: " + skoLista.get(i).getStorlek() +
                                "\nkategori: " + skoLista.get(i).getKategoriNamn());
                        shoppingCartShoeId = skoLista.get(i).getId();
                    }
                }
                break;
            case "Sommartofflan":
                for (String i : skoLista.keySet()) {
                    if (selectedItem.equalsIgnoreCase(i)) {
                        shoppingCartInfo.setText("Namn: " + skoLista.get(i).getNamn() +
                                "\nPris: " + skoLista.get(i).getPris() + ":-" +
                                "\nMärke: " + skoLista.get(i).getMärkeNamn() +
                                "\nFärg: " + skoLista.get(i).getFärg() +
                                "\nStorlek: " + skoLista.get(i).getStorlek() +
                                "\nkategori: " + skoLista.get(i).getKategoriNamn());
                        shoppingCartShoeId = skoLista.get(i).getId();
                    }
                }
                break;
            case "Stranddal":
                for (String i : skoLista.keySet()) {
                    if (selectedItem.equalsIgnoreCase(i)) {
                        shoppingCartInfo.setText("Namn: " + skoLista.get(i).getNamn() +
                                "\nPris: " + skoLista.get(i).getPris() + ":-" +
                                "\nMärke: " + skoLista.get(i).getMärkeNamn() +
                                "\nFärg: " + skoLista.get(i).getFärg() +
                                "\nStorlek: " + skoLista.get(i).getStorlek() +
                                "\nkategori: " + skoLista.get(i).getKategoriNamn());
                        shoppingCartShoeId = skoLista.get(i).getId();
                    }
                }
                break;
            case "Snow":
                for (String i : skoLista.keySet()) {
                    if (selectedItem.equalsIgnoreCase(i)) {
                        shoppingCartInfo.setText("Namn: " + skoLista.get(i).getNamn() +
                                "\nPris: " + skoLista.get(i).getPris() + ":-" +
                                "\nMärke: " + skoLista.get(i).getMärkeNamn() +
                                "\nFärg: " + skoLista.get(i).getFärg() +
                                "\nStorlek: " + skoLista.get(i).getStorlek() +
                                "\nkategori: " + skoLista.get(i).getKategoriNamn());
                        shoppingCartShoeId = skoLista.get(i).getId();
                    }
                }
                break;
            case "Swift":
                for (String i : skoLista.keySet()) {
                    if (selectedItem.equalsIgnoreCase(i)) {
                        shoppingCartInfo.setText("Namn: " + skoLista.get(i).getNamn() +
                                "\nPris: " + skoLista.get(i).getPris() + ":-" +
                                "\nMärke: " + skoLista.get(i).getMärkeNamn() +
                                "\nFärg: " + skoLista.get(i).getFärg() +
                                "\nStorlek: " + skoLista.get(i).getStorlek() +
                                "\nkategori: " + skoLista.get(i).getKategoriNamn());
                        shoppingCartShoeId = skoLista.get(i).getId();
                    }
                }
                break;
            case "Hejarklacken":
                for (String i : skoLista.keySet()) {
                    if (selectedItem.equalsIgnoreCase(i)) {
                        shoppingCartInfo.setText("Namn: " + skoLista.get(i).getNamn() +
                                "\nPris: " + skoLista.get(i).getPris() + ":-" +
                                "\nMärke: " + skoLista.get(i).getMärkeNamn() +
                                "\nFärg: " + skoLista.get(i).getFärg() +
                                "\nStorlek: " + skoLista.get(i).getStorlek() +
                                "\nkategori: " + skoLista.get(i).getKategoriNamn());
                    }
                }
                break;
            case "Highness":
                for (String i : skoLista.keySet()) {
                    if (selectedItem.equalsIgnoreCase(i)) {
                        shoppingCartInfo.setText("Namn: " + skoLista.get(i).getNamn() +
                                "\nPris: " + skoLista.get(i).getPris() + ":-" +
                                "\nMärke: " + skoLista.get(i).getMärkeNamn() +
                                "\nFärg: " + skoLista.get(i).getFärg() +
                                "\nStorlek: " + skoLista.get(i).getStorlek() +
                                "\nkategori: " + skoLista.get(i).getKategoriNamn());
                        shoppingCartShoeId = skoLista.get(i).getId();
                    }
                }
                break;
        }
    }
}

