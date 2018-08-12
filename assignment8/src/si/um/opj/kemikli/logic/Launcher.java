/*package si.um.opj.kemikli.logic;
import java.util.Scanner;
import java.util.Random;
import si.um.opj.kemikli.logic.ships.*;

public class Launcher{
	
	public void movementOfBoat(SailBoat sailor, int length) {
		
		/*yapýlacaklar
		 * Total zamaný tut.
		 * Loop oluþtur koþulu eðer kalan mesafe 0'dan büyükse
		 * windPeriod ile windSpeed'i çarpýp kalan mesafeden çýkar. Çýkarmak için koþullara bak
		 * 1)Eðer çýkacak sayý kalan mesafeden küçükse çýkar
		 * 2)Eðer birbirlerine eþitlerse looptan çýk geçen zamaný output ver 
		 * 3)Eðer çýkan mesafe büyükse kalan kýsmý bitirmek için geçen zamaný hesapla ve geçen total zamaný output ver.
		 * Bunlarý movementOfBoat fonksiyonunda yap.
		 * 
		
		int windSpeed = new Random().nextInt(40), windPeriod = new Random().nextInt(2400)+100;
		//period in msec, wind speed(also same speed for the ship) in km/h it must be change in 100-2500 msec.
		int totalTime=0,distCovered;//distCovered keeps distance covered in that period
		while(length > 0){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			distCovered = windSpeed*(windPeriod/(1000*60*60));//calculates distance covered in that period
			if(length > distCovered){
				length = length - distCovered;
			}
			else if(length == distCovered){
				length = length - distCovered;
				System.out.println("" + );
			}
			else{
				
			}
		}
	}

	public static void main(String[] args) {
		
		System.out.println("...Welcometo Regatta...");
		
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
    
		for(int i=1; i <= numOfShips; i++){
			shipName = "Sailor "+i;
			shipLength = new Random().nextInt(10) + 10;
    		shipConsumption = new Random().nextInt(30) + 50;
    		shipTank = new Random().nextInt(150) + 200;
    		numOfBed = new Random().nextInt(5) + 2;
    		occBed = 0;
    		surOfSails = new Random().nextInt(15) + 7;
    		
    		sailors[i] = new SailBoat(shipName,shipLength,shipConsumption,shipTank,numOfBed,occBed,surOfSails, i);
		}
		
    input.close();
	}

}*/
