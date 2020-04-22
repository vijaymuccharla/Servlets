package com.vj.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/thirdurl")
public class ThirdServlet extends HttpServlet {
    public ThirdServlet() {
    	System.out.println("ThirdServlet.ThirdServlet()");
    }

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			System.out.println("ThirdServlet.doGet()");
			//get writer
			PrintWriter pw=resp.getWriter();
			//set content tyep
			resp.setContentType("text/html");
			//get request attribute using key, display
			pw.println("<h1 style='color:green;text-align:center'>from 3rd Servlet Request Attribute (first) value :: "+req.getAttribute("first")+"</h1>");

	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ThirdServlet.doPost()");
		doGet(req, resp);
	}

}
