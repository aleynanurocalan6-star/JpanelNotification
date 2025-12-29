package line;

import java.awt.Color;
import java.util.function.Consumer;

import model.Notification;

public class NotificationLineController {

	private Notification notification;
	private NotificationLinePanel view;
	private Consumer<Notification> refreshAction;

	public NotificationLineController(Notification notification, Consumer<Notification> refreshAction) {
		this.notification = notification;
		this.refreshAction = refreshAction;
		initView();
	}

	private void initView() {
		view = new NotificationLinePanel();

		setupDisplay();

		view.getBtnRead().addActionListener(e -> {

			notification.setRead(true);
			view.getBtnRead().setEnabled(false);

			if (refreshAction != null) {

				refreshAction.accept(notification);
			}
		});

		view.getBtnPinned().addActionListener(e -> {

			notification.setPinned(true);

			if (refreshAction != null) {

				refreshAction.accept(notification);
			}

			updatePinned();
		});
	}

	private void setupDisplay() {

		view.getLblMessage().setText(notification.getMessage() + " " + notification.getCritical().name());
		view.getLblTimestamp().setText(notification.getTime().toString());

		if (notification.isPinned()) {
			updatePinned();
		}
	}

	private void updatePinned() {
		view.getBtnPinned().setText("Pinned");
		view.getBtnPinned().setEnabled(false);

		view.setBackground(new Color(255, 250, 205));
		view.revalidate();
		view.repaint();
	}

	public NotificationLinePanel getView() {
		return view;
	}
}