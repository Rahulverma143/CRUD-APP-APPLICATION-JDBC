package in.rahul.daofactory;

import in.rahul.persistence.RStudentDao;
import in.rahul.persistence.StudentDaoImpl;

public class StudentDaoFactory {

	private StudentDaoFactory() {
		
	}
	private static RStudentDao studentDao = null;
	
	public static RStudentDao getStudentDao() {
		
		if(studentDao == null) {
			studentDao = new StudentDaoImpl();
		}
		return studentDao;
	}
	
}
