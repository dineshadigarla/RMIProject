import java.rmi.Remote;

public interface PhoneBookServer extends Remote {
	
	public PhoneBookEntry[] getPhoneBook();
	public void addEntry( PhoneBookEntry entry );
	public void modifyEntry( PhoneBookEntry entry );
	public void deleteEntry( PhoneBookEntry entry );

}
