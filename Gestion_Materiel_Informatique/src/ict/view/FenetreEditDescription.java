package ict.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FenetreEditDescription  extends JDialog
{

    private String texte = "";
    private JTextArea textArea = new JTextArea();
    private JButton boutonValider = new JButton("Valider");
    private JButton boutonAnnuler = new JButton("Annuler");

    private class ValiderActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent actionEvent)
        {
            //recuperation du texte dans le text area
            texte = textArea.getText();
            dispose();
        }
    }
    private class AnnulerActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent actionEvent)
        {
            dispose();
        }
    }



    private void initComposant()
    {
        //parametrage du texte area
        this.textArea.setLineWrap(true);

        //Ajout des Actions des boutons
        this.boutonAnnuler.addActionListener(new AnnulerActionListener());
        this.boutonValider.addActionListener(new ValiderActionListener());

        //Ajout des boutons au panel1
        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel1.add(boutonValider);
        panel1.add(boutonAnnuler);


        //Ajout des composants dans dans le panel principale(ContentPane)
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(new JScrollPane(textArea), BorderLayout.CENTER);
        this.getContentPane().add(panel1, BorderLayout.SOUTH);
    }
    public String showFenetre()
    {
        this.setVisible(true);

        //retoune le texte contenu dans le textArea
        return texte;
    };

    public FenetreEditDescription(Frame parent, String texte, boolean modal)
    {
        super(parent, "AJOUT DESCRIPTION MATERIEL", modal);
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setResizable(true);

        this.textArea.setText(texte); // Ajout des infos dans le textArea de la fenetre
        this.texte = texte; // On ajoute les infos a la variable texte au cas ou on valide pas la modification
        this.initComposant();
    }
}
