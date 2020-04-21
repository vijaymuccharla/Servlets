package com.vijay.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LcTestServlet extends HttpServlet{
	
	public LcTestServlet() {
		System.out.println("LcTestServlet.0-param Constructor");
	}
	@Override
	public void init() throws ServletException {
	System.out.println("LcTestServlet.init()");
	
	}
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	System.out.println("LcTestServlet.service(-,-)");
	PrintWriter pw=null;
	//get writer
	pw=res.getWriter();
	//set content type
	res.setContentType("text/html");
	//write b logic
	pw.println("<center>");
	pw.println("<h1 style='color:green'>Date and time is :: "+new Date()+"</h1>");
	pw.println("</center>");
	//close stream
	pw.close();
	}
	
	@Override
	public void destroy() {
		System.out.println("LcTestServlet.destroy()");
	}

}//class
