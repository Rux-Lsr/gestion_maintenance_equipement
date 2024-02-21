package ict.view;

import java.time.LocalDate;

public class InfoMateriel
{
    private String nomMateriel;
    private String CategorieMateriel;
    private LocalDate dateAcquisition;
    private int NbMoisAvantProchainMaintenace;
    private String descriptionMateriel;



    public String getNomMateriel()
    {
        return nomMateriel;
    }

    public String getCategorieMateriel()
    {
        return CategorieMateriel;
    }

    public LocalDate getDateAcquisition()
    {
        return dateAcquisition;
    }

    public int getNbMoisAvantProchainMaintenace()
    {
        return NbMoisAvantProchainMaintenace;
    }

    public String getDescriptionMateriel()
    {
        return descriptionMateriel;
    }


    //CONSTRUCTEUR
    public InfoMateriel(String nom, String categorie, LocalDate dateAc,int nbMoisAPM, String description)
    {
        this.nomMateriel = nom;
        this.CategorieMateriel = categorie;
        this.dateAcquisition = dateAc;
        this.NbMoisAvantProchainMaintenace = nbMoisAPM;
        this.descriptionMateriel = description;
    }
}
