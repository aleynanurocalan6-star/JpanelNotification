package ui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import line.NotificationLineController;
import model.Critical;
import model.Notification;
import model.SortKeys;

public class NotificationController {

	private final List<Notification> notificationList;
	private NotificationPanel view;

	public NotificationController() {
		this.notificationList = new ArrayList<>();
		initView();
	}

	private void initView() {

		view = new NotificationPanel();

		initCmbBxSort();

		initListeners();
	}

	private void initCmbBxSort() {

		view.getCmbSort().setRenderer(new BasicComboBoxRenderer() {

			public java.awt.Component getListCellRendererComponent(javax.swing.JList<?> list, Object value, int index,
					boolean isSelected, boolean cellHasFocus) {

				JLabel lbl = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

				lbl.setText(((SortKeys) value).getScreenText());

				return lbl;

			};
		}

		);
	}

	private void initListeners() {

		view.getBtnSearch().addActionListener(e -> filter());
		view.getChkCritical().addActionListener(e -> filter());
		view.getChkWarning().addActionListener(e -> filter());
		view.getCmbSort().addActionListener(e -> filter());
	}

	public void filter() {

		view.getPnlNotif().removeAll();

		String query = view.getTxtSearch().getText().toLowerCase();

		boolean criticalSelected = view.getChkCritical().isSelected();
		boolean warningSelected = view.getChkWarning().isSelected();

		List<Notification> filterList = new ArrayList<>();

		for (Notification n : notificationList) {

			boolean containsQuery = n.getMessage().toLowerCase().contains(query);
			boolean criticalFilter = (criticalSelected && n.getCritical() == Critical.CRITICAL)
					|| (warningSelected && n.getCritical() == Critical.WARNING);

			boolean readStatus = n.isRead() == false;

			if (n.isPinned() || (containsQuery && criticalFilter && readStatus)) {

				filterList.add(n);
			}
		}

		filterList.sort(((SortKeys) view.getCmbSort().getSelectedItem()).getComparator());
		filterList.sort((n1, n2) -> Boolean.compare(n2.isPinned(), n1.isPinned()));

		for (Notification n : filterList) {

			NotificationLineController lineController = new NotificationLineController(n, notification -> {

				filter();
			});

			view.getPnlNotif().add(lineController.getView());
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

	public List<Notification> getNotificationList() {
		return notificationList;
	}

	public NotificationPanel getView() {
		return view;
	}
}
