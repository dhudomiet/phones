package phones.parsers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.hibernate.id.IdentityGenerator;

import phones.DOs.Phones;
import phones.DOs.Users;

public class JSONParser {
	public JSONParser() {
	}

	public static String toJSONArray(List<Users> users) {
		JSONArray jArray = new JSONArray();
		try {
			for (Users user : users) {
				JSONObject userJSON = new JSONObject();
				userJSON.put("idUser", user.getIdUser().toString());
				userJSON.put("firstName", user.getUserFirstName());
				userJSON.put("lastName", user.getUserLastName());
				List<Phones> phones = new ArrayList<Phones>(user.getPhones());
				JSONArray phns = new JSONArray();
				for(Phones phone : phones){
					JSONObject obj = new JSONObject();
					obj.put("idPhone", phone.getIdPhone().toString());
					obj.put("number", phone.getPhoneNumber());
					phns.put(obj);
				}
				userJSON.put("phones", phns);
				jArray.put(userJSON);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return jArray.toString();
	}
	
	public Users toUserObject(String json){
		Users user = new Users();
		try {
			JSONObject obj = new JSONObject(json);
			Iterator<String> keys = obj.keys();
			IdentityGenerator id = new IdentityGenerator();
			user.setUserFirstName((String)obj.get(keys.next()));
			user.setUserLastName((String)obj.get(keys.next()));
			Set<Phones> phones = new HashSet<Phones>();
			Phones p = new Phones();
			p.setPhoneNumber((String)obj.get(keys.next()));
			phones.add(p);
			user.setPhones(phones);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}
}
