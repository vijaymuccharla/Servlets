//EmployeesearchServlet
package com.vijay.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class  EmployeeSearchServlet extends HttpServlet {
	private static final String EMP_SEARCH_QUERY="SELECT EMPNO,ENAME,DEPTNO,SAL FROM EMP WHERE EMPNO=?";
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs=null;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {

		System.out.println("EmployeeSearchServlet.doGet()");
		PrintWriter pw=null;	
		int num=0;
		ServletContext sc=null;
		String driver=null,url=null,user=null,pwd=null;
		RequestDispatcher rd1=null,rd2=null,rd3=null,rd4=null,rd5=null,rd6=null,rd7=null,rd8=null;
		
		try{
			//	get writer
			pw=res.getWriter();
			//set content type
			res.setContentType("text/html");
			//get context obj
			sc=getServletContext();
			
			//get form data value
			num=Integer.parseInt(req.getParameter("eno")); //this may raise NFException		
				
			//get context int param values
			driver=sc.getInitParameter("driver");
			url=sc.getInitParameter("dburl");
			user=sc.getInitParameter("dbuser");
			pwd=sc.getInitParameter("dbpwd");
			
			
			//set jdbc property values 
			
			//load driver class (mandate because autoloading is not available here in servlet component)
			Class.forName(driver);
			
			//establis connection with DB
			System.out.println("EmployeeSearchServlet loaded Diver Class, Establishing Connection.............. ");
			con=DriverManager.getConnection(url,user,pwd);
			System.out.println("EmployeeSearchServlet loaded Diver Class, Connection Established.............. ");
			
			//forward req to Headr using rd.include
			rd7=req.getRequestDispatcher("/headerurl");
			System.out.println("\nEmployeeSearchServlet :: request forwarded to Source Servlet ");
			rd7.include(req, res);
			System.out.println("\nEmployeeSearchServlet :: response sent back to Destination Servlet ");
			System.out.println("\nEmployeeSearchServlet :: reponse included with Source Servlet");
				
					
			pw.println("<b/> context param value :: dbuser :: "+user);
			//create prepared Statement as we are using query params
			ps=con.prepareStatement(EMP_SEARCH_QUERY);
			//set query param
			ps.setInt(1, num);
			//create ResultSet object, send execute the query
			rs=ps.executeQuery();
			//gather results
			if(rs.next()){
				pw.println("<center>");
				pw.println("<h1 style='color:green'> Employee details </h1><br/><br/>");
				pw.println(" Employee ID : "+rs.getInt(1)+"<br/><br/>");
				pw.println(" Name			 : "+rs.getString(2)+"<br/><br/>");
				pw.println(" Department  : "+rs.getString(3)+"<br/><br/>");
				pw.println(" Salary            :	"+rs.getDouble(4)+"<br/><br/>");
				pw.println("<center>");

			}
			else{
				pw.println("<center>");
				pw.println("<h1 style='color:green'> Employee not found </h1>");
				pw.println("</center>");
			}
		}//try
		
		catch(Exception e){
			
			
//pw.close();	//DO NOT CLOSE PW before rd.forward bcoz it cannot take any further pw.println() method calls
			
			//using Request object to communicate with ERROR SERVLET passing URL pattern
			
			/*	rd1= req.getRequestDispatcher("/errorurl");		//    '/' slash is optional
				System.out.println("\nEmployeeSearchServlet :: BEFORE request forward using REQ");
				rd1.forward(req, res);
				System.out.println("\nEmployeeSearchServlet :: AFTER request forward using REQ");
				*/
			
//	if we call rd.forward twice	--->IllegalStateException: Cannot forward after response has been committed
			
			//using request object to communicate with HTML error page passing  URLpattern
			/*
			 		rd2=req.getRequestDispatcher("errormsg.html");
					System.out.println("\nEmployeeSearchServlet :: before error HTML");
					rd2.forward(req, res);
					System.out.println("\nEmployeeSearchServlet :: after error HTML");
			*/
			
//  	using ServletContext object to communicate with Error Servlet passing URLpattern
			/*
			rd3=sc.getRequestDispatcher("/errorurl");		//    '/' slash is mandatory
			System.out.println("\nEmployeeSearchServlet :: BEFORE request forward using SC");
			rd3.forward(req, res);
			System.out.println("\nEmployeeSearchServlet :: AFTER request forward using SC");
			*/
		
//	  	using ServletContext object to communicate with HTML page passing URLpattern
			/*
			rd4=sc.getRequestDispatcher("/errormsg.html");		//    '/' slash is mandatory
			System.out.println("\nEmployeeSearchServlet :: BEFORE request forward using SC");
			rd4.forward(req, res);
			System.out.println("\nEmployeeSearchServlet :: AFTER request forward using SC");
			*/
			
//	using ServletContext.getName object to communicate with Error Servlet using LOGICAL VIEW NAME**
			rd5=sc.getNamedDispatcher("errorservlet");
			//here it is not possible to pass LVN of HTML/JSP files*******
			System.out.println("EmployeeSearchServlet :: BEFORE req forward using SC");
			rd5.forward(req, res);
			System.out.println("EmployeeSearchServlet :: AFTER req forward using SC");
			
			
		}	//catch
		
		finally{
			//close stram objs
			try{
				if(con!=null)
					con.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			try{
				if(ps!=null)
					ps.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			try{
				if(rs!=null)
					rs.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			
			pw.println("<center>");
			pw.println("<h1 style='color:blue'><a href='input.html'>Home</a></h1>");
			pw.println("</center>");
			
			//forward req to footer.html to add footer and rd.include
			rd8=req.getRequestDispatcher("footer.html");	 //  '/' slash is optional again
			System.out.println("\nEmployeeSearchServlet:: request forwarded to footer.html...");
			rd8.include(req, res);
			System.out.println("\nEmployeeSearchServlet :: included footer.HTML as response");
			
			try{
				if(pw!=null)
					pw.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}//finally

	}//doGet

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
		System.out.println("EmployeeSearchServlet.doPost()");
		doGet(req,res);
	}//doPost

}//class
