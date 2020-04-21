package com.vj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/centralgsturl")
public class CentralGSTservlet extends HttpServlet {

    public CentralGSTservlet() {
    	System.out.println("CentralGSTservlet.CentralGSTservlet()");
    }

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("CentralGSTservlet.doGet()");
		PrintWriter pw=null;
		float pcost=0.0f,centralGST=0.0f;
		String ptype=null;
		//get writer
		pw=res.getWriter();
		//set repsonse content type
		res.setContentType("text/html");
		
		pcost=Float.parseFloat(req.getParameter("pcost"));
		ptype=req.getParameter("ptype");
		
		if(ptype.equalsIgnoreCase("product"))
			centralGST=pcost/100.0f*25.0f;
			else if(ptype.equalsIgnoreCase("service"))
				centralGST=pcost/100.0f*18.0f;
			else if(ptype.equalsIgnoreCase("startup"))
				centralGST=pcost/100.0f*7.0f;
			
		pw.println("<h3 style='color:green'> CentralGST :: "+centralGST+" </h3>");
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("CentralGSTservlet.doPost()");
		doGet(req, res);
	}

}
