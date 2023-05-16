package com.project.precize.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.project.precize.model.Student;
import com.spring.hibernate.configuration.HibernateConfig;

@Repository
public class StudentDao {

	private static final Logger logger = Logger.getLogger(StudentDao.class);  

	public boolean insertData(Student student) {
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {
			if(student!=null && student.getScore()>=30) {
				student.setResult("PASS");
			}else if(student!=null){
				student.setResult("FAIL");
			}
			
			session.beginTransaction();
			int studentId = 0;
			studentId=(int) session.save(student);
	        session.getTransaction().commit();
	        return (studentId==0)?false:true;
		}
	}

	public List<Student> fetchDetailsFromDatabase() {
		Session session = HibernateConfig.getSessionFactory().openSession();
		List<Student> student=null;
		try {
		    String hql = "FROM Student";
		    Query query = session.createQuery(hql);
		    student = query.list();
		} finally {
		    session.close();
		}

		return student;
	}
}
