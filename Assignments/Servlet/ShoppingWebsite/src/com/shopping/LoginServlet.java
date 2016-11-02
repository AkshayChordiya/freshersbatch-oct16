package com.shopping;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = request.getParameter("user_name");
		session.setAttribute("username", username);
		String password = request.getParameter("password");
		if (!session.isNew()) {
			request.getRequestDispatcher("comp_books.html").forward(request, response);
			return;
		}
		if (username != null && password != null && username.equals("a") && password.equals("a")) {
			request.getRequestDispatcher("comp_books.html").forward(request, response);
		} else {
			response.getWriter()
					.append("<html><body>")
					.append("<h1>")
					.append("Login failed!")
					.append("</h1>")
					.append("</body></html>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
