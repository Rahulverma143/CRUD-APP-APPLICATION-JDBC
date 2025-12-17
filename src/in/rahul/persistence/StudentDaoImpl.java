package in.rahul.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.rahul.dto.Student;

public class StudentDaoImpl implements RStudentDao {

    private static final String DBURL = "jdbc:mysql://localhost:3306/crudapp";
    private static final String DBUSERNAME = "root";
    private static final String DBPASSWORD = "root";

    // ================= ADD STUDENT =================
    @Override
    public String addStudent(Integer sId, String sname, Integer sage, String saddress) {

        String INSERTDATA = "INSERT INTO student(sId, sname, sage, saddress) VALUES(?,?,?,?)";

        try {
            Connection con = DriverManager.getConnection(DBURL, DBUSERNAME, DBPASSWORD);
            PreparedStatement pstmt = con.prepareStatement(INSERTDATA);

            pstmt.setInt(1, sId);
            pstmt.setString(2, sname);
            pstmt.setInt(3, sage);
            pstmt.setString(4, saddress);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0)
                return "success";

        } catch (Exception e) {
            System.out.println(e);
        }
        return "fail";
    }

    // ================= DELETE STUDENT =================
    @Override
    public String deleteStudent(Integer sid) {

        String DELETEQUERY = "DELETE FROM student WHERE sid=?";

        try {
            Connection con = DriverManager.getConnection(DBURL, DBUSERNAME, DBPASSWORD);
            PreparedStatement pstmt = con.prepareStatement(DELETEQUERY);

            pstmt.setInt(1, sid);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0)
                return "success";

        } catch (Exception e) {
            System.out.println(e);
        }
        return "fail";
    }

    // ================= SEARCH STUDENT =================
    @Override
    public Student searchStudent(Integer sid) {

        String SELECTQUERY = "SELECT sId, sname, sage, saddress FROM student WHERE sId=?";

        Student student = null;

        try {
            Connection con = DriverManager.getConnection(DBURL, DBUSERNAME, DBPASSWORD);
            PreparedStatement pstmt = con.prepareStatement(SELECTQUERY);

            pstmt.setInt(1, sid);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                student = new Student();
                student.setSid(rs.getInt("sId"));
                student.setSname(rs.getString("sname"));
                student.setSage(rs.getInt("sage"));
                student.setSaddress(rs.getString("saddress"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return student;
    }

    // ================= UPDATE STUDENT =================
    @Override
    public String updateStudent(Integer sid, String sname, Integer sage, String saddress) {

        String UPDATEQUERY = "UPDATE student SET sname=?, sage=?, saddress=? WHERE sid=?";

        try {
            Connection con = DriverManager.getConnection(DBURL, DBUSERNAME, DBPASSWORD);
            PreparedStatement pstmt = con.prepareStatement(UPDATEQUERY);

            pstmt.setString(1, sname);
            pstmt.setInt(2, sage);
            pstmt.setString(3, saddress);
            pstmt.setInt(4, sid);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0)
                return "success";

        } catch (Exception e) {
            System.out.println(e);
        }
        return "fail";
    }
}
