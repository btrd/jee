package fr.eservices.soaring.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Repas {
  @Id
  @GeneratedValue
  int id;
  
  Date date;
  int heure;
  String menu;
}
