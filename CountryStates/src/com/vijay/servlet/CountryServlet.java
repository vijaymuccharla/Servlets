package com.vijay.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CountryServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	PrintWriter pw=null;
	int number=0;
		//get writer from response
		pw=resp.getWriter();
		//set content type
		resp.setContentType("text/html");
		//get form parameter values
		number=Integer.parseInt(req.getParameter("country"));
		//declare states of the respective countries
		String[] state= {"Washington DC","New Delhi","Moscow","Beijing"};
		//perform business login to display the state base on the Country selected
		pw.println("<center>");
		if(number==0) {
			pw.println("<h1 style='color:green'>  Country : U.S.A </h1>");
			pw.println("<h1 style='color:green'>  State : "+state[number]+"</h1>");
		}
		else if(number==1) {
			pw.println("<h1 style='color:green'>  Country : India</h1>");
			pw.println("<h1 style='color:green'>  State : "+state[number]+"</h1>");
		}
		else if(number==2) {
			pw.println("<h1 style='color:green'>  Country : Russia </h1>");
			pw.println("<h1 style='color:green'>  State : "+state[number]+"</h1>");
		}
		else{
				pw.println("<h1 style='color:green'>  Country : China </h1>");
				pw.println("<h1 style='color:green'>  State : "+state[3]+"</h1>");
			}
		pw.println("<br/><br/><h1><a href='home.html'>Home</a></h1>");
		pw.println("</center>");
		
	}//doGet
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//call doGet 
		doGet(req,resp);
	}//doPost
}//class