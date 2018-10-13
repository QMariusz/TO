package view;

import controller.Calculate;
import model.Currency;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Interface extends JFrame {
    private final int DELAY = 250;
    private JTextField leftTextField;
    private JTextField rightTextField;
    private JComboBox<Object> leftComboBox;
    private JComboBox<Object> rightComboBox;
    private JButton resetButton;
    private JButton calculateButton;
    private Calculate calculate;
    private List<Currency> currencys;

    public Interface(Calculate calculate, List<Currency> currencyList) {
        super("Exchange");
        this.calculate = calculate;
        this.currencys = currencyList;

        setSize(new Dimension(500, 110));
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - getHeight()) / 2);
        setLocation(x, y);
        setFocusable(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents();
    }

    private void createComponents() {
        Container container = getContentPane();

        JPanel przyciski = new JPanel();
        przyciski.setLayout(new BoxLayout(przyciski, BoxLayout.Y_AXIS));

        leftComboBox = new JComboBox<>(currencys.stream().map(Currency::getName).toArray());
        leftComboBox.setBounds(10, 10, 180, 24);
        leftComboBox.setFont(new Font("Serif", Font.PLAIN, 14));

        rightComboBox = new JComboBox<>(currencys.stream().map(Currency::getName).toArray());
        rightComboBox.setBounds(295, 10, 180, 24);
        rightComboBox.setFont(new Font("Serif", Font.PLAIN, 14));

        leftTextField = new JTextField();
        leftTextField.setBounds(10, 40, 180, 24);
        leftTextField.setFont(new Font("Serif", Font.PLAIN, 14));

        rightTextField = new JTextField();
        rightTextField.setBounds(295, 40, 180, 24);
        rightTextField.setFont(new Font("Serif", Font.PLAIN, 14));
        rightTextField.setEnabled(false);
        rightTextField.setDisabledTextColor(Color.black);


        container.add(leftTextField);
        container.add(rightTextField);
        container.add(leftComboBox);
        container.add(rightComboBox);

        resetButton = new JButton("Reset");
        resetButton.setBounds(200, 210, 40, 40);
        calculateButton = new JButton("Calculate");
        calculateButton.setBounds(200, 210, 40, 40);

        przyciski.add(Box.createRigidArea(new Dimension(0, 10)));
        przyciski.add(resetButton);
        przyciski.add(Box.createRigidArea(new Dimension(0, 3)));
        przyciski.add(calculateButton);
        resetButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        calculateButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(przyciski);
        setVisible(true);

        //click Enter
        leftTextField.addActionListener(e -> rightTextField.setText(calculate.count(leftTextField.getText(),
                leftComboBox.getSelectedItem(), rightComboBox.getSelectedItem())));

        leftComboBox.addActionListener(e -> {
            leftTextField.setText("");
            rightTextField.setText("");
        });

        rightComboBox.addActionListener(e_ -> {
            leftTextField.setText("");
            rightTextField.setText("");
        });

        calculateButton.addActionListener(e -> rightTextField.setText(calculate.count(leftTextField.getText(),
                leftComboBox.getSelectedItem(), rightComboBox.getSelectedItem())));

        resetButton.addActionListener(e -> {
            leftTextField.setText("");
            rightTextField.setText("");
        });
    }
}
