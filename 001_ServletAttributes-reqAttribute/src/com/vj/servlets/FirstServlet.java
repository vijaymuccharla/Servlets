package com.vj.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		request.setAttribute("first", 100);	//100--- Integer wrapper object 
		//get Request dispatcher
		RequestDispatcher rd=request.getRequestDispatcher("/secondurl");
		pw.println("<h1 style='color:green;text-align:center'>from 1stServlet Request Attribute (first) value :: "+request.getAttribute("first")+"</h1>");
		rd.forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FirstServlet.doPost()");
		doGet(request, response);
	}

}
