package com.preact.preactandroid.model;

import java.util.Map;

/**
 * The EventModel class represents a person associated with an event to be
 * logged.
 */
public class EventModel {

	private String source;
	private String target_id;
	private String name;
	private String note;
	private Float revenue;
	private AccountModel account;
	private ActionLinkModel[] links;
	private Map<String, Object> extras;

	/**
	 * Default constructor.
	 */
	public EventModel() {
	}

	/**
	 * Getters and setters.
	 */
	public String getTarget_id() {
		return target_id;
	}

	public void setTarget_id(String target_id) {
		this.target_id = target_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Float getRevenue() {
		return revenue;
	}

	public void setRevenue(Float revenue) {
		this.revenue = revenue;
	}

	public AccountModel getAccount() {
		return account;
	}

	public void setAccount(AccountModel account) {
		this.account = account;
	}

	public ActionLinkModel[] getLinks() {
		return links;
	}

	public void setLinks(ActionLinkModel[] links) {
		this.links = links;
	}

	public Map<String, Object> getExtras() {
		return extras;
	}

	public void setExtras(Map<String, Object> extras) {
		this.extras = extras;
	}

	@Override
	public String toString() {
		return "EventModel [source=" + source + ", target_id=" + target_id
				+ ", name=" + name + ", revenue=" + revenue + ", extras="
				+ extras + "]";
	}

}