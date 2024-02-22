package ict.view;


import javax.swing.*;
import java.awt.*;
import java.text.Format;
import java.text.SimpleDateFormat;

public class FenetreDetailInfoMateriel extends JDialog {
    private JPanel panelMain;
    private JTextField textFieldNom;
    private JFormattedTextField textFieldDateAcquisition;
    private JTextField textFieldProchaineDM;
    private JTextArea textAreaDescription;
    private JButton buttonModifier;
    private JButton buttonMaintenir;
    private JButton buttonSupprimer;

    public FenetreDetailInfoMateriel() {
        panelMain = new JPanel();
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));

        textFieldNom = new JTextField();
        textFieldNom.setMaximumSize(new Dimension(Integer.MAX_VALUE, textFieldNom.getPreferredSize().height));
        panelMain.add(new JLabel("Nom"));
        panelMain.add(textFieldNom);

        Format format = new SimpleDateFormat("dd/MM/yyyy");
        textFieldDateAcquisition = new JFormattedTextField(format);
        textFieldDateAcquisition.setMaximumSize(new Dimension(Integer.MAX_VALUE, textFieldDateAcquisition.getPreferredSize().height));
        textFieldDateAcquisition.setEnabled(false);
        panelMain.add(new JLabel("date d'acquisition"));
        panelMain.add(textFieldDateAcquisition);

        textFieldProchaineDM = new JTextField();
        textFieldProchaineDM.setMaximumSize(new Dimension(Integer.MAX_VALUE, textFieldProchaineDM.getPreferredSize().height));
        panelMain.add(new JLabel("Prochaine D.M"));
        panelMain.add(textFieldProchaineDM);

        textAreaDescription = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textAreaDescription);
        scrollPane.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));
        panelMain.add(new JLabel("Description"));
        panelMain.add(scrollPane);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonModifier = new JButton("Modifier");
        buttonMaintenir = new JButton("Maintenir");
        buttonSupprimer = new JButton("Supprimer");
        buttonPanel.add(buttonModifier);
        buttonPanel.add(buttonMaintenir);
        buttonPanel.add(buttonSupprimer);
        panelMain.add(buttonPanel);

        setContentPane(panelMain);
        pack();
    }

    public void showWindow() {
        FenetreDetailInfoMateriel dialog = new FenetreDetailInfoMateriel();
        dialog.setTitle("Info Materiel");
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }
}
