package in.rahul.service;

import in.rahul.dto.Student;

public interface RStudentService {
	
	//Operation  implemented
public String addStudent(Integer sid, String sname, Integer sage, String saddress);
	
	public Student searchStudent(Integer sid);
	
	public String updateStudent(Integer sid, String sname, Integer sage, String saddress);
	
	public String deleteStudent(Integer sid);
	
}
