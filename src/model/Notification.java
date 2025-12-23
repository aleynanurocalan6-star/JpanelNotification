package model;

import java.time.LocalDateTime;

public class Notification {

	private String message;
	private boolean read = false;
	private Critical critical;
	private LocalDateTime time = LocalDateTime.now();

	// Constructor
	public Notification(String message, Critical critical) {
		this.message = message;
		this.critical = critical;
	}

	public Notification(String message) {
		this.message = message;
		this.critical = Critical.WARNING;
	}

	// GETTER'lar
	public String getMessage() {
		return message;
	}

	public boolean isRead() {
		return read;
	}

	public Critical getCritical() {
		return critical;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setRead(boolean read) {
		this.read = read;
	}
}
