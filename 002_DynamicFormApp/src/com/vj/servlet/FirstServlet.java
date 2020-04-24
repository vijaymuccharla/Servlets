package com.vj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw=null;
		String pname=null,fname=null,mstatus=null;
		//get writer
		pw=resp.getWriter();
		//set contecnt type of response
		resp.setContentType("text/html");
		//read form1/req1 data
		pname=req.getParameter("pname");
		fname=req.getParameter("fname");
		mstatus=req.getParameter("mstatus");

		//based on Marital status write a Dynamic Form to response
		if(mstatus.equalsIgnoreCase("single")) {
			pw.println("<div align='center'>");
			pw.println("<form action='secondurl'>");
			pw.println( "<table>");
			pw.println("<tr bgcolor='pink'><th colsspan='2'> Required batchelor details</th></tr>");
			pw.println("<tr><td> Reason for being single : </td>");
			pw.println( "<td> <input type='text' name='t1'/></td></tr>");
			pw.println("<tr><td> Why do you need marriage : </td>");
			pw.println( "<td> <input type='text' name='t2'/></td></tr>");
			pw.println( "<tr><td> <input type='submit' value='submit'/></td></tr>");
			pw.println( "</table></form></div>");

		}
		else if(mstatus.equalsIgnoreCase("married")) {
			pw.println("<div align='center'>");
			pw.println("<form action='secondurl'>");
			pw.println( "<table>");
			pw.println("<tr bgcoloSpouse name : </td>");
			pw.println( "<td> <input type='text' name='t1'/></td></tr>");
			pw.println("<tr><td> Children: </td>");
			pw.println( "<td> <input type='text' name='t2'/></td></tr>");
			pw.println( "<tr><td> <input type='submit' value='submit' value='0'/></td></tr>");
			pw.println( "</table></form></div>");
		}
		pw.println("<h2 style='color:blue;text-align:center'> <a href='form1.jsp'> <-Go back</a></h2>");
		//close stream
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
