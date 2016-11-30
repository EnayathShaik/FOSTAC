package com.ir.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.ir.model.CourseName;
import com.ir.model.State;
/**
 * Servlet implementation class DeleteState
 */

public class SearchState extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchState() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String sss = null ;
        String ssss = null;
        String n = request.getQueryString();    
        String [] n1 = n.split("&");
        String stateName = null;
        try{
        	 stateName = (n1[0].split("="))[1] ;
        	 String s [] = stateName.split("%20");
        	 String ss = " ";
        	 for(int i = 0 ; i < s.length ; i++){
        		 ss =ss + s[i] + " "; 
        	 }
        	 sss = ss.substring(1, ss.length());
        	 ssss = sss.substring(0 , sss.length() - 1);
        	 System.out.println(sss);
        }catch(Exception e){
        	stateName = "%";
        }
        
        String status = (n1[1].split("="))[1];
        System.out.println(stateName + "   "+ status);
        
        Configuration conf = new Configuration();
		conf.configure("/hibernate.cfg.xml");
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		String newList = null ;
		
		//if(stateName.equals("%")){
			System.out.println("state 1");
			Query query = session.createQuery("from State where status = '"+status+"' and statename like '"+ stateName+"'");
			List<State> list = query.list();
			System.out.println(list.size());
			session.close();

			if(list.size() > 0 || list != null){
				System.out.println("data selected finally  " );
				System.out.println(list);
				Gson g =new Gson();
				newList = g.toJson(list); 
			}
		/*}else{
			System.out.println("state2");
			Query query = session.createQuery("from State where status = '"+ status+ "' and upper(statename) like '"+ ssss.toUpperCase() +"' ");
			List<State> list = query.list();
			System.out.println(list.size());
			session.close();

			if(list.size() > 0 || list != null){
				System.out.println("data selected finally  " );
				System.out.println(list);
				Gson g =new Gson();
				newList = g.toJson(list); 
			}*/
		//}
		
		out.write(newList);
		out.flush();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
