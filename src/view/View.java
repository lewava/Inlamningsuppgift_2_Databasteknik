package view;

import controller.NewController;
import model.Beställning;
import repository.Repository;

import javax.swing.*;
import java.awt.*;
import java.util.List;

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
    private JComboBox<String> selectOrderOrders = new JComboBox();
    private JButton selectOrderNext = new JButton("Gå vidare");
    private JFrame shoppingCartFrame = new JFrame();
    private Container shoppingCartContainer = shoppingCartFrame.getContentPane();
    private JLabel shoppingCartLabel = new JLabel("Varor");
    private JComboBox<String> shoppingCartProduct = new JComboBox<>();
    private JTextArea shoppingCartInfo = new JTextArea();
    private JButton shoppingCartAddToCart = new JButton("AddToCart");
    private Repository repository = new Repository();
    private NewController controller = new NewController(this, loginFrame, selectOrderFrame, shoppingCartFrame,
            loginNameLabel, loginPasswordLabel, loginUserTextField, loginPasswordField, loginButton, selectOrderOrders,
            selectOrderNext, shoppingCartLabel, shoppingCartProduct, shoppingCartInfo, shoppingCartAddToCart);

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
        selectOrderOrders.setBounds(50, 30, 200, 30);
        selectOrderNext.setBounds(85, 80, 125, 30);
    }

    public void addComponentsToContainerForSelectOrder() {
        selectOrderContainer.add(selectOrderOrders);
        selectOrderContainer.add(selectOrderNext);
    }

    public void addActionEventForSelectOrder() {
        selectOrderOrders.addActionListener(controller);
        selectOrderNext.addActionListener(controller);
    }

    public void fillComboBoxForSelectOrder(int currentCustomer) {
        List<Beställning> orderList = repository.getOrders();

        selectOrderOrders.addItem("Ny Beställning");
        for (Beställning b : orderList) {
            if (b.getKundId() == currentCustomer)
                selectOrderOrders.addItem(b.getDatum());
        }
    }

    public void shoppingCartView() {
        setLayoutForShoppingCart();
        setLocationAndSizeForShoppingCart();
        AddComponentsToContainerForShoppingCart();
        fillComboBoxForShoppingCart();
        addActionEventForShoppingCart();
        shoppingCartInfo.setEditable(false);
        shoppingCartInfo.setFont(new Font("Serif", Font.BOLD, 15));
        shoppingCartFrame.setTitle("Shopping cart");
        shoppingCartFrame.setSize(350, 350);
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
        shoppingCartAddToCart.setBounds(65, 255, 200, 30);
    }

    public void AddComponentsToContainerForShoppingCart() {
        shoppingCartContainer.add(shoppingCartLabel);
        shoppingCartContainer.add(shoppingCartProduct);
        shoppingCartContainer.add(shoppingCartInfo);
        shoppingCartContainer.add(shoppingCartAddToCart);
    }

    public void fillComboBoxForShoppingCart() {
        List<String> skoName = repository.getShoeNames();
        for (String s : skoName) {
            shoppingCartProduct.addItem(s);
        }
    }

    public void addActionEventForShoppingCart() {
        shoppingCartProduct.addActionListener(controller);
        shoppingCartAddToCart.addActionListener(controller);
    }
}

