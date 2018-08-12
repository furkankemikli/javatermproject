package si.um.opj.kemikli.logic;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
/*
 * If necessary make some changes in the launcher because ship is changed
 * 
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
    
    System.out.println("Please enter name of the ship:");
    shipName = input.nextLine();
    
    System.out.println("Please enter length of the ship:");
    shipLength = input.nextDouble();
    
    System.out.println("Please enter consumption of the ship:");
    shipConsumption = input.nextDouble();
    
    System.out.println("Please enter tank size of the ship:");
    shipTank = input.nextDouble();
    
    System.out.println("Please enter the duration of the first trip:");
    double duration = input.nextDouble();
    
    System.out.println("Please enter the distance of the second trip:");
    double distance = input.nextDouble();
    
    System.out.println("Please enter the average speed of the second trip: ");
    double avrgSpeed = input.nextDouble();
    input.nextLine();

    System.out.println("Please enter the departure time of the third trip:(hh:mm)");
    String depTime = input.nextLine();
    
    System.out.println("Please enter the arrival time of the third trip:(hh:mm)");
    String arrTime = input.nextLine();
    
	input.close();
    
	Person myPerson = new Person(firstName, familyName, birthDate);
	Ship myShip = new Ship(myPerson,shipName, shipLength, shipConsumption, shipTank);
    
    System.out.println("Person Info:\n" + myPerson);
    /*System.out.println("Name: " + myPerson.getName());
    System.out.println("FamilyName: " + myPerson.getFamilyName());
    System.out.println("Birth Date: " + myPerson.getBirthDate());*/
    
    System.out.println("Ship Info:\n" + myShip);
    /*System.out.println("Name: " + myShip.getName());
    System.out.println("Length: " + myShip.getLength());
    System.out.println("Consumption: " + myShip.getConsumption() + " liters per hour");
    System.out.println("Tank Size: " + myShip.getTankSize());*/
    
    System.out.println(myShip.fuelConsumed(duration) + " in first trip in hour");
    System.out.println(myShip.fuelConsumed(distance, avrgSpeed) + "in second trip in km");
    System.out.println(myShip.fuelConsumed(depTime, arrTime) + "in third trip");
	}

}
