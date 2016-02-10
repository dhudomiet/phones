package phones.parsers;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

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
				userJSON.put("firstName", user.getUserFirstName());
				userJSON.put("lastName", user.getUserLastName());
				List<Phones> phones = new ArrayList<Phones>(user.getPhones());
				JSONArray phns = new JSONArray();
				for(Phones phone : phones){
					phns.put(phone.getPhoneNumber());
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
}
