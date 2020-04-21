package com.vj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.vj.bo.EmployeeBO;
import com.vj.dto.EmployeeDTO;

public class EmployeeDAOimpl implements EmployeeDAO {

	private String INSERT_EMPLOYEE="INSERT INTO EMPLOYEE_REGISTRATION VALUES(EMPID,?,?,?,?,?)";

	@Override
	public int insert(EmployeeBO bo) throws Exception {
		EmployeeDTO dto=null;
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		String result=null;
		//get JDBC connection from pool
		con=getJdbcConnection();
		//create PreparedStatement
		ps=con.prepareStatement(INSERT_EMPLOYEE);
		//set values for query params
		ps.setString(1, bo.getEmpName());
		ps.setString(2, bo.getEmpAddrs());
		ps.setFloat(3, bo.getBaseSal());
		ps.setFloat(4, bo.getGrossSal());
		ps.setFloat(5, bo.getEmpSal());

		//execute query
		count=ps.executeUpdate();


		//close streams
		con.close();
		ps.close();

		//return result
		return count;
	}

	public Connection getJdbcConnection() throws Exception{
		InitialContext con=null;
		DataSource ds=null;
		//connect to Server managed JDBC connection pool
		con=new InitialContext();
		ds=(DataSource)con.lookup("java:/comp/env/myjndi");
		return ds.getConnection();
	}//getConnection

}//class
