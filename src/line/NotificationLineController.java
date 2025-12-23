package line;

import model.Notification;

public class NotificationLineController {

	private Notification notification;
	private NotificationLinePanel view;

	public NotificationLineController(Notification notification) {

		this.notification = notification;

		initView();
	}

	private void initView() {

		view = new NotificationLinePanel();
		view.getLblMessage().setText(notification.getMessage());
		view.getLblTimestamp().setText(notification.getTime().toString());
		view.getBtnRead().addActionListener(e -> {

			notification.setRead(true);
			view.getBtnRead().setEnabled(false);

			System.out.println("Bildirim okundu olarak işaretlendi: " + notification.getMessage());
		});
	}

	public NotificationLinePanel getView() {
		return view;
	}
}
