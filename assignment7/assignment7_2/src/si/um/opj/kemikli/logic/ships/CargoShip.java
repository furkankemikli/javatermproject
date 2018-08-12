package si.um.opj.kemikli.logic.ships;

import java.io.Serializable;
import si.um.opj.kemikli.logic.persons.Person;


public class CargoShip extends Ship implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double maxPayLoad, payLoad;
	
	public CargoShip(){
		super();
	}

	public CargoShip(double maxPayLoad, double payLoad) {
		super();
		this.maxPayLoad = maxPayLoad;
		this.payLoad = payLoad;
	}

	public CargoShip(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public CargoShip(Person captain, String name, double length, double consumption, double tank_size) {
		super(captain, name, length, consumption, tank_size);
		// TODO Auto-generated constructor stub
	}

	public CargoShip(Person captain, String name, double length, double consumption, double tank_size, double maxPayLoad, double payLoad){
		super(captain, name,length,consumption,tank_size);
		this.maxPayLoad = maxPayLoad;
		this.payLoad = payLoad;
	}

	@Override
	public String toString() {
		return super.toString()
				+ "\nMax Payload: " + this.maxPayLoad
				+ "\nPayload: " + this.payLoad;
	}

	public double getMaxPayLoad() {
		return maxPayLoad;
	}

	public void setMaxPayLoad(double maxPayLoad) {
		this.maxPayLoad = maxPayLoad;
	}

	public double getPayLoad() {
		return payLoad;
	}

	public void setPayLoad(double payLoad) {
		this.payLoad = payLoad;
	}

	@Override
	public double getOccupancy() {
		// TODO Auto-generated method stub
		return 100*(maxPayLoad - payLoad)/maxPayLoad;
	}

}
