package com.mitrais.rms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mitrais.rms.dao.EmployeeDao;
import com.mitrais.rms.dao.impl.EmployeeDaoImpl;
import com.mitrais.rms.model.Employee;

@WebServlet("/employees/*")
public class EmployeeServlet extends AbstractController{
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
		HttpSession session = req.getSession(true);
    	if(session.getAttribute("username") == null)
		{
    		resp.sendRedirect(req.getContextPath()+"/login");
		}
		else {
	        String path = getTemplatePath(req.getServletPath()+req.getPathInfo());
	
	        if ("/list".equalsIgnoreCase(req.getPathInfo())){
	            EmployeeDao empDao = EmployeeDaoImpl.getInstance();
	            List<Employee> emp = empDao.findAll();
	            req.setAttribute("employees", emp);
	        }
	
	        RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
	        requestDispatcher.forward(req, resp);
	    }
    }
}
