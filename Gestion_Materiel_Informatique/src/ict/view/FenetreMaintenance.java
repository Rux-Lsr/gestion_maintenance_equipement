package ict.view;

import javax.swing.*;
import java.awt.event.*;
import java.sql.Date;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Objects;

public class FenetreMaintenance extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextArea textArea1;
    private JComboBox<String> comboBox1;
    private JFormattedTextField formattedTextField1;


    public FenetreMaintenance() {
        setContentPane(contentPane);
        setModal(true);
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
    }

    private void onOK() {
        if(!textArea1.getText().isEmpty()) {
            int i;
            for (i = 0; i<textArea1.getText().length(); i++)
                if (textArea1.getText().charAt(i) == ' ')
                    i++;
                System.out.println(textArea1.getText().length());
            System.out.println("i= "+i);
            if (i> textArea1.getText().length()){
                JOptionPane.showMessageDialog(
                        this,
                        "Veuillez remplir tous les champs",
                        "Maintenance",
                        JOptionPane.ERROR_MESSAGE
                );
            }else {
                JOptionPane.showMessageDialog(
                        this,
                        "Maintennance Reussie",
                        "SMaintenance",
                        JOptionPane.INFORMATION_MESSAGE
                );
                dispose();
            }
        }else {
            JOptionPane.showMessageDialog(
                    this,
                    "Veuillez remplir tous les champs",
                    "Maintenance",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }


    public  static void showWindow(){
        FenetreMaintenance dialog = new FenetreMaintenance();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    public void showWindow(int id_materiel){
        textArea1.setText("Entrez les observations sur la maintenance du materiel "+ id_materiel);
        FenetreMaintenance dialog = new FenetreMaintenance();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
    private void createUIComponents() {
        // TODO: place custom component creation code here
        this.setResizable(false);
        String[] options ={"Default", "personalised"} ;
        comboBox1 = new JComboBox<>(options);
        textArea1 = new JTextArea(25,50);
        this.setLocationRelativeTo(null);

        Format dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        formattedTextField1 = new JFormattedTextField(dateFormat);
        formattedTextField1.setValue(new Date(2024, 2, 22));


        //check if the personnalised field is choosen or not
        comboBox1.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String selectedItem = (String) e.getItem();
                if ("personalised".equals(selectedItem)) {
                    // Si l'option "personalised" est sélectionnée, activer le JFormattedTextField
                    formattedTextField1.setEnabled(true);
                } else {
                    // Sinon, désactiver le JFormattedTextField
                    formattedTextField1.setEnabled(false);
                }
            }
        });

        //check if the date field is in the correct format
        formattedTextField1.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                JFormattedTextField field = (JFormattedTextField) input;
                try {
                    ((SimpleDateFormat) dateFormat).parse(field.getText());
                    return true; // Le format est correct
                } catch (ParseException e) {
                    JOptionPane.showMessageDialog(null, "Format de date incorrect. Veuillez entrer une date au format dd/MM/yyyy.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return false; // Le format est incorrect
                }
            }
        });
    }
}
