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

	public Student findRankofStudent(String studentName) {
		long rank=0;
		Student studentRankDetails=null;
		try(Session session = HibernateConfig.getSessionFactory().openSession()) {
		    Query query = session.createQuery("SELECT COUNT(*) + 1 FROM Student WHERE score > (SELECT score FROM Student WHERE upper(name) = :name)");
		    query.setParameter("name", studentName.toUpperCase());

		    rank = (long) query.getSingleResult();
		    
		    studentRankDetails=findStudentByName(studentName);
	        if (studentRankDetails!=null) {
	            studentRankDetails.setRank(rank);
	        }
		} 

		return studentRankDetails;
	}

	public Student findStudentByName(String studentName) {
		Student student=null;
		try(Session session = HibernateConfig.getSessionFactory().openSession()) {
			Query query = session.createQuery("SELECT s " +
	                "FROM Student s " +
	                "WHERE upper(s.name) = :name");
	        query.setParameter("name", studentName.toUpperCase());

	        List<Student> resultList = query.list();
	        if (!resultList.isEmpty()) {
	            student = resultList.get(0);
	        }
		}
		return student;
	}
	public boolean deleteStudent(String studentName) {
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {
	         session.beginTransaction();
	        
	        Query query = session.createQuery("delete from Student where upper(name) = :name");
	        query.setParameter("name", studentName.toUpperCase());
	        
	        int rowCount = query.executeUpdate();
	        
	        session.getTransaction().commit();
	        
	        if (rowCount > 0) {
	            System.out.println("Student with name " + studentName + " has been deleted successfully.");
	            return true;
	        } else {
	            System.out.println("Student with name " + studentName + " does not exist.");
	            return false;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		return false;
	}

	public boolean updateExistingRecord(Student student) {
		Student studentToUpdate=findStudentByName(student.getName());
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {
			
			if (studentToUpdate != null) {
				session.beginTransaction();
	            studentToUpdate.setScore(student.getScore()); // Update the SAT score

	            if(student.getScore()>=30) {
	            	studentToUpdate.setResult("PASS");
	            }else {
	            	studentToUpdate.setResult("FAIL");
	            }
	            session.update(studentToUpdate); // Persist the updated student record

	            session.getTransaction().commit();
	            return true;
	        } else {
	            return false; // Student record not found
	        }
		}
	}
}
