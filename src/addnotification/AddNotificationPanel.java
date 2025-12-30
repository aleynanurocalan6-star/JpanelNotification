package addnotification;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import model.Critical;

public class AddNotificationPanel extends JPanel {

	private JTextField textField, txtId;
	private JComboBox<Critical> criticalComboBox;
	private JButton addButton, btnFetch, btnUpdate;
	private JPanel pnlId;
	private JRadioButton rbAddMode;
	private JRadioButton rbUpdateMode;

	public AddNotificationPanel() {
		setLayout(new BorderLayout());

		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		rbAddMode = new JRadioButton("Ekleme Yap", true);
		rbUpdateMode = new JRadioButton("Güncelleme Yap");
		ButtonGroup group = new ButtonGroup();
		group.add(rbAddMode);
		group.add(rbUpdateMode);
		panel.add(rbAddMode);
		panel.add(rbUpdateMode);
		add(panel, BorderLayout.NORTH);

		JPanel box = new JPanel(new GridLayout(0, 1, 0, 5));

		pnlId = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlId.add(new JLabel("ID:"));
		txtId = new JTextField(5);
		pnlId.add(txtId);
		btnFetch = new JButton("Getir");
		pnlId.add(btnFetch);
		box.add(pnlId);

		JPanel pnlMessage = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlMessage.add(new JLabel("Mesaj:"));
		textField = new JTextField(15);
		pnlMessage.add(textField);
		box.add(pnlMessage);

		JPanel pnlStatus = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlStatus.add(new JLabel("Durum:"));
		criticalComboBox = new JComboBox<>(Critical.values());
		pnlStatus.add(criticalComboBox);
		box.add(pnlStatus);

		add(box, BorderLayout.CENTER);

		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		addButton = new JButton("Ekle");
		btnUpdate = new JButton("Güncelle");
		buttonPanel.add(addButton);
		buttonPanel.add(btnUpdate);
		add(buttonPanel, BorderLayout.SOUTH);

		pnlId.setVisible(false);
		btnUpdate.setVisible(false);
	}

	public JPanel getPnlId() {
		return pnlId;
	}

	public JButton getAddButton() {
		return addButton;
	}

	public JButton getBtnUpdate() {
		return btnUpdate;
	}

	public JRadioButton getRbAddMode() {
		return rbAddMode;
	}

	public JRadioButton getRbUpdateMode() {
		return rbUpdateMode;
	}

	public JTextField getTextField() {
		return textField;
	}

	public JTextField getTxtUpdateId() {
		return txtId;
	}

	public JComboBox<Critical> getCriticalComboBox() {
		return criticalComboBox;
	}

	public JButton getBtnFetch() {
		return btnFetch;
	}
}