import java.io.Serializable;

public class PhoneBookEntry implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8592206952657882433L;
	private int id;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	
	PhoneBookEntry(String firstName,String lastName,String phoneNumber){
		this.firstName=firstName;
		this.lastName=lastName;
		this.phoneNumber=phoneNumber;
	}
	
	PhoneBookEntry(int id,String firstName,String lastName,String phoneNumber){
		this.id=id;
		this.firstName=firstName;
		this.lastName=lastName;
		this.phoneNumber=phoneNumber;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName=firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName=lastName;
	}
	
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public void setPhoneName(String phoneNumber) {
		this.phoneNumber=phoneNumber;
	}
	
	
	

	
}
