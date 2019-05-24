package com.dtech.web.template.email;

import java.util.ArrayList;
import java.util.List;

import com.dtech.web.template.pattern.Observer;
import com.dtech.web.template.pattern.Subject;

import lombok.Data;

@Data
public class ContentPublisher implements Subject {

	private int count;
	
	private String message;
	
	private List<Observer> observers;
	
	public ContentPublisher() {
		observers = new ArrayList<Observer>();
	}
	
	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void unregisterObserver(Observer o) {
		observers.remove(o);
	}

	@Override
	public void notifyObservers() {
		observers.stream().forEach(o -> o.update(count, message));
	}
	
	public void dataChanged() {
		//use a service to get the count failureCountService.getCount();
		count = 1;
		message = "failed " + count + "  times";
		
		notifyObservers();
	}
}
