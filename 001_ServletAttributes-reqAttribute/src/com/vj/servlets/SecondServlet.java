package com.vj.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
		//display the attribute value which prover they use same request object and carry all request attributes
		pw.println("<h1 style='color:green;text-align:center'>from 2nd Servlet Request Attribute (first) value :: "+req.getAttribute("first")+"</h1>");
		//again forward this request to another servlet
		RequestDispatcher rd=req.getRequestDispatcher("/thirdurl");
		rd.forward(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("SecondServlet.doPost()");
		doGet(req, resp);
	}

}
