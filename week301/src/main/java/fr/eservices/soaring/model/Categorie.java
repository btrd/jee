package fr.eservices.soaring.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class Categorie {
	@Id
	@GeneratedValue
	int id;
	
	String titre;
}
