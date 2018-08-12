package assignment1;

import java.time.LocalDate;

public class Person {
	
	private String first_name;
	private String family_name;
	private LocalDate birth_date;
	
	public Person(){}
	
	public Person(String first_name, String family_name){
		this.first_name = first_name;
		this.family_name = family_name;
	}
	
	public Person(String first_name, String family_name, LocalDate birth_date){
		this.first_name = first_name;
		this.family_name = family_name;
		this.birth_date = birth_date;
	}
	
	public String toString(){
		return "First Name: " + this.first_name
				+",\nFamily Name: " + this.family_name
				+",\nBirth Date: " + this.birth_date;
	}
	
	public void setName(String first_name){
		this.first_name = first_name;
	}
	
	public void setFamilyName(String family_name){
		this.family_name = family_name;
	}
	
	public void setBirthDate(LocalDate birth_date){
		this.birth_date = birth_date;
	}
	
	public String getName(){
		return first_name;
	}
	
	public String getFamilyName(){
		return family_name;
	}
	
	public LocalDate getBirthDate(){
		return birth_date;
	}

}
