<%@ page import="java.io.*,java.sql.*" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
 
<%
 
            String sn=request.getParameter("ver");
 
                    Class.forName("org.postgresql.Driver");
                    Connection con =DriverManager.getConnection("jdbc:postgresql://localhost/Fssai","postgres","postgres");
                    Statement st=con.createStatement();
                    //ResultSet rs = st.executeQuery("select * from emp where empno="+sn);
                    ResultSet rs = st.executeQuery("select * from loginDetails where loginid='"+sn+"'");  // this is for name
                    if(rs.next())
                    {    
                        out.println("<font color=red>");
                        out.println("Name already taken");
                        out.println("</font>");
 
                    }else {
 
                        out.println("<font color=green>");
                        out.println("Available");
                        out.println("</font>");
 
                    }
 
rs.close();
st.close();
con.close();
 
%>