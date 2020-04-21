package com.vijay.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet( urlPatterns = "/headerurl", name = "headerservlet")		//destination servlet
public class HeaderServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("HeaderServlet.doGet()");
		PrintWriter pw=null;
		RequestDispatcher rd1=null;
		int eno=0;
		//get PrintWriter
		pw=res.getWriter();
		//set content Type
		res.setContentType("text/html");
		//display error via response obj
		pw.println("<h1 style='color:green;text-align='center'> <marquee> Page - Header </marquee><hr/></h1>");
		try {
		eno=Integer.parseInt(req.getParameter("eno"));	
		pw.println("<h2 style='color:red;text-align:center'>form data eno from REQ object :: " + eno + " to prove its using same REQ object</h2>");
		}
		catch(NumberFormatException nfe) {
		rd1=req.getRequestDispatcher("/eno.html");
		rd1.include(req, res);
		}//catch
//we cannot close PrintWriter  here, bcoz we may use PW in Source Servlet, 
//		as it Combines both responses together we'll need PW.
			//pw.close();  
	}//doGet
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("HeaderServlet.doPost()");
		doGet(req,res);
	}
	
}
