package business.DAO.student;

import business.config.ConnectionDB;
import business.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImp implements StudentDAO {



    @Override
    public List<Student> findAll() {
        Connection conn = null;
        CallableStatement cstmt = null;
        List<Student> students = null;
        try {
            students = new ArrayList<>();
            //B1. khoi tao doi tuong connection lam viec voi db
            conn = ConnectionDB.openConnection();
            //B2. khoi tao doi tuong callStatemane de goi proceduce de thao tac du lieu
            cstmt = conn.prepareCall("{call getALlStudent()}");
            //B3. Xet gia tri cho cac tham so
            //B4. Dang ki kieu du lieu cho cac tham so ra
            //B5. Thuc hien proceduce va xu li ket qua tra ve
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setStatus(rs.getBoolean("status"));
                students.add(student);
            }
        } catch (SQLException sql) {
            System.out.println(sql.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cstmt);
        }
        return students;
    }

    @Override
    public boolean add(Student student) {
        Connection conn = null;
        CallableStatement cstmt = null;
        List<Student> students = null;
        try {
            conn = ConnectionDB.openConnection();
            cstmt = conn.prepareCall("{call addNewStudent(?,?,?)}");
            cstmt.setString(1, student.getName());
            cstmt.setInt(2, student.getAge());
            cstmt.setBoolean(3,student.isStatus());
            cstmt.executeUpdate();
            return true;
        } catch (SQLException sql) {
            System.out.println(sql.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, cstmt);
        }
        return false;
    }

    @Override
    public boolean update(Student student) {
        Connection conn = null;
        CallableStatement cstmt = null;
        try {
            conn = ConnectionDB.openConnection();
            cstmt = conn.prepareCall("{call updateStudent(?,?,?,?)}");
            cstmt.setInt(1, student.getId());
            cstmt.setString(2, student.getName());
            cstmt.setInt(3, student.getAge());
            cstmt.setBoolean(4,student.isStatus());
            cstmt.executeUpdate();
            return true;
        } catch (SQLException sql) {
            System.out.println(sql.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, cstmt);
        }
        return false;
    }
    @Override
    public boolean delete(Student student) {
        Connection conn = null;
        CallableStatement cstmt = null;
        try {
            conn = ConnectionDB.openConnection();
            cstmt = conn.prepareCall("{call deleteStudent(?)}");
            cstmt.setInt(1, student.getId());
            cstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.fillInStackTrace();
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cstmt);
        }
        return false;
    }

    @Override
    public int getCountStudentByStatus(boolean status) {
        Connection conn = null;
        CallableStatement cstmt = null;
        try {
            conn = ConnectionDB.openConnection();
            cstmt = conn.prepareCall("{call getCountStudentByStatus(?,?)}");
            cstmt.setBoolean(1, status);
            cstmt.registerOutParameter(2, Types.INTEGER);
            cstmt.execute();
            return cstmt.getInt(2);
        } catch (SQLException e) {
            e.fillInStackTrace();
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cstmt);
        }
        return 0;
    }
}
