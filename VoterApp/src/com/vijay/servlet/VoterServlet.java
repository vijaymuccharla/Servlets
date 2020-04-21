package com.vijay.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VoterServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw=null;
		String name=null,gender=null;
		int age=0;
		//get writer
		pw=resp.getWriter();
		//set content type
		resp.setContentType("text.html");
		//get req parameters
		name=req.getParameter("name");
		age=Integer.parseInt(req.getParameter("age"));
		gender=req.getParameter("gender");
		//perform business logic operations
		if(gender.equalsIgnoreCase("M")) {
			if(age>=28) {
				pw.println("<center><h1 style='color:green'> Mr. "+name+" is Eligible!! </h1></center>");
			}
			else{
				pw.println("<center><h1 style='color:red'> Mr. "+name+" is not Eligible!! </h1></center>");
			}
		}
		else if(gender.equalsIgnoreCase("F")) {
			if(age>=23) {
				pw.println("<center><h1 style='color:green'> Ms. "+name+" is Eligible!! </h1></center>");
			}
			else{
				pw.println("<center><h1 style='color:red'> Ms. "+name+" is not Eligible!! </h1></center>");
			}
		}//else if
		pw.println("<center><a href='Home.html'> <img src='home.jpg'><br>Home</a></center>");
	}//get
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		this.doGet(req,res);
	}//post
}//class
