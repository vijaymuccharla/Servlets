package com.vj.dto;


public class EmployeeDTO {

	private String empName=null,empAddrs=null;
	private float baseSal=00.f;
	
	public EmployeeDTO() {
		System.out.println("EmployeeDTO :: 0-param constructor");
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpAddrs() {
		return empAddrs;
	}

	public void setEmpAddrs(String empAddrs) {
		this.empAddrs = empAddrs;
	}

	public float getBaseSal() {
		return baseSal;
	}

	public void setBaseSal(float baseSal) {
		this.baseSal = baseSal;
	}


}//class
