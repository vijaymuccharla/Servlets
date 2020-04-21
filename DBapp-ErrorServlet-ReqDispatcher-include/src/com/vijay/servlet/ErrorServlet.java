package com.vijay.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
		RequestDispatcher rd1=null,rd2=null;
		int eno=0;
		//getting PrintWriter from the response obj of source
		pw=res.getWriter();
		//set content Type
		res.setContentType("text/html");
		
		//forward req to Headr using rd.include
		rd1=req.getRequestDispatcher("/headerurl");
		System.out.println("\nErrorServlet :: request forwarded to Source Servlet ");
		rd1.include(req, res);
		System.out.println("\nErrorServlet :: response sent back to Destination Servlet ");
		System.out.println("\nErrorServlet :: reponse included with Source Servlet");
		
		//display error via response obj
		pw.println("<h1  style='color:purple;text-align:center'>Error Servlet </h1>");
		pw.println("<h1  style='color:red;text-align:center'>Internal Problem </h1>");
		pw.println("<h3  style='color:red;text-align:center'><a href='input.html'> Try Again....</a> </h3>");
		eno=Integer.parseInt(req.getParameter("eno"));	
		pw.println("<h2 style='color:red;text-align:center'>form data eno from REQ object :: " + eno + " to prove its using same REQ object</h2>");
		
		//forward req to footer.html to add footer and rd.include
		rd2=req.getRequestDispatcher("footer.html");	 //  '/' slash is optional again
		System.out.println("\nErrorServlet:: request forwarded to footer.html...");
		rd2.include(req, res);
		System.out.println("\nErrorServlet :: included footer.HTML as response");
		
		
		
//we cannot close PrintWriter  here, bcoz we may use PW in Source Servlet, 
//		as it Combines both responses together we'll need PW.
			//pw.close();  
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("ErrorServlet.doPost()");
		doGet(req,res);
	}
	
}
