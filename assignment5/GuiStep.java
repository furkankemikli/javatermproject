package layoutTut;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JProgressBar;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiStep {
	/*
	  Add button to the pages to switch between two pages.Maybe adding menu etc.
	  then move add,edit and delete buttons to the second page
	 */

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtSurname;
	private JTextField txtBirthDate;
	private JTextField txtEmail;
	private JTextField txtCabinNumber;
	private JTextField txtTitle;
	private JTextField txtDepature;
	private JTextField txtDuration;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiStep window = new GuiStep();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GuiStep() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 345);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(1, 1));
		
		JPanel pnlMain = new JPanel();
		frame.getContentPane().add(pnlMain, "name_423583603335938");
		pnlMain.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlGetInfo = new JPanel();
		pnlMain.add(pnlGetInfo, BorderLayout.NORTH);
		pnlGetInfo.setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel lblPassengerInfo = new JLabel("PASSENGER INFO");
		Font passFont = lblPassengerInfo.getFont();
		Font newFont = new Font(passFont.getFontName(), Font.BOLD, passFont.getSize()+2);
		lblPassengerInfo.setFont(newFont);
		pnlGetInfo.add(lblPassengerInfo);
		
		JLabel label_5 = new JLabel("");
		pnlGetInfo.add(label_5);
		
		JLabel label_4 = new JLabel("");
		pnlGetInfo.add(label_4);
		
		JLabel label_6 = new JLabel("");
		pnlGetInfo.add(label_6);
		
		JLabel lblName = new JLabel("Name:");
		pnlGetInfo.add(lblName);
		
		txtName = new JTextField();
		pnlGetInfo.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblSurname = new JLabel("Surname:");
		pnlGetInfo.add(lblSurname);
		
		txtSurname = new JTextField();
		pnlGetInfo.add(txtSurname);
		txtSurname.setColumns(10);
		
		JLabel lblBirthDate = new JLabel("Birth Date(DD MM YYYY):");
		pnlGetInfo.add(lblBirthDate);
		
		txtBirthDate = new JTextField();
		pnlGetInfo.add(txtBirthDate);
		txtBirthDate.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		pnlGetInfo.add(lblEmail);
		
		txtEmail = new JTextField();
		pnlGetInfo.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblPreferredMeal = new JLabel("Preferred Meal:");
		pnlGetInfo.add(lblPreferredMeal);
		
		JComboBox cbPreferredMeal = new JComboBox();
		cbPreferredMeal.addItem("MEAT");
		cbPreferredMeal.addItem("FISH");
		cbPreferredMeal.addItem("VEGETARIAN");
		cbPreferredMeal.addItem("DIET");
		pnlGetInfo.add(cbPreferredMeal);
		
		JLabel lblCabinNumber = new JLabel("Cabin Number:");
		pnlGetInfo.add(lblCabinNumber);
		
		txtCabinNumber = new JTextField();
		pnlGetInfo.add(txtCabinNumber);
		txtCabinNumber.setColumns(10);
		
		JLabel lblCruseLst = new JLabel("CRUISE LIST");
		Font cruiseFont = lblCruseLst.getFont();
		Font newCruiseFont = new Font(cruiseFont.getFontName(), Font.BOLD, cruiseFont.getSize()+2);
		lblCruseLst.setFont(newCruiseFont);
		pnlGetInfo.add(lblCruseLst);
		
		JList list = new JList();
		pnlMain.add(list, BorderLayout.CENTER);
		
		JPanel pnlButton = new JPanel();
		pnlMain.add(pnlButton, BorderLayout.SOUTH);
		
		JButton btnNextPage = new JButton("NEXT PAGE");
		pnlButton.add(btnNextPage);
		
		JButton btnCancel_1 = new JButton("CANCEL");
		pnlButton.add(btnCancel_1);
		
		JButton btnSell = new JButton("SELL");
		pnlButton.add(btnSell);
		
		JPanel pnlSecond = new JPanel();
		frame.getContentPane().add(pnlSecond, "name_424505119068653");
		pnlSecond.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlLists = new JPanel();
		pnlSecond.add(pnlLists, BorderLayout.CENTER);
		GridBagLayout gbl_pnlLists = new GridBagLayout();
		gbl_pnlLists.columnWidths = new int[]{291, 291, 0};
		gbl_pnlLists.rowHeights = new int[]{0, 0, 0, 244, 0};
		gbl_pnlLists.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlLists.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlLists.setLayout(gbl_pnlLists);
		
		JLabel lblCaptanLst = new JLabel("CAPTAIN LIST");
		Font capFont = lblCaptanLst.getFont();
		Font newCapFont = new Font(capFont.getFontName(), Font.BOLD, capFont.getSize()+2);
		
		JLabel lblShpLst = new JLabel("SHIP LIST");
		Font shipFont = lblShpLst.getFont();
		Font newShipFont = new Font(shipFont.getFontName(), Font.BOLD, shipFont.getSize()+2);
		lblShpLst.setFont(newShipFont);
		GridBagConstraints gbc_lblShpLst = new GridBagConstraints();
		gbc_lblShpLst.insets = new Insets(0, 0, 5, 5);
		gbc_lblShpLst.gridx = 0;
		gbc_lblShpLst.gridy = 2;
		pnlLists.add(lblShpLst, gbc_lblShpLst);
		lblCaptanLst.setFont(newCapFont);
		GridBagConstraints gbc_lblCaptanLst = new GridBagConstraints();
		gbc_lblCaptanLst.insets = new Insets(0, 0, 5, 0);
		gbc_lblCaptanLst.gridx = 1;
		gbc_lblCaptanLst.gridy = 2;
		pnlLists.add(lblCaptanLst, gbc_lblCaptanLst);
		
		JList list_1 = new JList();
		GridBagConstraints gbc_list_1 = new GridBagConstraints();
		gbc_list_1.fill = GridBagConstraints.BOTH;
		gbc_list_1.insets = new Insets(0, 0, 0, 5);
		gbc_list_1.gridx = 0;
		gbc_list_1.gridy = 3;
		pnlLists.add(list_1, gbc_list_1);
		
		JList list_2 = new JList();
		GridBagConstraints gbc_list_2 = new GridBagConstraints();
		gbc_list_2.fill = GridBagConstraints.BOTH;
		gbc_list_2.gridx = 1;
		gbc_list_2.gridy = 3;
		pnlLists.add(list_2, gbc_list_2);
		
		JPanel pnlInfo = new JPanel();
		pnlSecond.add(pnlInfo, BorderLayout.NORTH);
		pnlInfo.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblTitle = new JLabel("Title of Cruise:");
		pnlInfo.add(lblTitle);
		
		txtTitle = new JTextField();
		pnlInfo.add(txtTitle);
		txtTitle.setColumns(10);
		
		JLabel lblDepature = new JLabel("Date of Depature(DD MM YYYY):");
		pnlInfo.add(lblDepature);
		
		txtDepature = new JTextField();
		pnlInfo.add(txtDepature);
		txtDepature.setColumns(10);
		
		JLabel lblDuration = new JLabel("Duration of Cruise:");
		pnlInfo.add(lblDuration);
		
		txtDuration = new JTextField();
		pnlInfo.add(txtDuration);
		txtDuration.setColumns(10);
		
		JPanel pnlButton_1 = new JPanel();
		pnlSecond.add(pnlButton_1, BorderLayout.SOUTH);
		pnlButton_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnPrevousPage = new JButton("PREVIOUS PAGE");
		pnlButton_1.add(btnPrevousPage);
		
		JButton btnCancel = new JButton("CANCEL");
		pnlButton_1.add(btnCancel);
		
		JButton btnADD = new JButton("ADD");
		pnlButton_1.add(btnADD);
		
		btnNextPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pnlMain.setVisible(false);
				pnlSecond.setVisible(true);
			}
		});
		
		btnPrevousPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pnlMain.setVisible(true);
				pnlSecond.setVisible(false);
			}
		});
	}
}
