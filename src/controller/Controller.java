package controller;

import model.Beställning;
import model.Kund;
import model.Sko;
import repository.Repository;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Controller implements ActionListener {
    private JFrame loginFrame;
    private JFrame selectOrderFrame;
    private JFrame shoppingCartFrame;
    private JTextField loginUserTextField;
    private JPasswordField loginPasswordField;
    private JButton loginButton;
    private JComboBox<Beställning> selectOrderOrders;
    private JButton chooseOrder;
    private JButton newOrder;
    private JComboBox<String> shoppingCartProduct;
    private JTextArea shoppingCartInfo;
    private JButton shoppingCartAddToCart;
    private Repository repository = new Repository();
    private int currentCustomerId;
    private int selectedShoeId;
    private int selectedOrderId;
    private JButton prinOrder;
    private List<String> order = new ArrayList<>();


    public Controller(JFrame loginFrame, JFrame selectOrderFrame, JFrame shoppingCartFrame,
                      JTextField loginUserTextField, JPasswordField loginPasswordField, JButton loginButton,
                      JComboBox<Beställning> selectOrderOrders, JButton chooseOrder, JComboBox<String> shoppingCartProduct,
                      JTextArea shoppingCartInfo, JButton shoppingCartAddToCart, JButton newOrder, JButton prinOrder) {
        this.loginFrame = loginFrame;
        this.selectOrderFrame = selectOrderFrame;
        this.shoppingCartFrame = shoppingCartFrame;
        this.loginUserTextField = loginUserTextField;
        this.loginPasswordField = loginPasswordField;
        this.loginButton = loginButton;
        this.selectOrderOrders = selectOrderOrders;
        this.chooseOrder = chooseOrder;
        this.shoppingCartProduct = shoppingCartProduct;
        this.shoppingCartInfo = shoppingCartInfo;
        this.shoppingCartAddToCart = shoppingCartAddToCart;
        this.newOrder = newOrder;
        this.prinOrder = prinOrder;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            checkLogin();

        } else if (e.getSource() == chooseOrder) {
            Beställning selectedItem = (Beställning) selectOrderOrders.getSelectedItem();
            selectedOrderId = selectedItem.getId();
            selectOrderFrame.setVisible(false);
            shoppingCartFrame.setVisible(true);

        } else if (e.getSource() == newOrder) {
            selectOrderFrame.setVisible(false);
            shoppingCartFrame.setVisible(true);
        } else if (e.getSource() == shoppingCartProduct) {
            updateShoeInfo();

        } else if (e.getSource() == shoppingCartAddToCart) {
            String selectedItem = (String) shoppingCartProduct.getSelectedItem();
            order.add(selectedItem);

            try {
                if (e.getSource() == newOrder) {
                    repository.addToCart(currentCustomerId, 0, getShoeId());

                } else {
                    repository.addToCart(currentCustomerId, selectedOrderId, getShoeId());
                    System.out.println(selectedItem + " lades till i din beställning.");
                }

            }catch (Exception e1) {
                System.out.println("Något gick fel, din vara kunde inte läggas till i beställningen.");
            }

        } else if (e.getSource() == prinOrder) {

            System.out.println("------ Din beställning innehåller ------");

            for (String s : order) {
                System.out.println("\t" + "\t   " + s);
            }
            System.out.println("------ Slut på beställning ------");
        }
    }

    public int checkLogin() {
        List<Kund> customerList = repository.getCustomer();

        for (Kund l : customerList) {
            if (loginUserTextField.getText().equalsIgnoreCase(l.getFörnamn()) && String.valueOf(loginPasswordField.getPassword()).equals(l.getLösenord())) {
                loginFrame.setVisible(false);
                selectOrderFrame.setVisible(true);
                fillOrderComboBox(l.getId());
                fillShoeComboBox();
                currentCustomerId = l.getId();
                break;
            }
            if (!loginUserTextField.getText().equalsIgnoreCase(l.getFörnamn()) && !String.valueOf(loginPasswordField.getPassword()).equals(l.getLösenord())) {
                JOptionPane.showMessageDialog(null, "Fel användarnamn eller lösenord.");
                break;
            }
        }
        return currentCustomerId;
    }

    public void fillOrderComboBox(int currentCustomer) {
        HashMap<String, Beställning> orderList = repository.getOrders();
        ;

        for (Map.Entry<String, Beställning> entry : orderList.entrySet()) {
            if (entry.getValue().getKundId() == currentCustomer) {
                selectOrderOrders.addItem(entry.getValue());
            }
        }
    }

    public void fillShoeComboBox() {
        List<String> shoeNames = repository.getShoeNames();
        for (String s : shoeNames) {
            shoppingCartProduct.addItem(s);
        }
    }

    public int getShoeId() {
        String selectedItem = (String) shoppingCartProduct.getSelectedItem();

        switch (selectedItem) {
            case "Bubblegum":
                selectedShoeId = 3;
                break;
            case "Air Max":
                selectedShoeId = 7;
                break;
            case "Sommartofflan":
                selectedShoeId = 1;
                break;
            case "Stranddal":
                selectedShoeId = 4;
                break;
            case "Snow":
                selectedShoeId = 5;
                break;
            case "Swift":
                selectedShoeId = 6;
                break;
            case "Hejarklacken":
                selectedShoeId = 2;
                break;
            case "Highness":
                selectedShoeId = 8;
                break;
        }
        return selectedShoeId;
    }


    public void updateShoeInfo() {
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
                        selectedShoeId = skoLista.get(i).getId();
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
                        selectedShoeId = skoLista.get(i).getId();
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
                        selectedShoeId = skoLista.get(i).getId();
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
                        selectedShoeId = skoLista.get(i).getId();
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
                        selectedShoeId = skoLista.get(i).getId();
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
                        selectedShoeId = skoLista.get(i).getId();
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
                        selectedShoeId = skoLista.get(i).getId();
                    }
                }
                break;
        }
    }
}

