package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.DAO;

/**
 * Servlet implementation class UpdateControl
 */
@WebServlet("/update")
public class UpdateControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateControl() {
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
		request.setCharacterEncoding("UTF-8");
		
		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		int phone = Integer.parseInt(request.getParameter("phone"));
		String address = request.getParameter("address");
		int uid = Integer.parseInt(request.getParameter("id"));
		
		DAO dao = new DAO();
		dao.editProfile(fullname, email, phone, address, uid);
		
		request.getRequestDispatcher("profile?uid="+uid).forward(request, response);

		
		
	}

}
