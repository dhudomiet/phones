package phones.services;

import java.util.List;

import phones.DOs.Users;

public interface DataService {
	public List<Users> getUsers();
	public List<Users> getUsersByFirstName(String firstName);
	public List<Users> getUsersByLastName(String lastName);
	public Users getUserbyFullData(String firstName, String lastName);
}
