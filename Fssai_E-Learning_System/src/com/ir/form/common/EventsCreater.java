package com.ir.form.common;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

public class EventsCreater {
	public String timeConvert(int time) { 
		   return time/24/60 + ":" + time/60%24 + ':' + time%60;
		 }
	
	public void createEvents(HttpServletRequest httpServletRequest) throws ParseException {/*

	  try {
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		// root elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("monthly");
		doc.appendChild(rootElement);
		
		
		
		Configuration conf = new Configuration();
		conf.configure("/hibernate.cfg.xml");
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		Query query = session.createSQLQuery("select cn.coursename,tc.trainingdate,tc.trainingtime,SUM(CAST(cn.courseduration AS DECIMAL(10, 2))) as courseduration ,tc.coursetype from trainingcalendar tc inner join coursename cn on tc.coursetype=cn.coursetypeid  GROUP BY tc.trainingdate,tc.trainingtime,tc.coursetype,cn.coursename");
		List<Object[]> eventList = query.list();
		session.close();
		for(int index=0;index<eventList.size();index++){
			Object[] objArr=eventList.get(index);
			// staff elements
			Element event = doc.createElement("event");
			rootElement.appendChild(event);
			
			//id
			Element id = doc.createElement("id");
			id.appendChild(doc.createTextNode(String.valueOf(index)));
			event.appendChild(id);
			// name elements
			Element name = doc.createElement("name");
			name.appendChild(doc.createTextNode(objArr[0].toString()));
			event.appendChild(name);
			

			// startdate elements
			Element startdate = doc.createElement("startdate");
			
			String[] convetedTime;
			try {
				String ed = objArr[1].toString();  // Start date
				if(ed != null && ed.length() >0){
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					Calendar c = Calendar.getInstance();
					String formateDate = ed.substring(6,10) + "-" + ed.substring(3,5)+ "-" + ed.substring(0,2);
					c.setTime(sdf.parse(formateDate));
					startdate.appendChild(doc.createTextNode(formateDate));
					event.appendChild(startdate);
					
					convetedTime = timeConvert((int)Double.parseDouble(objArr[3].toString())).split(":");
					c.add(Calendar.DATE,Integer.parseInt(convetedTime[0]));  // number of days to add
					
					ed = sdf.format(c.getTime());
				
					// enddate elements
					Element enddate = doc.createElement("enddate");
					enddate.appendChild(doc.createTextNode(ed));
					event.appendChild(enddate);
		
					// starttime elements
					Element starttime = doc.createElement("starttime");
					starttime.appendChild(doc.createTextNode(objArr[2].toString()));
					event.appendChild(starttime);
		
					// endtime elements
					Element endtime = doc.createElement("endtime");
					endtime.appendChild(doc.createTextNode(convetedTime[1]+":"+convetedTime[2]));
					event.appendChild(endtime);
				}
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
			// color elements
			Element color = doc.createElement("color");
			color.appendChild(doc.createTextNode("#ffb128"));
			event.appendChild(color);
			
			Element url = doc.createElement("url");
			url.appendChild(doc.createTextNode("calendarSearch.fssai?courseTypeId="+objArr[4].toString()+"&trainingDate='"+objArr[1].toString()+"'"));
			event.appendChild(url);


		}
				// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		
		StreamResult result = new StreamResult(new File(httpServletRequest.getServletContext().getRealPath("/website/js/events.xml")));

		// Output to console for testing
		// StreamResult result = new StreamResult(System.out);
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.transform(source, result);

		System.out.println("File saved!");

	  } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	  } catch (TransformerException tfe) {
		tfe.printStackTrace();
	  }
	*/}
}