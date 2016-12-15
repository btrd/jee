package fr.eservices.sample2.impl;

import org.springframework.stereotype.Component;

import fr.eservices.sample2.api.Greeter;

@Component
public class EnglishGreeter implements Greeter {
	
	@Override
	public String hello(String name) {
		return new fr.eservices.sample1.Greeter().hello(name);
	}

}
