import javax.swing.*;
import java.awt.*;
import java.util.List;


public class ShoppingCartView extends JFrame {
    private Container container = getContentPane();
    private JLabel label = new JLabel("Varor");
    private JComboBox<String> product = new JComboBox<>();
    private JTextArea info = new JTextArea();
    private JButton addToCart = new JButton("AddToCart");
    private Repository repository = new Repository();
    private ControllerShoppingCart controllerShoppingCart = new ControllerShoppingCart(addToCart, product, info);

    public ShoppingCartView() {
        setLayout();
        setLocationAndSize();
        addComponentsToContainer();
        fillComboBox();
        addActionEvent();
        info.setEditable(false);
        info.setFont(new Font("Serif", Font.BOLD, 15));
        this.setTitle("Shopping cart");
        this.setSize(350, 350);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(false);
    }

    public void setLayout() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        label.setBounds(50, 23, 100, 30);
        product.setBounds(125, 25, 150, 30);
        info.setBounds(40, 80, 250, 150);
        addToCart.setBounds(65, 255, 200, 30);
    }

    public void addComponentsToContainer() {
        container.add(label);
        container.add(product);
        container.add(info);
        container.add(addToCart);
    }

    public void fillComboBox() {
        List<String> skoName = repository.getSkoName();
        for (String s : skoName) {
            product.addItem(s);
        }
    }

    public void addActionEvent() {
        product.addActionListener(controllerShoppingCart);
    }
}
