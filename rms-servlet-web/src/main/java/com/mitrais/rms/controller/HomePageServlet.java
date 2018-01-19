package com.mitrais.rms.controller;

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
    	HttpSession session = req.getSession(true);
    	String uname = req.getParameter("username");
    	session.setAttribute("username", uname);
        req.getRequestDispatcher(req.getContextPath()+"/home.jsp").forward(req, resp);
    }

}
