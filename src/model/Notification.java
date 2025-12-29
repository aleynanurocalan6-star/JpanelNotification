package model;

import java.time.LocalDateTime;

public class Notification {

	private static int totalID = 0;

	private String message;
	private boolean read = false;
	private Critical critical;
	private LocalDateTime time = LocalDateTime.now();
	private boolean pinned = false;
	private int id;

	public Notification(String message, Critical critical) {
		this.message = message;
		this.critical = critical;
		id = totalID++;

	}

	public Notification(String message) {

		this(message, Critical.WARNING);

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
