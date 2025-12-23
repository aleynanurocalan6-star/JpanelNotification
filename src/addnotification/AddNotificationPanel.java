package addnotification;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Critical;

public class AddNotificationPanel extends JPanel {
	private JTextField textField;
	private JComboBox<Critical> criticalComboBox;
	private JButton addButton;

	public AddNotificationPanel(AddNotificationController controller) {

		textField = new JTextField(20);
		textField.setBounds(57, 12, 260, 25);

		criticalComboBox = new JComboBox<>(Critical.values());
		criticalComboBox.setBounds(378, 10, 85, 25);
		criticalComboBox.setMaximumRowCount(10);

		addButton = new JButton("Ekle");
		addButton.setBounds(475, 9, 59, 26);
		setLayout(null);

		JLabel label = new JLabel("Mesaj:");
		label.setBounds(10, 14, 37, 16);
		add(label);
		add(textField);
		JLabel label_1 = new JLabel("Durum:");
		label_1.setBounds(330, 14, 41, 16);
		add(label_1);
		add(criticalComboBox);
		add(addButton);

		addButton.addActionListener(e -> {
			String mesaj = textField.getText().trim();

			Critical selectedStatus = (Critical) criticalComboBox.getSelectedItem();

			if (!mesaj.isEmpty()) {
				controller.addNotificationWithEnum(mesaj, selectedStatus);
				textField.setText("");
			} else {
				JOptionPane.showMessageDialog(this, "Lütfen bir mesaj yazın!");
			}
		});
	}
}