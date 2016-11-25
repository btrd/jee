package fr.eservices.soaring.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Reservation {
	@Id
	@ManyToOne
    @JoinColumn(name = "pilote_id")
	Pilote pilote;
	@Id
	@ManyToOne
    @JoinColumn(name = "repas_id")
	Repas repas;
	int nbPersonnes;
}
