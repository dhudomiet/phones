package phones.DOs;

import java.util.Set;

public class Phones {
	private Integer idPhone;
	private String phoneNumber;
	private Set<Users> users;
	
	public Integer getIdPhone() {
		return idPhone;
	}
	public void setIdPhone(Integer idPhone) {
		this.idPhone = idPhone;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Set<Users> getUsers() {
		return users;
	}
	public void setUsers(Set<Users> users) {
		this.users = users;
	}
	
	
}
