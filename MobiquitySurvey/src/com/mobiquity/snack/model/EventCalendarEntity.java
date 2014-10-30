package com.mobiquity.snack.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EVENT_CALENDAR")
public class EventCalendarEntity {

	@Id
	@GeneratedValue
	@Column(name = "event_id")
	private long eventID;

	@Column(name = "event_name")
	private String eventName;

	@Column(name = "event_date")
	private Date eventDate;

	@OneToOne
	@JoinColumn(name = "USER_ID")
	private UserEntity userId;

	public long getEventID() {
		return eventID;
	}

	public void setEventID(long eventID) {
		this.eventID = eventID;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public UserEntity getUserId() {
		return userId;
	}

	public void setUserId(UserEntity userId) {
		this.userId = userId;
	}

}
