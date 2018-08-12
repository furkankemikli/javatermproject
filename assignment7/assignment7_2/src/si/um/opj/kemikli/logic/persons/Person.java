package si.um.opj.kemikli.logic.persons;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * This class implements a person that has a name,surname and birth date.
 * @author Furkan Kemikli
 * @version 1.0
 */
public class Person implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5742954383279102236L;
	private String first_name;
	private String family_name;
	private LocalDate birth_date;
	
	/**
	 * This constructs a person with no parameter
	 */
	public Person(){}
	
	/**
	 * This constructs a person with his/her name and surname.
	 * @param first_name the first name of the person
	 * @param family_name the family name of the person
	 */
	public Person(String first_name, String family_name){
		this.first_name = first_name;
		this.family_name = family_name;
	}
	
	/**
	 * This constructs a person with his/her name and surname.
	 * @param first_name the first name of the person
	 * @param family_name the family name of the person
	 * @param birth_date the birth date of the person
	 */
	public Person(String first_name, String family_name, LocalDate birth_date){
		this.first_name = first_name;
		this.family_name = family_name;
		this.birth_date = birth_date;
	}
	
	/**
	 * This is overloaded toString method which prints all the attributes of the person.
	 */
	@Override
	public String toString(){
		return "First Name: " + this.first_name
				+",\nFamily Name: " + this.family_name
				+",\nBirth Date: " + this.birth_date;
	}
	
	/**
	 * This changes the name of the person
	 * @param first_name the name of the person
	 */
	public void setName(String first_name){
		this.first_name = first_name;
	}
	
	/**
	 * This changes the surname of the person
	 * @param family_name the surname of the person
	 */
	public void setFamilyName(String family_name){
		this.family_name = family_name;
	}
	
	/**
	 * This changes the birth date of the person
	 * @param birth_date the birth date of the person
	 */
	public void setBirthDate(LocalDate birth_date){
		this.birth_date = birth_date;
	}
	
	/**
	 * This returns the name of the person
	 * @return the first name of the person
	 */
	public String getName(){
		return first_name;
	}
	
	/**
	 * This returns the surname of the person
	 * @return the family name of the person
	 */
	public String getFamilyName(){
		return family_name;
	}
	
	/**
	 * This returns the birth date of the person
	 * @return the birth date of the person
	 */
	public LocalDate getBirthDate(){
		return birth_date;
	}

}
