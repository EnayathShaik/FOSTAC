package com.ir.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ir.model.City;
import com.ir.util.HibernateUtil;
/**
 * Servlet implementation class DeleteState
 */

public class DeleteCity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCity() {
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
		
		/*Configuration conf = new Configuration();
		conf.configure("/hibernate.cfg.xml");
		SessionFactory sf = conf.buildSessionFactory();*/
		SessionFactory sf = new HibernateUtil().getSessionFactory();
		Session session = sf.openSession();
		City   cityNameee=(City) session.load(City.class, Integer.parseInt(name));
		session.delete(cityNameee);
		session.beginTransaction().commit();
		session.close();
		
		/*String sql ="select ct.coursetype , cn.coursename , cn.courseduration , cn.paidunpaid , cn.modeoftraining , cn.status ,cn.coursenameid"+
					" from coursename as cn inner join coursetype as ct on ct.coursetypeid= cn.coursetypeid "+
					" where cn.coursetypeid='"+ Integer.parseInt(courseType) +"' and cn.coursename= '"+ fcn+"'";
		
		Query query = session.createSQLQuery(sql);
		List<CourseName> list = query.list();
		System.out.println(list.size());
		session.close();*/
		String newList = "Records successfully updated !!!" ;
		/*if(list.size() > 0 || list != null){
			System.out.println("data selected finally  " );
			System.out.println(list);
			Gson g =new Gson();
			newList = g.toJson(list); 
		}*/
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
