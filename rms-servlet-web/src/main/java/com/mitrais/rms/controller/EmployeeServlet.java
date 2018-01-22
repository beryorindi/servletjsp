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
import com.mitrais.rms.model.User;

@WebServlet("/employees/*")
public class EmployeeServlet extends AbstractController{
	EmployeeDao empDao = EmployeeDaoImpl.getInstance();
	
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
	        if ("/".equalsIgnoreCase(req.getPathInfo())) {
				path = req.getServletPath()+"/list";
	        }
	        if ("/list".equalsIgnoreCase(req.getPathInfo())){	           
	            List<Employee> emp = empDao.findAll();
	            req.setAttribute("employees", emp);
	        }
	        if ("/edit".equalsIgnoreCase(req.getPathInfo())){
	        	Long id = Long.parseLong(req.getParameter("id"));
	            Employee emp = empDao.find(id);
	            req.setAttribute("employee", emp);
	        }
	        if("/delete".equalsIgnoreCase(req.getPathInfo())){
	        	Long id = Long.parseLong(req.getParameter("id"));
	        	Employee emp = empDao.find(id);
	        	empDao.delete(emp);
	        	path = req.getServletPath()+"/list";
	        }
	
	        RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
	        requestDispatcher.forward(req, resp);
	    }
    }
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		String path = getTemplatePath(req.getServletPath()+req.getPathInfo());
		HttpSession session = req.getSession(true);
		
    	if(session.getAttribute("username") == null)
		{
    		resp.sendRedirect(req.getContextPath()+"/login");
		}
		else {
			if("/form".equalsIgnoreCase(req.getPathInfo())){
	        	Employee emp = new Employee(req.getParameter("name"), req.getParameter("position"), req.getParameter("office"));
	        	empDao.save(emp);
	        }
	        if ("/edit".equalsIgnoreCase(req.getPathInfo())){
	            Employee emp = new Employee(Long.parseLong(req.getParameter("id")), req.getParameter("name"), req.getParameter("position"), req.getParameter("office"));
	            empDao.update(emp);
	        }
	        path = req.getContextPath()+req.getServletPath()+"/list";
	        resp.sendRedirect(path);
		}
	}
}
