package model;

public class Customer {
	private int customerId;
	private String username;
	private String email;
	private String password;
	
	
	
	//empty constructor
	public Customer() {
		
		// TODO Auto-generated constructor stub
	}
	
	
	//constructor using fields
	public Customer(int customerId, String username, String email, String password) {
		super();
		this.customerId = customerId;
		this.username = username;
		this.email = email;
		this.password = password;
	}



	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", username=" + username + ", email=" + email + ", password="
				+ password + "]";
	}


	//getters and setters genrated
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
