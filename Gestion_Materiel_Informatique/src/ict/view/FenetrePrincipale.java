package ict.view;

import javax.swing.*;


//constructeur
public class FenetrePrincipale extends JFrame
{
    private JMenuBar barMenu;
    private JToolBar barOutil;
    private JTable tableOUtil;
    private JButton boutonAjoutMateriel;
    private JButton boutonSupprimeMateriel;
    private JButton boutonEditMateriel;


    private void initBarreMenu()
    {
        // Creationde la barre de menu
        this.barMenu = new JMenuBar();
        // Creationdes des differents menus
        JMenu menuFichier = new JMenu("Fichier");
        JMenu menuGestion = new JMenu("Gestion");
        JMenu menuAides = new JMenu("Aides");

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
    }
}
