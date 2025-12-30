package addnotification;

import java.util.List;
import java.util.function.Consumer;

import javax.swing.JOptionPane;

import model.Critical;
import model.Notification;

public class AddNotificationController {

	private Consumer<Notification> btnConsumer;

	private AddNotificationPanel view;
	private List<Notification> notificationList;
	private Notification newNotification;

	public AddNotificationController(Consumer<Notification> btnConsumer, List<Notification> notificationLis) {

		this.btnConsumer = btnConsumer;
		this.notificationList = notificationList;

		this.view = new AddNotificationPanel();

		initController();

	}

	private void initController() {

		view.getRbAddMode().addActionListener(e -> {

			view.getPnlId().setVisible(false);

			view.getAddButton().setVisible(true);

			view.getBtnUpdate().setVisible(false);

			view.revalidate();

			view.repaint();

		});

		view.getRbUpdateMode().addActionListener(e -> {

			view.getPnlId().setVisible(true);

			view.getAddButton().setVisible(false);

			view.getBtnUpdate().setVisible(true);

			view.revalidate();

			view.repaint();

		});

		view.getAddButton().addActionListener(e -> {

			String mesaj = view.getTextField().getText().trim();

			Critical durum = (Critical) view.getCriticalComboBox().getSelectedItem();

			if (mesaj.isEmpty()) {

				JOptionPane.showMessageDialog(view, "Mesaj boş olamaz");

			} else {

				Notification n = new Notification(mesaj, durum);

				btnConsumer.accept(n);

				view.getTextField().setText("");

				JOptionPane.showMessageDialog(view, "Bildirim Eklendi");

			}

		});

		view.getBtnFetch().addActionListener(e -> {

			try {

				int id = Integer.parseInt(view.getTxtUpdateId().getText());

				JOptionPane.showMessageDialog(view, id + " ID aranıyo");

			} catch (NumberFormatException ex) {

				JOptionPane.showMessageDialog(view, "Sayısal ID gir");

			}

		});

		view.getBtnUpdate().addActionListener(e -> {

			String mesaj = view.getTextField().getText().trim();

			if (!mesaj.isEmpty()) {

				btnConsumer.accept(null);

				JOptionPane.showMessageDialog(view, "Bildirim Güncellendi");

			} else {

				JOptionPane.showMessageDialog(view, "Güncellemek için bir mesaj yazmalısınız!");

			}

		});

	}

	public AddNotificationPanel getView() {

		return view;

	}

}