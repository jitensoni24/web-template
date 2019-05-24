package com.dtech.web.template.email;

import com.dtech.web.template.pattern.Observer;

public class DatabaseObserver implements Observer {

	//jdbc template to store data in database if an update is called
	
	@Override
	public void update(int count, String message) {
		String string = "Log counter : " + count + " and message " + message;
		displayMessage(string);
		//jdbc.update(string) in the database
	}

	private void displayMessage(String string) {
		System.out.println("Class :: " + this.getClass().getSimpleName() + " Message:: " + string);
	}
}
