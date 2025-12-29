package addnotification;

import java.util.function.Consumer;

import javax.swing.JOptionPane;

import model.Critical;
import model.Notification;

public class AddNotificationController {

	private Consumer<Notification> btnConsumer;
	private AddNotificationPanel view;

	public AddNotificationController(Consumer<Notification> btnConsumer) {
		this.btnConsumer = btnConsumer;
		initView();
	}

	private void initView() {
		this.view = new AddNotificationPanel();

		view.getAddButton().addActionListener(e -> {
			Notification notification = createNotificationFromPanel();
			if (notification != null && btnConsumer != null) {
				btnConsumer.accept(notification);
				view.getTextField().setText("");
			}
		});

		view.getBtnFetch().addActionListener(e -> {
			try {
				int id = Integer.parseInt(view.getTxtUpdateId().getText());

				JOptionPane.showMessageDialog(view, id + " ID bildirim aranıyor");
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(view, " sayısal ID girin");
			}
		});

		view.getBtnUpdate().addActionListener(e -> {
			String newMessage = view.getTxtUpdateMessage().getText().trim();
			if (!newMessage.isEmpty()) {

				btnConsumer.accept(null);
				JOptionPane.showMessageDialog(view, "Bildirim Güncellendi");
			} else {
				JOptionPane.showMessageDialog(view, "Yeni mesaj boş olamaz");
			}
		});
	}

	private Notification createNotificationFromPanel() {
		Notification notification = null;
		String notificationText = view.getTextField().getText().trim();
		Critical criticalValue = (Critical) view.getCriticalComboBox().getSelectedItem();

		if (!notificationText.isEmpty()) {
			notification = new Notification(notificationText, criticalValue);
		} else {
			JOptionPane.showMessageDialog(view, " bir mesaj yazın");
		}
		return notification;
	}

	public AddNotificationPanel getView() {
		return view;
	}
}