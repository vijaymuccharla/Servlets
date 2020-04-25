package com.vj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


/*
CREATE TABLE `springcore`.`person_info` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `fname` VARCHAR(45) NULL,
  `marital_status` VARCHAR(45) NULL,
  `info1` VARCHAR(45) NULL,
  `info2` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

*/
@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
	
	private static final String PERSON_DATA_QUERY="INSERT INTO PERSON_INFO VALUES(ID,?,?,?,?,?)";
	
	@Resource(name = "myjndi")
	private DataSource ds;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String hpname=null,hfname=null,hmstatus=null,sT1=null,sT2=null;
		int count=0;
		Connection con=null;
		PreparedStatement ps=null;
		
		
		//get writer
		PrintWriter pw=resp.getWriter();
		//set content type
		resp.setContentType("text/html");
		
		//read form1/req1 deatails HIDDEN in form2(HIDDENtext)/request2 data and display all the details entered by the enduser
		hpname=req.getParameter("hpname");
		hfname=req.getParameter("hfname");
		hmstatus=req.getParameter("hmstatus");

		//read form2/req2 data and display all the details entered by the enduser
		sT1=req.getParameter("t1");
		sT2=req.getParameter("t2");
		
		
		//insert record into DB
		try {
			//create Connection object
			con=ds.getConnection();
			//create PreparedStatement
			ps=con.prepareStatement(PERSON_DATA_QUERY);
			//set form1/reuest1 and form2/request2 data  to QEURY params
			ps.setString(1, hpname);
			ps.setString(2, hfname);
			ps.setString(3, hmstatus);
			ps.setString(4, sT1);
			ps.setString(5, sT2);
			
			//execute the query and collext no.of records inserted in DB table
			count=ps.executeUpdate();
			if(count==0) {
				pw.println("<center>");
				pw.println("<h1 style='color:blue;text-align:center'> ---------- RESULT PAGE --------- </h1>");
				pw.println("<h2 style='color:red;text-align:center'> Profile registration failed </h2>");
			}
			else {
				pw.println("<center>");
				pw.println("<h1 style='color:blue;text-align:center'> ---------- RESULT PAGE --------- </h1>");
				pw.println("<h2 style='color:green;text-align:center'> Profile registered successfully </h2>");
			}
				
		}//try
		catch(SQLException se) {
			pw.println("<h2 style='color:red;text-align:center'> Profile registration failed, DB problem </h2>");
			se.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			//close streams
			try {
				if(con!=null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				if(ps!=null)
					ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}//finally
		
		
		
		//wirter to response
		pw.println("<h3 style='color:green'> Form1/Request1 Data :: "+hpname+"..."+hfname+"..."+hmstatus+"</h3>");

		pw.println("<h3 style='color:blue'> Form2/Request2 Data :: "+sT1+"..."+sT2+"</h3>");
		pw.println("</center>");

		pw.println("<h2 style='color:blue;text-align:center'> <a href='form1.jsp'> Home </a></h2>");
		/*
				Here form 1/request1 has values are stored to form2 using HIDDEN text boxes hence the 2nd request can access them.
				So form1/Form2 values are VISIBLE to 2nd Servlet also.

				 Session Tracking-Hiddent Text Boxes 
		 */		

		//close stream
		pw.close();

	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
