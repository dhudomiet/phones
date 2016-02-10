package phones.servicesimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import phones.DBConfig.HibernateUtil;
import phones.DOs.Users;
import phones.services.DataService;

public class DataServiceImpl implements DataService {

	public List<Users> getUsers() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("SELECT DISTINCT u FROM Users u INNER JOIN u.phones");
		List<Users> users = query.list();
		session.getTransaction().commit();
		return users;
	}

	public List<Users> getUsersByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Users> getUsersByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	public Users getUserbyFullData(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

}
