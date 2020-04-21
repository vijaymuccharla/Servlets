package com.vijay.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		ServletConfig cg=null;
		ServletContext sc=null;
		PrintWriter pw=null;
		//get PrintWriter
		pw=res.getWriter();
		//set content Type
		res.setContentType("text/html");
		//get config object of Generic servlet Class
		cg=getServletConfig();
		//get context object 
		sc=getServletContext();
		//access the config init params of other servlet
		pw.println("<center>");
		pw.println(" details using ServletConfig object <br/>");
		pw.println(" Config init param dbuser :: "+cg.getInitParameter("dbuser")+"<br/><br/>");
		pw.println("<h1>");
		pw.println(" details using ServletContext object <br/>");
		pw.println(" Context init param dbuser :: "+sc.getInitParameter("dbuser")+"<br/>");
		pw.println(" Major version of the Servlet API  :: "+sc.getMajorVersion()+"<br/>");
		pw.println(" Minor version of the Servlet API :: "+sc.getMinorVersion()+"<br/>");
		pw.println(" MIME type :: "+sc.getMimeType("com/vijay/cgfs/applicationContext.xml")+"<br/>");
		pw.println(" name and version of the servlet container :: "+sc.getServerInfo()+"<br/>");
		pw.println(" real path :: "+sc.getRealPath("/")+"<br/>");
		pw.println(" Context path :: "+sc.getContextPath());
		
		pw.println("</h1>");
		pw.println("</center>");
		
	
	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}
	
}
