package in.rahul.persistence;

import in.rahul.dto.Student;

public interface RStudentDao {
	// Operations to be implemented
	
	public String addStudent(Integer sId, String sname, Integer sage, String saddress);
	
	public Student searchStudent(Integer sid);
	
	public String updateStudent(Integer sid, String sname, Integer sage, String saddress);
	
	public String deleteStudent(Integer sid);
	
}
