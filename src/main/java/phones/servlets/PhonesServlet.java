package phones.servlets;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.hibernate.Session;

import phones.DBConfig.HibernateUtil;
import phones.DOs.Phones;
import phones.DOs.Users;
import phones.parsers.JSONParser;
import phones.services.DataService;
import phones.servicesimpl.DataServiceImpl;



/**
 * Servlet implementation class PhonesServlet
 */
public class PhonesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhonesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataService s = new DataServiceImpl();
		List<Users> users=s.getUsers();
		String output = JSONParser.toJSONArray(users);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		System.out.println("number of users: "+users.size());
		PrintWriter out = response.getWriter();
		out.println(output);
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuffer sb = new StringBuffer();
		BufferedReader reader = request.getReader();
		String line = null;
		while((line = reader.readLine())!=null){
			sb.append(line);
		}
		DataService saveUser= new DataServiceImpl();
		String isSave = saveUser.saveNewUser(sb.toString());
		List<Users> users=saveUser.getUsers();
		String output = JSONParser.toJSONArray(users);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(output);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String param = request.getParameter("idUser");
		String phone = request.getParameter("idPhone");
		Integer id = Integer.parseInt(param);
		Integer idPhone = Integer.parseInt(phone);
		DataService service = new DataServiceImpl();
		String result = service.deleteUser(id,idPhone);
		System.out.println("idUser: "+id+" idPhone: "+idPhone);
		PrintWriter out = response.getWriter();
		out.println(result);
	}

}
