package com.dtech.web.template.email;

import com.dtech.web.template.pattern.Observer;

public class EmailObserver  implements Observer {

	//email service to send email
	
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
