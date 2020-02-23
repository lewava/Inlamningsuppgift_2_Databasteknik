import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class ControllerShoppingCart implements ActionListener {
    private JButton addToCart;
    private JComboBox product;
    private JTextArea info;
    private Repository repository = new Repository();

    public ControllerShoppingCart(JButton addToCart, JComboBox product, JTextArea info) {
        this.addToCart = addToCart;
        this.product = product;
        this.info = info;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        HashMap<String, Sko> skoLista = repository.getSkoInfo();
        product = (JComboBox) e.getSource();
        String selectedItem = (String) product.getSelectedItem();

        switch (selectedItem) {
            case "Bubblegum":
                for (String i : skoLista.keySet()) {
                    if (selectedItem.equalsIgnoreCase(i)) {
                        info.setText("Namn: " + skoLista.get(i).getNamn() +
                                "\nPris: " + skoLista.get(i).getPris() + ":-" +
                                "\nMärke: " + skoLista.get(i).getMärke() +
                                "\nFärg: " + skoLista.get(i).getFärg() +
                                "\nStorlek: " + skoLista.get(i).getStorlek() +
                                "\nkategori: " + skoLista.get(i).getKategori());
                    }
                }
                break;
            case "Air Max":
                for (String i : skoLista.keySet()) {
                    if (selectedItem.equalsIgnoreCase(i)) {
                        info.setText("Namn: " + skoLista.get(i).getNamn() +
                                "\nPris: " + skoLista.get(i).getPris() + ":-" +
                                "\nMärke: " + skoLista.get(i).getMärke() +
                                "\nFärg: " + skoLista.get(i).getFärg() +
                                "\nStorlek: " + skoLista.get(i).getStorlek() +
                                "\nkategori: " + skoLista.get(i).getKategori());
                    }
                }
                break;
            case "Sommartofflan":
                for (String i : skoLista.keySet()) {
                    if (selectedItem.equalsIgnoreCase(i)) {
                        info.setText("Namn: " + skoLista.get(i).getNamn() +
                                "\nPris: " + skoLista.get(i).getPris() + ":-" +
                                "\nMärke: " + skoLista.get(i).getMärke() +
                                "\nFärg: " + skoLista.get(i).getFärg() +
                                "\nStorlek: " + skoLista.get(i).getStorlek() +
                                "\nkategori: " + skoLista.get(i).getKategori());
                    }
                }
                break;
            case "Stranddal":
                for (String i : skoLista.keySet()) {
                    if (selectedItem.equalsIgnoreCase(i)) {
                        info.setText("Namn: " + skoLista.get(i).getNamn() +
                                "\nPris: " + skoLista.get(i).getPris() + ":-" +
                                "\nMärke: " + skoLista.get(i).getMärke() +
                                "\nFärg: " + skoLista.get(i).getFärg() +
                                "\nStorlek: " + skoLista.get(i).getStorlek() +
                                "\nkategori: " + skoLista.get(i).getKategori());
                    }
                }
                break;
            case "Snow":
                for (String i : skoLista.keySet()) {
                    if (selectedItem.equalsIgnoreCase(i)) {
                        info.setText("Namn: " + skoLista.get(i).getNamn() +
                                "\nPris: " + skoLista.get(i).getPris() + ":-" +
                                "\nMärke: " + skoLista.get(i).getMärke() +
                                "\nFärg: " + skoLista.get(i).getFärg() +
                                "\nStorlek: " + skoLista.get(i).getStorlek() +
                                "\nkategori: " + skoLista.get(i).getKategori());
                    }
                }
                break;
            case "Swift":
                for (String i : skoLista.keySet()) {
                    if (selectedItem.equalsIgnoreCase(i)) {
                        info.setText("Namn: " + skoLista.get(i).getNamn() +
                                "\nPris: " + skoLista.get(i).getPris() + ":-" +
                                "\nMärke: " + skoLista.get(i).getMärke() +
                                "\nFärg: " + skoLista.get(i).getFärg() +
                                "\nStorlek: " + skoLista.get(i).getStorlek() +
                                "\nkategori: " + skoLista.get(i).getKategori());
                    }
                }
                break;
            case "Hejarklacken":
                for (String i : skoLista.keySet()) {
                    if (selectedItem.equalsIgnoreCase(i)) {
                        info.setText("Namn: " + skoLista.get(i).getNamn() +
                                "\nPris: " + skoLista.get(i).getPris() + ":-" +
                                "\nMärke: " + skoLista.get(i).getMärke() +
                                "\nFärg: " + skoLista.get(i).getFärg() +
                                "\nStorlek: " + skoLista.get(i).getStorlek() +
                                "\nkategori: " + skoLista.get(i).getKategori());
                    }
                }
                break;
            case "Highness":
                for (String i : skoLista.keySet()) {
                    if (selectedItem.equalsIgnoreCase(i)) {
                        info.setText("Namn: " + skoLista.get(i).getNamn() +
                                "\nPris: " + skoLista.get(i).getPris() + ":-" +
                                "\nMärke: " + skoLista.get(i).getMärke() +
                                "\nFärg: " + skoLista.get(i).getFärg() +
                                "\nStorlek: " + skoLista.get(i).getStorlek() +
                                "\nkategori: " + skoLista.get(i).getKategori());
                    }
                }
                break;
        }

        if (e.getSource() == addToCart) {

        }
    }
}
