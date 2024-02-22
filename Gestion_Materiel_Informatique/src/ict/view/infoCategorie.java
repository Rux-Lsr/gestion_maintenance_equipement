import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
public class demo1 extends JFrame {

    private Button boutton_annuler;
    private Button boutton_valider;
    private JTextArea champ_description_categorie;
    private JTextField champ_nom_categorie;
    private JPanel container;
    private JPanel formulaire;
    private JLabel nom;
    private JLabel nom1;
    private JScrollPane scroller_description;
    private JLabel titleForm;

    public demo1() {
        initComponents();
    }
    private void initComponents() {

        container = new JPanel();
        formulaire = new JPanel();
        titleForm = new JLabel();
        nom = new JLabel();
        champ_nom_categorie = new JTextField();
        nom1 = new JLabel();
        scroller_description = new JScrollPane();
        champ_description_categorie = new JTextArea();
        boutton_valider = new Button();
        boutton_annuler = new Button();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new Dimension(500, 400));

        container.setBackground(new Color(175, 216, 199));

        TitledBorder bordure = BorderFactory.createTitledBorder("ENREGISTREMENT CATEGORIE");
        formulaire.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        formulaire.setBorder(bordure);
        formulaire.setBackground(new Color(65, 133, 104));

        titleForm.setFont(new Font("Arial ", 1, 14)); // NOI18N

        nom.setFont(new Font("Arial Black", 0, 14)); // NOI18N
        nom.setText("Nom de la categorie:");

        champ_nom_categorie.setToolTipText("");

        nom1.setFont(new Font("Arial Black", 0, 14)); // NOI18N
        nom1.setText("Description de la categorie : ");

        champ_description_categorie.setColumns(20);
        champ_description_categorie.setRows(5);
        scroller_description.setViewportView(champ_description_categorie);

        boutton_valider.setActionCommand("Valider");
        boutton_valider.setFont(new Font("Arial", 0, 14)); // NOI18N
        boutton_valider.setLabel("Valider");
            

        boutton_annuler.setActionCommand("Valider");
        boutton_annuler.setFont(new Font("Arial", 0, 14)); // NOI18N
        boutton_annuler.setLabel("Annuler");

        GroupLayout formulaireLayout = new GroupLayout(formulaire);
        formulaire.setLayout(formulaireLayout);
        formulaireLayout.setHorizontalGroup(
            formulaireLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(formulaireLayout.createSequentialGroup()
                .addComponent(titleForm)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(formulaireLayout.createSequentialGroup()
                .addGroup(formulaireLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(formulaireLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(formulaireLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(nom)
                            .addComponent(nom1))
                        .addGap(29, 29, 29)
                        .addGroup(formulaireLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(champ_nom_categorie)
                            .addComponent(scroller_description, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)))
                    .addGroup(formulaireLayout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(boutton_valider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(126, 126, 126)
                        .addComponent(boutton_annuler, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(166, Short.MAX_VALUE))
        );
        formulaireLayout.setVerticalGroup(
            formulaireLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(formulaireLayout.createSequentialGroup()
                .addComponent(titleForm)
                .addGap(46, 46, 46)
                .addGroup(formulaireLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(champ_nom_categorie, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                    .addComponent(nom))
                .addGroup(formulaireLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(formulaireLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(scroller_description, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(formulaireLayout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(nom1)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(formulaireLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(boutton_valider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(boutton_annuler, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        boutton_valider.getAccessibleContext().setAccessibleName("Valider");

        GroupLayout containerLayout = new GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, containerLayout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(formulaire, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(formulaire, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(container, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(container, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }
    public static void main(String args[]) {
       new demo1().setVisible(true);
    }

   
}
