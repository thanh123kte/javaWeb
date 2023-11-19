package control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import entity.Account;

/**
 * Servlet implementation class LoginControl
 */
@WebServlet("/login")
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginControl() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String account = request.getParameter("user");
		String pass = request.getParameter("pass");
		DAO dao = new DAO();
		Account a = dao.login(account, pass);
		 if(a.getPermission() == 2) {
			 HttpSession session = request.getSession();
			 session.setAttribute("acc", a);
			 session.setAttribute("pass", pass);
			 request.getRequestDispatcher("home").forward(request, response);
		}else if(a.getPermission() == 1) {
			request.getRequestDispatcher("dashboard.jsp").forward(request, response);
		}else {
			request.setAttribute("mess", "<div class=\"alert alert-danger\" role=\"alert\">\r\n"
					+ "  Wrong password or username.\r\n"
					+ "</div>");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
	}
	
	
}
