package com.preact.preactandroid.model;

/**
 * The PersonModel class represents a person associated with an event
 * to be logged.
 */
public class ActionLinkModel {
	
	private String name;
	private String href;

	/**
	 * Default constructor.
	 */
	public ActionLinkModel() {
	}

	/**
	 * Constructor
	 * @param name
	 * @param href
	 */
	public ActionLinkModel(String name, String href) {
		this.name = name;
		this.href = href;
	}
	
	/**
	 * Getters and setters.
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}
	
	@Override
	public String toString() {
		return "ActionLinkModel [name=" + name + ", href=" + href + "]";
	}

}