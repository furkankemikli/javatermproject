package si.um.opj.kemikli.logic;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import si.um.opj.kemikli.logic.persons.Passenger;
import si.um.opj.kemikli.logic.persons.Person;
import si.um.opj.kemikli.logic.persons.Passenger.Meal;
import si.um.opj.kemikli.logic.ships.Cruiser;

public class Launcher{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	System.out.println("...Welcome...");
	
	String cruiseName;
	LocalDate birthDate, deptDate;
	int cruiseDur;
    Scanner input = new Scanner(System.in);    
    Person mycap = new Person("Jack", "Daniels");
    
    Cruiser myCruiser = new Cruiser(mycap, "Cruiser",53 , 45 , 500, 40, 4 , 20 , 160);
    
    System.out.println("Please enter name of the cruise:");
    cruiseName = input.nextLine();
    
    System.out.println("Please enter departure date of the cruise: (dd MM yyyy)");
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
    deptDate = LocalDate.parse(input.nextLine(), formatter);

    System.out.println("Please enter duration of the cruise");
    cruiseDur = input.nextInt();
    input.nextLine();
    
    Cruise myCruise = new  Cruise(cruiseName, myCruiser,deptDate,cruiseDur);
    birthDate = LocalDate.parse("15 02 1997", formatter);
    
    Passenger myPassenger[] = new Passenger[20];
    
    for(int i=0; i < 20; i++){
        myPassenger[i] = new Passenger("p"+i+"name", "p"+i+"family", birthDate, "p1@", Meal.FISH);
    }
    /*for(int i=0; i < 20; i++)
    {
    	System.out.println(myPassenger[i].getName());
    }*/
    for(int i=0; i < 5; i++){
    	if(myCruise.cabinEmpty(4)){
    	myCruise.sellTicket(4, myPassenger[i]);
    	System.out.println(myPassenger[i].getName() + " is added to the cabin 4.");
    	}
    	else{
    		System.out.println(myPassenger[i].getName() + " can not be added to cabin 4.");
    	}
    }
    myCruise.cancelTicket(4, myPassenger[1]);
    System.out.println(myPassenger[1].getName() + "'s ticket cancelled.");
    if(myCruise.cabinEmpty(4))
    	System.out.println("There is available seat at the cabin 4");
    
    
    input.close();
	}
}
