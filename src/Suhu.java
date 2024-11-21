import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Suhu {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Konversi Suhu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridBagLayout());
        frame.add(panel, BorderLayout.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel inputLabel = new JLabel("Masukkan suhu (°C):");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(inputLabel, gbc);

        JTextField inputField = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        panel.add(inputField, gbc);

        JButton convertButton = new JButton("Konversi");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panel.add(convertButton, gbc);

        JLabel resultLabel = new JLabel("Hasil: ");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(resultLabel, gbc);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double celsius = Double.parseDouble(inputField.getText());
                    double fahrenheit = (celsius * 9 / 5) + 32;
                    resultLabel.setText("Hasil: " + fahrenheit + " °F");
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Input tidak valid!");
                }
            }
        });

        frame.setVisible(true);
    }
}
