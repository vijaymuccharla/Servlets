//EmployeesearchServlet
package com.vijay.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class  EmployeeSearchServlet extends HttpServlet {
	private static final String EMP_SEARCH_QUERY="SELECT EMPNO,ENAME,DEPTNO,SAL FROM EMP WHERE EMPNO=?";
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs=null;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {

		PrintWriter pw=null;	
		int num=0;
		ServletConfig cg=null;
		ServletContext sc=null;
		String driver=null,url=null,user=null,pwd=null;
		
		try{
			//	get writer
			pw=res.getWriter();
			//set content type
			res.setContentType("text/html");
			//get form data value
			num=Integer.parseInt(req.getParameter("eno"));		
			//get config object
			cg=getServletConfig();
			//get context obj
			sc=getServletContext();
			//get context int param values
			driver=sc.getInitParameter("driver");
			url=sc.getInitParameter("dburl");
			user=sc.getInitParameter("dbuser");
			pwd=sc.getInitParameter("dbpwd");
			
			pw.println("<b> config param value :: dbuser :: "+user);
			
			//set jdbc property values 
			
			//load driver class (mandate because autoloading is not available here in servlet component)
			Class.forName(driver);
			//establis connection with DB
			con=DriverManager.getConnection(url,user,pwd);
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
		catch(ClassNotFoundException cnf){
			pw.println("<center>");
			pw.println("JDBC class problem");
			pw.println("<center>");
			cnf.printStackTrace();
		}	
		catch(SQLException se){
			pw.println("<center>");
			pw.println("SQL error");
			pw.println("<center>");
			se.printStackTrace();
		}

		catch(Exception e){
			pw.println("<center>");
			pw.println("Internal error");
			pw.println("<center>");
			e.printStackTrace();
		}	
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
			pw.println("<h1 style='color:blue'>Servlet name :: "+cg.getServletName()+"</h1><br/>");
			pw.println("<h1 style='color:blue'>Servlet Config class name :: "+cg.getClass()+"</h1>");
			pw.println("<h1 style='color:blue'>Servlet Context class name :: "+sc.getClass()+"</h1>");
			pw.println("<h1 style='color:blue'><a href='input.html'>Home</a></h1>");
			pw.println("</center>");
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
		doGet(req,res);
	}//doPost

}//class
