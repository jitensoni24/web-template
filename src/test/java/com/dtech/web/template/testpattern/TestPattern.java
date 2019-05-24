package com.dtech.web.template.testpattern;

import com.dtech.web.template.email.ContentPublisher;
import com.dtech.web.template.email.DatabaseObserver;
import com.dtech.web.template.email.EmailObserver;

public class TestPattern {
	public static void main(String[] args) {
		DatabaseObserver dbo = new DatabaseObserver();
		EmailObserver eo = new EmailObserver();
		ContentPublisher cp = new ContentPublisher();
		cp.registerObserver(dbo);
		cp.registerObserver(eo);
		
		cp.dataChanged();
		
		cp.dataChanged();
		
		cp.dataChanged();
	}
}
