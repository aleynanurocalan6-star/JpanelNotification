package model;

import java.util.Comparator;

public enum SortKeys {

	DATE("Zaman", new Comparator<Notification>() {

		@Override
		public int compare(Notification o1, Notification o2) {

			return o1.getTime().compareTo(o2.getTime());
		}

	}), STATUS("Öncelik (C->W)", new Comparator<Notification>() {

		@Override
		public int compare(Notification o1, Notification o2) {

			Critical critical1 = o1.getCritical();
			Critical critical2 = o2.getCritical();

			if (critical1 == critical2) {

				return o1.getTime().compareTo(o2.getTime());

			} else if (critical1 == Critical.CRITICAL && critical2 == Critical.WARNING) {

				return -1;

			} else if (critical1 == Critical.WARNING && critical2 == Critical.CRITICAL) {

				return 1;

			} else {

				return 0;
			}

		}

	}), ALPHABETIC("Alfabetik(A - Z)", new Comparator<Notification>() {

		@Override
		public int compare(Notification o1, Notification o2) {

			return o1.getMessage().compareTo(o2.getMessage());
		}

	});

	private String screenText;
	private Comparator<Notification> comparator;

	SortKeys(String screentText, Comparator<Notification> comparator) {

		this.screenText = screentText;
		this.comparator = comparator;

	}

	public String getScreenText() {
		return screenText;
	}

	public Comparator<Notification> getComparator() {
		return comparator;
	}

}
