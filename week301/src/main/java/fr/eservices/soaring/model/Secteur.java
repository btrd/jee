package fr.eservices.soaring.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Secteur implements Serializable {
	@Id
	@ManyToOne
    @JoinColumn(name = "epreuve_id")
	Epreuve epreuve;
	@Id
	@ManyToOne
    @JoinColumn(name = "pointPassage_id")
	PointPassage pointPassage;

	String rayon;
	String type;
}
