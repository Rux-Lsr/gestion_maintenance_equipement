import javax.swing.UIManager;


import ict.view.*;

public class Main
{
    public static void main(String[] args)
    {
        //changement de style
        try
        {
            int i = 0;
            for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
            {
                if(i == 1)
                {
                    System.out.println(info.getName());
                    UIManager.setLookAndFeel(info.getClassName());
                }
                i++;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        /*String[] tab = {"Ordinateur", "Climatiseur", "Cables reseaux"};
        InfoMateriel info;

        System.out.println("Hello world!");
        FenetreAjoutMateriel fenetreAjoutMateriel = new FenetreAjoutMateriel(null, tab, true);
        info = fenetreAjoutMateriel.showFenetre();

        if(info == null)
        {
            System.out.println("null");
        }
        else
        {
            System.out.println(info.getCategorieMateriel());
        }*/


    }
}