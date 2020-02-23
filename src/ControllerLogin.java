import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ControllerLogin extends JFrame implements ActionListener {
    private JTextField userTextField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private Repository repository = new Repository();
    private ShoppingCartView shoppingCartView = new ShoppingCartView();


    public ControllerLogin(JTextField textField, JPasswordField passwordField, JButton button) {
        this.userTextField = textField;
        this.passwordField = passwordField;
        this.loginButton = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        List<Login> loginList = repository.getLogin();
        String tempPass = String.valueOf(passwordField.getPassword());

        if (e.getSource() == loginButton) {
            for (Login l : loginList) {
                if (userTextField.getText().equalsIgnoreCase(l.getFörnamn()) && tempPass.equals(l.getLösenord())) {
                    super.setVisible(false);
                    shoppingCartView.setVisible(true);
                    break;
                }
                if (!userTextField.getText().equalsIgnoreCase(l.getFörnamn()) && !tempPass.equals(l.getLösenord())) {
                    JOptionPane.showMessageDialog(null, "Fel användarnamn eller lösenord.");
                    break;
                }
            }
        } else if (e.getSource() == passwordField) {
            loginButton.doClick();
        }
    }
}
