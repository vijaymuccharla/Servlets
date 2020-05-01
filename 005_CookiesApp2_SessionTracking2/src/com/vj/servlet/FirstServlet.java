package com.vj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=null,fname=null,gender=null;
		Cookie ck1=null,ck2=null,ck3=null;
//		get writer'
		PrintWriter pw=resp.getWriter();
//		set content type
		resp.setContentType("text/html");
//		read form data 
		name=req.getParameter("name");
		fname=req.getParameter("fname");
		gender=req.getParameter("gender");
		
//		set from data to in-memory cookies
		ck1=new Cookie("name", name);
		ck2=new Cookie("fname", fname);
		ck3=new Cookie("gender", gender);
		
//		add cookies to response
		resp.addCookie(ck1);
		resp.addCookie(ck2);
		resp.addCookie(ck3);
 
		//dynamic web page for second servlet url
		pw.println("<center>");
		pw.println("<h1 style=color:green;text-align=center'> Income Details </h1>");
		pw.println("<form action='secondurl' method='post'>"
				+ "<table bgcolor='lightgreen'>"
				+ "<tr><td> Income : </td><td> <input type='text' name='income'/></td></tr>"
				+ "<tr><td> Tax  :</td><td><input type='text' name='tax'/></td></tr>"
				+ "<tr><td colspan='2'><input type='submit' value='submit'/></td></tr>"
				+ "</table>"
				+ "</form>");
		
		pw.println("</center>");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
