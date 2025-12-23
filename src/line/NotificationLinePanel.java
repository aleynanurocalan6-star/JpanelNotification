package line;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class NotificationLinePanel extends JPanel {

	private JButton btnRead;
	private JLabel lblMessage;
	private JLabel lblTimestamp;

	public NotificationLinePanel() {

		setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 0.0 };
		gridBagLayout.rowWeights = new double[] { 0.0 };
		setLayout(gridBagLayout);

		lblMessage = new JLabel("Notification Text");

		GridBagConstraints gbc_lblMessage = new GridBagConstraints();
		gbc_lblMessage.anchor = GridBagConstraints.WEST;
		gbc_lblMessage.insets = new Insets(0, 0, 0, 5);
		gbc_lblMessage.gridx = 0;
		gbc_lblMessage.gridy = 0;
		add(lblMessage, gbc_lblMessage);

		lblTimestamp = new JLabel("");
		GridBagConstraints gbc_labelTimestamp = new GridBagConstraints();
		gbc_labelTimestamp.anchor = GridBagConstraints.WEST;
		gbc_labelTimestamp.insets = new Insets(0, 0, 0, 5);
		gbc_labelTimestamp.gridx = 1;
		gbc_labelTimestamp.gridy = 0;
		add(lblTimestamp, gbc_labelTimestamp);

		btnRead = new JButton("Read");

		GridBagConstraints gbc_btnRead = new GridBagConstraints();
		gbc_btnRead.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnRead.gridx = 2;
		gbc_btnRead.gridy = 0;
		add(btnRead, gbc_btnRead);
	}

	public JButton getBtnRead() {
		return btnRead;
	}

	public JLabel getLblMessage() {
		return lblMessage;
	}

	public JLabel getLblTimestamp() {
		return lblTimestamp;
	}

}
