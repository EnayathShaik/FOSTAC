package com.ir.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ir.model.CourseName;
import com.zentect.ajax.AjaxRequest;

/**
 * Servlet implementation class DeleteState
 */

public class EditMTP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditMTP() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
		String name = (request.getQueryString());
		System.out.println("kk");
		String id = request.getQueryString();
		
		String sql=" select mtp.managetrainingpartnerid  , ld.loginid  ,  mtp.pan , mtp.trainingpartnername , ld.status , "+
				" mtp.websiteurl , mtp.headofficedataaddress1 , mtp.headofficedataaddress2 ,mtp.pin ,  "+
			  " s.stateid , d.districtid , c.cityid , mtp.email "+
				" from managetrainingpartner as mtp "+
				" inner join logindetails as ld on ld.id = mtp.logindetails "+
				" inner join district as d on d.districtid = mtp.district "+
				" inner join city as c on c.cityId = mtp.city "+
				" inner join state as s on s.stateid = mtp.state "+
				" where mtp.managetrainingpartnerid = '"+ name+"' ";
		
		List<CourseName> list = new AjaxRequest().returnList(sql);
		String newList = null ;
		if(list.size() > 0 || list != null){
			System.out.println("data selected finally  " );
			System.out.println(list);
			Gson g =new Gson();
			newList = g.toJson(list); 
		}
		out.write(newList);
		out.flush();
		
		/*Configuration conf = new Configuration();
		conf.configure("/hibernate.cfg.xml");
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		String sql=" select mtp.managetrainingpartnerid  , ld.loginid  ,  mtp.pan , mtp.trainingpartnername , ld.status , "+
					" mtp.websiteurl , mtp.headofficedataaddress1 , mtp.headofficedataaddress2 ,mtp.pin ,  "+
				  " s.stateid , d.districtid , c.cityid , mtp.email "+
					" from managetrainingpartner as mtp "+
					" inner join logindetails as ld on ld.id = mtp.logindetails "+
					" inner join district as d on d.districtid = mtp.district "+
					" inner join city as c on c.cityId = mtp.city "+
					" inner join state as s on s.stateid = mtp.state "+
					" where mtp.managetrainingpartnerid = '"+ name+"' ";
//nmnhjkhk
		Query query = session.createSQLQuery(sql);
		List<CourseName> list = query.list();
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
		out.flush();*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
