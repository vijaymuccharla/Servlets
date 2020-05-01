package com.vj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/secondurl")
public class SecondServelt extends HttpServlet {


	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String income=null,tax=null;
//		get writer'
		PrintWriter pw=resp.getWriter();
//		set content type
		resp.setContentType("text/html");
//		read form2/req2 data
		income=req.getParameter("income");
		tax=req.getParameter("tax");
		
 
		//dynamic web page for second servlet url
		pw.println("<center>");
		pw.println("<h1 style=color:green;text-align=center'> All details of From1/Form2 using cookies </h1>");
		pw.println("<table border=1>"
				+ "<tr><td>Cookie Name</td>"
				+ "<td>Cookie value</td></tr>");
		//get available cookies
		Cookie[] cs=req.getCookies();
		if(cs!=null) {
			for(Cookie ck:cs) {
			pw.println("<tr><td>"+ck.getName()+"</td><td>"+ck.getValue()+"</td></tr>");
		}//for
			pw.println("</table>");
		}//if
		else {
			pw.println("<h3 style='color:red'>Cookies not available</h3>");
		}//esle
		
		
		pw.println("<br/><br/>Form2 details : "+"<br/>Income : "+income+"<br/> Tax : "+tax);
		pw.println("</center>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
