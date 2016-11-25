package fr.eservices.soaring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Reservation {
  @Id
  @GeneratedValue
  int id;
  
  int nbPersonnes;
}
