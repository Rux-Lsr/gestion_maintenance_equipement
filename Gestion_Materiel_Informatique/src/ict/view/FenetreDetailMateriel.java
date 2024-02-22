package ict.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FenetreDetailMateriel extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JTextArea textArea1;
    private JComboBox comboBox1;
    private JFormattedTextField formattedTextField1;
    private JFormattedTextField formattedTextField2;
    private JButton modificationButton;

    public FenetreDetailMateriel() {
        setContentPane(contentPane);
        setModal(true);
        setResizable(false);

        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        modificationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }

    private void onOK() {
        // add your code here
        FenetreMaintenance fenetreMaintenance = new FenetreMaintenance();
        fenetreMaintenance.showWindow();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    private void onModifier(){

    }
    public void showWindow() {
        FenetreDetailMateriel dialog = new FenetreDetailMateriel();
        dialog.setPreferredSize(new Dimension(600,600));
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        System.exit(0);
    }

    private void createUIComponents() {
        // TODO: Wabo, et les autres placez le code de personalisation des composant dans cette fonction
    }
}
