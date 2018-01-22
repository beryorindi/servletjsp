package com.mitrais.rms.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mitrais.rms.dao.UserDao;
import com.mitrais.rms.dao.impl.UserDaoImpl;
import com.mitrais.rms.model.User;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/login")
public class LoginServlet extends AbstractController
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
    	
    	String path = getTemplatePath(req.getServletPath());
    	
    	HttpSession session = req.getSession(true);
    	if(session.getAttribute("username") == null)
		{
    		RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
	        requestDispatcher.forward(req, resp);
		}else{
	        resp.sendRedirect(req.getContextPath()+"/home");
		}
 
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
    	UserDao userDao = UserDaoImpl.getInstance();
    	String uname = req.getParameter("username");
    	String upass = req.getParameter("userpass");
    	
    	User loginUser = new User(uname,upass);
    	HttpSession session = req.getSession(true);
    	Optional<User> dbuser = userDao.findByUserName(uname);
    	if(dbuser.isPresent()){
    		if(loginUser.getPassword().equals(dbuser.get().getPassword())){
        		session.setAttribute("username", uname);
        		resp.sendRedirect(req.getContextPath()+"/home");
        	}else{
        		resp.sendRedirect(req.getContextPath()+"/login");
        	}
    	}
    	else{
    		resp.sendRedirect(req.getContextPath()+"/login");
    	}
    	
    	
    	
        
    }
}
