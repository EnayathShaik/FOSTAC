package com.ir.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.zentect.ajax.AjaxRequest;
/**
 * Servlet implementation class DeleteState
 */

public class GetCourseDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCourseDetails() {
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
		String courseName,modeOfTraining,trainingPatrtner,trainingDate = null,trainingCenterState,trainingCenterDistrict , courseType;
		
		courseName = (totalConnected[0].split("="))[1];
		if(courseName.equals("0")){		courseName = "%";	}
		modeOfTraining = (totalConnected[1].split("="))[1];
		if(modeOfTraining.equals("0")){		modeOfTraining = "%";	}
		trainingPatrtner = (totalConnected[2].split("="))[1];
		if(trainingPatrtner.equals("0")){		trainingPatrtner = "%";	}
		String[] trainingDate1 = totalConnected[3].split("=");
	/*	if(trainingDate1.length == 1){
			trainingDate = "%";
		}else{
			trainingDate = totalConnected[3].split("=")[1];
		}*/
		trainingCenterState = (totalConnected[3].split("="))[1];
		if(trainingCenterState.equals("0")){		trainingCenterState = "%";	}
		trainingCenterDistrict = (totalConnected[4].split("="))[1];
		if(trainingCenterDistrict.equals("0")){		trainingCenterDistrict = "%";	}
		courseType = (totalConnected[5].split("="))[1];
		if(courseType.equals("0")){		courseType = "%";	}
		String sql ="select tc.trainingcalendarid , concat(pitp.trainingpartnerpermanentline1 , ' ' , pitp.trainingpartnerpermanentline2 , ' ' , s.statename , ' ' , d.districtname , ' ' , c.cityname) as address, "+
				" concat(tc.trainingdate , ' / ' , tc.trainingtime) as schedule , "+
				" concat(pitp.firstname , ' ' , pitp.middlename , ' ' , pitp.lastname ) ,concat( pitp.trainingpartnerpermanentmobile , ' / ' , pitp.trainingpartnerpermanentemail)  as contact, "+
				" tc.seatCapacity ,(CAST(CAST (tc.seatCapacity AS NUMERIC(19,4)) AS INT) - ( select count(1) from courseenrolleduser where trainingcalendarid = tc.trainingcalendarid)) "+
				" ,cn.courseCode , tc.trainingDate, tc.batchCode, cn.courseduration  "+
				" from trainingcalendar as tc "+
				" inner join coursename as cn on cn.coursenameid = tc.coursename "+
				" inner join coursetype as ct on ct.coursetypeid = tc.coursetype "+
				" inner join managetrainingpartner as mtp on mtp.managetrainingpartnerid = tc.trainingpartner "+
				" inner join personalinformationtrainingpartner as pitp on mtp.managetrainingpartnerid = pitp.trainingpartnername "+
				" inner join state as s on s.stateid = pitp.trainingpartnerpermanentstate "+
				" inner join city as c on c.cityid = pitp.trainingpartnerpermanentcity "+
				" inner join district as d on d.districtid = pitp.trainingpartnerpermanentdistrict "+
				" and tc.trainingcenter = pitp.personalinformationtrainingpartnerid "+
				" where CAST(tc.coursename AS varchar(10)) like '"+courseName+"' "+
				" and CAST(tc.courseType AS varchar(10)) like  '"+courseType+"' "+
				//" and cn.modeoftraining like '"+modeOfTraining+"' "+
				" and CAST(tc.trainingpartner AS varchar(10)) like '"+trainingPatrtner+"'  "+
				//" and CAST(tc.trainingdate AS varchar(10)) like '"+trainingDate+"' "+
				" and CAST(s.stateid AS varchar(10)) like '"+trainingCenterState+"' "+
				" and CAST(d.districtid AS varchar(10)) like '"+trainingCenterDistrict+"' "+
				" and  to_timestamp(COALESCE(tc.trainingdate, '19900101010101'),'DD-MM-YYYY') > CURRENT_TIMESTAMP - INTERVAL '1 days' and  (CAST(CAST (tc.seatCapacity AS NUMERIC(19,4)) AS INT) - ( select count(1) from courseenrolleduser where trainingcalendarid = tc.trainingcalendarid) > 0)";
	
		List list = new AjaxRequest().returnList(sql);
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
		String sql ="select tc.trainingcalendarid , concat(pitp.trainingpartnerpermanentline1 , ' ' , pitp.trainingpartnerpermanentline2 , ' ' , s.statename , ' ' , d.districtname , ' ' , c.cityname) as address, "+
					" concat(tc.trainingdate , ' / ' , tc.trainingtime) as schedule , "+
					" concat(pitp.firstname , ' ' , pitp.middlename , ' ' , pitp.lastname ) ,concat( pitp.trainingpartnerpermanentmobile , ' / ' , pitp.trainingpartnerpermanentemail)  as contact, "+
					" pitp.seatcapacitypersession ,(CAST(CAST (pitp.seatcapacitypersession AS NUMERIC(19,4)) AS INT) - ( select count(1) from courseenrolleduser where trainingcalendarid = tc.trainingcalendarid)) "+
					" from trainingcalendar as tc "+
					" inner join coursename as cn on cn.coursenameid = tc.coursename "+
					" inner join coursetype as ct on ct.coursetypeid = tc.coursetype "+
					" inner join managetrainingpartner as mtp on mtp.managetrainingpartnerid = tc.trainingpartner "+
					" inner join personalinformationtrainingpartner as pitp on mtp.managetrainingpartnerid = pitp.trainingpartnername "+
					" inner join state as s on s.stateid = pitp.trainingpartnerpermanentstate "+
					" inner join city as c on c.cityid = pitp.trainingpartnerpermanentcity "+
					" inner join district as d on d.districtid = pitp.trainingpartnerpermanentdistrict "+
					" and tc.trainingcenter = pitp.personalinformationtrainingpartnerid "+
					" where CAST(tc.coursename AS varchar(10)) like '"+courseName+"' "+
					//--and CAST(tc.courseType AS varchar(10)) like '%' 
					//" and cn.modeoftraining like '"+modeOfTraining+"' "+
					" and CAST(tc.trainingpartner AS varchar(10)) like '"+trainingPatrtner+"'  "+
					" and CAST(tc.trainingdate AS varchar(10)) like '"+trainingDate+"' "+
					" and CAST(s.stateid AS varchar(10)) like '"+trainingCenterState+"' "+
					" and CAST(d.districtid AS varchar(10)) like '"+trainingCenterDistrict+"' "+
					"  and  (CAST(CAST (pitp.seatcapacitypersession AS NUMERIC(19,4)) AS INT) - ( select count(1) from courseenrolleduser where trainingcalendarid = tc.trainingcalendarid) > 0)";
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
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
