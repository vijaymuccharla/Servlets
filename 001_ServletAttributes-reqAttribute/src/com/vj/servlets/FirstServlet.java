package com.vj.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {

	public FirstServlet() {
		System.out.println("FirstServlet.FirstServlet()");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FirstServlet.doGet()");
		String attrib=null;
		//get writer
		PrintWriter pw=response.getWriter();
		
		//set response content type
		response.setContentType("text/html");
		
		//set request attribute with key and value(object) uses AutoBoxing(java-1.5)
		request.setAttribute("reqAttrib", "rVal");	//String value--- object 
		pw.println("<h1 style='color:green;text-align:center'>from 1stServlet Request Attribute (reqAttrib) value :: "+request.getAttribute("reqAttrib")+"</h1>");
		
		//get HtttpSession object using Request Object
		HttpSession ses=request.getSession();
		//set any session attribute value
		ses.setAttribute("sesAttrib", "sVal");
		//get Request dispatcher
		pw.println("<h1 style='color:green;text-align:center'>from 1stServlet Session Attribute (sesAttrib) value :: "+ses.getAttribute("sesAttrib")+"</h1>");
		
		//get ContextAttrib/ApplicationAttrib object
		ServletContext sc=getServletContext();
		//set ContextAttrib
		sc.setAttribute("ctxtAttrib", "ctxtVal");
		pw.println("<h1 style='color:green;text-align:center'>from 1stServlet Context/Application Attribute (ctxtAttrib) value :: "+sc.getAttribute("ctxtAttrib")+"</h1>");
		
		RequestDispatcher rd=request.getRequestDispatcher("/secondurl");
		rd.forward(request, response);
		
		pw.close();
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FirstServlet.doPost()");
		doGet(request, response);
	}

}
