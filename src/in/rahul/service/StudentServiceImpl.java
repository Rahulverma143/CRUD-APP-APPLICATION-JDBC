package in.rahul.service;

import in.rahul.dto.Student;
import in.rahul.persistence.RStudentDao;
import in.rahul.daofactory.StudentDaoFactory;

public class StudentServiceImpl implements RStudentService {

	RStudentDao studentDao;

	public StudentServiceImpl() {
		studentDao = StudentDaoFactory.getStudentDao();
	}

	@Override
	public String addStudent(Integer sId, String sname, Integer sage, String saddress) {
		return studentDao.addStudent(sId, sname, sage, saddress);
	}

	@Override
	public Student searchStudent(Integer sid) {
		return studentDao.searchStudent(sid);
	}

	@Override
	public String updateStudent(Integer sid, String sname, Integer sage, String saddress) {
		return studentDao.updateStudent(sid, sname, sage, saddress);
	}

	@Override
	public String deleteStudent(Integer sid) {
		return studentDao.deleteStudent(sid);
	}
}
