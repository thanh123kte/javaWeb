package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdateProductControl
 */
@WebServlet("/updatecontrol")
public class UpdateProductControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String decs = request.getParameter("decs");
		String img = request.getParameter("image");
		double price = Double.parseDouble(request.getParameter("price"));
		
		request.setAttribute("prid", id);
		request.setAttribute("name", name);
		request.setAttribute("decs", decs);
		request.setAttribute("img", img);
		request.setAttribute("price", price);
		
		HttpSession session = request.getSession();
		session.setAttribute("prid", id);
		session.setAttribute("prname", name);
		session.setAttribute("prdecs", decs);
		session.setAttribute("primg", img);
		session.setAttribute("prprice", price);
		
		request.getRequestDispatcher("admin/updateProduct.jsp").forward(request, response);
		
	}

}
