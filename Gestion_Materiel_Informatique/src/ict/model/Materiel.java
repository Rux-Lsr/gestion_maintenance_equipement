package ict.model;
import java.time.LocalDate;
import java.util.Date;

public class Materiel
{
   private String nom_materiel;
   private String description_materiel;
   private int id_materiel;
   private int id_categorie;
   private LocalDate date_acquisition_materiel;

   public Materiel(String nom_materiel, String description_materiel, int id_materiel, int id_categorie
           , LocalDate date_acquisition_materiel)
   {
      this.nom_materiel = nom_materiel;
      this.description_materiel = description_materiel;
      this.id_materiel = id_materiel;
      this.id_categorie = id_categorie;
      this.date_acquisition_materiel = date_acquisition_materiel;
   }

   // Geter
   public String getNom_materiel() {
      return nom_materiel;
   }

   public String getDescription_materiel() {
      return description_materiel;
   }

   public int getId_materiel() {
      return id_materiel;
   }

   public int getId_categorie() {
      return id_categorie;
   }

   public LocalDate getDate_acquisition_materiel() {
      return date_acquisition_materiel;
   }

   // SETER

   public void setNom_materiel(String nom_materiel) {
      this.nom_materiel = nom_materiel;
   }

   public void setDescription_materiel(String description_materiel) {
      this.description_materiel = description_materiel;
   }

   public void setId_materiel(int id_materiel) {
      this.id_materiel = id_materiel;
   }

   public void setId_categorie(int id_categorie) {
      this.id_categorie = id_categorie;
   }

   public void setDate_acquisition_materiel(LocalDate date_acquisition_materiel) {
      this.date_acquisition_materiel = date_acquisition_materiel;
   }
}