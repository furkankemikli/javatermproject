package si.um.opj.kemikli.logic.persons;

import java.time.LocalDate;

public class Captain extends Person{

	private String title;
	private int numOfLic;
	
	public Captain(){
		super();
	}
	
	public Captain(String first_name, String family_name, LocalDate birth_date, String title, int numOfLic ){
		super(first_name,family_name,birth_date);
		this.title = title;
		this.numOfLic = numOfLic;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public void setNumOfLic(int numOfLic){
		this.numOfLic = numOfLic;
	}
	
	public String getTitle(){
		return this.title;
	}
	
	public int getNumOfLic(){
		return this.numOfLic;
	}
	
	@Override
	public String toString(){
		return super.toString();
	}

}
