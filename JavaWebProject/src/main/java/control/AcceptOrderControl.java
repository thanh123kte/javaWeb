package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import entity.Account;
import entity.Order_details;

/**
 * Servlet implementation class AcceptOrderControl
 */
@WebServlet("/acceptorder")
public class AcceptOrderControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcceptOrderControl() {
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
		int id = Integer.parseInt(request.getParameter("id"));
		
		String check = request.getParameter("check");
		DAO dao = new DAO();
		if(check.equals("1")){	
			dao.acceptOrder(id);
			request.getRequestDispatcher("listordercontrol").forward(request, response);
		}else if(check.equals("2")) {
			int code = Integer.parseInt(request.getParameter("code"));
			dao.deleteOrder(id);
			dao.deleteOrderDetails(code);
			request.getRequestDispatcher("listordercontrol").forward(request, response);
		}else {
			List<Order_details> list = new ArrayList<Order_details>();
			int code = Integer.parseInt(request.getParameter("code"));
			list = dao.getOrderDetails(code);
			int uid = list.get(0).getUserid();
			Account a = new Account();
			
			a = dao.getUserAccount(uid);
			System.out.println("id"+a.getId());
			System.out.println("name"+a.getName());
			System.out.println("addr"+a.getAddress());
			System.out.println("email"+a.getAddress());
			System.out.println("phone"+a.getPhone());
			int total=1;
			for (Order_details l : list) {
				total += l.getPrice()*l.getQuantity();
			}
			total += total*15/100;
			
			request.setAttribute("listo", list);
			request.setAttribute("acc", a);
			request.setAttribute("total", total);
			request.getRequestDispatcher("admin/orderDetails.jsp").forward(request, response);
		}
		
		
		
	}

}
