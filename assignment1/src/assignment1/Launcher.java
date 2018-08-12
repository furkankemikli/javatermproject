package assignment1;
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
	
	Person myPerson = new Person();
	Ship myShip = new Ship();
	String familyName, firstName, shipName;
	LocalDate birthDate;
    double shipLength, shipConsumption,shipTank;
    Scanner input = new Scanner(System.in);
    
    System.out.println("Please enter first name of the person:");
    firstName = input.nextLine();
    myPerson.setName(firstName);
    
    System.out.println("Please enter family name of the person:");
    familyName = input.nextLine();
    myPerson.setFamilyName(familyName);
    
    System.out.println("Please enter birth date of the person: (dd MM yyyy)");
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
    birthDate = LocalDate.parse(input.nextLine(), formatter);
    myPerson.setBirthDate(birthDate);
    
    System.out.println("Please enter name of the ship:");
    shipName = input.nextLine();
    myShip.setName(shipName);
    
    System.out.println("Please enter length of the ship:");
    shipLength = input.nextDouble();
    myShip.setLength(shipLength);
    
    System.out.println("Please enter consumption of the ship:");
    shipConsumption = input.nextDouble();
    myShip.setConsumption(shipConsumption);
    
    System.out.println("Please enter tank size of the ship:");
    shipTank = input.nextDouble();
    myShip.setTank_size(shipTank);   
    input.close();
    
    myShip.setCaptain(myPerson);
    
    System.out.println("Person Info:");
    System.out.println("Name: " + myPerson.getName());
    System.out.println("FamilyName: " + myPerson.getFamilyName());
    System.out.println("Birth Date: " + myPerson.getBirthDate());
    
    System.out.println("Ship Info");
    System.out.println("Captain Name: " + myShip.getCaptain().getName());
    System.out.println("Name: " + myShip.getName());
    System.out.println("Length: " + myShip.getLength());
    System.out.println("Consumption: " + myShip.getConsumption() + " liters per hour");
    System.out.println("Tank Size: " + myShip.getTank_size());
	}

}
