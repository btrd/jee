package fr.eservices.soaring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Epreuve {
	public enum Status {
		PREVU,
		ANNULE,
		PROVISOIRE,
		NON_OFFICIEL,
		OFFICIEL
	}
	public enum Type {
		AAT,
		AST
	}

	@Id
	@GeneratedValue
	int id;

	String jour;
	Status status;
	Type type;
}