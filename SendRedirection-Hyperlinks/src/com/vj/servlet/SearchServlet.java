package com.vj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/searchurl")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public SearchServlet() {
    	System.out.println("SearchServlet.SearchServlet()");
    }

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw=null;
		String query=null;
		//get PrintWriter
		pw=resp.getWriter();
		//set response content tyep
		resp.setContentType("text/html");
		//get form data
		query=req.getParameter("query");
		//set query to remote WebApp hyperlink
		pw.println("<h1 style='color:green;text-align:center'><a href='https://www.google.co.in/search?q="+query+"'> GoogleSearch</a></h1> ");
		
		//close stream
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
