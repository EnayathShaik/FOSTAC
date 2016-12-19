package com.ir.servlet.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ir.general.ReadProperties;

public class ConfigServlet extends HttpServlet {
	
	/**
	 * Servlet used to read properties
	 */
	private static final long serialVersionUID = 1L;

	public void init()
    {
		try{
			ReadProperties properties = new ReadProperties();
			properties.readProperties();
		}catch(Exception E){
			System.out.println("Exception while fetching properties.." + E.getMessage());
		}
    }
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	}
		
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	}

}
