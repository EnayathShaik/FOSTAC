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

import com.ir.model.City;
import com.ir.model.District;
import com.ir.model.State;

/**
 * Servlet implementation class DeleteState
 */

public class UpdateMTP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMTP() {
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
		String [] total = name.split(",");
		String status = total[0];
		String url = total[1];
		String email = total[2];
		String address1 = total[3];
		String address2 = total[4];
		String pin = total[5];
		String state = total[6];
		String district = total[7];
		String city = total[8];
		String mtpId = total[9];
		String isActive = (status.equalsIgnoreCase("A") ? "Y" : "N");
		System.out.println("status>"+status+url+email+address1+address2+pin+state+district+city+mtpId);

		State s = new State();
		s.setStateId(Integer.parseInt(state));
		District d = new District();
		d.setDistrictId(Integer.parseInt(district));
		City c = new City();
		c.setCityId(Integer.parseInt(city));
		
		
		Configuration conf = new Configuration();
		conf.configure("/hibernate.cfg.xml");
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		String selectLoginDetails = "select logindetails from managetrainingpartner where managetrainingpartnerid = '"+mtpId+"'";
		Query querySel = session.createSQLQuery(selectLoginDetails);
		String selectSel = querySel.getQueryString();
		System.out.println("login id is   :"+ selectSel);
		
		String sql="UPDATE managetrainingpartner "+
				" SET city='"+c.getCityId()+"',  "+
				" district='"+d.getDistrictId()+"', email='"+email+"', "+
				" headofficedataaddress1='"+address1+"', headofficedataaddress2='"+address2+"', "+
				" pin='"+pin+"', state='"+s.getStateId()+"' , "+
				" websiteurl='"+url+"' "+
				" WHERE managetrainingpartnerid = '"+mtpId+"' ";

		String sqlLD = "update logindetails set status ='"+status+"' , isactive = '"+isActive+"' where id =("+selectSel+")"; 
		Query query = session.createSQLQuery(sql);
		Query query2 = session.createSQLQuery(sqlLD);
		System.out.println(sql);
		
		Integer i = query.executeUpdate();
		System.out.println("i  :"+ i);
		Integer j = query2.executeUpdate();
		System.out.println("j  :"+ j);
		System.out.println("sql==>"+sqlLD);
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
