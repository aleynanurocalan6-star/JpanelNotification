package addnotification;

import model.Critical;
import model.Notification;
import ui.NotificationController;

public class AddNotificationController {
	private AddNotificationView view;
	private NotificationController controller;

	public AddNotificationController(NotificationController controller) {
		this.controller = controller;
		this.view = new AddNotificationView(this);
	}

	public void addNotificationWithEnum(String message, Critical status) {

		Notification notification = new Notification(message, status);

		controller.addNotification(notification);

		controller.filter();
	}

	public AddNotificationView getView() {
		return view;
	}
}