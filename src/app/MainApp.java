package app;

import javax.swing.JFrame;

import addnotification.AddNotificationController;
import model.Critical;
import model.Notification;
import ui.NotificationController;

public class MainApp {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Bildirim Yönetim Sistemi");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 500);

		NotificationController controller = new NotificationController();

		Notification n1 = new Notification("Yeni bildirim 1");
		Notification n2 = new Notification("Sistem merhaba");
		Notification n3 = new Notification("Güncelleme ödev");
		Notification n4 = new Notification("Kritik ödev", Critical.CRITICAL);
		Notification n5 = new Notification("YAMAN ULAŞ BOZ♥", Critical.CRITICAL);

		controller.addNotification(n1);
		controller.addNotification(n2);
		controller.addNotification(n3);
		controller.addNotification(n4);
		controller.addNotification(n5);

		controller.filter();
		AddNotificationController addController = new AddNotificationController(controller);
		JFrame addFrame = new JFrame(" Bildirim Ekle");
		addFrame.setSize(600, 150);
		addFrame.add(addController.getView());
		addFrame.setLocation(100, 100);
		addFrame.setVisible(true);

		frame.add(controller.getView());

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}