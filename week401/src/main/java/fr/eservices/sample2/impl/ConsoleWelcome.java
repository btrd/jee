package fr.eservices.sample2.impl;

import org.springframework.stereotype.Component;

import fr.eservices.sample2.api.Welcome;

@Component
public class ConsoleWelcome implements Welcome {

	@Override
	public String askName() {
		return new fr.eservices.sample1.Welcome().askName();
	}
	
}
