package si.um.opj.kemikli.logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import si.um.opj.kemikli.exceptions.CabinOccupiedException;
import si.um.opj.kemikli.logic.persons.Passenger;
import si.um.opj.kemikli.logic.ships.Ship;

public class Cruise implements Salable, Serializable{

	@Override
	public String toString() {
		return "Cruise [Title = " + title + ", Ship = " + ship.getName() + ", Departure Date = " + departureDate + ", Travel Duration = "
				+ travelDuration + "]";
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 874568190278752019L;
	private String title;
	private Ship ship;
	private LocalDate departureDate;
	private int travelDuration;
	public File excFile;
	public PrintStream excPS;
	
	public Cruise() throws FileNotFoundException {
		super();
		excFile = new File("exception.txt");
		excPS = new PrintStream(excFile);
	}
	
	public Cruise(String title, Ship ship, LocalDate departureDate, int travelDuration) throws FileNotFoundException {
		super();
		this.title = title;
		this.ship = ship;
		this.departureDate = departureDate;
		this.travelDuration = travelDuration;
		excFile = new File("exception.txt");
		excPS = new PrintStream(excFile);
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}
	public int getTravelDuration() {
		return travelDuration;
	}
	public void setTravelDuration(int travelDuration) {
		this.travelDuration = travelDuration;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Ship getShip() {
		return ship;
	}
	public void setShip(Ship ship) {
		this.ship = ship;
	}

	@Override
	public void sellTicket(int cabin, Passenger passenger) {
		// TODO Auto-generated method stub
		Passenger[][] dummy = ship.getCabin();//gets cabin from ship
		boolean empty = false;
		int cabinCap = dummy[0].length;
		int i=0;
		try {
			while(empty == false && i < cabinCap)//if empty place found or all places checked then exits loop 
			{	
				if(dummy[cabin][i] == null){//checks if any place empty if empty then places passenger to that place
					empty = true;
					dummy[cabin][i] = passenger;
					System.out.println(passenger.getName() + " is added to the cabin " + cabin);
				}
				i++;
				if(empty == false && i == 4){
					throw new CabinOccupiedException(cabin);
				}
			}
		} catch (CabinOccupiedException coe) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			excPS.println("WARNING");
			excPS.println("Cabin Occupied Exception");
			excPS.println("There is no space at given cabin number " + cabin);
			excPS.println(dtf.format(now));
		}
		
	}
	@Override
	public void cancelTicket(int cabin, Passenger passenger) {
		// TODO Auto-generated method stub
		Passenger[][] dummy = ship.getCabin();
		int cabinCap = dummy[0].length;
		for(int i=0; i < cabinCap; i++)//to find passenger
		{
			if(dummy[cabin][i] == passenger){//passenger found in cabin and deleted
				dummy[cabin][i] = null;	
				System.out.println(passenger.getName() + "'s ticket is cancelled.");
			}
		}
		ship.setCabin(dummy);//modifies original cabin
	}
	@Override
	public boolean cabinEmpty(int cabin) {
		// TODO Auto-generated method stub
		Passenger[][] dummy = ship.getCabin();
		int cabinCap = dummy[0].length;
		int counter = 0;
		for(int i=0; i < cabinCap; i++){
			if(dummy[cabin][i] != null)//if there is a person at that seat
				counter++;
		}
		if(counter < 4)
			return true;//if cabin is empty return true
		else
			return false;//if cabin is full then return false
	}
	
	
}
