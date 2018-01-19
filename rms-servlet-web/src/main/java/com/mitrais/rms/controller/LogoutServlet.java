package com.mitrais.rms.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/logout")
public class LogoutServlet extends AbstractController
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
    	HttpSession session = req.getSession(false);
    	if(session != null){
    		session.invalidate();
    	}
    	resp.sendRedirect(req.getContextPath()+"/login");
    }


}
