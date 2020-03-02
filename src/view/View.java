package view;

import controller.Controller;
import model.Beställning;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {

    private JFrame loginFrame = new JFrame();
    private Container loginContainer = loginFrame.getContentPane();
    private JLabel loginNameLabel = new JLabel("Name");
    private JLabel loginPasswordLabel = new JLabel("Password");
    private JTextField loginUserTextField = new JTextField();
    private JPasswordField loginPasswordField = new JPasswordField();
    private JButton loginButton = new JButton("Login");
    private JFrame selectOrderFrame = new JFrame();
    private Container selectOrderContainer = selectOrderFrame.getContentPane();
    private JComboBox<Beställning> selectOrderOrders = new JComboBox();
    private JLabel selectOrderLabel = new JLabel("Välj Beställning");
    private JButton chooseOrder = new JButton("Välj beställning");
    private JButton newOrder = new JButton("Ny Beställning");
    private JFrame shoppingCartFrame = new JFrame();
    private Container shoppingCartContainer = shoppingCartFrame.getContentPane();
    private JLabel shoppingCartLabel = new JLabel("Varor");
    private JComboBox<String> shoppingCartProduct = new JComboBox<>();
    private JTextArea shoppingCartInfo = new JTextArea();
    private JButton shoppingCartAddToCart = new JButton("AddToCart");
    private JButton printOrder = new JButton("Skriv ut beställning");
    private Controller controller = new Controller(loginFrame, selectOrderFrame, shoppingCartFrame,
            loginUserTextField, loginPasswordField, loginButton, selectOrderOrders, chooseOrder,
            shoppingCartProduct, shoppingCartInfo, shoppingCartAddToCart, newOrder, printOrder);

    public View() {
        loginView();
        selectOrderView();
        shoppingCartView();
    }

    public void loginView() {
        setLayoutForLogin();
        setLocationAndSizeForLogin();
        addComponentsToContainerLogin();
        addActionEventForLogin();
        loginFrame.setTitle("Login");
        loginFrame.setSize(300, 310);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setResizable(false);
        loginFrame.setVisible(true);
    }

    public void setLayoutForLogin() {
        loginContainer.setLayout(null);
    }

    public void setLocationAndSizeForLogin() {
        loginNameLabel.setBounds(30, 50, 100, 30);
        loginPasswordLabel.setBounds(30, 100, 100, 30);
        loginUserTextField.setBounds(100, 50, 150, 30);
        loginPasswordField.setBounds(100, 100, 150, 30);
        loginButton.setBounds(110, 150, 125, 30);
    }

    public void addComponentsToContainerLogin() {
        loginContainer.add(loginNameLabel);
        loginContainer.add(loginPasswordLabel);
        loginContainer.add(loginUserTextField);
        loginContainer.add(loginPasswordField);
        loginContainer.add(loginButton);
    }

    public void addActionEventForLogin() {
        loginButton.addActionListener(controller);
        loginPasswordField.addActionListener(controller);
    }

    public void selectOrderView() {
        setLayoutForSelectOrder();
        setLocationAndSizeForSelectOrder();
        addComponentsToContainerForSelectOrder();
        addActionEventForSelectOrder();
        selectOrderFrame.setTitle("Orders");
        selectOrderFrame.setSize(300, 180);
        selectOrderFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        selectOrderFrame.setLocationRelativeTo(null);
        selectOrderFrame.setResizable(false);
        selectOrderFrame.setVisible(false);

    }

    public void setLayoutForSelectOrder() {
        selectOrderContainer.setLayout(null);
    }

    public void setLocationAndSizeForSelectOrder() {
        selectOrderLabel.setBounds(110, 10, 100, 30);
        selectOrderOrders.setBounds(50, 45, 200, 30);
        newOrder.setBounds(155, 90, 100, 30);
        chooseOrder.setBounds(45, 90, 100, 30);
    }

    public void addComponentsToContainerForSelectOrder() {
        selectOrderContainer.add(selectOrderOrders);
        selectOrderContainer.add(chooseOrder);
        selectOrderContainer.add(selectOrderLabel);
        selectOrderContainer.add(newOrder);
    }

    public void addActionEventForSelectOrder() {
        selectOrderOrders.addActionListener(controller);
        chooseOrder.addActionListener(controller);
        newOrder.addActionListener(controller);
    }


    public void shoppingCartView() {
        setLayoutForShoppingCart();
        setLocationAndSizeForShoppingCart();
        AddComponentsToContainerForShoppingCart();
        addActionEventForShoppingCart();
        shoppingCartInfo.setEditable(false);
        shoppingCartInfo.setFont(new Font("Serif", Font.BOLD, 15));
        shoppingCartFrame.setTitle("Shopping cart");
        shoppingCartFrame.setSize(350, 370);
        shoppingCartFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        shoppingCartFrame.setLocationRelativeTo(null);
        shoppingCartFrame.setResizable(false);
        shoppingCartFrame.setVisible(false);
    }

    public void setLayoutForShoppingCart() {
        shoppingCartContainer.setLayout(null);
    }

    public void setLocationAndSizeForShoppingCart() {
        shoppingCartLabel.setBounds(50, 23, 100, 30);
        shoppingCartProduct.setBounds(125, 25, 150, 30);
        shoppingCartInfo.setBounds(40, 80, 250, 150);
        shoppingCartAddToCart.setBounds(65, 245, 200, 30);
        printOrder.setBounds(65, 290, 200, 30);
    }

    public void AddComponentsToContainerForShoppingCart() {
        shoppingCartContainer.add(shoppingCartLabel);
        shoppingCartContainer.add(shoppingCartProduct);
        shoppingCartContainer.add(shoppingCartInfo);
        shoppingCartContainer.add(shoppingCartAddToCart);
        shoppingCartContainer.add(printOrder);
    }

    public void addActionEventForShoppingCart() {
        shoppingCartProduct.addActionListener(controller);
        shoppingCartAddToCart.addActionListener(controller);
        printOrder.addActionListener(controller);
    }
}

