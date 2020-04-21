package com.vj.vo;

public class EmployeeVO {

	private String empName=null,emoAddrs=null,baseSal=null,doj=null;

	public EmployeeVO() {
		System.out.println("EmployeeVO :: 0-param constructor");
	}
	
	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmoAddrs() {
		return emoAddrs;
	}

	public void setEmoAddrs(String emoAddrs) {
		this.emoAddrs = emoAddrs;
	}

	public String getBaseSal() {
		return baseSal;
	}

	public void setBaseSal(String baseSal) {
		this.baseSal = baseSal;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	
}//class
