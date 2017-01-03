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
  String codePostal;
  String ville;
  String telPortable;

  @ManyToOne
  Club club;
}
