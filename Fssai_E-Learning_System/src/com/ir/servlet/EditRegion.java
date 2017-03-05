package com.ir.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ir.model.Region;
import com.ir.util.HibernateUtil;
/**
 * Servlet implementation class DeleteState
 */

public class EditRegion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditRegion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
		String name = (request.getQueryString());
		System.out.println("passing name   :" + name);
		String[] totalConnected = name.split("&");
		String regionName,status;
		int  regionId,stateId,districtId,cityId;
		//status = (totalConnected[0].split("="))[1];
		
		regionId = Integer.parseInt((totalConnected[0].split("="))[1]);
		regionName = (totalConnected[1].split("="))[1];
		status = (totalConnected[2].split("="))[1];
		stateId =  Integer.parseInt((totalConnected[3].split("="))[1]);
		districtId =  Integer.parseInt((totalConnected[4].split("="))[1]);
		cityId =  Integer.parseInt((totalConnected[5].split("="))[1]);
		System.out.println("checkkk data==>"+regionId+regionName+stateId+districtId+cityId);
		
		/*Configuration conf = new Configuration();
		conf.configure("/hibernate.cfg.xml");
		SessionFactory sf = conf.buildSessionFactory();*/
		SessionFactory sf = new HibernateUtil().getSessionFactory();
		Session session = sf.openSession();
		System.out.println("status=>"+status);
		if(status.equals("A")){
			
		Region   r=(Region) session.load(Region.class, regionId);
		
		r.setRegionName(regionName);
		r.setStatus("A");
		r.setStateId(stateId);
		r.setDistrictId(districtId);
		r.setCityId(cityId);
		session.update(r);
		session.beginTransaction().commit();
		session.close();
		}
		else 
		{
			Region   r=(Region) session.load(Region.class, regionId);
			
			r.setRegionName(regionName);
			r.setStatus("I");
			r.setStateId(stateId);
			r.setDistrictId(districtId);
			r.setCityId(cityId);
			session.update(r);
			session.beginTransaction().commit();
			session.close();
		}
		String newList = "Records successfully updated !!!" ;
		out.write(newList);
		out.flush();

	}

}
