package ict.model;
import java.util.Date;

public  class Maintenance {
    
    private int id_maintenance;
    private Date date_maintenance = new Date();
    private String observation_maintenance;
    private Boolean est_effectuer_maintenance;
    private int id_materiel;

    // SETER
    public void setId_maintenance(int id_maintenance)
    {
        this.id_maintenance = id_maintenance;
    }

    public void setDate_maintenance(Date date_maintenance)
    {
        this.date_maintenance = date_maintenance;
    }

    public void setObservation_maintenance(String observation_maintenance)
    {
        this.observation_maintenance = observation_maintenance;
    }

    public void setEst_effectuer_maintenance(Boolean est_effectuer_maintenance)
    {
        this.est_effectuer_maintenance = est_effectuer_maintenance;
    }

    // GETER
    public void setId_materiel(int id_materiel)
    {
        this.id_materiel = id_materiel;
    }

    public int getId_maintenance()
    {
        return id_maintenance;
    }

    public Date getDate_maintenance()
    {
        return date_maintenance;
    }

    public String getObservation_maintenance()
    {
        return observation_maintenance;
    }

    public Boolean getEst_effectuer_maintenance()
    {
        return est_effectuer_maintenance;
    }

    public int getId_materiel()
    {
        return id_materiel;
    }

    // CONSTRUCTEUR
    public Maintenance(int id_maintenance, Date date_maintenance, String observation_maintenance
            , Boolean est_effectuer_maintenance, int id_materiel)
    {
        this.id_maintenance = id_maintenance;
        this.date_maintenance = date_maintenance;
        this.observation_maintenance = observation_maintenance;
        this.est_effectuer_maintenance = est_effectuer_maintenance;
        this.id_materiel = id_materiel;
    }

}
