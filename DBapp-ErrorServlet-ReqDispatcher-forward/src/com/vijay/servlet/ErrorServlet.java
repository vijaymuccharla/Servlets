package com.vijay.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet( urlPatterns = "/errorurl", name = "errorservlet")		//destination servlet
public class ErrorServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("ErrorServlet.doGet()");
		PrintWriter pw=null;
		int eno=0;
		//get PrintWriter
		pw=res.getWriter();
		//set content Type
		res.setContentType("text/html");
		//display error via response obj
		pw.println("<h1  style='color:purple;text-align:center'>Error Servlet </h1>");
		pw.println("<h1  style='color:red;text-align:center'>Internal Problem </h1>");
		pw.println("<h3  style='color:red;text-align:center'><a href='input.html'> Try Again....</a> </h3>");
		eno=Integer.parseInt(req.getParameter("eno"));	
		pw.println("<h2 style='color:red;text-align:center'>form data eno from REQ object :: " + eno + " to prove its using same REQ object</h2>");
			//pw.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("ErrorServlet.doPost()");
		doGet(req,res);
	}
	
}
