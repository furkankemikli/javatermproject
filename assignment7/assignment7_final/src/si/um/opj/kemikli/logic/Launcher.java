package si.um.opj.kemikli.logic;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import si.um.opj.kemikli.logic.persons.Passenger;
import si.um.opj.kemikli.logic.persons.Person;
import si.um.opj.kemikli.logic.persons.Passenger.Meal;
import si.um.opj.kemikli.logic.ships.Cruiser;

public class Launcher{


	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
	Passenger pasArr[] = new Passenger[20];
	Person mycap;
	Cruiser myCruiser;
	Cruise myCruise = new Cruise();
	System.out.println("...Welcome...");
	try {
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("save.bin"));
		
		mycap = (Person) objectInputStream.readObject();
		myCruiser = (Cruiser) objectInputStream.readObject();
		for(int i=0; i < 20; i++){
	          pasArr[i] = (Passenger) objectInputStream.readObject();
	    }
		myCruise = (Cruise) objectInputStream.readObject();
		objectInputStream.close();
		System.out.println(mycap);
        System.out.println("\n");
		System.out.println(myCruiser);
        System.out.println("\n");
		for(int i=0; i < 20; i++){
	          System.out.println(pasArr[i]);
	          System.out.println("\n");
	    }
		System.out.println(myCruise);
		
	} catch (IOException i) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		myCruise.excPS.println("CRITICAL");
		myCruise.excPS.println("IOException");
		myCruise.excPS.println("Input file to load information couldn't found.");
		myCruise.excPS.println(dtf.format(now));
	} catch (ClassNotFoundException c) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		myCruise.excPS.println("ERROR\nClassNotFoundException");
		myCruise.excPS.println("Person or ship class not found.");
		myCruise.excPS.println(dtf.format(now));
	}

    String cruiseName;
	LocalDate birthDate, deptDate;
	int cruiseDur;
    Scanner input = new Scanner(System.in);    
    
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
	Passenger myPassenger[] = new Passenger[20];
    birthDate = LocalDate.parse("15 02 1997", formatter);
    
    mycap = new Person("Jack", "Daniels");
    for(int i=0; i < 20; i++){
        myPassenger[i] = new Passenger("p"+i+"name", "p"+i+"family", birthDate, "p1@", Meal.FISH);
    }
    myCruiser = new Cruiser(mycap, "Cruiser",53 , 45 , 500, 40, 4 , 20 , 160);

    Character answer = null;
    if(myCruise.getTitle() != null)
    {
    	System.out.println("Do you want to change information of the cruise:(Y/y or N/n)");
    	answer = input.nextLine().charAt(0);
    }
    if(answer == null || answer == 'Y' || answer == 'y')
    {
    	System.out.println("Please enter name of the cruise:");
    	cruiseName = input.nextLine();
    
    	System.out.println("Please enter departure date of the cruise: (dd MM yyyy)");
    	deptDate = LocalDate.parse(input.nextLine(), formatter);

    	System.out.println("Please enter duration of the cruise");
    	cruiseDur = input.nextInt();
    	input.nextLine();
    
    	myCruise = new  Cruise(cruiseName, myCruiser,deptDate,cruiseDur);
    }
    
    
    for(int i=0; i < 5; i++){//throws cabin occupied exception
    	myCruise.sellTicket(4, myPassenger[i]);
    }
    myCruise.cancelTicket(4, myPassenger[1]);
    if(myCruise.cabinEmpty(4))
    	System.out.println("There is available seat at the cabin 4");
    
    try {
    	ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("save.bin"));
    	objectOutputStream.writeObject(mycap);
    	objectOutputStream.writeObject(myCruiser);
    	for(int i=0; i < 20; i++){
           objectOutputStream.writeObject(myPassenger[i]);
        }
    	objectOutputStream.writeObject(myCruise);
    	objectOutputStream.close();
	} catch (IOException e) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		myCruise.excPS.println("CRITICAL");
		myCruise.excPS.println("IOException");
		myCruise.excPS.println("Output file couldn't found to save data.");
		myCruise.excPS.println(dtf.format(now));
	}
    myCruise.excPS.close();
    input.close();
	}
}
