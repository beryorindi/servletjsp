package com.mitrais.rms.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/home")
public class HomePageServlet extends AbstractController
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
    	String path = getTemplatePath(req.getServletPath());
        
        
//    	HttpSession session = req.getSession(true);
//    	String uname = req.getParameter("username");
//    	session.setAttribute("username", uname);
    	
    	RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
        requestDispatcher.forward(req, resp);
        //req.getRequestDispatcher(req.getServletPath()+"/home.jsp").forward(req, resp);
    }

}
