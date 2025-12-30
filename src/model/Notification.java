package model;

import java.time.LocalDateTime;

public class Notification {
	private static int totalID = 0;
	private int id;
	private String message;
	private boolean read = false;
	private Critical critical;
	private LocalDateTime time = LocalDateTime.now();
	private boolean pinned = false;

	public Notification(String message, Critical critical) {
		this.message = message;
		this.critical = critical;
		this.id = totalID++;
	}

	public Notification(String message) {
		this(message, Critical.WARNING);
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setCritical(Critical critical) {
		this.critical = critical;
	}

	public String getMessage() {
		return message;
	}

	public int getId() {
		return id;
	}

	public boolean isPinned() {
		return pinned;
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

	public void setPinned(boolean pinned) {
		this.pinned = pinned;
	}
}