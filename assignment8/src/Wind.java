import java.util.Random;

public class Wind extends Thread{
	
	private double windSpeed, windPeriod;
	
	@Override
	public void run() {
		try {
			setWindSpeed(new Random().nextInt(40));
			setWindPeriod(new Random().nextInt(2400) + 100);
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Wind() {}

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

}
