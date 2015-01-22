<%@page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%
String name = request.getParameter("name").toString();
String data ="";
try{
           Class.forName("org.postgresql.Driver");
           Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "admin");
           Statement st=con.createStatement();
           ResultSet rs=st.executeQuery("select * from obiekt where nazwa='"+name+"'");
int count=0;
          while(rs.next())
          {

                   count++;
          }

                    if(count>0)
          {
             data="Podana nazwa jest już zajęta!";
          }
          else
          {
                      data="";
          }
out.println(data);
}
catch (Exception e) {
System.out.println(e);
}
%>