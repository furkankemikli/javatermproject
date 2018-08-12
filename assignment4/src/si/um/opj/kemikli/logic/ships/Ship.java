package si.um.opj.kemikli.logic.ships;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import si.um.opj.kemikli.logic.persons.Passenger;
import si.um.opj.kemikli.logic.persons.Person;

/**
 * This class implements a ship that has a name,length,consumption per hour value
 * and tank size of it.
 * @author Furkan Kemikli
 * @version 1.0
 */
public abstract class Ship {

	private Person captain;//captain of the ship
	private String name;//keeps name of the ship
	private double length;//keeps length of the ship
	private double consumption;//keeps consumption of the ship whose unit is liters per hour
	private double tank_size;//keeps tank size of ship
	private Passenger[][] cabin;
	
	
	
	/**
	 * This the percentage of capacity occupancy of a ship
	 * @return percentage of capacity occupancy
	 */
	public abstract double getOccupancy();
	
	/**
	 * This constructs a ship with no parameter
	 */
	public Ship(){
		this.cabin = new Passenger[0][0];
	}
	
	/**
	 * This constructs a ship only with name.
	 * @param name the name of the ship
	 */
	public Ship(String name){
		this.name = name;
		this.cabin = new Passenger[0][0];
	}
	
	/**
	 * This constructs a ship with all attributes of it.
	 * @param captain the captain of the ship
	 * @param name the name of the ship
	 * @param length the length of the ship
	 * @param consumption the consumption of the ship in the unit of liter per hour
	 * @param tank_size the fuel tank size of the ship
	 */
	public Ship(Person captain, String name, double length, double consumption, double tank_size){
		this(name);
		this.captain = captain;
		this.length = length;
		this.consumption = consumption;
		this.tank_size = tank_size;
		this.cabin = new Passenger[0][0];
	}
	
	public Ship(Person captain, String name,double length, double consumption, double tank_size, int numOfCab, int cabinCap){
		this(name);
		this.captain = captain;
		this.length = length;
		this.consumption = consumption;
		this.tank_size = tank_size;
		this.cabin = new Passenger[numOfCab][cabinCap];
	}
	
	
	/**
	 * This is overloaded toString method which prints all the attributes of the ship
	 */
	@Override
	public String toString(){
		return "Captain Info:\n" + this.captain
				+ "\nName of the ship: " + this.name 
				+ ",\nLength of the ship: " + this.length
				+ " meters,\nConsumption of the ship: " + this.consumption
				+ " liters per hour,\nTank size of the ship: " + this.tank_size;
	}
	
	/**
	 * This returns fuel consumed in a trip with given duration of the trip
	 * @param duration the duration of the trip in hours
	 * @return fuel consumed in this trip
	 */
	public String fuelConsumed(double duration){
		return this.consumption*duration + "liters fuel consumed."; 
	}
	
	/**
	 * This calculates consumed fuel with given distance and average speed
	 * @param distance the distance of the trip
	 * @param average_speed the average speed of the ship in the trip
	 * @return fuel consumed in this trip
	 */
	public String fuelConsumed(double distance, double average_speed){
		return this.consumption*(distance/average_speed) + "liters fuel consumed.";
	}
	
	/**
	 * This returns consumed fuel between departure and arrival time at the trip
	 * @param departure the departure time from the beginning
	 * @param arrival the arrival time to the destination
	 * @return fuel consumed in this trip
	 */
	public String fuelConsumed(String departure, String arrival){
		LocalTime depart = LocalTime.parse(departure);
		LocalTime arrive = LocalTime.parse(arrival);
		double minutesbetween = ChronoUnit.MINUTES.between(depart,arrive);
		return (minutesbetween/60)*this.consumption + "liters fuel consumed.";
	}
	
	/**
	 * This changes the name of the ship
	 * @param name the name of the ship
	 */
	public void setName(String name){
		this.name = name;
	}
	
	/**
	 * This changes the length of the ship
	 * @param length the length of the ship
	 */
	public void setLength(double length){
		this.length = length;
	}
	
	/**
	 * This changes the consumption of the ship
	 * @param consumption the consumption of the ship(liter per hour)
	 */
	public void setConsumption(double consumption){
		this.consumption = consumption;
	}
	
	/**
	 * This changes the fuel tank size of the ship
	 * @param tank_size the tank size of the ship
	 */
	public void setTankSize(double tank_size){
		this.tank_size = tank_size;
	}
	
	/**
	 * This returns the name of the ship
	 * @return name of the ship
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * This returns the length of the ship
	 * @return the length of the ship
	 */
	public double getLength(){
		return length;
	}
	
	/**
	 * This returns the consumption of the ship
	 * @return the consumption of the ship
	 */
	public double getConsumption(){
		return consumption;
	}
	
	/**
	 * This returns the fuel tank size of the ship
	 * @return the tank size of the ship
	 */
	public double getTankSize(){
		return tank_size;
	}

	public Passenger[][] getCabin() {
		return cabin;
	}

	public void setCabin(Passenger[][] cabin) {
		this.cabin = cabin;
	}
}
