package com.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(
        urlPatterns = "/login",
        initParams = @WebInitParam(name="Lorem", value="Ipsom")
)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		String parameter = config.getInitParameter("Lorem");
		System.out.println(parameter);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("user_name");
		String password = request.getParameter("password");
		String message = "Login failed!";
		if (username.equals("a") && password.equals("a")) {
			message = "Welcome " + username;
		}
		response.getWriter()
				.append("<html><body>")
				.append("<h1>")
				.append(message)
				.append("</h1>")
				.append("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
