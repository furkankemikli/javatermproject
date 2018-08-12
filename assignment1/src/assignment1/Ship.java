package assignment1;


public class Ship {
	
	private Person captain;
	private String name;
	private double length;
	private double consumption;
	private double tank_size;
	
	public Ship(){}
	
	public Ship(String name){
		this.name = name;
	}
	public Ship(Person captain, String name, double length, double consumption, double tank_size){
		this.captain = captain;
		this.name = name;
		this.length = length;
		this.consumption = consumption;
		this.tank_size = tank_size;
	}
	
	public String toString(){
		return  "Captain Info: " + this.captain
				+ "Name of the ship: " + this.name 
				+ ",\nLength of the ship: " + this.length
				+ "meters,\nConsumption of the ship: " + this.consumption
				+ "liters per hour,\nTank size of the ship: " + this.tank_size;
	}

	public void setCaptain(Person captain) {
		this.captain = captain;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setLength(double length){
		this.length = length;
	}

	public void setTank_size(double tank_size) {
		this.tank_size = tank_size;
	}

	public void setConsumption(double consumption){
		this.consumption = consumption;
	}
	
	public Person getCaptain() {
		return captain;
	}
	
	public String getName(){
		return name;
	}
	
	public double getLength(){
		return length;
	}
	
	public double getConsumption(){
		return consumption;
	}
	
	public double getTank_size() {
		return tank_size;
	}
}
