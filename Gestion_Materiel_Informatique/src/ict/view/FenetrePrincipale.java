package ict.view;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;


//constructeur
public class FenetrePrincipale extends JFrame
{
    private JMenuBar barMenu;
    private JToolBar barOutil;
    private JTable tableListMateriel;
    private JButton boutonAjoutMateriel;
    private JButton boutonSupprimeMateriel;
    private JButton boutonEditMateriel;
    private JComboBox comboBoxCategorie;
    private class ModelTable extends AbstractTableModel
    {
        private Object[][] donnee; // Donnees du tableau
        private String[] titres; // titres du tableaux

        // Constructeur
        public ModelTable(String[] titre, Object[][] donnee)
        {
            this.donnee = donnee;
            this.titres = titre;
        }

        @Override
        public int getRowCount()
        {
            return donnee.length;
        }

        @Override
        public int getColumnCount()
        {
            return titres.length;
        }

        @Override
        public Object getValueAt(int l, int c)
        {
            return donnee[l][c];
        }

        public String getColumnName(int col)
        {
            return titres[col];
        }

        public boolean isCellEditable(int row, int col)
        {
            return false;
        }

    }


    private JToolBar initBarOutil()
    {
        // creation de la barre d outil
        JToolBar toolBar = new JToolBar();

        // creation des boutons
        this.boutonAjoutMateriel = new JButton("  +  ");
        this.boutonSupprimeMateriel = new JButton("  -  ");
        this.boutonEditMateriel = new JButton(" EDITION ");



        //ajout des boutons dans la barre d outil
        toolBar.add(this.boutonAjoutMateriel);
        toolBar.add(this.boutonSupprimeMateriel);
        toolBar.add(this.boutonEditMateriel);

        return toolBar;
    }

    private JPanel initPanelGauche()
    {
        // Creation du panel gauche
        JPanel panelGauche = new JPanel();

        // Creation du comboBoxCategorie
        comboBoxCategorie = new JComboBox();

        //Ajustement de la taille du ComboxCategorie
        comboBoxCategorie.setPreferredSize(new Dimension(200, 30));

        //Ajout des composants dans le panel gauche
        panelGauche.add(comboBoxCategorie);

        return panelGauche;
    }

    private JPanel initPanelDroit()
    {
        // -------------------CREATION---------------------
        // Creation du panel droit
        JPanel panelDroit = new JPanel();

        // creation de la barre d'outil
        this.barOutil = this.initBarOutil();

        // Creation du table materiel
        String[][] donnees = {{"0", "Ordinateur", "18/12/2003", "18/12/2024"}
                , {"0", "Laptop2", "18/12/2003", "18/12/2024"}};
        String[] titres = {"IDENTIFIANT", "NOM MATERIEL", "DATE ACQUISITION", "DATE PROCHAINE MAITENANCE"};
        this.tableListMateriel = new JTable(new ModelTable(titres, donnees));

        // --------------CONFIGURATION COMPOSANT------------
        // configuration du tableau de materiel
        this.tableListMateriel.setRowHeight(30); // reglage de la taille de la hauteur des cellules du tableau
        this.tableListMateriel.setShowVerticalLines(false);// cache les lignes des colonnes
        this.tableListMateriel.setShowHorizontalLines(false);// cache les ligne des lignes


        // Ajout des composants dans le panel droit
        panelDroit.setLayout(new BorderLayout());
        panelDroit.add(this.barOutil, BorderLayout.NORTH);
        panelDroit.add(new JScrollPane(this.tableListMateriel), BorderLayout.CENTER);

        return panelDroit;
    }

    private void initSplitPane()
    {
        //-------------------CREATION---------------------
        // Creation du panel gauche et un panel droit
        JPanel panelGauche = this.initPanelGauche();//initPanelGauche construit et retoune le panel gauche
        JPanel panelDroit = this.initPanelDroit();

        // Creation du separateur
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelGauche, panelDroit);
        splitPane.setDividerLocation(300);//ajustement de la position verticale du separateur



        //-----------AJOUT DANS LA FENETRE------------------
        //Ajout des panel dans le panel principale(ContentPane)
        this.getContentPane().add(splitPane);
    }

    private void initBarreMenu()
    {
        // -------------------CREATION---------------------
        // Creationde la barre de menu
        this.barMenu = new JMenuBar();

        // Creationdes des differents menus
        JMenu menuFichier = new JMenu("Fichier");
        JMenu menuGestion = new JMenu("Gestion");
        JMenu menuAides = new JMenu("Aides");


        // ------------------CONFIGURATION-------------------
        //this.barMenu.setPreferredSize(new Dimension(100,25));




        // --------------AJOUT DANS LA FENETRE----------------
        // Ajout des menus dans la barre de nenu
        barMenu.add(menuFichier);
        barMenu.add(menuGestion);
        barMenu.add(menuAides);


        //Ajout du menu dans la fenetre principale
        this.setJMenuBar(barMenu);



    }

    //methode qui permet d'afficher la fenetre
    public void showFenetre()
    {
        this.setVisible(true);
    }


    public FenetrePrincipale()
    {
        this.setSize(1024,576);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        //
        this.initBarreMenu();
        this.initSplitPane();
    }
}
