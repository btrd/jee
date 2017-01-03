package fr.eservices.soaring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PointPassage {
  @Id
  @GeneratedValue
  int id;

  String nom;
  int lattitude;
  int longitude;
  String description;
}
