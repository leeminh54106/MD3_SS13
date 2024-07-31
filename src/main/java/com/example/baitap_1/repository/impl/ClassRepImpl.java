package com.example.baitap_1.repository.impl;

import com.example.baitap_1.model.Classes;
import com.example.baitap_1.repository.ClassRep;
import com.example.baitap_1.utils.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassRepImpl implements ClassRep {

    @Override
    public List<Classes> findAll() {
        //1 Tạo kết nối
        Connection conn = ConnectionDB.openConnection();
        List<Classes> classesList = new ArrayList<>();
        try {
            //2. Thực thi truy vấn
            PreparedStatement ps = conn.prepareStatement("select * from classes");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Classes classes = new Classes();
                classes.setClassId(rs.getString("classId"));
                classes.setClassName(rs.getString("className"));
                classes.setStatus(rs.getBoolean("status"));
                classesList.add(classes);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //3. Đóng kết nối
            ConnectionDB.closeConnection(conn);
        }
        return classesList;
    }

    @Override
    public Classes findById(String classId) {
        Connection conn = ConnectionDB.openConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from classes where classId = ?");
            ps.setString(1, classId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Classes classes = new Classes();
                classes.setClassId(rs.getString("classId"));
                classes.setClassName(rs.getString("className"));
                classes.setStatus(rs.getBoolean("status"));
                return classes;
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
    public boolean addClass(Classes classes) {
        Connection conn = ConnectionDB.openConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("insert into classes (classId, className, status) value (?, ?, ?)");
            ps.setString(1, classes.getClassId());
            ps.setString(2, classes.getClassName());
            ps.setBoolean(3, classes.isStatus());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public boolean updateClass(Classes classes) {
       Connection conn = ConnectionDB.openConnection();

        try {
            PreparedStatement ps = conn.prepareStatement("update classes set className = ?, status = ? where classId = ?");
            ps.setString(1, classes.getClassName());
            ps.setBoolean(2, classes.isStatus());
            ps.setString(3, classes.getClassId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public boolean deleteClass(String classId) {
        Connection conn = ConnectionDB.openConnection();

        try {
            PreparedStatement ps = conn.prepareStatement("delete from classes where classId =?");
            ps.setString(1, classId);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public List<Classes> findClassByName(String className) {
        List<Classes> classesList = new ArrayList<>();

        Connection conn = ConnectionDB.openConnection();

        try {
            if (className == null || className.isEmpty()) {
                className = "%";
            }
            else {
                className = "%" + className + "%";
            }
            PreparedStatement ps = conn.prepareStatement("select * from classes where className like ?");
            ps.setString(1, "%" + className + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Classes classes = new Classes();
                classes.setClassId(rs.getString("classId"));
                classes.setClassName(rs.getString("className"));
                classes.setStatus(rs.getBoolean("status"));
                classesList.add(classes);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(conn);
        }
        return classesList;
    }
}
