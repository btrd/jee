package fr.eservices.sample2.impl;

import javax.swing.JOptionPane;

import fr.eservices.sample2.api.Welcome;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("swing")
public class SwingWelcome implements Welcome {

	@Override
	public String askName() {
		return JOptionPane.showInputDialog(null, "What is your name", "Welcome", JOptionPane.QUESTION_MESSAGE);
	}
}
