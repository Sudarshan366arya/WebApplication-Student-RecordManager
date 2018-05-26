package com.student.record.controller;

import java.util.Collections;
import java.util.List;
import com.student.record.model.Student;
import com.student.record.util.HibernateUtil;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

public class StudentManager extends HibernateUtil {
	
	public Student add(Student st) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(st);
		session.getTransaction().commit();
		return st;
	}
	public Student adddone(Student st) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(st);
		session.getTransaction().commit();
		return st;
	}

	public Student delete(int roll) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Student st = (Student)session.load(Student.class, roll);
		if(null != st) {
			session.delete(st);
		}
		session.getTransaction().commit();
		return st;
	}

	public Student update(int roll) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Student st = (Student)session.load(Student.class, roll);
		if(null != st) {
			
			System.out.println("-----------------------Name "+st.getName());
			System.out.println("-----------------------Batch "+st.getBatch());
			System.out.println("-----------------------Contact "+st.getContact_No());
		}
		session.getTransaction().commit();
		return st;
	}
	@SuppressWarnings("unchecked")
	public List<Student> list() {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Student> sts = null;
		try {
			sts = (List<Student>)session.createQuery("from Student").list();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return sts;
	}
	@SuppressWarnings("unchecked")
	public List<Student> search(String name,String batch,String contact_no) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();		
		Criteria criteria = session.createCriteria(Student.class);

	
		if(name != null)
		{				criteria.add(Restrictions.ilike("name", "%"+name+"%"));
			
		}
		if(batch!=null){
			criteria.add(Restrictions.ilike("batch", "%"+batch+"%"));
		}
       if(contact_no!=null){
    	   criteria.add(Restrictions.ilike("contact_no", "%"+contact_no+"%"));
		}
		List<Student> cts = criteria.list();
		if(cts.size() > 0)
		{
			return cts;
		}
		else
		{
			return Collections.emptyList();
		}	
	
	}

}
