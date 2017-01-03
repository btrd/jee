package fr.eservices.sample1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(value="fr.eservices.sample1")
public class Application {
	
	@Autowired
	Greeter greeter;
	@Autowired
	Printer printer;
	@Autowired
	Welcome welcome;
	
	public Application() {
		
		// TODO: First. Initialize properties. 
	}
	
	public void run() {
		String name = welcome.askName();
		String response = greeter.hello(name);
		printer.print( response );
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Application.class);
		Application app = ctx.getBean(Application.class);
		app.run();
	}

}
