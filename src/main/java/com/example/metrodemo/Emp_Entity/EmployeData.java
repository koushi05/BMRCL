package com.example.metrodemo.Emp_Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="metroempdata")
public class EmployeData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long eid;
	
	@Column(name="ename")
	private String ename;
	
	@Column(name="address")
	private String address;
	
	@Column(name="desig")
	private String desig;
	
	public EmployeData(String ename, String address, String desig) {
		this.ename = ename;
		this.address = address;
		this.desig = desig;
	}
	
	public EmployeData() {
	}

	
	public Long getEid() {
		return eid;
	}

	public void setEid(Long eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDesig() {
		return desig;
	}

	public void setDesig(String desig) {
		this.desig = desig;
	}
	
	
}
