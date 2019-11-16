package com.k15t.pat.registration;

/**
 * Data Transfer Object that is queried and stored in persistant storage.
 * 
 * @author pythonprojects
 *
 */
public class Registration implements RegistrationInterface{
	
	private String user;
	private String password;  
	private String address;
	private String email;
	private String phone;
	
	
	@Override
	public String getUser() { 
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	@Override
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		
		Registration other = (Registration) obj;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Registration [user=" + user + ", password=" + password + ", address=" + address + ", email=" + email
				+ ", phone=" + phone + "]";
	}
	
	
}
