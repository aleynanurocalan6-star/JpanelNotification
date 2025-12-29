package addnotification;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import model.Critical;

public class AddNotificationPanel extends JPanel {

	private JTextField textField;
	private JComboBox<Critical> criticalComboBox;
	private JButton addButton;

	private JTextField txtId;
	private JTextField txtUpdateMessage;
	private JButton btnFetch;
	private JButton btnUpdate;

	public AddNotificationPanel() {
		setLayout(new BorderLayout());

		JPanel pnlAdd = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlAdd.setBorder(BorderFactory.createTitledBorder("Yeni Bildirim Ekle"));

		pnlAdd.add(new JLabel("Mesaj:"));
		textField = new JTextField(15);
		pnlAdd.add(textField);

		pnlAdd.add(new JLabel("Durum:"));
		criticalComboBox = new JComboBox<>(Critical.values());
		pnlAdd.add(criticalComboBox);

		addButton = new JButton("Ekle");
		pnlAdd.add(addButton);

		JPanel pnlUpdate = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlUpdate.setBorder(BorderFactory.createTitledBorder("Bildirim Güncelle"));

		pnlUpdate.add(new JLabel("ID:"));
		txtId = new JTextField(5);
		pnlUpdate.add(txtId);

		btnFetch = new JButton("Getir");
		pnlUpdate.add(btnFetch);

		pnlUpdate.add(new JLabel("Yeni Mesaj:"));
		txtUpdateMessage = new JTextField(15);
		pnlUpdate.add(txtUpdateMessage);

		btnUpdate = new JButton("Güncelle");
		pnlUpdate.add(btnUpdate);

		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Ekleme Paneli", pnlAdd);
		tabbedPane.addTab("Güncelleme Paneli", pnlUpdate);

		add(tabbedPane, BorderLayout.CENTER);
	}

	public JTextField getTextField() {
		return textField;
	}

	public JComboBox<Critical> getCriticalComboBox() {
		return criticalComboBox;
	}

	public JButton getAddButton() {
		return addButton;
	}

	public JTextField getTxtUpdateId() {
		return txtId;
	}

	public JTextField getTxtUpdateMessage() {
		return txtUpdateMessage;
	}

	public JButton getBtnFetch() {
		return btnFetch;
	}

	public JButton getBtnUpdate() {
		return btnUpdate;
	}
}