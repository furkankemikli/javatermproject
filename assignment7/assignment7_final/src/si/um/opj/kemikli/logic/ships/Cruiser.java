package si.um.opj.kemikli.logic.ships;

import java.io.Serializable;

import si.um.opj.kemikli.logic.persons.Person;

public class Cruiser extends Ship implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3772699571996059000L;
	private int numOfCab, numOfPass, maxPass; 
	
	public Cruiser(){
		super();
	}

	public Cruiser(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public Cruiser(Person captain, String name, double length, double consumption, double tank_size) {
		super(captain, name, length, consumption, tank_size);
		// TODO Auto-generated constructor stub
	}

	public Cruiser(int numOfCab, int numOfPass, int maxPass) {
		super();
		this.numOfCab = numOfCab;
		this.numOfPass = numOfPass;
		this.maxPass = maxPass;
	}
	
	public Cruiser(Person captain, String name, double length, double consumption, double tank_size, int numOfCab,int cabinCap, int numOfPass, int maxPass){
		super(captain, name,length,consumption,tank_size,numOfCab,cabinCap);
		this.numOfCab = numOfCab;
		this.numOfPass = numOfPass;
		this.maxPass = maxPass;
	}

	@Override
	public String toString() {
		return super.toString()
				+ "\nNumber Of Cabins: " + this.numOfCab
				+ "\nNumber Of Passengers: " + this.numOfPass
				+ "\nMax Number Of Passenger: " + this.maxPass;
	}

	public int getNumOfCab() {
		return numOfCab;
	}

	public void setNumOfCab(int numOfCab) {
		this.numOfCab = numOfCab;
	}

	public int getNumOfPass() {
		return numOfPass;
	}

	public void setNumOfPass(int numOfPass) {
		this.numOfPass = numOfPass;
	}

	public int getMaxPass() {
		return maxPass;
	}

	public void setMaxPass(int maxPass) {
		this.maxPass = maxPass;
	}

	@Override
	public double getOccupancy() {
		// TODO Auto-generated method stub
		return 100*((double)numOfPass)/maxPass;
	}
}
