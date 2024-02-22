package ict.view;

import javax.swing.*;

public class Detail extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextArea textArea2;
    private JPanel panel1;
    private JTextArea textArea1 = new JTextArea(100,40);
    private JTextField textField1;
    private JFormattedTextField formattedTextField1;
    private JFormattedTextField formattedTextField2;

    public Detail() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
    }

    public static void main(String[] args) {
        Detail dialog = new Detail();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        panel1 = new JPanel();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
}
