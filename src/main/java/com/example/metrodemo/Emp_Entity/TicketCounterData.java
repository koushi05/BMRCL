package com.example.metrodemo.Emp_Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TC")
public class TicketCounterData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long tid;
	private String fromStation;
	private String toStation;
	private String lane;
	private int fare;
	
	public TicketCounterData(String fromStation, String toStation, String lane, int fare) {
		this.fromStation = fromStation;
		this.toStation = toStation;
		this.lane = lane;
		this.fare = fare;
	}
	
	
	public TicketCounterData() {
	}


	public Long getTid() {
		return tid;
	}
	public void setTid(Long tid) {
		this.tid = tid;
	}
	public String getFromStation() {
		return fromStation;
	}
	public void setFromStation(String fromStation) {
		this.fromStation = fromStation;
	}
	public String getToStation() {
		return toStation;
	}
	public void setToStation(String toStation) {
		this.toStation = toStation;
	}
	public String getLane() {
		return lane;
	}
	public void setLane(String lane) {
		this.lane = lane;
	}
	public int getFare() {
		return fare;
	}
	public void setFare(int fare) {
		this.fare = fare;
	}
	
	
	
	
	
}
