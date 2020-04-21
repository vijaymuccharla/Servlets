package com.vijay.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormServlet extends HttpServlet {
	//zero param for console audit
	public FormServlet() {
		System.out.println("FormServlet.FormServlet()");
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		PrintWriter pw=null;
		String name=null,gender= null,addrs=null,mstatus=null,qualif=null,crs[]=null,hbs[]=null;
		int age=0;
		//servler console audit
		System.out.println("FormServlet.doPost()");
		//getwriter
		pw=res.getWriter();
		//get set content type
		res.setContentType("text/html");
		//read form data
		name=req.getParameter("tname");
		age=Integer.parseInt(req.getParameter("tage"));
		gender=req.getParameter("gender");
		addrs=req.getParameter("taddrs");
		mstatus=req.getParameter("ms");
		qualif=req.getParameter("qualif");
		crs=req.getParameterValues("crs");
		hbs=req.getParameterValues("hb");
	
		pw.println("<center>");
		//write business logic
		if(gender.equalsIgnoreCase("M")) {
			if(age<=5){
				pw.println("<h1 style='color:red'>"+name+", you are a kid!! ask your parents to help you fill the form :):)></h1>");
			}
			else if(age<=12){
				pw.println("<h1 style='color:green'>"+name+", you are just "+age+"!! ask your parents to help you fill the form :):)></h1>");
			}
			else if(age<=18){
				pw.println("<h1 style='color:green'>"+name+", you are a teenager!! Go get all the documents needed :):)></h1>");
			}
			else if(age<=30){
				if(mstatus.equalsIgnoreCase("married")) {
					pw.println("<h1 style='color:green'>"+name+", you are Married!! ask your wife permission :):)></h1>");
				}
				else{
				pw.println("<h1 style='color:green'>"+name+", you are unmarried !! just get the needed documents :):)></h1>");
				}
			}
			else if(age<=50){
				if(mstatus.equalsIgnoreCase("married")) {
					pw.println("<h1 style='color:green'>"+name+", you are Married, middle aged!! we will help you Uncle,do not worry :):)></h1>");
				}
				else{
				pw.println("<h1 style='color:green'>"+name+", you are unmarried !! please wait we will help Uncle :):)></h1>");
				}
			}
			else if(age<=75){
				if(mstatus.equalsIgnoreCase("married")) {
					pw.println("<h1 style='color:green'>"+name+", you are Married dadaji!! Please call Aunty and ask her to come :):)></h1>");
				}
				else{
				pw.println("<h1 style='color:green'>"+name+", you are unmarried!! please wait we will help DADAJI:):)></h1>");
				}
			}
			else {
				if(mstatus.equalsIgnoreCase("married")) {
					pw.println("<h1 style='color:green'>"+name+", you are Married and "+age+"!! Please collect your pension :):)></h1>");
				}
				else{
				pw.println("<h1 style='color:green'>"+name+", you are unmarried and "+age+"!! please collect your pension:):)></h1>");
				}
			}
		}
		
		
		if(gender.equalsIgnoreCase("F")) {
		if(age<=5){
			pw.println("<h1 style='color:red'>"+name+", you are a baby girl!! ask your parents to help you fill the form :):)></h1>");
		}
		else if(age<=12){
			pw.println("<h1 style='color:green'>"+name+", you are just "+age+"!! ask your parents to help you fill the form :):)></h1>");
		}
		else if(age<=18){
			pw.println("<h1 style='color:green'>"+name+", you are a teenage girl!! Go get all the documents needed :):)></h1>");
		}
		else if(age<=30){
			if(mstatus.equalsIgnoreCase("married")) {
				pw.println("<h1 style='color:green'>"+name+", you are Married man!! ask your hubby permission :):)></h1>");
			}
			else{
			pw.println("<h1 style='color:green'>"+name+", you are unmarried woman!! just get the needed documents :):)></h1>");
			}
		}
		else if(age<=50){
			if(mstatus.equalsIgnoreCase("married")) {
				pw.println("<h1 style='color:green'>"+name+", you are married middle aged woman!! we will help you Uncle,do not worry :):)></h1>");
			}
			else{
			pw.println("<h1 style='color:green'>"+name+", you are unmarried middle aged woman!! please wait we will help Uncle :):)></h1>");
			}
		}
		else if(age<=75){
			if(mstatus.equalsIgnoreCase("married")) {
				pw.println("<h1 style='color:green'>"+name+", you are Married Dadiji!! Please call uncle and ask him to come :):)></h1>");
			}
			else{
			pw.println("<h1 style='color:green'>"+name+", you are unmarried Dadiji!! Please wait we will help Dadiji:):)></h1>");
			}
		}
		else {
			if(mstatus.equalsIgnoreCase("married")) {
				pw.println("<h1 style='color:green'>"+name+", you are Married granny and "+age+"!! Please collect your pension :):)></h1>");
			}
			else{
			pw.println("<h1 style='color:green'>"+name+", you are unmarried granny and "+age+"!! please collect your pension:):)></h1>");
			}
		}
	}
	
	pw.println("<h1> Age : "+age+"</br></h1>");
	pw.println("<h1> Gender : "+gender+"</br></h1>");
	pw.println("<h1> Address : "+addrs+"</br></h1>");
	pw.println("<h1> Marital status : "+mstatus+"</br></h1>");
	pw.println("<h1> Qualification : "+qualif+"</br></h1>");
	pw.println("<h1> Courses : "+Arrays.toString(crs)+"</br></h1>");
	pw.println("<h1> Hobbies : "+Arrays.toString(crs)+"</br></h1>");
	
	pw.println("<a href='form.html'><img src='home.jpg' height='50' width='50'> </br>Home Page</a> ");
	pw.println("</center>");
	pw.close();
	}//doPost
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//servler console audit
		System.out.println("FormServlet.doGet()");
		this.doPost(req, res);
	}//doGet
		
}//class
