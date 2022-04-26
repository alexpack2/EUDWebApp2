package com.eudh;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AddSomeData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Member member = new Member();
		Work work = new Work();
		Home home = new Home();
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Member.class).
				addAnnotatedClass(Home.class).addAnnotatedClass(Work.class);
		
		SessionFactory sf = con.buildSessionFactory();		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		member.setName("John");
		member.setSurname("Smith");
		member.setGender("M");
		member.setBirthdate("03-06-1998");
		work.setWorkAddress("AAA");
		home.setHomeAddress("AAA");
		work.setUser(member);
		home.setUser(member);
		
		session.save(work); 
		session.save(home); 
		session.save(member);
		
		member = new Member();
		work = new Work();
		home = new Home();
		
		member.setName("Alex");
		member.setSurname("West");
		member.setGender("M");
		member.setBirthdate("23-02-1997");
		work.setWorkAddress("BBB");
		home.setHomeAddress(null);
		work.setUser(member);
		home.setUser(member);
		
		session.save(work); 
		session.save(home); 
		session.save(member);
		
		member = new Member();
		work = new Work();
		home = new Home();
		
		member.setName("Mairy");
		member.setSurname("North");
		member.setGender("F");
		member.setBirthdate("13-11-1980");
		work.setWorkAddress(null);
		home.setHomeAddress("CCC");
		work.setUser(member);
		home.setUser(member);
		
		session.save(work); 
		session.save(home); 
		session.save(member);
		
		member = new Member();
		work = new Work();
		home = new Home();
		
		member.setName("Suzan");
		member.setSurname("Bell");
		member.setGender("F");
		member.setBirthdate("02-02-2010");
		work.setWorkAddress(null);
		home.setHomeAddress(null);
		work.setUser(member);
		home.setUser(member);
		
		session.save(work); 
		session.save(home); 
		session.save(member);
		tx.commit();
		
		sf.close();
	}

}
