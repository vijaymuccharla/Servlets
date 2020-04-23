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


@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {

	public SecondServlet() {
		System.out.println("SecondServlet.SecondServlet()");
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("SecondServlet.doGet()");
		//get writer object from resp
		PrintWriter pw=resp.getWriter();
		//set resp content type
		resp.setContentType("text/html");
		//get request attribute stored in request object
		//display the attribute value which proves they use same request object and carry all request attributes
		pw.println("<h1 style='color:green;text-align:center'>from 2ndServlet Request Attribute (reqAttrib) value :: "+req.getAttribute("reqAttrib")+"</h1>");
		
		//get Session object
		HttpSession ses=req.getSession();
		pw.println("<h1 style='color:green;text-align:center'>from 2ndServlet Session Attribute (sesAttrib) value :: "+ses.getAttribute("sesAttrib")+"</h1>");
		
		//get ContextObject
		ServletContext sc= getServletContext();
		pw.println("<h1 style='color:green;text-align:center'>from 2ndServlet Context/Application Attribute (ctxtAttrib) value :: "+sc.getAttribute("ctxtAttrib")+"</h1>");

		//get Request dispatcher
		RequestDispatcher rd=req.getRequestDispatcher("/thirdurl");
		rd.forward(req, resp);
		
		pw.close();
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("SecondServlet.doPost()");
		doGet(req, resp);
	}

}
