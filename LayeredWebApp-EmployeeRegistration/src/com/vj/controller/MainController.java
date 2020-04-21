package com.vj.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vj.dto.EmployeeDTO;
import com.vj.service.EmployeeService;
import com.vj.service.EmployeeServiceImpli;
import com.vj.vo.EmployeeVO;


@WebServlet("/controller")
public class MainController extends HttpServlet{

	private EmployeeService service;

	@Override
	public void init() throws ServletException {
		System.out.println("EmployeeController.init()");
		service=new EmployeeServiceImpli();

	}

	public MainController() {
		System.out.println("EmployeeController :: 0-param constructor");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw=null;
		EmployeeVO vo=null;
		EmployeeDTO dto=null;
		String result=null;
		
		//get PrintWriter
		pw=resp.getWriter();
		//set contentType
		resp.setContentType("text/html");
		//get form data and convert it to VO object
		vo=new EmployeeVO();
		vo.setEmpName(req.getParameter("ename"));
		vo.setEmoAddrs(req.getParameter("eaddress"));
		vo.setBaseSal(req.getParameter("baseSalary"));

		//convert VO to DTO
		dto=new EmployeeDTO();
		dto.setEmpName(vo.getEmpName());
		dto.setEmpAddrs(vo.getEmoAddrs());
		dto.setBaseSal(Float.parseFloat(vo.getBaseSal()));
		

		try {

			//			use service
			result=service.register(dto);
			pw.println("<center>");
			pw.println("<h1 style='color:green'> "+result+"  </h1>");

		}
		catch (Exception e) {
			pw.println("<center>");
			pw.println("<h1 style='color:red'> Internal Error , Please Check </h1>");
			pw.println("<center>");
			e.printStackTrace();
		}
		finally {

			pw.println("<b><h2 ><a href='welcome.html'>  Home </a></h2></b>");
			pw.println("</center>");
			pw.close();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);

	}

	@Override
	public void destroy() {
		service=null;
	}
}
