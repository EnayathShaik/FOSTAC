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

public class GetTrainingCalender extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetTrainingCalender() {
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
		System.out.println("passing name   :" + name);
		String[] totalConnected = name.split("&");
		String courseType="",courseName="",trainingPartner="",trainingCenter="",trainingDate = null,trainingTime = null,trainerName = null,trainingType="";
		
		if(!name.equalsIgnoreCase("ALL")){
		courseType = (totalConnected[0].split("="))[1];
		if(courseType.equals("0")){		courseType = "%";	}
		courseName = (totalConnected[1].split("="))[1];
		if(courseName.equals("0")){		courseName = "%";	}
		trainingPartner = (totalConnected[2].split("="))[1];
		if(trainingPartner.equals("0")){		trainingPartner = "%";	}
		trainingCenter = (totalConnected[3].split("="))[1];
		if(trainingCenter.equals("0")){		trainingCenter = "%";	}
		
		String[] trainingDate1 = totalConnected[4].split("=");
		if(trainingDate1.length == 1){
			trainingDate = "%";
		}else{
			trainingDate = totalConnected[4].split("=")[1];
		}
		String[] trainingTime1 = totalConnected[5].split("=");
		if(trainingTime1.length == 1){
			trainingTime = "%";
		}else{
			trainingTime = totalConnected[5].split("=")[1];
		}
		
		
		String[] trainerName1 = totalConnected[6].split("=");
		System.out.println((totalConnected[6].split("="))[1] + "  **************");
		if((totalConnected[6].split("="))[1].equals("0")){
			trainerName = "%";
		}else{
			trainerName = totalConnected[6].split("=")[1];
		}
		
		
		
		
		
		System.out.println(trainerName);
		
		}
		Configuration conf = new Configuration();
		conf.configure("/hibernate.cfg.xml");
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		String sql = "";
		if(name.equalsIgnoreCase("ALL"))

			sql="select tc.trainingcalendarid ,mtp.trainingpartnername ,  "+
						" concat(pitp.firstname ,  '  ' , pitp.middlename , ' ' , PITP.lastname) as name, "+
						" cn.coursename , ct.coursetype , tc.trainingdate ,tc.trainingtime , pitp.seatcapacitypersession , pitp.seatcapacityavailable , "+
						"   tc.trainingtype  , pitp.trainingcentrename,  concat(pitr.firstname ,  '  ' , pitr.middlename , ' ' , pitr.lastname), tc.batchcode "+
						" ,cn.courseCode from trainingcalendar as tc "+
						" inner join coursename as cn on cn.coursenameid = tc.coursename "+
						" inner join coursetype as ct on ct.coursetypeid = tc.coursetype "+
						" inner join managetrainingpartner as mtp on mtp.managetrainingpartnerid = tc.trainingpartner "+
						" inner join personalinformationtrainingpartner as pitp on mtp.managetrainingpartnerid = pitp.trainingpartnername and tc.trainingcenter = pitp.personalinformationtrainingpartnerid"+
						" inner join personalinformationtrainer as pitr on CAST(CAST (tc.trainername AS NUMERIC(19,4)) AS INT) = pitr.personalinformationtrainerid "+
						" Where to_timestamp(COALESCE(tc.trainingdate, '19900101010101'),'DD-MM-YYYY') > now()" ;
						else
							
		sql="select tc.trainingcalendarid ,mtp.trainingpartnername ,  "+
					" concat(pitp.firstname ,  '  ' , pitp.middlename , ' ' , PITP.lastname) as name, "+
					" cn.coursename , ct.coursetype , tc.trainingdate ,tc.trainingtime , pitp.seatcapacitypersession , pitp.seatcapacityavailable , "+
					"   tc.trainingtype  , pitp.trainingcentrename , concat(pitr.firstname ,  '  ' , pitr.middlename , ' ' , pitr.lastname), tc.batchcode"+
					"  ,cn.courseCode  from trainingcalendar as tc "+
					" inner join coursename as cn on cn.coursenameid = tc.coursename "+
					" inner join coursetype as ct on ct.coursetypeid = tc.coursetype "+
					" inner join managetrainingpartner as mtp on mtp.managetrainingpartnerid = tc.trainingpartner "+
					" inner join personalinformationtrainingpartner as pitp on mtp.managetrainingpartnerid = pitp.trainingpartnername and tc.trainingcenter = pitp.personalinformationtrainingpartnerid"+
					" inner join personalinformationtrainer as pitr on CAST(CAST (tc.trainername AS NUMERIC(19,4)) AS INT) = pitr.personalinformationtrainerid "+
					"  "+
					" where to_timestamp(COALESCE(tc.trainingdate, '19900101010101'),'DD-MM-YYYY') > now() AND CAST(tc.coursename AS varchar(10)) like '"+courseName+"' "+
					//--and cn.modeoftraining like 'Online'
					" and CAST(tc.courseType AS varchar(10)) like '"+courseType+"' "+ 
					" and CAST(tc.trainingpartner AS varchar(10)) like '"+trainingPartner+"' "+ 
					" and CAST(tc.trainingcenter AS varchar(10)) like '"+trainingCenter+"' "+ 
					" and CAST(tc.trainingdate AS varchar(10)) like '"+trainingDate+"' "+ 
					" and CAST(tc.trainingTime AS varchar(10)) like '"+trainingTime+"' "+ 
					" and CAST(tc.trainerName AS varchar(10)) like '"+trainerName+"' "; 
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
