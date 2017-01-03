package fr.eservices.sample2.appl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import fr.eservices.sample2.api.Greeter;
import fr.eservices.sample2.api.Welcome;
import fr.eservices.sample2.api.Printer;

@Configuration
@ComponentScan(value="fr.eservices.sample2.impl")
public class Application {

	@Autowired
	@Qualifier("welcome")
	Welcome welcome;
	@Autowired
	@Qualifier("greeter")
	Greeter greeter;
	@Autowired
	@Qualifier("printer")
	Printer printer;
	

	public Application() {
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
