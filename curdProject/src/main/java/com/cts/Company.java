package com.cts;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="company")
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="company_id")
	private long companyId;

	@Column(name="employee_id") 
	private long employeeId;
	
	@Column(name="company_name")
	private String companyName;

	@Column(name="period_of_stay")
	private int periodOfStay;
	


	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getPeriodOfStay() {
		return periodOfStay;
	}

	public void setPeriodOfStay(int periodOfStay) {
		this.periodOfStay = periodOfStay;
	}

	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", employeeId=" + employeeId + ", companyName=" + companyName
				+ ", periodOfStay=" + periodOfStay + "]";
	}

	
	
	
	
	
	

}
