package si.um.opj.kemikli.logic.ships;

public class Cruiser extends Ship{
	
	private int numOfCab, numOfPass, maxPass;
	
	public Cruiser(){
		super();
	}

	public Cruiser(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public Cruiser(String name, double length, double consumption, double tank_size) {
		super(name, length, consumption, tank_size);
		// TODO Auto-generated constructor stub
	}

	public Cruiser(int numOfCab, int numOfPass, int maxPass) {
		super();
		this.numOfCab = numOfCab;
		this.numOfPass = numOfPass;
		this.maxPass = maxPass;
	}
	
	public Cruiser(String name, double length, double consumption, double tank_size, int numOfCab, int numOfPass, int maxPass){
		super(name,length,consumption,tank_size);
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
