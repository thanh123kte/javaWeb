package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import entity.Account;

/**
 * Servlet implementation class RegisterControl
 */
@WebServlet("/register")
public class RegisterControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterControl() {
        super();
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
		String repass = request.getParameter("repass");
		
		if(pass.equals(repass)) {
			DAO dao = new DAO();
			int check = dao.register(account, pass);
			if(check==0) {
				request.setAttribute("mess", "Account already existed");
				request.getRequestDispatcher("Register.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
		}else {
			request.setAttribute("mess", "Password are not the same");
			request.getRequestDispatcher("Register.jsp").forward(request, response);
		}
		
	}

}
