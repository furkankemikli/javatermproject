package si.um.opj.kemikli.logic.persons;

import java.io.Serializable;
import java.time.LocalDate;

public class Passenger extends Person implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3751361906638836241L;

	public enum Meal{
		MEAT, FISH, VEGETARIAN, DIET;
	}
	private String email;
	private Meal prefMeal;
	
	public Passenger(){
		super();
	}
	
	public Passenger(String first_name, String family_name, LocalDate birth_date, String email, Meal prefMeal){
		super(first_name,family_name,birth_date);
		this.email = email;
		this.prefMeal = prefMeal;		
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public void setPrefMeal(Meal prefMeal){
		this.prefMeal = prefMeal;
	}
		
	public String getEmail(){
		return this.email;
	}
	
	public Meal getPrefMeal(){
		return this.prefMeal;
	}
	
	@Override
	public String toString(){
		return super.toString()
				+",\nEmail: " + this.email
				+",\nPreferred Meal: " + this.prefMeal;
	}

}
