package com.ir.util;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class GenerateUniqueID {

	@Autowired
	@Qualifier("sessionFactory")
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public static void setSessionFactory(SessionFactory sessionFactory) {
		GenerateUniqueID.sessionFactory = sessionFactory;
	}


	public static  String getNextCombinationId(String prefix)
	{
		String combinationId =  null;
		BigInteger getNextId =  getNextId();
		combinationId =prefix+ getFourDigitFormat(getNextId) ;
		
		return combinationId;

	}
	
	
	public static BigInteger getNextId(){
		BigInteger count = new BigInteger("0");
		Session session = sessionFactory.openSession();
		String sql = "select count(1)+1 from personalinformationtrainee";
		Query query = session.createSQLQuery(sql);
		List listCount = query.list();
		if(listCount.size()>0){
			count = (BigInteger) listCount.get(0);
		}
		return count;
	}
	
	
	private static String getFourDigitFormat(BigInteger getNextId)
	{
		 String pattern="00000";
		 DecimalFormat myFormatter = new DecimalFormat(pattern);
		 String output = myFormatter.format(getNextId);
		 return output;
	}
}
