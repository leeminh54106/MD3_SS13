package com.example.baitap_1.controller.classes;

import com.example.baitap_1.model.Classes;
import com.example.baitap_1.service.ClassesService;
import com.example.baitap_1.service.impl.ClassesServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet (name = "classController", value = "/class-controller")
public class ClassesController extends HttpServlet {
    private ClassesService classesService = new ClassesServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        action = action == null ? "" : action;
        switch (action) {
            case "add":
                req.getRequestDispatcher("/WEB-INF/views/classes/add_class.jsp").forward(req, resp);
                break;
            case "edit":
            {
                String classId = req.getParameter("classId");
                req.setAttribute("classEdit", classesService.findById(classId));
                req.getRequestDispatcher("/WEB-INF/views/classes/edit_class.jsp").forward(req, resp);
                break;
            }
            case "delete":
            {
                String classId = req.getParameter("classId");
                classesService.deleteClass(classId);
//              req.getRequestDispatcher("/WEB-INF/views/class/students.jsp").forward(req, resp);
                resp.sendRedirect("/class-controller");
                break;
            }
            case "detail":
            {
                String classId = req.getParameter("classId");
                req.setAttribute("classDetail", classesService.findById(classId));
                req.getRequestDispatcher("/WEB-INF/views/classes/detail_class.jsp").forward(req, resp);
                break;
            }
            default:
                req.setAttribute("classes", classesService.findAll());
                req.getRequestDispatcher("/WEB-INF/views/classes/class.jsp").forward(req, resp);
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
                String classId = req.getParameter("classId");
                String className = req.getParameter("className");
                boolean status = Boolean.valueOf(req.getParameter("status"));
                Classes classes = new Classes(classId, className, status);
                classesService.addClass(classes);
                resp.sendRedirect("/class-controller");
                break;
            }
            case "edit":
            {
                String classId = req.getParameter("classId");
                String className = req.getParameter("className");
                boolean status = Boolean.valueOf(req.getParameter("status"));
                Classes classes = new Classes(classId, className, status);
                classesService.updateClass(classes);
                resp.sendRedirect("/class-controller");
                break;
            }
            case "search":
                String className = req.getParameter("className");
                List<Classes> classesResults = classesService.findClassByName(className);
                req.setAttribute("classes", classesResults);
                req.getRequestDispatcher("/WEB-INF/views/classes/class.jsp").forward(req, resp);
                break;
            default:
                req.setAttribute("classes", classesService.findAll());
                req.getRequestDispatcher("/WEB-INF/views/classes/class.jsp").forward(req, resp);
        }
    }
}
