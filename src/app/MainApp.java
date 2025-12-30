package app;

import javax.swing.JFrame;

import addnotification.AddNotificationController;
import model.Critical;
import model.Notification;
import ui.NotificationController;

public class MainApp {

	public static void main(String[] args) {

		NotificationController controller = new NotificationController();

		Notification n1 = new Notification("Yeni bildirim 1");

		Notification n2 = new Notification("Sistem merhaba");

		Notification n3 = new Notification("Güncelleme ödev");

		Notification n4 = new Notification("Kritik ödev", Critical.CRITICAL);

		controller.addNotification(n1);

		controller.addNotification(n2);

		controller.addNotification(n3);

		controller.addNotification(n4);

		controller.filter();

		AddNotificationController addController = new AddNotificationController((n) -> {

			controller.addNotification(n);

			controller.filter();

		}, null);

		JFrame frame = new JFrame("Bildirim Yönetim Sistemi");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setSize(700, 500);

		frame.add(controller.getView());

		frame.setLocationRelativeTo(null);

		frame.setVisible(true);

		JFrame addFrame = new JFrame(" Bildirim Ekle");

		addFrame.setSize(600, 250);

		addFrame.add(addController.getView());

		addFrame.setLocation(100, 100);

		addFrame.setVisible(true);

	}

}