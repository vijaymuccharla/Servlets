package com.vijay.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProcessServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter pw=null;
		String comp=null;
		int val1=0,val2=0;
		//get Writer from response
		pw=resp.getWriter();
		//set content Type
		resp.setContentType("text/html");
		//get s1 req param value that is used to send the request
		comp=req.getParameter("s1");
		pw.println("<center>");
		//wirte logic
		if(comp.equalsIgnoreCase("link1")) {//date
			pw.println("<h1 style='color:green'>Date and time ::"+new Date()+"</h1>");
		}
		else if(comp.equalsIgnoreCase("link2")) {//system properties
			pw.println("<h1 style='color:green'> System properties :: "+System.getProperties()+"</h1>");
		}
		else if(comp.equalsIgnoreCase("add")) {
			val1=Integer.parseInt(req.getParameter("t1"));
			val2=Integer.parseInt(req.getParameter("t2"));
			pw.println("<h1 style='color:green'> Addition :: "+val1+" + "+val2+"= "+(val1+val2)+"</h1>");
		}
		else if(comp.equalsIgnoreCase("subtract")) {
			val1=Integer.parseInt(req.getParameter("t1"));
			val2=Integer.parseInt(req.getParameter("t2"));
			pw.println("<h1 style='color:green'> Subtraction:: "+val1+" - "+val2+"= "+(val1-val2)+"</h1>");
		}
		else {
			val1=Integer.parseInt(req.getParameter("t1"));
			val2=Integer.parseInt(req.getParameter("t2"));
			pw.println("<h1 style='color:green'> Multiplied :: "+val1+" * "+val2+"= "+(val1*val2)+"</h1>");
		}
		pw.println("<a href='form.html'>Home</a>");
		pw.println("</center>");
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		doGet(req,resp);
		
	}
}
