package ict.model;
import java.time.LocalDate;
import java.util.Date;

public class Notification {
    
    private int id_notification;
    private int id_maintenance;
    private String description_notification;
    private LocalDate date_notification;

    // CONSTRUCTEUR
    public Notification(int id_notification, int id_maintenance, String description_notification,
                        LocalDate date_notification) {
        this.id_notification = id_notification;
        this.id_maintenance = id_maintenance;
        this.description_notification = description_notification;
        this.date_notification = date_notification;
    }


    // Geter
    public int getId_notification() {
        return id_notification;
    }

    public int getId_maintenance() {
        return id_maintenance;
    }

    public String getDescription_notification() {
        return description_notification;
    }

    public LocalDate getDate_notification() {
        return date_notification;
    }

    // SETER

    public void setId_notification(int id_notification)
    {
        this.id_notification = id_notification;
    }

    public void setId_maintenance(int id_maintenance)
    {
        this.id_maintenance = id_maintenance;
    }

    public void setDescription_notification(String description_notification)
    {
        this.description_notification = description_notification;
    }

    public void setDate_notification(LocalDate date_notification) {
        this.date_notification = date_notification;
    }
}
