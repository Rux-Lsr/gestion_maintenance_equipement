package ict.view;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;


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
    private JComboBox comboBoxOrganisation;
    private JCheckBox comboBoxTrie;
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
        this.boutonAjoutMateriel = new JButton(new ImageIcon("../Images/ajouter3.png"));
        this.boutonSupprimeMateriel = new JButton(new ImageIcon("../Images/corbeille2.png"));
        this.boutonEditMateriel = new JButton(" EDITION ");



        //ajout des boutons dans la barre d outil
        toolBar.add(this.boutonAjoutMateriel);
        toolBar.add(this.boutonSupprimeMateriel);
        toolBar.add(this.boutonEditMateriel);

        return toolBar;
    }

    private JPanel initPanelGauche()
    {

        // ------------CREATION DES COMPOSANTS----------------


        // Creation de spring layout du panel panelTmp
        SpringLayout spl1 = new SpringLayout();

        // Creation du panel gauche
        JPanel panelGauche = new JPanel();
        JPanel panelTmp = new JPanel(spl1);

        // Creation des comboBox
        this.comboBoxOrganisation = new JComboBox();
        this.comboBoxCategorie = new JComboBox();
        // Creation des labels
        JLabel labelCategorie = new JLabel("CATEGORIE: ");
        JLabel labelOrganisation = new JLabel("TRIE: ");





        // -------------CONFIGURATION DES COMPOSANTS-----------

        //Ajustement de la taille des Combox
        this.comboBoxCategorie.setPreferredSize(new Dimension(200, 30));
        this.comboBoxOrganisation.setPreferredSize(new Dimension(200, 30));
        // redimentionnement du panelTmp
        //panelTmp.setBackground(Color.BLUE);
        panelTmp.setPreferredSize(new Dimension(300, 500));

        // positionnement du comboBoxCategorie
        spl1.putConstraint(SpringLayout.NORTH, labelCategorie, 30, SpringLayout.NORTH, panelTmp);
        spl1.putConstraint(SpringLayout.WEST, labelCategorie, 110, SpringLayout.WEST, panelTmp);

        //positionnement du label categorie
        spl1.putConstraint(SpringLayout.NORTH, this.comboBoxCategorie, 5, SpringLayout.SOUTH, labelCategorie);
        spl1.putConstraint(SpringLayout.WEST, this.comboBoxCategorie, 50, SpringLayout.WEST, panelTmp);

        //
        spl1.putConstraint(SpringLayout.NORTH, this.comboBoxOrganisation, 5, SpringLayout.SOUTH, labelOrganisation);
        spl1.putConstraint(SpringLayout.WEST, this.comboBoxOrganisation, 50, SpringLayout.WEST, panelTmp);

        //positionnement du label organisation
        spl1.putConstraint(SpringLayout.NORTH, labelOrganisation, 10, SpringLayout.SOUTH, comboBoxCategorie);
        spl1.putConstraint(SpringLayout.WEST, labelOrganisation, 127, SpringLayout.WEST, panelTmp);


        //--------------AJOUT DES COMPOSANTS-----------------

        //Ajout des composants dans le panel  panelTmp et le panel gauche

        panelTmp.add(labelOrganisation);
        panelTmp.add(this.comboBoxCategorie);
        panelTmp.add(labelCategorie);
        panelTmp.add(this.comboBoxOrganisation);
        panelGauche.add(panelTmp);

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
                , {"1", "Laptop2", "18/12/2003", "18/12/2024"},
                {"1", "Laptop2", "18/12/2003", "18/12/2024"},{"1", "Laptop2", "18/12/2003", "18/12/2024"}};
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
        splitPane.setDividerLocation(250);//ajustement de la position verticale du separateur



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
        // creation des items du menu gestion
        JMenuItem itemAjoutCategorie = new JMenuItem("Ajouter categorie");


        // ------------------CONFIGURATION-------------------
        //ajustement de la taille de la barre du menu
        this.barMenu.setPreferredSize(new Dimension(100,29));




        // --------------AJOUT DANS LA FENETRE----------------
        // AJout des items du menu gestion
        menuGestion.add(itemAjoutCategorie);
        // Ajout des menus Sdans la barre de nenu
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
