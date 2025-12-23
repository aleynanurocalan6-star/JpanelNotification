package ui;

import java.util.ArrayList;
import java.util.List;

import line.NotificationLineController;
import model.Critical;
import model.Notification;

public class NotificationController {

	private final List<Notification> notificationList;
	private NotificationPanel view;

	public NotificationController() {

		this.notificationList = new ArrayList<>();
		initView();
	}

	private void initView() {

		view = new NotificationPanel();
		initListeners();
	}

	private void initListeners() {

		view.getBtnSearch().addActionListener(e -> filter());

		view.getChkCritical().addActionListener(e -> filter());
		view.getChkWarning().addActionListener(e -> filter());
	}

	public void filter() {

		view.getPnlNotif().removeAll();

		String query = view.getTxtSearch().getText().toLowerCase();

		boolean criticalSelected = view.getChkCritical().isSelected();
		boolean warningSelected = view.getChkWarning().isSelected();

		for (Notification n : notificationList) {

			if ((n.getMessage().toLowerCase().contains(query))
					&& ((criticalSelected && n.getCritical() == Critical.CRITICAL)
							|| (warningSelected && n.getCritical() == Critical.WARNING))) {

				NotificationLineController lineController = new NotificationLineController(n);
				view.getPnlNotif().add(lineController.getView());
			}
		}

		view.getPnlNotif().revalidate();
		view.getPnlNotif().repaint();
	}

	public void addNotification(Notification notification) {

		notificationList.add(notification);
	}

	public void deleteNotification(Notification notification) {
		notificationList.remove(notification);

	}

	public void addNotification(List<Notification> notifications) {
		notificationList.addAll(notifications);

	}

	public NotificationPanel getView() {
		return view;
	}
}
