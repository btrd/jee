package fr.eservices.sample2.impl;

import org.springframework.stereotype.Component;

import fr.eservices.sample2.api.Printer;

@Component
public class ConsolePrinter implements Printer {
	
	@Override
	public void print(String message) {
		new fr.eservices.sample1.Printer().print(message);
	}

}
