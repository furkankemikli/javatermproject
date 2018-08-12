package si.um.opj.kemikli.logic.ships;

import java.util.Random;

public class Wind extends Thread{
	private Random random =  new Random();
	private double windSpeed = random.nextInt(40);
	private double windPeriod = random.nextInt(2400)+100;
	
	public double getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}

	public double getWindPeriod() {
		return windPeriod;
	}

	public void setWindPeriod(double windPeriod) {
		this.windPeriod = windPeriod;
	}

	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(500);
				windPeriod = random.nextInt(2400)+100;
				windSpeed = random.nextInt(40);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	

}
