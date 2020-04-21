package com.vj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadParameters;

@WebServlet("/uploadurl")
public class FileUploadServlet extends HttpServlet {


	public FileUploadServlet() {
		System.out.println("FileUploadServlet :: 0-param constructor");
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
	}//doGet

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter pw=null;
		MultipartFormDataRequest nreq=null;
		UploadParameters up=null;
		UploadBean bean=null;
		Vector vector=null;
		//get printWriter
		pw=resp.getWriter();
		//set content type
		resp.setContentType("text/html");
		try {
			//create object for MIME type using MultiPartFormDataReq
			nreq=new MultipartFormDataRequest(req);
			//start file upload process
			//create UploadBean object
			bean=new UploadBean();
			//set restrictions
			bean.setFolderstore("D:/testupload");
			bean.setOverwrite(false);
			bean.setMaxfiles(5);
			bean.setFilesizelimit(20*1024);
			bean.setBlacklist("*.zip,*.txt");
			
			bean.store(nreq);
			pw.println("<center>");
			pw.println("<h1 color='green'>  Files uploaded successfully !!");
			//print or get file details
			vector=bean.getHistory();
			for(int i=0;i<vector.size();i++) {
				up=(UploadParameters) vector.elementAt(i);
				pw.println("<h3></br><Uploaded File is :: " +up.getFilename()+"</br> size = "+up.getFilesize()+" bytes" +
						"</br>Content Type :: "+up.getContenttype()+"</br> Store Model :: "+up.getStoremodelname()+"</br> StoreInfo ::"+
						up.getStoreinfo()+"</h3>");
			}//for

		} catch (Exception e) {
			pw.println("<h1 style='color:red;text-align:center'> File Upload Unsuccess !! "+e.getMessage()+"</h1>");
		}
		//home hyperlink
		pw.println("<h1 color='blue' > </br><a href='first.html'> Home</h1>");
		pw.println("</center>");
		//close stream
		pw.close();
		
	}//doPost

}//class
