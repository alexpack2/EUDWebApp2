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
@Table(name="home_data")
public class Home {
	@Id
	@Column(name="idhome")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="iduserh")
	@MapsId
	private Member user;
	@Column(name="home_address")
	private String homeAddress;
	
	public Home() {
		super();
	}
	
	public Home(int id,  String homeAddress) {
		super();
		this.id = id;
		this.homeAddress = homeAddress;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getHomeAddress() {
		return homeAddress;
	}


	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	
	public void setUser(Member user) {
		 this.user = user;
	}
	
	public Member getUser() {
		return this.user;
	}
	

}
