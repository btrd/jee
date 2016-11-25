package fr.eservices.soaring.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Pilote {
  @Id
  @GeneratedValue
  int id;
  
  String nom;
  String prenom;
  Date dateNaissance;
  String adresse;
  int codePostal;
  String ville;
  int telPortable;
  
  @ManyToOne
  Club club;
}
