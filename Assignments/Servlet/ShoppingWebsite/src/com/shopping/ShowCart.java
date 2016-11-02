package com.shopping;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShowCart
 */
@WebServlet("/showCart")
public class ShowCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<String> books = new ArrayList<>();
		List<String> comp_books = (List<String>) session.getAttribute("books");
		if (comp_books != null && !comp_books.isEmpty())
			books.addAll(comp_books);
		
		String[] hist_books = request.getParameterValues("hist_book");
		if (hist_books != null && hist_books.length != 0) {
			List<String> hist_books_in_list = Arrays.asList(hist_books);
			books.addAll(hist_books_in_list);
		}
		
		session.setAttribute("books", books);
		
		PrintWriter writer = response.getWriter();
				writer.append("<!DOCTYPE html>") 
				.append("<html>")
				.append("<head>")
				.append("<title>Shopping Cart</title>")
				.append("</head>")
				.append("<body>")
				.append("<h1>")
				.append("Welcome " + session.getAttribute("username"))
				.append("</h1>");

		for (String book : books) {
			writer.append("<ul>")
				  .append("<li>")
				  .append(book)
				  .append("</li>")
				  .append("</ul>");
		}
		writer.append("<form action=\"controller?forward=logout\" method=\"POST\">")
			  .append("<br>")
			  .append("<input value=\"Logout\" type=\"submit\">")
			  .append("</form>")
			  .append("</body>")
			  .append("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
