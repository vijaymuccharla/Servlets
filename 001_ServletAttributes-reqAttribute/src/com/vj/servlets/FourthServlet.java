package com.vj.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fourthurl")
public class FourthServlet extends HttpServlet {
    public FourthServlet() {
    	System.out.println("FourthServlet.FourthServlet()");
    }

public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("FourthServlet.doGet()");
		//get writer
		PrintWriter pw=resp.getWriter();
		//set content type
		resp.setContentType("text/html");
		//display request attribute value, but this request object has not attribute so, it will be null.
		pw.println("<h1 style='color:green;text-align:center'>from 4th Servlet Request Attribute (first) value :: "+req.getAttribute("first")+"</h1>");

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FourthServlet.doPost()");
		doGet(request, response);
	}

}
