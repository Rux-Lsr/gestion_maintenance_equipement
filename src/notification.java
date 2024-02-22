import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Image;

public class notification extends JFrame {

    public notification() {
        super("Liste de notifications"); // Titre de la fenêtre
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fermeture de la fenêtre
        this.setSize(new Dimension(600, 300)); // Taille de la fenêtre
        this.setLocationRelativeTo(null); // Centrage de la fenêtre
        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.setLayout(new BorderLayout());

        // Création d'un modèle de liste pour contenir les notifications
        DefaultListModel<JPanel> listModel = new DefaultListModel<>();

        // Ajout de quelques notifications à la liste
        // Utilisation de getClass().getResource() pour charger les images à partir du chemin relatif
        listModel.addElement(createNotificationPanel("Notification 1", "logo1.png"));
        listModel.addElement(createNotificationPanel("Notification 2", "logo1.png"));
        listModel.addElement(createNotificationPanel("Notification 3", "logo1.png"));
        listModel.addElement(createNotificationPanel("Notification 4", "logo1.png"));

        // Création de la JList avec le modèle de liste
        JList<JPanel> notificationList = new JList<>(listModel);
        notificationList.setCellRenderer(new PanelListRenderer()); // Utilisation d'un renderer personnalisé

        // Ajout de la JList à un JScrollPane pour permettre le défilement si nécessaire
        JScrollPane scrollPane = new JScrollPane(notificationList);

        // Ajout du JScrollPane au centre du contenu de la fenêtre
        contentPane.add(scrollPane, BorderLayout.CENTER);

        // Ajout d'un ListSelectionListener pour gérer les clics sur les notifications
        notificationList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    // Obtenez l'index de la notification sélectionnée
                    int selectedIndex = notificationList.getSelectedIndex();
                    // Afficher les détails de la notification sélectionnée dans une nouvelle fenêtre
                    showNotificationDetails(selectedIndex);
                }
            }
        });
    }

    // Méthode pour créer un JPanel personnalisé pour chaque notification avec un logo
    private JPanel createNotificationPanel(String notificationText, String logoPath) {
        JPanel panel = new JPanel(new BorderLayout());
        // Utilisation de getClass().getResource() pour charger l'image à partir du chemin relatif
        ImageIcon icon = new ImageIcon(getClass().getResource(logoPath));
        // Redimensionner l'image à une taille spécifique
        Image img = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(img);
        JLabel logoLabel = new JLabel(resizedIcon);
        JLabel textLabel = new JLabel(notificationText);
        panel.add(logoLabel, BorderLayout.WEST);
        panel.add(textLabel, BorderLayout.CENTER);
        return panel;
    }

    // Méthode pour afficher les détails de la notification sélectionnée dans une nouvelle fenêtre
    private void showNotificationDetails(int selectedIndex) {
        // Création d'une nouvelle fenêtre pour afficher les détails
        JFrame detailsFrame = new JFrame("Détails de la notification");
        detailsFrame.setSize(300, 200);
        detailsFrame.setLocationRelativeTo(null);

        // Récupérer les détails de la notification en fonction de l'index sélectionné
        String[] details = getNotificationDetails(selectedIndex);

        // Création des composants pour afficher les détails
        JLabel nameLabel = new JLabel("Nom: " + details[0]);
        JLabel surnameLabel = new JLabel("Date de maintenanre: " + details[1]);
        JLabel descriptionLabel = new JLabel("Description: " + details[2]);

        // Ajout des composants à la fenêtre
        detailsFrame.setLayout(new GridLayout(3, 1));
        detailsFrame.add(nameLabel);
        detailsFrame.add(surnameLabel);
        detailsFrame.add(descriptionLabel);

        // Afficher la fenêtre
        detailsFrame.setVisible(true);

        // Ajouter un WindowListener pour fermer la fenêtre de détails lorsque la fenêtre principale est fermée
        detailsFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                detailsFrame.dispose();
            }
        });
    }

    // Méthode pour récupérer les détails de la notification en fonction de l'index sélectionné
    private String[] getNotificationDetails(int selectedIndex) {
        // Ici, vous pouvez implémenter la logique pour récupérer les détails de la notification en fonction de l'index
        // Pour cet exemple, nous utilisons des valeurs statiques
        String[] details = new String[3];
        details[0] = "Ordinateur";
        details[1] = "12/03/2024";
        details[2] = "Ceci est la description de la notification " + (selectedIndex + 1);
        return details;
    }

    // Renderer personnalisé pour centrer les éléments de la liste
    private class PanelListRenderer implements ListCellRenderer<JPanel> {
        @Override
        public Component getListCellRendererComponent(JList<? extends JPanel> list, JPanel value, int index, boolean isSelected, boolean cellHasFocus) {
            value.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Ajout d'une marge
            return value;
        }
    }

    public static void main(String[] args) {
        notification notification = new notification();
        notification.setVisible(true);
    }
}
