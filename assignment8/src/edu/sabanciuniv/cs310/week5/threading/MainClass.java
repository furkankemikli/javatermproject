package edu.sabanciuniv.cs310.week5.threading;

public class MainClass {

	public static void main(String[] args) {
		try{
			NamePrintThread npt = new NamePrintThread();	
			npt.start();
			
			for(int i=0;i<90;i++)
			{
				System.out.println("Hello "+ i);
				Thread.sleep(200);
			}
		}catch (Exception ex)
		{
			ex.printStackTrace();
		}

	}

}
