package com.example.baitap_1.controller.students;

import com.example.baitap_1.model.Student;
import com.example.baitap_1.service.StudentService;
import com.example.baitap_1.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "studentController", value = "/student-controller")
public class StudentsController extends HttpServlet {
    private StudentService studentService = new StudentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        action = action == null ? "" : action;
        switch (action) {
            case "add":
                req.getRequestDispatcher("/WEB-INF/views/add_student.jsp").forward(req, resp);
                break;
            case "edit":
            {
                Integer studentId = Integer.parseInt(req.getParameter("studentId"));
                req.setAttribute("studentEdit", studentService.findById(studentId));
                req.getRequestDispatcher("/WEB-INF/views/edit_student.jsp").forward(req, resp);
                break;
            }
            case "delete":
            {
                Integer studentId = Integer.parseInt(req.getParameter("studentId"));
                studentService.deleteStudent(studentId);
                resp.sendRedirect("/student-controller");
                break;
            }
            case "detail":
            {
                Integer studentId = Integer.parseInt(req.getParameter("studentId"));
                req.setAttribute("studentDetail", studentService.findById(studentId));
                req.getRequestDispatcher("/WEB-INF/views/detail_student.jsp").forward(req, resp);
                break;
            }
            default:
            req.setAttribute("students", studentService.findAll());
            req.getRequestDispatcher("/WEB-INF/views/student.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        action = action == null ? "" : action;
        switch (action) {
            case "add":
            {
                String fullName = req.getParameter("fullName");
                String gender = req.getParameter("gender");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date birthday ;
                try {
                    birthday = sdf.parse(req.getParameter("birthday"));
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }

                String address = req.getParameter("address");
                String classId = req.getParameter("classId");
                Boolean studentGender = true;
                if (gender == null) studentGender = false;

                Student student = new Student(null, fullName, studentGender, birthday, address, classId);
                studentService.addStudent(student);
                resp.sendRedirect("/student-controller");
                break;
            }
            case "edit":
                Integer studentId = Integer.parseInt(req.getParameter("studentId"));
                String fullName = req.getParameter("fullName");
                String gender = req.getParameter("gender");

                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
                Date birthday;
                try {
                    birthday = sf.parse(req.getParameter("birthday"));
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }

                String address = req.getParameter("address");
                String classId = req.getParameter("classId");

                Boolean studentGender = true;


                if (gender == null) studentGender = false;

                Student student = new Student(studentId, fullName, studentGender,birthday,address,classId);
                studentService.updateStudent(student);
                break;
            case "search":
                String studentName = req.getParameter("studentName");
                List<Student> studentResults = studentService.findByStudentName(studentName);
                req.setAttribute("students", studentResults);
                req.getRequestDispatcher("/WEB-INF/views/students.jsp").forward(req, resp);
                break;
            default:
                req.setAttribute("students", studentService.findAll());
                req.getRequestDispatcher("/WEB-INF/views/student.jsp").forward(req, resp);
        }
    }
}