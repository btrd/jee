package fr.eservices.soaring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Profil {
  @Id
  @GeneratedValue
  int id;
  
  String nom;
}
