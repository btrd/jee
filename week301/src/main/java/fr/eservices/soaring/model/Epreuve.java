package fr.eservices.soaring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import fr.eservices.soaring.model.Status;
import fr.eservices.soaring.model.Type;

@Entity
public class Epreuve {

	@Id
	@GeneratedValue
	int id;

	String jour;
	Status status;
	Type type;
}
