package fr.eservices.soaring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Club {
	@Id
	@GeneratedValue
	int id;
	
	String ville;
	String nom;
	
	@ManyToOne
	Region region;
}
