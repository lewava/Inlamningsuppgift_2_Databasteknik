import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {

    private Container container = getContentPane();
    private JLabel nameLabel = new JLabel("Name");
    private JLabel passwordLabel = new JLabel("Password");
    private JTextField userTextField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    private JButton loginButton = new JButton("Login");
    private ControllerLogin controller = new ControllerLogin(userTextField, passwordField, loginButton);

    public LoginView() {
        setLayout();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        this.setTitle("Login");
        this.setSize(300, 310);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);

    }

    public void setLayout() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        nameLabel.setBounds(30, 50, 100, 30);
        passwordLabel.setBounds(30, 100, 100, 30);
        userTextField.setBounds(100, 50, 150, 30);
        passwordField.setBounds(100, 100, 150, 30);
        loginButton.setBounds(110, 150, 125, 30);
    }

    public void addComponentsToContainer() {
        container.add(nameLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(loginButton);
    }

    public void addActionEvent() {
        loginButton.addActionListener(controller);
        passwordField.addActionListener(controller);
    }
}

