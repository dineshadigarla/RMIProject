import java.rmi.Naming;

public class MyClient {
	
	public static void main(String args[]){  
		try{  
			PhoneBookServer stub=(PhoneBookServer)Naming.lookup("rmi://localhost:5000/sonoo");  
			System.out.println(stub.getPhoneBook());  
		}
		catch(Exception e){
			e.printStackTrace();
		}  
	}
}
