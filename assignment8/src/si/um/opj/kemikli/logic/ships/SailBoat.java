package si.um.opj.kemikli.logic.ships;

import java.util.Random;
import java.util.Scanner;


public class SailBoat extends Thread {
	
	private String name;
	private double surOfSail,length,consumption,tank_size, trackLen;
	private int numOfBeds, occupBeds, id;
	
	public SailBoat() {}

	public SailBoat(String name) {
		this.name = name;
	}

	public SailBoat(String name, double length, double consumption, double tank_size) {
		this.name = name;
		this.length = length;
		this.consumption = consumption;
		this.tank_size = tank_size;
	}

	public SailBoat(double surOfSail, int numOfBeds, int occupBeds) {
		this.surOfSail = surOfSail;
		this.numOfBeds = numOfBeds;
		this.occupBeds = occupBeds;
	}
	
	public SailBoat(String name, double length, double consumption, double tank_size, int numOfBeds, int occupBeds
			, double surOfSail, int id, double trackLen){
		this.name = name;
		this.length = length;
		this.consumption = consumption;
		this.tank_size = tank_size;
		this.surOfSail = surOfSail;
		this.numOfBeds = numOfBeds;
		this.occupBeds = occupBeds;
		this.id = id;
		this.trackLen = trackLen;
	}
	
	@Override
	public String toString() {
		return "Sailboat Info:\n"
				+"Name of the ship: " + this.name 
				+ ",\nLength of the ship: " + this.length
				+ " meters,\nConsumption of the ship: " + this.consumption
				+ " liters per hour,\nTank size of the ship: " + this.tank_size
				+ "\nSurface of Sail: " + this.surOfSail
				+ "\nNumber of Beds:" + this.numOfBeds
				+ "\nOccupied Beds: " + this.occupBeds;
	}
	
	public String getNameShip() {
		return name;
	}

	public void setNameShip(String name) {
		this.name = name;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getConsumption() {
		return consumption;
	}

	public void setConsumption(double consumption) {
		this.consumption = consumption;
	}

	public double getTank_size() {
		return tank_size;
	}

	public void setTank_size(double tank_size) {
		this.tank_size = tank_size;
	}	

	public double getSurOfSail() {
		return surOfSail;
	}

	public void setSurOfSail(double surOfSail) {
		this.surOfSail = surOfSail;
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

	public double getOccupancy() {
		// TODO Auto-generated method stub
		return 100*((double)occupBeds)/numOfBeds;
	}
	@Override
	public void run() {
		
		double windPeriod,windSpeed, sailSpeed;
		double totalTime=0,distCovered, necTime;//distCovered keeps distance covered in that period
		int counter = 0;
		System.out.println("Sailor " + id + " started.");
		while(trackLen > 0){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			counter ++;
			windPeriod = wind.getWindPeriod();
			windSpeed = wind.getWindSpeed();
			sailSpeed = windSpeed * surOfSail / 10;
			System.out.println("Sailboat " + id + " has counter" + counter +" has speed " + sailSpeed + " wind " + windSpeed + "period " + windPeriod + " has remaining " + trackLen);
			distCovered = sailSpeed*(windPeriod/(1000*60*60));//calculates distance covered in that period
			//System.out.println("WindSpeed for Sailor " + id + " is " + windSpeed  + "." );
			if(trackLen > distCovered){
				totalTime = totalTime + (windPeriod/1000);
				trackLen = trackLen - distCovered;
				//System.out.println("Remaining distance for Sailor " + id + " is " + trackLen );
			}
			else if(trackLen == distCovered){
				totalTime = totalTime + (windPeriod/1000);
				trackLen = 0;
				System.out.println("Sailor " + id + " is finished race in " + String.format("%.3f", totalTime) + ".");
			}
			else{//if covered distance is larger so first calculate necessary time to finish.
				necTime = trackLen/windSpeed;//in hours
				necTime = 3600 * necTime;
				totalTime = totalTime + necTime;
				System.out.println("Sailor " + id + " is finished race in " + String.format("%.3f", totalTime) + "sec .");
				trackLen = 0;
			}
		}
		Thread.currentThread().interrupt();
	}
	public static Wind wind = new Wind();
	public static void main(String[] args) {
		
		System.out.println("...Welcome to Regatta...");
		
		wind.start();
		int numOfShips;
		double lenOfTrack;
		Scanner input = new Scanner(System.in);
	
		System.out.println("Please enter the number of the ships in the race:");
		numOfShips = input.nextInt();
		input.nextLine();
	
		System.out.println("Please enter the length of the track(in km):");
		lenOfTrack = input.nextDouble();
		input.nextLine();
	
		String shipName;
		double shipLength, shipConsumption,shipTank;
		int numOfBed, occBed, surOfSails;
		SailBoat sailors[] = new SailBoat [numOfShips];
    
		for(int i=0; i < numOfShips; i++){
			shipName = "Sailor "+i;
			shipLength = new Random().nextInt(10) + 10;
    		shipConsumption = new Random().nextInt(30) + 50;
    		shipTank = new Random().nextInt(150) + 200;
    		numOfBed = new Random().nextInt(5) + 2;
    		occBed = 0;
    		surOfSails = new Random().nextInt(15) + 7;
    		
    		sailors[i] = new SailBoat(shipName,shipLength,shipConsumption,shipTank,numOfBed,occBed,surOfSails, i+1, lenOfTrack);
    		sailors[i].start();
		}
    input.close();
	}

}
