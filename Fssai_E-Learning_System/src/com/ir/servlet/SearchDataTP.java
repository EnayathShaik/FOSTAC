
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
import com.ir.model.CourseName;
/**
 * Servlet implementation class DeleteState
 */

public class SearchDataTP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchDataTP() {
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
		String name = (request.getQueryString());
		System.out.println("passing name   :" + name);
		String[] totalConnected = name.split("&");
		String id="",tpname="", fcn = "",websiteURL= "",pan= "",email="",headOfficeDataAddress1="",headOfficeDataAddress2="",pin="",stateId="",district="",city="",status="";
		
		
		if(!name.equalsIgnoreCase("ALL")){
			try{
				id = (totalConnected[0].split("="))[1];	
			}
			catch(Exception e){
				id ="%";	
			}
			try{
				tpname = (totalConnected[1].split("="))[1];
			}
			catch(Exception e)
			{
				tpname = "%";	
			}
			try{
				websiteURL = (totalConnected[2].split("="))[1];	
			}catch(Exception e)
			{
				websiteURL = "%";
			}
		try{
			pan = (totalConnected[3].split("="))[1];
		}
		catch(Exception e)
		{
			pan = "%";
		}
		try{
			email = (totalConnected[4].split("="))[1];
		}
		catch(Exception e){
			email = "%";
		}
		try{
			headOfficeDataAddress1 = (totalConnected[5].split("="))[1];
		}catch(Exception e)
		{
			headOfficeDataAddress1 = "%";
		}
		try{
			headOfficeDataAddress2 = (totalConnected[6].split("="))[1];
		}
		catch(Exception e){
			headOfficeDataAddress2 = "%";
		}
		try{
			pin = (totalConnected[1].split("="))[7];	
		}
		catch(Exception e){
			pin = "%";
		}
		try{
			stateId = (totalConnected[8].split("="))[1];
		}
		catch(Exception e){
			stateId = "%";
		}
		try{
			district = (totalConnected[9].split("="))[1];
		}
		catch(Exception e){
			district = "%";
		}
		try{
			city = (totalConnected[10].split("="))[1];
		}
		catch(Exception e){
			city = "%";
		}
		try{
			status = (totalConnected[11].split("="))[1];
		}
		catch(Exception e){
			status = "%";
		}
		
		String[] tpnameA  = tpname.split("%20");
		String cn = "";
		for(int i = 0 ; i < tpnameA.length ; i++){
			cn = cn + tpnameA[i] + " ";
		}
		
		fcn = cn.substring(0, cn.length()-1);
		System.out.println(fcn.length()  + "   "+ fcn);
		}
		Configuration conf = new Configuration();
		conf.configure("/hibernate.cfg.xml");
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		
		String sql = null;
		if(!name.equalsIgnoreCase("ALL"))
		 sql ="select mtp.managetrainingpartnerid  , ld.loginid  , mtp.trainingpartnername , mtp.pan , "+
					" mtp.websiteurl , (CASE WHEN ld.isActive = 'Y' THEN 'INACTIVE' ELSE 'ACTIVE' END) as updateStatus,(CASE WHEN ld.isActive = 'Y' THEN 'ACTIVE' ELSE 'INACTIVE' END) as currentstatus from managetrainingpartner as mtp "+
					" inner join logindetails as ld on ld.id=mtp.logindetails "+
					" where upper(mtp.trainingpartnername) like '"+fcn.toUpperCase() +"%' and ld.loginid like '"+id+"%' "+
					 " and mtp.trainingpartnername like '"+tpname+"%' and mtp.pan like '"+pan+"%' and mtp.websiteurl like '"+websiteURL+"%' " +
					 " and mtp.email like '"+email+"%' and mtp.headOfficeDataAddress1 like '"+headOfficeDataAddress1+"%' " +
					 " and mtp.headOfficeDataAddress2 like '"+headOfficeDataAddress2+"%' and mtp.pin like '"+pin+"%' and cast(mtp.state as varchar) like '"+stateId+"'" +
					 "and cast(mtp.district as varchar) like '"+district+"' and cast(mtp.city as varchar) like '"+city+"' and ld.status like '"+status+"%'" ;
		else
			 sql ="select mtp.managetrainingpartnerid  , ld.loginid  , mtp.trainingpartnername , mtp.pan , "+
						" mtp.websiteurl , (CASE WHEN ld.isActive = 'Y' THEN 'INACTIVE' ELSE 'ACTIVE' END) as updateStatus ,(CASE WHEN ld.isActive = 'Y' THEN 'ACTIVE' ELSE 'INACTIVE' END) as currentstatus from managetrainingpartner as mtp "+
						" inner join logindetails as ld on ld.id=mtp.logindetails ";
			
		Query query = session.createSQLQuery(sql);
		System.out.println("sql===>"+sql);
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
