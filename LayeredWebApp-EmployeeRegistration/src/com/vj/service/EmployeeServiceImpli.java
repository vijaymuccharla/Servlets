package com.vj.service;

import com.vj.bo.EmployeeBO;
import com.vj.dao.EmployeeDAO;
import com.vj.dao.EmployeeDAOimpl;
import com.vj.dto.EmployeeDTO;

public class EmployeeServiceImpli implements EmployeeService {

	private EmployeeDAO dao;

	public EmployeeServiceImpli() {
		System.out.println("EmployeeServiceImpli :: 0-param constructor");
		dao=new EmployeeDAOimpl();
	}
	
	@Override
	public String register(EmployeeDTO dto) throws Exception {
		float grossSal=0.0f,totSal=0.0f;
		EmployeeBO bo=null;
		String result=null;
		int count=0;
		//convert DTO to BO
		bo=new EmployeeBO();
		bo.setEmpName(dto.getEmpName());
		bo.setEmpAddrs(dto.getEmpAddrs());
		bo.setBaseSal(dto.getBaseSal());
		grossSal=dto.getBaseSal() - dto.getBaseSal()*0.4f;
		totSal=grossSal + grossSal*0.2f;
		bo.setGrossSal(grossSal);
		bo.setEmpSal(totSal);

		//use DAO pass BO
		count=dao.insert(bo);
		if(count==0) 
			result=" Registration Failed  ";
		else
			result="Registration Success, \n"+
						"Gross Salary : "+grossSal+"Employee Salary : "+totSal;
		
		//return result
		return result;
	}

}
