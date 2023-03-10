package com.woo.home;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello WH");
		
		Soldier soldier = new Soldier();
		Gun gun = new Gun();
		Bullet bullet = new Bullet();
		
		soldier.setGun(gun);
		
		gun.setBullet(bullet);
		
		soldier.useGun();
		
//		String method = request.getMethod();
//		System.out.println("Method : "+method);
//		StringBuffer sb = request.getRequestURL();
//		System.out.println("URL : "+sb);
//		String uri = request.getRequestURI();
//		System.out.println("URI : "+uri);
//		// Cookie
//		Cookie [] cookies = request.getCookies();
//		for(Cookie cookie : cookies) {
//			System.out.println("Cookie Name : "+cookie.getName());
//			System.out.println("Cookie Value : "+cookie.getValue());
//		}
//		// ContextPath
//		String context = request.getContextPath();
//		System.out.println("ContextPath : "+context);
//		// name(Parameter)
//		String name = request.getParameter("name");
//		System.out.println("Name : "+name);
//		// age(Parameter)
//		String age = request.getParameter("age");
//		int a = Integer.parseInt(age);
//		System.out.println("Age : "+a*2);
//		// moneys(ParameterValues)
//		String [] moneys = request.getParameterValues("money");
//		for(String m:moneys) {
//			System.out.println(m);
//		}
		
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/home.jsp");
		view.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
