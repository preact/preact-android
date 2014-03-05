package com.preact.preactandroid.model;

import java.util.Map;

/**
 * The PersonModel class represents a person associated with an event to be
 * logged.
 */
public class PersonModel {

	private String email;
	private String name;
	private String created_at;
	private String uid;
	private Map<String, Object> properties;

	/**
	 * Default constructor.
	 */
	public PersonModel() {
	}

	/**
	 * Copy constructor.
	 */
	public PersonModel(PersonModel other) {
		this.email = other.email;
		this.name = other.name;
		this.created_at = other.created_at;
		this.uid = other.uid;
		this.properties = other.properties;
	}

	/**
	 * Getters and setters.
	 */
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Map<String, Object> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, Object> properties) {
		this.properties = properties;
	}

	@Override
	public String toString() {
		return "PersonModel [email=" + email + ", name=" + name
				+ ", created_at=" + created_at + ", uid=" + uid
				+ ", properties=" + properties + "]";
	}

}