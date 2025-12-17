package in.rahul.servicefactory;

import in.rahul.service.RStudentService;
import in.rahul.service.StudentServiceImpl;

// Connection connection = DriverManager.getConnection(url, username,password);

  public class StudentServiceFactory {

	// Make Constructor private to avoid object creation
	
	  private StudentServiceFactory() {
			
	}
	  private static  RStudentService studentservice = null;
	  
	  public static RStudentService getStudentService() {
		  
		  // Singleton Design Pattern Code
		  
		  if(studentservice == null) {
			  studentservice = new StudentServiceImpl();
		  }
		  return studentservice;
	  }
		
}
