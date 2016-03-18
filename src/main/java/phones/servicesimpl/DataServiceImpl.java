package phones.servicesimpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.id.IdentityGenerator;

import phones.DBConfig.HibernateUtil;
import phones.DOs.Phones;
import phones.DOs.Users;
import phones.parsers.JSONParser;
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

	public String saveNewUser(String json) {
		JSONObject obj = null;
		try {
			obj = new JSONObject(json);
			JSONParser parser = new JSONParser();
			Users user = parser.toUserObject(json);
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();	
			return "success";
		}catch(Exception e){
			e.printStackTrace();
			return "fail";
		}
	}

	public String deleteUser(Integer id, Integer idPhone) {
		try{
			Users us = new Users();
			us.setIdUser(id);
			Phones phone = new Phones();
			phone.setIdPhone(idPhone);
			Set<Phones> phones = new HashSet<Phones>();
			phones.add(phone);
			us.setPhones(phones);
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(us);
			session.getTransaction().commit();
			return "success";
		}catch(Exception e){
			e.printStackTrace();
			return "fail";
		}
	}

}
