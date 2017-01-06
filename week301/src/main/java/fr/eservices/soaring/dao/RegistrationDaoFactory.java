package fr.eservices.soaring.dao;

public class RegistrationDaoFactory {

	public static RegistrationDao createRegistrationDao() {
		RegistrationJpa regDao = new RegistrationJpa();
		return regDao;
	}
	
}
