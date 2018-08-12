package si.um.opj.kemikli.logic.ships;

import si.um.opj.kemikli.logic.persons.Person;

public class SailBoat extends Ship{
	
	private double surOfSail;
	private int numOfBeds, occupBeds;
	
	public SailBoat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SailBoat(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public SailBoat(Person captain, String name, double length, double consumption, double tank_size) {
		super(captain, name, length, consumption, tank_size);
		// TODO Auto-generated constructor stub
	}

	public SailBoat(double surOfSail, int numOfBeds, int occupBeds) {
		super();
		this.surOfSail = surOfSail;
		this.numOfBeds = numOfBeds;
		this.occupBeds = occupBeds;
	}
	
	public SailBoat(Person captain, String name, double length, double consumption, double tank_size, int numOfBeds, int occupBeds, double surOfSail){
		super(captain, name,length,consumption,tank_size);
		this.surOfSail = surOfSail;
		this.numOfBeds = numOfBeds;
		this.occupBeds = occupBeds;
	}

	public double getSurOfSail() {
		return surOfSail;
	}

	public void setSurOfSail(double surOfSail) {
		this.surOfSail = surOfSail;
	}

	@Override
	public String toString() {
		return "Sailboat Info:\n" + super.toString()
		+ "\nSurface of Sail: " + this.surOfSail
		+ "\nNumber of Beds:" + this.numOfBeds
		+ "\nOccupied Beds: " + this.occupBeds;
	}

	public int getNumOfBeds() {
		return numOfBeds;
	}

	public void setNumOfBeds(int numOfBeds) {
		this.numOfBeds = numOfBeds;
	}

	public int getOccupBeds() {
		return occupBeds;
	}

	public void setOccupBeds(int occupBeds) {
		this.occupBeds = occupBeds;
	}

	@Override
	public double getOccupancy() {
		// TODO Auto-generated method stub
		return 100*((double)occupBeds)/numOfBeds;
	}

}
