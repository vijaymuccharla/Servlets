package com.vj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/stategsturl")
public class StateGSTservlet extends HttpServlet {

    public StateGSTservlet() {
      System.out.println("StateGSTservlet.StateGSTservlet()");
    }

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		ServletContext sc1=null,sc2=null;
		RequestDispatcher rd=null;
		String pname=null,cname=null,ptype=null;
		float pcost=0.0f,stateGST=0.0f;
			//get Writer from response
		pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		//read form data
		pname=req.getParameter("pname");
		cname=req.getParameter("cname");
		ptype=req.getParameter("ptype");
		pcost=Float.parseFloat(req.getParameter("pcost"));
		
		pw.println("<center>");
		pw.println("<h1 style='color:red'> Project State and Central GST proforma</h1>");
		pw.println("<h3 style='color:green'> Poject :: "+pname+" </h3>");
		pw.println("<h3 style='color:green'> Company :: "+cname+" </h3>");
		pw.println("<h3 style='color:green'> Cost :: "+pcost+" </h3>");
		
		if(ptype.equalsIgnoreCase("product"))
		stateGST=pcost/100.0f*20.0f;
		else if(ptype.equalsIgnoreCase("service"))
			stateGST=pcost/100.0f*12.0f;
		else if(ptype.equalsIgnoreCase("startup"))
			stateGST=pcost/100.0f*4.0f;

		
		pw.println("<br/><h3 style='color:green'> StateGST :: "+stateGST+" </h3>");
		
		//Cross Context Comminication with CentralGSTapp
		//get servlet context of current WebApp
		sc1=getServletContext();
		//get servlet context of another webapp of same server
		sc2=sc1.getContext("/CrossContextCommunication-CentralGSTapp");//foreign context
		//get Req Dispatcher pointing to Dest Servlet comp
		rd=sc2.getRequestDispatcher("/centralgsturl");
		rd.include(req, res);
		
		pw.println("<br/><br/><h1> <a href='home.html'>Home</h1>");
		pw.println("<center>");
		
		//close stream
		pw.close();
		
		
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
