package com.eudh;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="work_data")
public class Work {
	@Id
	@Column(name="idowrk")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column(name="work_address")
	String workAddress;
	@NotNull
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="iduserw")
	@MapsId
	Member user;
	
	public Work() {
		super();
	}
	
	public Work(int id, String workAddress, Member user) {
		super();
		this.id = id;
		this.workAddress = workAddress;
		this.user = user;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWorkAddress() {
		return workAddress;
	}
	public void setWorkAddress(String workAddress) {
		this.workAddress = workAddress;
	}
	public Member getUser() {
		return user;
	}
	public void setUser(Member user) {
		this.user = user;
	}
	
	

}
