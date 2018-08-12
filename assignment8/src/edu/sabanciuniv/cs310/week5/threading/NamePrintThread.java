package edu.sabanciuniv.cs310.week5.threading;

public class NamePrintThread extends Thread{
	
	
	@Override
	public void run() {
		try{
		for(int i=0;i<100;i++)
		{
			System.out.println(" CS310 ");
			Thread.sleep(180);
		}
		}catch (Exception ex)
		{
			ex.printStackTrace();
		}
		
	}

}
