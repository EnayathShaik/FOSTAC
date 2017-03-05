package com.ir.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.google.gson.Gson;

/**
 * Servlet implementation class MyServlt
 */

public class OnLoadAdminTrainingPartnerList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OnLoadAdminTrainingPartnerList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
				System.out.println("onload admin trainer list in pending");
				response.setContentType("text/html;charset=UTF-8");
		        PrintWriter out = response.getWriter();
		        
		        
		        Configuration conf = new Configuration();
				conf.configure("/hibernate.cfg.xml");
				SessionFactory sf = conf.buildSessionFactory();
				Session session = sf.openSession();
				String newList=null;
				
				String sql ="select mtp.managetrainingpartnerid as id, mtp.trainingpartnername , count(pitp.trainingpartnername) from personalinformationtrainingpartner as pitp "+ 
						" inner join managetrainingpartner as mtp on pitp.trainingpartnername = mtp.managetrainingpartnerid "+
						"  inner join logindetails as ld on pitp.logindetails = ld.id where ld.status='I' "+
						" group by mtp.trainingpartnername , mtp.managetrainingpartnerid ";		
		
				Query query = session.createSQLQuery(sql);
				List list = query.list();
				System.out.println(list.size());
				session.close();
				if(list.size() > 0 || list != null){
					System.out.println(list);
					Gson g =new Gson();
					newList = g.toJson(list); 
				}
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
