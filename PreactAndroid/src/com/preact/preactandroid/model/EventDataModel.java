package com.preact.preactandroid.model;

import com.google.gson.Gson;

/**
 * The EventDataModel class represents an account associated with an event to be
 * logged.
 */
public class EventDataModel {

	private EventModel event;
	private PersonModel person;

	/**
	 * Default Constructor.
	 */
	public EventDataModel() {
	}

	/**
	 * Constructor.
	 */
	public EventDataModel(EventModel event, PersonModel person) {
		this.event = event;
		this.person = person;
	}

	/**
	 * Getters and setters.
	 */
	public EventModel getEvent() {
		return event;
	}

	public void setEvent(EventModel event) {
		this.event = event;
	}

	public PersonModel getPerson() {
		return person;
	}

	public void setPerson(PersonModel person) {
		this.person = person;
	}

	public String getJSONString() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}

	@Override
	public String toString() {
		return "EventDataModel [event=" + event + ", person=" + person + "]";
	}

}