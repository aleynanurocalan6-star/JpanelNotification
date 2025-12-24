package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class NotificationPanel extends JPanel {

	private JTextField txtSearch;
	private JCheckBox chkCritical, chkWarning;
	private JComboBox<String> cmbSort;
	private JPanel pnlList;
	private JButton btnSearch;
	private JPanel pnlNotif;
	private JPanel pnlFiller;

	public NotificationPanel() {
		initTopPanel();
		initListPanel();
	}

	private void initTopPanel() {
		setLayout(new BorderLayout(10, 10));
		JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		txtSearch = new JTextField(15);
		chkCritical = new JCheckBox("Critical");
		chkCritical.setSelected(true);
		chkWarning = new JCheckBox("Warning");
		chkWarning.setSelected(true);

		cmbSort = new JComboBox<>(new String[] { "Tarihe Göre", "Önceliğe Göre (C->W)", "Alfabetik (A-Z)" });

		btnSearch = new JButton("Ara");

		topPanel.add(new JLabel("Search: "));
		topPanel.add(txtSearch);
		topPanel.add(btnSearch);
		topPanel.add(chkCritical);
		topPanel.add(chkWarning);
		topPanel.add(new JLabel("Sırala: "));
		topPanel.add(cmbSort);

		add(topPanel, BorderLayout.NORTH);
	}

	private void initListPanel() {
		pnlList = new JPanel();
		JScrollPane scrollPaneNotification = new JScrollPane();
		scrollPaneNotification.setViewportView(pnlList);
		GridBagLayout gbl_pnlList = new GridBagLayout();
		gbl_pnlList.columnWeights = new double[] { 1.0 };
		gbl_pnlList.rowWeights = new double[] { 0.0, 1.0 };
		pnlList.setLayout(gbl_pnlList);

		pnlNotif = new JPanel();
		GridBagConstraints gbc_pnlNotif = new GridBagConstraints();
		gbc_pnlNotif.fill = GridBagConstraints.HORIZONTAL;
		gbc_pnlNotif.insets = new Insets(0, 0, 5, 0);
		gbc_pnlNotif.gridx = 0;
		gbc_pnlNotif.gridy = 0;
		pnlList.add(pnlNotif, gbc_pnlNotif);
		pnlNotif.setLayout(new BoxLayout(pnlNotif, BoxLayout.Y_AXIS));

		pnlFiller = new JPanel();
		GridBagConstraints gbc_pnlFiller = new GridBagConstraints();
		gbc_pnlFiller.fill = GridBagConstraints.BOTH;
		gbc_pnlFiller.gridx = 0;
		gbc_pnlFiller.gridy = 1;
		pnlList.add(pnlFiller, gbc_pnlFiller);

		add(scrollPaneNotification, BorderLayout.CENTER);
	}

	public JComboBox<String> getCmbSort() {
		return cmbSort;
	}

	public JTextField getTxtSearch() {
		return txtSearch;
	}

	public JCheckBox getChkCritical() {
		return chkCritical;
	}

	public JCheckBox getChkWarning() {
		return chkWarning;
	}

	public JPanel getPnlNotif() {
		return pnlNotif;
	}

	public JButton getBtnSearch() {
		return btnSearch;
	}
}