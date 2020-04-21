package com.vijay.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

//@WebServlet(urlPatterns = "/registerurl") 
@WebServlet(name = "hospital" ,urlPatterns = "/patienturl", loadOnStartup = 1)
public class PatientRegistrationServlet extends HttpServlet {
	@Resource(name  = "myjndi")
	private DataSource ds;
	public PatientRegistrationServlet() {
		
		System.out.println("PatientRegistrationServlet :: 0-param constructor");
	}
	
	private static final String INSERT_PATIENT_DETAILS = " INSERT INTO PATIENTREGISTRATION VALUES(regId,?,?,?,?,?) ";

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		PrintWriter pw = null;
		String pName = null, pAddrs = null, pGender = null, pStage = null;
		int age = 0, count = 0;
		Connection con = null;
		PreparedStatement ps = null;
		ServletConfig cg=null;
		
		// get writer from response object
		pw = res.getWriter();
		// set response type
		res.setContentType("text/html");
		// get req parameters
		pName = req.getParameter("name");
		pAddrs = req.getParameter("addrs");
		age = Integer.parseInt(req.getParameter("age"));
		pGender = req.getParameter("gender");
		pStage = req.getParameter("stage");
		//get ServletConfig object
		cg=getServletConfig();


		try {
			
			// get connection obj from Connection pool using JNDI
//			con = getConnectionObj(); // connection object from Connection POOL
			con=ds.getConnection();		//connection object via @Resource annotation dependency lookup
			
			// create Prepared Statement
			ps = con.prepareStatement(INSERT_PATIENT_DETAILS);
			// set query param values
			ps.setString(1, pName);
			ps.setString(2, pAddrs);
			ps.setInt(3, age);
			ps.setString(4, pGender);
			ps.setString(5, pStage);

			// execute query to insert/register Patient detials
			count = ps.executeUpdate();

			if (count == 0) {
				pw.println("<h1 style='color:red;text-align:center' > Registration Failed </h1>");
			} else {
				pw.println("<h1 style='color:green;text-align:center' > Registration Success </h1>");
			}
			
			pw.println(" Servlet Name :: "+cg.getServletName()+"</h1>");

			
			
	

		} // try
		catch (SQLException se) {
			pw.println("<h1 style='color:red;text-align:center' > DB problem </h1>");
			se.printStackTrace();
		} catch (Exception e) {
			pw.println("<h1 style='color:red;text-align:center' > Unknown problem </h1>");
			e.printStackTrace();
		} finally {
			// close stream objects
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			pw.println("<h1 style='text-align:center' ><a href='home.html'> --Go to Homepage-- </a></h1>");
			try {
				if (pw != null)
					pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		} // finally

	}// doGet

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
	/*				
						// method to return connection object from Server Managed JDBC connection pool
						public Connection getConnectionObj() throws Exception {
					
							InitialContext ic = null;
							DataSource ds = null;
							Connection con = null;
							// Establish connection with JNDI registry
							ic = new InitialContext();
							// get Datasource object from JNDI registry
							ds = (DataSource) ic.lookup("java:/comp/env/myjndi"); // look up operation on JNDI con pool
							// get JDBC connection object from JDBC connection pool
							con = ds.getConnection();
					
							return con;
						}
	*/
}//class
