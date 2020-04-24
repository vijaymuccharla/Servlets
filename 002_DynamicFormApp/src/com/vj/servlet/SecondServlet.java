package com.vj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pname=null,fname=null,mstatus=null,sT1=null,sT2=null;
		//get writer
		PrintWriter pw=resp.getWriter();
		//set content type
		resp.setContentType("text/html");
		//read form1/req1 data and display all the details entered by the enduser
		pname=req.getParameter("pname");
		fname=req.getParameter("fname");
		mstatus=req.getParameter("mstatus");

		pw.println("<center>");
		pw.println("<h3 style='color:green'> Form1/Request1 Data :: "+pname+"..."+fname+"..."+mstatus+"</h3>");


		//read form2/req2 data and display all the details entered by the enduser
		sT1=req.getParameter("t1");
		sT2=req.getParameter("t2");
		pw.println("<h3 style='color:blue'> Form2/Request2 Data :: "+sT1+"..."+sT2+"</h3>");
		pw.println("</center>");

		pw.println("<h2 style='color:blue;text-align:center'> <a href='form1.jsp'> Home </a></h2>");
		/*
				Here form 1/request1 has values that can be accessed only by FirstServlet as request,response objects are different for Second servlets
				So form1 values are NULL.
				
				But form 2 values will be displayed as SecondServlet request has access to form 2 /resquest2

				To solve this we have Session Tracking/Session Management
		 */		

		//close stream
		pw.close();

	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
