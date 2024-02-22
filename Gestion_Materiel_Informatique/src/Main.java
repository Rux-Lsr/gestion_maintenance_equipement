import javax.swing.UIManager;

import ict.view.FenetreAjoutMateriel;
import ict.view.FenetrePrincipale;
import ict.view.InfoMateriel;

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
        FenetrePrincipale fenetrePrincipale = new FenetrePrincipale();
        fenetrePrincipale.showFenetre();

    }
}