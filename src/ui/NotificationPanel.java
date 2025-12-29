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

import model.SortKeys;

@SuppressWarnings("serial")
public class NotificationPanel extends JPanel {

	private JTextField txtSearch;
	private JCheckBox chkCritical, chkWarning;
	private JComboBox<SortKeys> cmbSort;
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
		add(topPanel, BorderLayout.NORTH);

		JLabel lblSearch = new JLabel("Search: ");
		topPanel.add(lblSearch);

		txtSearch = new JTextField(15);
		topPanel.add(txtSearch);

		btnSearch = new JButton("Ara");
		topPanel.add(btnSearch);

		chkCritical = new JCheckBox("Critical");
		chkCritical.setSelected(true);
		topPanel.add(chkCritical);

		chkWarning = new JCheckBox("Warning");
		chkWarning.setSelected(true);
		topPanel.add(chkWarning);

		JLabel lblSort = new JLabel("Sırala: ");
		topPanel.add(lblSort);

		cmbSort = new JComboBox<>();

		for (SortKeys key : SortKeys.values()) {

			cmbSort.addItem(key);
		}

		topPanel.add(cmbSort);

	}

	private void initListPanel() {

		pnlList = new JPanel();

		JScrollPane scrollPaneNotification = new JScrollPane();

		GridBagLayout gbl_pnlList = new GridBagLayout();
		gbl_pnlList.columnWeights = new double[] { 1.0 };
		gbl_pnlList.rowWeights = new double[] { 0.0, 1.0 };

		pnlList.setLayout(gbl_pnlList);

		scrollPaneNotification.setViewportView(pnlList);

		pnlNotif = new JPanel();
		pnlNotif.setLayout(new BoxLayout(pnlNotif, BoxLayout.Y_AXIS));

		GridBagConstraints gbc_pnlNotif = new GridBagConstraints();
		gbc_pnlNotif.fill = GridBagConstraints.HORIZONTAL;
		gbc_pnlNotif.insets = new Insets(0, 0, 5, 0);
		gbc_pnlNotif.gridx = 0;
		gbc_pnlNotif.gridy = 0;
		pnlList.add(pnlNotif, gbc_pnlNotif);

		pnlFiller = new JPanel();
		GridBagConstraints gbc_pnlFiller = new GridBagConstraints();
		gbc_pnlFiller.fill = GridBagConstraints.BOTH;
		gbc_pnlFiller.gridx = 0;
		gbc_pnlFiller.gridy = 1;
		pnlList.add(pnlFiller, gbc_pnlFiller);

		add(scrollPaneNotification, BorderLayout.CENTER);
	}

	public JComboBox<SortKeys> getCmbSort() {
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