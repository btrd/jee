package fr.eservices.soaring.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;

@Entity
@Inheritance
public class Repas{
  @Id
  @GeneratedValue
  int id;

  Date date;
  String heure;
  String menu;
}
