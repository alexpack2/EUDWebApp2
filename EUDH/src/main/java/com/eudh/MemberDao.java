package com.eudh;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MemberDao {

	private ArrayList<Member> members = new ArrayList<Member>();
	private ArrayList<Work> workL = new ArrayList<Work>();
	private ArrayList<Home> homeL = new ArrayList<Home>();
	
	public SessionFactory configure()
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(Member.class).
				addAnnotatedClass(Home.class).addAnnotatedClass(Work.class);
		
		SessionFactory sf = con.buildSessionFactory();
		
		return sf;
	}
	
	@SuppressWarnings("unchecked")
	public String delete(int id)
	{
		
		String result = "Data deleted successfully";
		
		Member member = new Member();
		member.setId(id);
		
		Session session = this.configure().openSession();
		Transaction tx = session.beginTransaction();
		
		session.delete(member);
		
		tx.commit();
		
		session.close();
		
		this.retrieve();
	
	    return result;
	}
	
	@SuppressWarnings("unchecked")
	public String retrieve()
	{

		String result = "Data retrieved successfully";
		
		Session session = this.configure().openSession();
		Transaction tx = session.beginTransaction();
		
		members = new ArrayList<Member>(session.createQuery("from Member").list());
		workL = new ArrayList<Work>(session.createQuery("from Work").list());
		homeL = new ArrayList<Home>(session.createQuery("from Home").list());
		
		tx.commit();
		session.close();
		
		return result;
	}
	
	public String insert(Member member,Work work,Home home) 
	{

		String result = "Data inserted successfully";
		
		Session session = this.configure().openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(work); 
		session.save(home); 
		session.save(member);
		
		tx.commit();
		
		session.close();

		return result;
	}
	
	public ArrayList<Member> getMembers(){
		return members;
	}
	
	public ArrayList<Home> getHomeL(){
		return homeL;
	}
	
	public ArrayList<Work> getWorkL(){
		return workL;
	}
}
