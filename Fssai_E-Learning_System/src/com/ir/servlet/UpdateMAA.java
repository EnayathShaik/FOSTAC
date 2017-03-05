package com.ir.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Servlet implementation class DeleteState
 */

public class UpdateMAA extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMAA() {
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
		String [] total = name.split("&");
		String userId = total[0].split("=")[1];
		String status = total[1].split("=")[1];
		String websiteUrl = total[2].split("=")[1];
		String email = total[3].split("=")[1];
		String headOfficeDataAddress1 = total[4].split("=")[1].replaceAll("%20", " ");
		String headOfficeDataAddress2 = total[5].split("=")[1].replaceAll("%20", " ");
		System.out.println("address 1  :"+ headOfficeDataAddress1 +"     "+ headOfficeDataAddress2);
		String pin = total[6].split("=")[1];
		String stateId = total[7].split("=")[1];
		String district = total[8].split("=")[1];
		String city = total[9].split("=")[1];
		String isActive = status.equalsIgnoreCase("A")?"Y":"N";

		Configuration conf = new Configuration();
		conf.configure("/hibernate.cfg.xml");
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		String selectLoginDetails = "select logindetails from manageassessmentagency where manageassessmentagencyid = '"+userId+"'";
		Query querySel = session.createSQLQuery(selectLoginDetails);
		String selectSel = querySel.getQueryString();
		System.out.println("login id is   :"+ selectSel);
		
		String sql="UPDATE manageassessmentagency "+
				" SET city='"+city+"',  "+
				" district='"+district+"', email='"+email+"', "+
				" headofficedataaddress1='"+headOfficeDataAddress1+"', headofficedataaddress2='"+headOfficeDataAddress2+"', "+
				" pin='"+pin+"', stateid='"+stateId+"', "+
				" websiteurl='"+websiteUrl+"' "+
				" WHERE manageassessmentagencyid = '"+userId+"' ";

		String sqlLD = "update logindetails set status ='"+status+"' , isactive = '"+isActive+"' where id =("+selectSel+")";
		Query query2 = session.createSQLQuery(sqlLD);

		Query query = session.createSQLQuery(sql);
		System.out.println(sql);
		Integer i = query.executeUpdate();
		System.out.println("i  :"+ i);
		
		Integer j = query2.executeUpdate();
		System.out.println("j  :"+ j);
		session.beginTransaction().commit();
		session.close();
		String newList = null ;
		if(i > 0 ){
			System.out.println("data selected finally  " );
			newList = "Data updated successfully"; 
		}else{
			newList = "Oops , something went wrong try ageain !!!";
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
