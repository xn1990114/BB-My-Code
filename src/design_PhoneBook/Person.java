package design_PhoneBook;

public class Person {
	public String firstName;
	public String lastName;
	public String number;
	
	public Person(String firstName,String lastName,String number){
		this.firstName=firstName;
		this.lastName=lastName;
		this.number=number;
	}
	public String toString(){
		return this.firstName+" "+this.lastName+" "+this.number;
	}
}
