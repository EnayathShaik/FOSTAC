package com.ir.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.google.gson.Gson;

/**
 * Servlet implementation class MyServlt
 */

public class SearchUpcomingTraining extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchUpcomingTraining() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
				
				
		HttpSession httpSession=request.getSession(false);
		Integer userId=0;
		if(null!=httpSession.getAttribute("userId")){
			userId= (Integer) httpSession.getAttribute("userId");
		}
		System.out.println("userId == "+userId);
				System.out.println("onload training center list");
				response.setContentType("text/html;charset=UTF-8");
		        PrintWriter out = response.getWriter();
		        Configuration conf = new Configuration();
				conf.configure("/hibernate.cfg.xml");
				SessionFactory sf = conf.buildSessionFactory();
				Session session = sf.openSession();
				String id = request.getQueryString();
				
				String sql ="select tc.trainingcalendarid , concat(pitp.trainingpartnerpermanentline1 , ' ' , pitp.trainingpartnerpermanentline2 , ' ' , s.statename , ' ' , d.districtname , ' ' , c.cityname) as address, "+
						" concat(tc.trainingdate , ' / ' , tc.trainingtime) as schedule , "+
						" concat(pitp.firstname , ' ' , pitp.middlename , ' ' , pitp.lastname ) ,concat( pitp.trainingpartnerpermanentmobile , ' / ' , pitp.trainingpartnerpermanentemail)  as contact, "+
						" (select count(1) from courseenrolleduser A where A.trainingcalendarid = tc.trainingcalendarid) , tc.seatcapacity , ct.coursetype "+
						"  , cn.coursename  , tc.status,cn.coursecode,tc.batchcode from trainingcalendar as tc "+
						" inner join coursename as cn on cn.coursenameid = tc.coursename "+
						" inner join coursetype as ct on ct.coursetypeid = tc.coursetype "+
						" inner join managetrainingpartner as mtp on mtp.managetrainingpartnerid = tc.trainingpartner "+
						" inner join personalinformationtrainingpartner as pitp on mtp.managetrainingpartnerid = pitp.trainingpartnername "+
						" inner join logindetails as log on log.id = pitp.logindetails "+
						" inner join state as s on s.stateid = pitp.trainingpartnerpermanentstate "+
						" inner join city as c on c.cityid = pitp.trainingpartnerpermanentcity "+
						" inner join district as d on d.districtid = pitp.trainingpartnerpermanentdistrict "+
						" and tc.trainingcenter = pitp.personalinformationtrainingpartnerid where to_timestamp(COALESCE(tc.trainingdate, '19900101010101'),'DD-MM-YYYY HH24:MI') > now()";// and tc.trainingcenter='"+id+"'";
						//" WHERE log.id = "+userId;
			System.out.println("before query");
			Query query = session.createSQLQuery(sql);
			System.out.println("after query");
			List list = query.list();
			System.out.println(list.size());
			session.close();
			String newList = null ;
			if(list.size() > 0 || list != null){
				System.out.println("data selected finally  " );
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
