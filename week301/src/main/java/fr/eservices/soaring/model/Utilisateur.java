package fr.eservices.soaring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Utilisateur {
  @Id
  @GeneratedValue
  int id;
  
  String identifiant;
  String motDePasse;
  String nom;
  String prenom;
}
