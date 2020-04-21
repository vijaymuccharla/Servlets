package com.vijay.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CountryServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
		PrintWriter pw=null;
		String link=null;
		Locale[] locales=null;
		
		//set content type
		res.setContentType("text/html");
		
		//get writer from response object
		pw=res.getWriter();

		//create hyperlink for home
		pw.println("<center>");
		pw.println("<a href='home.html'><h1>HomePage</h1></a>");
		pw.println("</center>");
		
		//get request parameters
		link=req.getParameter("s1");
		
		//perform B.logic
		//get all available locales from Locale  class
		locales=Locale.getAvailableLocales();
		if(link.equalsIgnoreCase("link1")) {
			pw.println("<center>");
			pw.println("<h1 style='color:green'>Available Contries </h1>");
			for(Locale l:locales) 
				pw.println(l.getDisplayCountry()+"<br>");
			pw.println("</center>");
		}//if
		
		else if(link.equalsIgnoreCase("link2")) {
			pw.println("<center>");
			pw.println("<h1 style='color:green'>Available Languages</h1>");
			for(Locale l:locales) 
				pw.println(l.getDisplayLanguage()+"<br>");
			pw.println("</center>");
		}//esle if
		
		else {
			pw.println("<center>");
			pw.println("<h1 style='color:green'>Current Date/Time</h1><br>");
			pw.println("<h1 style='color:aqua'>"+new Date()+"</h1>");
			pw.println("</center>");
		}
	}//doGet
}//class