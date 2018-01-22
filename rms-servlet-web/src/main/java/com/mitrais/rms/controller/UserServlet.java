package com.mitrais.rms.controller;

import com.mitrais.rms.dao.UserDao;
import com.mitrais.rms.dao.impl.UserDaoImpl;
import com.mitrais.rms.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/users/*")
public class UserServlet extends AbstractController
{
	UserDao userDao = UserDaoImpl.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
    	String path = getTemplatePath(req.getServletPath()+req.getPathInfo());
    	HttpSession session = req.getSession(true);
    	if(session.getAttribute("username") == null)
		{
    		resp.sendRedirect(req.getContextPath()+"/login");
		}
		else {
			if ("/".equalsIgnoreCase(req.getPathInfo())) {
				path = req.getServletPath()+"/list";
	        }
	        if ("/list".equalsIgnoreCase(req.getPathInfo())) {
	            List<User> users = userDao.findAll();
	            req.setAttribute("users", users);
	        }
	        if ("/edit".equalsIgnoreCase(req.getPathInfo())){
	        	Long id = Long.parseLong(req.getParameter("id"));
	            User user = userDao.find(id);
	            req.setAttribute("user", user);
	        }
	        
	        if("/delete".equalsIgnoreCase(req.getPathInfo())){
	        	Long id = Long.parseLong(req.getParameter("id"));
	        	User user = userDao.find(id);
	            userDao.delete(user);
	            path = req.getServletPath()+"/list";
	            //resp.sendRedirect(path);
	        }
	        RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
	        requestDispatcher.forward(req, resp);
		}
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String path = getTemplatePath(req.getServletPath()+req.getPathInfo());

        if("/form".equalsIgnoreCase(req.getPathInfo())){
        	User user = new User(req.getParameter("username"), req.getParameter("userpass"));
        	userDao.save(user);
        }
        if ("/edit".equalsIgnoreCase(req.getPathInfo())){
            User user = new User(Long.parseLong(req.getParameter("id")), req.getParameter("username"), req.getParameter("userpass"));
            userDao.update(user);            
        }
        
        path = req.getContextPath()+req.getServletPath()+"/list";
        resp.sendRedirect(path);
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
//        requestDispatcher.forward(req, resp);
        //resp.sendRedirect("list");
    }
    
    
}
