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
		System.out.println("SearchServlet.doGet()");
		PrintWriter pw=null;
		String query=null,engine=null;
		//get writer from response
		pw=resp.getWriter();
		//set respose content type
		resp.setContentType("text/html");
		//read form data
		query=req.getParameter("query");
		engine=req.getParameter("engine");
		
		if(engine.equalsIgnoreCase("google")) 
				resp.sendRedirect("https://www.google.com/search?q="+query);
		else if(engine.equalsIgnoreCase("yahoo")) 
			resp.sendRedirect("https://in.search.yahoo.com/search?p="+query);
		else if(engine.equalsIgnoreCase("bing")) 
			resp.sendRedirect("https://www.bing.com/search?q="+query);
		
		//rd.forward(req,resp);   -----> will throw ISE cause resp.sendRedirect() will discard the existing response
		//rd.include(-,-);  -----> Will throw ISE, as Sendredirect already discarded the response
		 
			//close stream
		pw.close();
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SearchServlet.doPost()");
		doGet(request, response);
	}

}
