package phones.DOs;

import java.util.Set;

public class Users {
	private Integer idUser;
	private String userFirstName;
	private String userLastName;
	private Set<Phones> phones;
	
	public Integer getIdUser() {
		return idUser;
	}
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public Set<Phones> getPhones() {
		return phones;
	}
	public void setPhones(Set<Phones> phones) {
		this.phones = phones;
	}
	
	
	
}
