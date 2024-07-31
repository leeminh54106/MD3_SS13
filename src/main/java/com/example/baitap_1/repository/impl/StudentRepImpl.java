package com.example.baitap_1.repository.impl;

import com.example.baitap_1.model.Student;
import com.example.baitap_1.repository.StudentRep;
import com.example.baitap_1.utils.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepImpl implements StudentRep {
    @Override
    public List<Student> findAll() {
        Connection conn = ConnectionDB.openConnection();
        List<Student> students = new ArrayList<>();

        try {
            CallableStatement cs = conn.prepareCall("{call get_all_students()}");
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setStudentId(rs.getInt("studentId"));
                student.setFullName(rs.getString("fullName"));
                student.setGender(rs.getBoolean("Gender"));
                student.setBirthday(rs.getDate("birthday"));
                student.setAddress(rs.getString("address"));
                student.setClassId(rs.getString("classId"));
                students.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            ConnectionDB.closeConnection(conn);
        }
        return students;
    }

    @Override
    public Student findById(Integer studentId) {
        Connection conn = ConnectionDB.openConnection();

        try {
            CallableStatement cs = conn.prepareCall("{call get_student_by_id(?)}");
            cs.setInt(1, studentId);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                Student student = new Student();
                student.setStudentId(rs.getInt("studentId"));
                student.setFullName(rs.getString("fullName"));
                student.setGender(rs.getBoolean("Gender"));
                student.setBirthday(rs.getDate("birthday"));
                student.setAddress(rs.getString("address"));
                student.setClassId(rs.getString("classId"));
                return student;
            }
            else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public boolean addStudent(Student student) {
        Connection conn = ConnectionDB.openConnection();

        try {
            CallableStatement cs = conn.prepareCall("{call insert_student(?, ?, ? ,? ,?)}");
            cs.setString(1, student.getFullName());
            cs.setBoolean(2, student.isGender());
            cs.setDate(3, new Date(student.getBirthday().getTime()));
            cs.setString(4, student.getAddress());
            cs.setString(5, student.getClassId());
            cs.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public boolean updateStudent(Student student) {
        Connection conn = ConnectionDB.openConnection();

        try {
            CallableStatement cs = conn.prepareCall("{call update_student(?, ?, ?, ?, ?, ?)}");
            cs.setInt(1, student.getStudentId());
            cs.setString(2, student.getFullName());
            cs.setBoolean(3, student.isGender());
            cs.setDate(4, new Date(student.getBirthday().getTime()));
            cs.setString(5, student.getAddress());
            cs.setString(6, student.getClassId());
            cs.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            ConnectionDB.closeConnection(conn);
        }

    }

    @Override
    public boolean deleteStudent(Integer studentId) {
        Connection conn = ConnectionDB.openConnection();

        try {
            CallableStatement cs = conn.prepareCall("{call delete_student(?)}");
            cs.setInt(1, studentId);
            cs.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public List<Student> findByStudentName(String studentName) {
        List<Student> students = new ArrayList<>();
        Connection conn = ConnectionDB.openConnection();
        try {
            PreparedStatement ps = conn.prepareCall("{call delete_student(?)}");
            ps.setString(1, studentName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setStudentId(rs.getInt("studentId"));
                student.setFullName(rs.getString("fullName"));
                student.setGender(rs.getBoolean("Gender"));
                student.setBirthday(rs.getDate("birthday"));
                student.setAddress(rs.getString("address"));
                student.setClassId(rs.getString("classId"));
                students.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            ConnectionDB.closeConnection(conn);
        }
        return students;
    }
}
