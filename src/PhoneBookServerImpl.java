import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PhoneBookServerImpl extends UnicastRemoteObject implements PhoneBookServer {

	Statement stmt = null;
	ResultSet rs = null;
	Connection con=null;
	PhoneBookServerImpl()throws RemoteException {  
		super();  
	}  

	@Override
	public PhoneBookEntry[] getPhoneBook() {
		PhoneBookEntry[] phoneBookEntry = new PhoneBookEntry[1000];
		try { 
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/housejoy","root","admin");  
			stmt=con.createStatement();  
			rs=stmt.executeQuery("select firstName,lastName,phonemumber from phonebook");    
			int i=0;
			while(rs.next()) {
				phoneBookEntry[i]=new PhoneBookEntry(rs.getString(1),rs.getString(2),rs.getString(3));
				i++;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		}
		return phoneBookEntry;
	}

	@Override
	public void addEntry(PhoneBookEntry entry) {
		// TODO Auto-generated method stub
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/housejoy","root","admin");  
			stmt=con.createStatement();  
			String query="insert into phonebook (firstName,lastName,phonemumber) values ('"+entry.getFirstName()+"','"+entry.getLastName()+"','"+entry.getPhoneNumber()+"')";
			int result= stmt.executeUpdate(query);
			if(result!=0) {
				System.out.println("Successfully Updated");
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		}
	}

	@Override
	public void modifyEntry(PhoneBookEntry entry) {
		
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/housejoy","root","admin");  
			stmt=con.createStatement();  
			String query="update phonebook set firstName= '"+entry.getFirstName()+"', lastName='"+entry.getLastName()+"',phonemumber='"+entry.getPhoneNumber()+"' where id="+entry.getId();
			int result= stmt.executeUpdate(query);
			if(result!=0) {
				System.out.println("Successfully Updated");
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		}
		
	}

	@Override
	public void deleteEntry(PhoneBookEntry entry) {
		
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/housejoy","root","admin");  
			stmt=con.createStatement();  
			String query="delete from phonebook  where id="+entry.getId();
			int result= stmt.executeUpdate(query);
			if(result!=0) {
				System.out.println("Successfully Updated");
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		}

		
	}

}
