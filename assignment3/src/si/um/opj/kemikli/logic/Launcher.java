package si.um.opj.kemikli.logic;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import si.um.opj.kemikli.logic.persons.*;
import si.um.opj.kemikli.logic.ships.*;
/*
 * If necessary make some changes in the launcher because ship is changed
 * Also check what they want
 * */
public class Launcher{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	System.out.println("...Welcome...");
	
	String familyName, firstName, shipName;
	LocalDate birthDate;
    double shipLength, shipConsumption,shipTank;
    Scanner input = new Scanner(System.in);
    
    System.out.println("Please enter first name of the person:");
    firstName = input.nextLine();
    
    System.out.println("Please enter family name of the person:");
    familyName = input.nextLine();
    
    System.out.println("Please enter birth date of the person: (dd MM yyyy)");
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
    birthDate = LocalDate.parse(input.nextLine(), formatter);
    
	Person myPerson = new Person(firstName, familyName, birthDate);
	
	String title,email;
	Meal meal;
	int numOfLicence;
	System.out.println("Please enter first name of the captain:");
    firstName = input.nextLine();
    
    System.out.println("Please enter family name of the captain:");
    familyName = input.nextLine();
    
    System.out.println("Please enter birth date of the captain: (dd MM yyyy)");
    formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
    birthDate = LocalDate.parse(input.nextLine(), formatter);
    
    System.out.println("Please enter the title of the captain:");
    title = input.nextLine();
    
    System.out.println("Please enter the number of licence of the captain:");
    numOfLicence = input.nextInt();
    input.nextLine();
    
    Captain myCaptain = new Captain(firstName,familyName,birthDate,title,numOfLicence);
    
    System.out.println("Please enter first name of the passenger:");
    firstName = input.nextLine();
    
    System.out.println("Please enter family name of the passenger:");
    familyName = input.nextLine();
    
    System.out.println("Please enter birth date of the passenger: (dd MM yyyy)");
    formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
    birthDate = LocalDate.parse(input.nextLine(), formatter);
    
    System.out.println("Please enter the email of the passenger:");
    email = input.nextLine();
    
    System.out.println("Please enter the preferred meal of the passanger:(MEAT, FISH, VEGETARIAN, DIET)");
    meal = Meal.valueOf(input.nextLine());
    
    Passenger myPassenger = new Passenger(firstName,familyName,birthDate,email,meal);
    
    System.out.println("Please enter name of the cargo ship:");
    shipName = input.nextLine();
    
    System.out.println("Please enter length of the cargo ship:");
    shipLength = input.nextDouble();
    
    System.out.println("Please enter consumption of the cargo ship:");
    shipConsumption = input.nextDouble();
    
    System.out.println("Please enter tank size of the cargo ship:");
    shipTank = input.nextDouble();
    
    double maxPayload,payLoad;
    System.out.println("Please enter the max payload of the cargo ship:");
    maxPayload = input.nextDouble();
    
    System.out.println("Please enter the payload of the cargo ship:");
    payLoad = input.nextDouble();
    input.nextLine();
    
    CargoShip myCargo = new CargoShip(myCaptain, shipName,shipLength,shipConsumption,shipTank,maxPayload,payLoad);
    
    System.out.println("Please enter name of the cruiser:");
    shipName = input.nextLine();
    
    System.out.println("Please enter length of the cruiser:");
    shipLength = input.nextDouble();
    
    System.out.println("Please enter consumption of the cruiser:");
    shipConsumption = input.nextDouble();
    
    System.out.println("Please enter tank size of the cruiser:");
    shipTank = input.nextDouble();
    
    int numOfCab, numOfPass, maxPass;
    
    System.out.println("Please enter the number of cabins in cruiser:");
    numOfCab = input.nextInt();
    
    System.out.println("Please enter the number of passenger in cruiser:");
    numOfPass = input.nextInt();
    
    System.out.println("Please enter the max passenger in cruiser:");
    maxPass = input.nextInt();
    input.nextLine();
    
    Cruiser myCruiser = new Cruiser(myPerson, shipName,shipLength,shipConsumption,shipTank,numOfCab,numOfPass,maxPass);
    
    System.out.println("Please enter name of the sail boat:");
    shipName = input.nextLine();
    
    System.out.println("Please enter length of the sail boat:");
    shipLength = input.nextDouble();
    
    System.out.println("Please enter consumption of the sail boat:");
    shipConsumption = input.nextDouble();
    
    System.out.println("Please enter tank size of the sail boat:");
    shipTank = input.nextDouble();
    
    double surOfSails;
    int numOfBed,occBed;
    
    System.out.println("Please enter the surface of sails:");
    surOfSails = input.nextDouble();
    
    System.out.println("Please enter the number of beds in sail boat:");
    numOfBed = input.nextInt();
    
    System.out.println("Please enter the occupied beds in sail boat:");
    occBed = input.nextInt();
    
    SailBoat mySail = new SailBoat(myCaptain, shipName,shipLength,shipConsumption,shipTank,numOfBed,occBed,surOfSails);
    
    System.out.println("Person Info:\n" + myPerson);
    System.out.println("Captain Info:\n" + myCaptain);
    System.out.println("Passenger Info:\n" + myPassenger);
    System.out.println("Cargo Ship Info:\n" + myCargo);
    System.out.println("Cargo Ship Occupancy: " + myCargo.getOccupancy());
    System.out.println("Cruiser Info:\n" + myCruiser);
    System.out.println("Cruiser Occupancy: " + myCruiser.getOccupancy());
    System.out.println("Sail Boat Info:\n" + mySail);
    System.out.println("Sail Boat Occupancy: " + mySail.getOccupancy());
    
    input.close();
	}

}
