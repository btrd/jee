package fr.eservices.soaring.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class Club {
	@Id
	@GeneratedValue
	int id;
	
	String ville;
	String nom;
}
