//bankingApp
//bank class
package model;

public class Bank {
	private int bank_id;
	private String bankName;
	private String bankBranch;
	
	public Bank(int bankId, String bankName, String bankBranch) {
		this.bank_id=bankId;
		this.bankName=bankName;
		this.bankBranch=bankBranch;
	}

	public int getBank_id() {
		return bank_id;
	}

	public void setBank_id(int bank_id) {
		this.bank_id = bank_id;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankBranch() {
		return bankBranch;
	}

	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}
}
//account class
package model;

public abstract class Account {
	private int accountId;
	private int customerId;
	private Bank bank;
	private String accountType;
	private double balance;
	
	public Account(int accountId, int customerId, Bank bank, String accountType, double balance) {
		super();
		this.accountId = accountId;
		this.customerId = customerId;
		this.bank = bank;
		this.accountType = accountType;
		this.balance = balance;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
 
}
//savingsAccount class
package model;

public class SavingsAccount extends Account {
	private double interestRate;

	public SavingsAccount(int accountId, int customerId, Bank bank, String accountType, double balance,double interestRate) {
		super(accountId, customerId, bank, accountType, balance);
		// TODO Auto-generated constructor stub
		this.interestRate=interestRate;
		
	}
	public double getInerestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate=interestRate;
	}

}
//currentAccount
package model;

public class CurrentAccount extends Account {
	private double overDraft;

	public CurrentAccount(int accountId, int customerId, Bank bank, String accountType, double balance,double overDraft) {
		super(accountId, customerId, bank, accountType, balance);
		// TODO Auto-generated constructor stub
		this.overDraft=overDraft;
		
	}

	public double getOverDraft() {
		return overDraft;
	}

	public void setOverDraft(double overDraft) {
		this.overDraft = overDraft;
	}

}



//JDBC connectivity


package JDBCconnectivity;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;
public class Main {
	public static void main(String[] args)throws SQLException {
		String url="jdbc:mysql://localhost:3306/sample";
		String username="root";
		String password="MySQL@Ramya11";
		
		Connection con=DriverManager.getConnection(url,username, password);
		if(con!=null) {
			System.out.println("Connection Established");
		}
		else {
			System.out.println("Connection Not Established");
		}
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter User Details");
		String name=sc.nextLine();
		String pass=sc.nextLine();
		int id=sc.nextInt();
		String sql="Insert into users(username,password,user_id)" + "values(?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, pass);
		ps.setInt(3, id);
		int res=ps.executeUpdate();
		if(res>0) {
			System.out.println("A new user created!");
		}
		String query="select * from users";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		while(rs.next()) {
			System.out.println("UserName:"+rs.getString("username"));
			System.out.println("PassWord:"+rs.getString("password"));
			System.out.println("User ID:"+rs.getString("user_Id"));
		}
		System.out.println("Enter the values to be updated");
                String name=scan.nextLine();
                String pass=scan.nextLine();
                int id=scan.nextInt();
                String Updatequery="update users set username=?,password=? where user_id=? ";
                PreparedStatement ps=con.prepareStatement(Updatequery);
                ps.setString(1, name);
                ps.setString(2, pass);
                ps.setInt(3, id);
                int updateRes=ps.executeUpdate();
                if(updateRes>0) {
    	                System.out.println("User details updated successfully!!");
                }
                else {
    	                System.out.println("No user is found ");
                }
    
    //delete 
                System.out.println("Enter the user id to be deleted");
                int id=scan.nextInt();
                String deleteQuery="delete from users where user_id=?";
                PreparedStatement ps=con.prepareStatement(deleteQuery);
                ps.setInt(1, id);
                int delRes=ps.executeUpdate();
                if(delRes>0) {
    	                System.out.println("User deleted Successfully!!");
                }
                else {
    	                System.out.println("Invalid userid!!");
                }
		 System.out.println("Enter the user ID:");
                 int id = scan.nextInt();

    // Prepare the SQL query
                String selectQuery = "SELECT username, password, user_id FROM users WHERE user_id = ?";
                PreparedStatement ps = con.prepareStatement(selectQuery);
                ps.setInt(1, id);  // Set the parameter

    // Execute the query
                ResultSet res = ps.executeQuery();  // Do not pass selectQuery again

    // Process the results
                if (res.next()) {
                        System.out.println("Username: " + res.getString("username"));
                        System.out.println("Password: " + res.getString("password"));
                        System.out.println("User ID: " + res.getInt("user_id"));
                } 
		else {
                        System.out.println("No user found with the given user ID.");
                }
	}
}
