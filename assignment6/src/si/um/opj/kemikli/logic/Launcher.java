package si.um.opj.kemikli.logic;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import si.um.opj.kemikli.logic.persons.Captain;
import si.um.opj.kemikli.logic.persons.Passenger;
import si.um.opj.kemikli.logic.persons.Passenger.Meal;
import si.um.opj.kemikli.logic.ships.Cruiser;

import java.awt.Font;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.CardLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Launcher{
	
	static int k=10;
	static Captain[] captains = new Captain[k];
	static Cruiser[] ships = new Cruiser[k];
	static ArrayList<Cruise> cruises = new ArrayList<Cruise>();
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
	
	static String passName, passFamily, passEmail, cruiseTitle;
	static LocalDate passBirth, cruiseDepart;
	static int passCabin, cruiseDuration;
	Meal passMeal;
	static Cruise passCruise;//keeps which cruise chosen for this passenger
	static Cruiser cruCruiser;//keeps which cruiser chosen for new cruise
	static Captain cruCaptain;//keeps selected captain info from list
	static Passenger passenger;//keeps passenger info
	
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
		private JTextField txtDeparture;
		private JTextField txtDuration;

		public void run() {
			try {
				GuiStep window = new GuiStep();
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
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
			
			JComboBox<Meal> cbPreferredMeal = new JComboBox<Meal>();
			cbPreferredMeal.addItem(Meal.MEAT);
			cbPreferredMeal.addItem(Meal.FISH);
			cbPreferredMeal.addItem(Meal.VEGETARIAN);
			cbPreferredMeal.addItem(Meal.DIET);
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
			
			DefaultListModel<Cruise> model = new DefaultListModel<>();
			JList<Cruise> list = new JList<Cruise>(model);
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
			
			DefaultListModel<Cruiser> model_1 = new DefaultListModel<>();
			DefaultListModel<Captain> model_2 = new DefaultListModel<>();
			JList<Cruiser> list_1 = new JList<Cruiser>(model_1);
			GridBagConstraints gbc_list_1 = new GridBagConstraints();
			gbc_list_1.fill = GridBagConstraints.BOTH;
			gbc_list_1.insets = new Insets(0, 0, 0, 5);
			gbc_list_1.gridx = 0;
			gbc_list_1.gridy = 3;
			pnlLists.add(list_1, gbc_list_1);
			
			JList<Captain> list_2 = new JList<Captain>(model_2);
			GridBagConstraints gbc_list_2 = new GridBagConstraints();
			gbc_list_2.fill = GridBagConstraints.BOTH;
			gbc_list_2.gridx = 1;
			gbc_list_2.gridy = 3;
			pnlLists.add(list_2, gbc_list_2);
			
			for(int i=0; i < k; i++){
				model_1.addElement(ships[i]);
				model_2.addElement(captains[i]);
			}
			
			JPanel pnlInfo = new JPanel();
			pnlSecond.add(pnlInfo, BorderLayout.NORTH);
			pnlInfo.setLayout(new GridLayout(0, 2, 0, 0));
			
			JLabel lblTitle = new JLabel("Title of Cruise:");
			pnlInfo.add(lblTitle);
			
			txtTitle = new JTextField();
			pnlInfo.add(txtTitle);
			txtTitle.setColumns(10);
			
			JLabel lblDepature = new JLabel("Date of Departure(DD MM YYYY):");
			pnlInfo.add(lblDepature);
			
			txtDeparture = new JTextField();
			pnlInfo.add(txtDeparture);
			txtDeparture.setColumns(10);
			
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
			
			JButton btnCancel_2 = new JButton("CANCEL");
			pnlButton_1.add(btnCancel_2);
			
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
			
			btnCancel_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					txtName.setText("");
					txtSurname.setText("");
					txtBirthDate.setText("");
					txtEmail.setText("");
					txtCabinNumber.setText("");
					cbPreferredMeal.setSelectedItem("MEAT");
				}
			});
			
			btnSell.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						passName = txtName.getText();
						passFamily = txtSurname.getText();
						passBirth = LocalDate.parse(txtBirthDate.getText(), formatter);
						passEmail = txtEmail.getText();
						passMeal = (Meal) cbPreferredMeal.getSelectedItem();
						passCabin = Integer.parseInt(txtCabinNumber.getText());
						passCruise = list.getSelectedValue();
						if(txtCabinNumber.getText() == "" || txtName.getText() == "" || txtSurname.getText() == "" ||
								txtBirthDate.getText() == "" || txtEmail.getText() == ""){
							JOptionPane.showMessageDialog(frame, "You have enter necessary information to sell ticket!");
						}
						else{
							if(passCruise.cabinEmpty(passCabin)){
								passenger = new Passenger(passName,passFamily,passBirth,passEmail,passMeal);
								passCruise.sellTicket(passCabin, passenger);
								JOptionPane.showMessageDialog(frame, "Ticket successfully sold.");

								txtName.setText("");
								txtSurname.setText("");
								txtBirthDate.setText("");
								txtEmail.setText("");
								txtCabinNumber.setText("");
								cbPreferredMeal.setSelectedItem("MEAT");
							}
							else{
								JOptionPane.showMessageDialog(frame, "This cabin is full.");
							}
						}
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(frame, "There is a problem with the given information. Please check!!!");
					}
				}
			});
			
			btnCancel_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					txtTitle.setText("");
					txtDeparture.setText("");
					txtDuration.setText("");
				}
			});
			
			btnADD.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						cruiseTitle = txtTitle.getText();
						cruiseDepart = LocalDate.parse(txtDeparture.getText(), formatter);
						cruiseDuration = Integer.parseInt(txtDuration.getText());
						cruCruiser = list_1.getSelectedValue();
						cruCaptain = list_2.getSelectedValue();
						if(txtTitle.getText() == "" || txtDeparture.getText() == "" || txtDuration.getText() == ""){
							JOptionPane.showMessageDialog(frame, "You have enter necessary information to add new cruise!");
						}
						else{
							cruCruiser.setCaptain(cruCaptain);
							cruises.add(new Cruise(cruiseTitle,cruCruiser,cruiseDepart,cruiseDuration));
							JOptionPane.showMessageDialog(frame, "Cruise successfully added.");
							
							txtTitle.setText("");
							txtDeparture.setText("");
							txtDuration.setText("");
							list.removeAll();
							for(int i=0; i < cruises.size(); i++){
								model.addElement(cruises.get(i));
							}
						}
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(frame, "There is a problem with the given information. Please check!!!");
					}
					
				}
			});
		}
	}	

	public static void main(String[] args) {
	String c_name;
	double c_length, c_consumption,c_tank_size;
	int c_numOfCab, c_cabinCap, c_numOfPass, c_maxPass;
	
	String capName, capFamName,capTitle;
	LocalDate capBirth;
	int capNumLic;
	
	for(int i=0; i<k; i++){
		c_name = "Cruiser " + (i + 1);
		c_length = 30;
		c_consumption = 47;
		c_tank_size = 1486;
		c_numOfCab = 10;
		c_cabinCap = 4;
		c_numOfPass = 0;
		c_maxPass = c_numOfCab*c_cabinCap;
		ships[i] = new Cruiser(c_name,c_length,c_consumption,c_tank_size,c_numOfCab,c_cabinCap, c_numOfPass,c_maxPass);
		
		capName = "Captain " + (i + 1);
		capFamName = "Captain Family " + (i + 1);
	    capBirth = LocalDate.parse("15 02 1974", formatter);
	    capTitle = "Title " + (i + 1);
	    capNumLic = 5;		
		captains[i] = new Captain(capName, capFamName, capBirth, capTitle, capNumLic);		
	}
			
	Launcher launcher = new Launcher();
	GuiStep myGui = launcher.new GuiStep();
	myGui.run();
	
	}
}
