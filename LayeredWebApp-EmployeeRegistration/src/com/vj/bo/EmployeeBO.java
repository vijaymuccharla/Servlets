package com.vj.bo;


public class EmployeeBO {

	private String empName=null,empAddrs=null;
	private float baseSal=0.0f,grossSal=0.0f,empSal=0.0f;
	
	public EmployeeBO() {
		System.out.println("EmployeeBO :: 0-param constructor");
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

	public float getGrossSal() {
		return grossSal;
	}

	public void setGrossSal(float grossSal) {
		this.grossSal = grossSal;
	}

	public float getEmpSal() {
		return empSal;
	}

	public void setEmpSal(float empSal) {
		this.empSal = empSal;
	}

	
}
