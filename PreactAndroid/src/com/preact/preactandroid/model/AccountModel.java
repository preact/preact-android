package com.preact.preactandroid.model;

/**
 * The AccountModel class represents an account associated with an event to be
 * logged.
 */
public class AccountModel {

	private String id;
	private String name;

	/**
	 * Default constructor.
	 */
	public AccountModel() {
	}

	/**
	 * Getters and setters.
	 */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "AccountModel [id=" + id + ", name=" + name + "]";
	}

}