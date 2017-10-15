import java.awt.FlowLayout;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class CapacityConverter extends JFrame {
    // DECLARE AND CREATE COMPONENTS
    JLabel jlblTypeConversion01 = new JLabel("Liters - Gallons");
    JTextField jtxtfldValue01 = new JTextField(20);

    JLabel jlblTypeConversion02 = new JLabel("Gallons - Liters");
    JTextField jtxtfldValue02 = new JTextField(20);

    JLabel jlblNote = new JLabel("Enter the number and press <<ENTER>>");

    private CapacityConverter() {

        setTitle("Capacity Converter");
        setSize(340, 120);
        setLocation(50, 50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setVisible(true);

        add(jlblTypeConversion01);
        add(jtxtfldValue01);

        add(jlblTypeConversion02);
        add(jtxtfldValue02);

        jtxtfldValue01.addKeyListener(new EventJTField());
        jtxtfldValue02.addKeyListener(new EventJTField());

        jtxtfldValue01.addFocusListener(new EventJTField());
        jtxtfldValue02.addFocusListener(new EventJTField());

    }

    public static void main(String[] args) {
        new CapacityConverter();
    }
    private class EventJTField implements KeyListener, FocusListener {
        Double result;
        String message;

        public void keyPressed(KeyEvent ev) {

            if (ev.getKeyCode() == KeyEvent.VK_ENTER) {

                if (ev.getSource() == jtxtfldValue01) {

                    result = Double.parseDouble(jtxtfldValue01.getText()) * 0.22;
                    message = Double.toString(result);
                    JOptionPane.showMessageDialog(null, message, "liters - gallons", JOptionPane.INFORMATION_MESSAGE);

                } else {

                    result = Double.parseDouble(jtxtfldValue02.getText()) / 0.22;
                    message = Double.toString(result);
                    JOptionPane.showMessageDialog(null, message, "gallons - liters", JOptionPane.INFORMATION_MESSAGE);

                }
            }
        }

        public void keyReleased(KeyEvent ev) {}
        
        public void keyTyped(KeyEvent ev) {};


        public void focusGained(FocusEvent ev) {

            if (ev.getSource() == jtxtfldValue01) {

                jtxtfldValue02.setText("");

            } else {

                jtxtfldValue01.setText("");
            }
            

        }

        public void focusLost(FocusEvent ev) {}
    }
}

