package ict.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class FenetreAjoutMateriel extends JDialog
{

    private JTextField textFieldNomMateriel = new JTextField();
    private JComboBox comboBoxCategorie;
    private JTextField textFieldDateAcquisition = new JTextField();
    private JTextField textFieldNombreDeMoisAPM = new JTextField();
    private JTextArea textAreaDescriptionMateriel = new JTextArea("");
    private JButton boutonAjouter = new JButton("Ajouter");
    private JButton boutonAnnuler = new JButton("Annuler");
    private String[] ListeCategorieMateriel;
    //les infos du materiel sont retournees a l aide de l'objet de type InfoMateriel
    private InfoMateriel infoMateriel = null;



    private class RetournerInfoFenetreActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent actionEvent)
        {
            String nomMateriel = textFieldNomMateriel.getText();
            String categorie = (String) comboBoxCategorie.getSelectedItem();
            String description = textAreaDescriptionMateriel.getText();
            LocalDate dateAcquisition = null;
            int nombreDeMoisAPM = 0;


            //CONTROLE SUR LES ENTREES-----------------

            //On verifie si le nom du materiel est vide
            if(nomMateriel.equals(""))
            {
                String message = "Le renseigez le nom du materiel il ne doit pas etre vide!";
                JOptionPane.showMessageDialog(null, message, "NON INVALIDE",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            //on verifie si il y'a une categorie choisis
            if(categorie.equals(""))
            {
                String message = "Le renseigez la categorie du materiel il ne doit pas etre vide!";
                JOptionPane.showMessageDialog(null, message, "Categorie INVALIDE",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            //On verifie la date d'acquisition et le nombre de mois A.P.M
            try
            {
                String dateStr = textFieldDateAcquisition.getText();
                dateAcquisition = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                nombreDeMoisAPM = Integer.parseInt(textFieldNombreDeMoisAPM.getText());
                //On verifie si le nombre de mois n'est pas negatif ouegal a zero
                if(nombreDeMoisAPM <= 0)
                {
                    String message = "Le nombre de mois entrer ne doit pas etre inferieur " +
                            "ou egal a zero!\nVeuillez entrer un nombre correcte!";
                    JOptionPane.showMessageDialog(null, message, "NOMBRE INVALIDE",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

            }
            catch (DateTimeParseException e)
            {
                String message = "La date entrer est invalide! veuillez verifier \n" +
                        "le format de la date (dd/MM/yyy)!";
                JOptionPane.showMessageDialog(null, message, "DATE INVALIDE",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            catch (NumberFormatException e)
            {
                String message = "Le nombre de mois entrer est invalide! " +
                        "veuiller entrer un nombre correcte!";
                JOptionPane.showMessageDialog(null, message, "NOMBRE INVALIDE",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            catch (Exception e)
            {

            }


            //Creation et AJOUT DES INFOS DANS L'OBJET INFOMATERIL A RETOURNER-----------------

            infoMateriel = new InfoMateriel(nomMateriel,categorie, dateAcquisition,
                    nombreDeMoisAPM, description);
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
    private class OuvrirFenetreEditDescriptionListener implements MouseListener
    {
        public void mouseClicked(MouseEvent mouseEvent)
        {
            //on suveille le nombre de clique pour afficher la fenetre
            if(mouseEvent.getClickCount() == 2)
            {
                JTextArea textArea = textAreaDescriptionMateriel;
                FenetreEditDescription fenetre = new FenetreEditDescription(null, textArea.getText(), true);
                //On ajoute a textAreaDescriptionMateriel les infos de la description retouner par
                //FenetreEditDescription
                textArea.setText(fenetre.showFenetre());
            }
        }

        @Override
        public void mousePressed(MouseEvent mouseEvent)
        {

        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent)
        {

        }

        @Override
        public void mouseEntered(MouseEvent mouseEvent)
        {

        }

        @Override
        public void mouseExited(MouseEvent mouseEvent)
        {

        }
    }


    private void initComposants()
    {
        JLabel titre1 = new JLabel("NOM MATERIEL: ");
        JLabel titre2 = new JLabel("CATEGORIE: ");
        JLabel titre3 = new JLabel("DATE ACQUISITION: ");
        JLabel titre4 = new JLabel("NOMBRE DE M.A.P.M: ");
        JLabel titre5 = new JLabel("DESCRIPTION: ");

        SpringLayout splAjoutBatiment = new SpringLayout();
        SpringLayout splZone1 = new SpringLayout();
        SpringLayout splZone2 = new SpringLayout();
        JPanel panelInfoMateriel = new JPanel(splZone1);

        //ajustement de la taille et de la bordure du panel1
        panelInfoMateriel.setBorder(BorderFactory.createTitledBorder(" Info Materiel"));
        panelInfoMateriel.setPreferredSize(new Dimension(400, 320));

        //ajustement de la taille textField Nom Materiel
        textFieldNomMateriel.setPreferredSize(new Dimension(200, 30));
        //ajustement de la taille textFieldDateAcquisition
        textFieldDateAcquisition.setPreferredSize(new Dimension(200, 30));
        //ajustement de taille du textFieldNombreDeMoisAPM
        textFieldNombreDeMoisAPM.setPreferredSize(new Dimension(200, 30));

        //ajustement de la taille ComboBoxCategorie
        comboBoxCategorie.setPreferredSize(new Dimension(200, 30));

        //ajustement de taille du textAreaDescriptionMateriel et modification des bordure
        // et on le rend ineditable
        textAreaDescriptionMateriel.setPreferredSize(new Dimension(200, 60));
        textAreaDescriptionMateriel.setLineWrap(true);
        textAreaDescriptionMateriel.setBorder(BorderFactory.createEtchedBorder());
        textAreaDescriptionMateriel.setEditable(false);


        //ajustement de la taille des boutons
        boutonAjouter.setPreferredSize(new Dimension(150,30));
        boutonAnnuler.setPreferredSize(new Dimension(150,30));

        //Ajout des actions des boutons
        boutonAnnuler.addActionListener(new AnnulerActionListener());
        boutonAjouter.addActionListener(new RetournerInfoFenetreActionListener());

        //Ajout des actions textAreaDescriptionMateriel
        textAreaDescriptionMateriel.addMouseListener(new OuvrirFenetreEditDescriptionListener());

        //position du panel1
        splAjoutBatiment.putConstraint(SpringLayout.NORTH, panelInfoMateriel, 50, SpringLayout.NORTH, this.getContentPane());
        splAjoutBatiment.putConstraint(SpringLayout.WEST, panelInfoMateriel, 50, SpringLayout.WEST, this.getContentPane());
        //position du tittre1 et du JTextField (textFieldNombreDeMois)
        splZone1.putConstraint(SpringLayout.NORTH, titre1, 25, SpringLayout.NORTH ,  panelInfoMateriel);
        splZone1.putConstraint(SpringLayout.EAST, titre1, 150, SpringLayout.WEST ,  panelInfoMateriel);
        //position du textFielNombreDeMois
        splZone1.putConstraint(SpringLayout.NORTH, textFieldNomMateriel, 25, SpringLayout.NORTH, panelInfoMateriel);
        splZone1.putConstraint(SpringLayout.WEST, textFieldNomMateriel, 10, SpringLayout.EAST ,  titre1);

        //position du titre2
        splZone1.putConstraint(SpringLayout.NORTH, titre2, 30, SpringLayout.SOUTH, titre1);
        splZone1.putConstraint(SpringLayout.EAST, titre2, 150, SpringLayout.WEST, panelInfoMateriel);
        //position du textFieldNombreEtage
        splZone1.putConstraint(SpringLayout.NORTH, comboBoxCategorie, 30, SpringLayout.SOUTH, titre1);
        splZone1.putConstraint(SpringLayout.WEST, comboBoxCategorie, 10, SpringLayout.EAST ,  titre2);

        //position titre3
        splZone1.putConstraint(SpringLayout.NORTH, titre3, 30, SpringLayout.SOUTH, titre2);
        splZone1.putConstraint(SpringLayout.EAST, titre3, 150, SpringLayout.WEST, panelInfoMateriel);
        //position du textFielPrixDateAcquisition
        splZone1.putConstraint(SpringLayout.NORTH, textFieldDateAcquisition, 30, SpringLayout.SOUTH, titre2);
        splZone1.putConstraint(SpringLayout.WEST, textFieldDateAcquisition, 10, SpringLayout.EAST ,  titre3);

        //position titre4
        splZone1.putConstraint(SpringLayout.NORTH, titre4, 30, SpringLayout.SOUTH, titre3);
        splZone1.putConstraint(SpringLayout.EAST, titre4, 150, SpringLayout.WEST, panelInfoMateriel);
        //position du textFielNombreDeMoisAPM
        splZone1.putConstraint(SpringLayout.NORTH, textFieldNombreDeMoisAPM, 30, SpringLayout.SOUTH, titre3);
        splZone1.putConstraint(SpringLayout.WEST, textFieldNombreDeMoisAPM, 10, SpringLayout.EAST ,  titre4);

        //position titre5
        splZone1.putConstraint(SpringLayout.NORTH, titre5, 30, SpringLayout.SOUTH, titre4);
        splZone1.putConstraint(SpringLayout.EAST, titre5, 150, SpringLayout.WEST, panelInfoMateriel);
        //
        splZone1.putConstraint(SpringLayout.NORTH, textAreaDescriptionMateriel, 30, SpringLayout.SOUTH, titre4);
        splZone1.putConstraint(SpringLayout.WEST, textAreaDescriptionMateriel, 10, SpringLayout.EAST ,  titre5);

        //position du bouton Ajouter
        splAjoutBatiment.putConstraint(SpringLayout.NORTH, boutonAjouter,30, SpringLayout.SOUTH, panelInfoMateriel);
        splAjoutBatiment.putConstraint(SpringLayout.WEST, boutonAjouter,70, SpringLayout.WEST, getContentPane());
        //position du bouton annuler
        splAjoutBatiment.putConstraint(SpringLayout.NORTH, boutonAnnuler,30, SpringLayout.SOUTH, panelInfoMateriel);
        splAjoutBatiment.putConstraint(SpringLayout.WEST, boutonAnnuler,50, SpringLayout.EAST, boutonAjouter);


        //Ajout des elements du panelInfoMateriel(titre1 et textFieldNomBatiment)
        panelInfoMateriel.add(titre1);
        panelInfoMateriel.add(textFieldNomMateriel);
        panelInfoMateriel.add(titre2);
        panelInfoMateriel.add(comboBoxCategorie);
        panelInfoMateriel.add(titre3);
        panelInfoMateriel.add(textFieldDateAcquisition);
        panelInfoMateriel.add(titre4);
        panelInfoMateriel.add(textFieldNombreDeMoisAPM);
        panelInfoMateriel.add(titre5);
        panelInfoMateriel.add(textAreaDescriptionMateriel);




        //Ajout des panels et des bouton dans le ContentPane(Panel Principale)
        this.getContentPane().setLayout(splAjoutBatiment);
        this.getContentPane().add(panelInfoMateriel);
        this.getContentPane().add(boutonAjouter);
        this.getContentPane().add(boutonAnnuler);


    }

    public InfoMateriel showFenetre()
    {
        this.setVisible(true);

        //retournement des infos de la fenetre par l'objet de type InfoFenetre
        return this.infoMateriel;
    }


    public FenetreAjoutMateriel(Frame parent, String[] categorieMateriel, boolean modal)
    {
        super(parent, "AJOUT MATERIEL", modal);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        this.ListeCategorieMateriel = categorieMateriel;
        this.comboBoxCategorie = new JComboBox(categorieMateriel);
        this.initComposants();

    }

}
