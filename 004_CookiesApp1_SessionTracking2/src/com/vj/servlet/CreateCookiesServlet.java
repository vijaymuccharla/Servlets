package com.vj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/createurl")
public class CreateCookiesServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Cookie ck1=null,ck2=null,ck3=null,ck4=null;
		//get writer
		PrintWriter pw=resp.getWriter();
		//set content type
		resp.setContentType("text/html");
		//create 2 in-memory coockies and add them to current session
		//create object of cookie
		ck1=new Cookie("Priya", "Female");
		ck2=new Cookie("Rakesh", "Male");
		resp.addCookie(ck1);		//these will stay as long as the session is on, once browser closed/session closed, cookies will be deleted
		resp.addCookie(ck2);
		
		//create 2 persistent cookies
		ck3=new Cookie("BMW", "Luxury");
		ck4= new Cookie("Scoda", "SUV");
		//set age of cookies (persistent cookies)
		ck3.setMaxAge(120);		//secs		//these will deleted after given time automatically
		ck4.setMaxAge(60);	//secs		//these will deleted after given time automatically
		
		resp.addCookie(ck3);
		resp.addCookie(ck4);
		
		pw.println("<br/><br/><br/><br/><br/><h1 style='color:green;text-align:center'> Cookies added successfully</h1>");
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
