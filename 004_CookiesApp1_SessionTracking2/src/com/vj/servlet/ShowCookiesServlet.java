package com.vj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/showurl")
public class ShowCookiesServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String title="Available Cookies";
		//get writer
		PrintWriter pw=resp.getWriter();
		//set content type
		resp.setContentType("text/html");
		//
		pw.println("<center>");
		pw.println("<h2 style='color:red'>"+title+"</h2>");
		pw.println("<table border=1>"
				+ "<tr><td>Cookie Name</td>"
				+ "<td>Cookie value</td></tr>");
		//get available cookies
		Cookie[] cks=req.getCookies();
		if(cks!=null) {
			for(Cookie ck:cks) {
			pw.println("<tr><td>"+ck.getName()+"</td><td>"+ck.getValue()+"</td></tr>");
		}//for
			pw.println("</table>");
		}//if
		else {
			pw.println("<h3 style='color:red'>Cookies not available</h3>");
		}//esle
		pw.println("</center>");
		
	}//doGet

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}//doPost

}//class
