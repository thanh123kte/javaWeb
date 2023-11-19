package control;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import entity.Cart;

/**
 * Servlet implementation class CheckOutControl
 */
@WebServlet("/checkout")
public class CheckOutControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckOutControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		DAO dao = new DAO();
		int uid = Integer.parseInt(request.getParameter("uid"));
		Random random = new Random();
		int order_code = random.nextInt(900000) + 100000;
		
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	    String order_date = currentDateTime.format(formatter);
	    
	    String order_status = "Mới";
	    dao.addOrder(order_code, order_date, order_status);
	    
	    List<Cart> list = dao.cartProduct(uid);
	    for(Cart o : list) {
	    	dao.addOrderDetail(order_code, uid, o.getId(), o.getQuantity());
	    }
	    
	    dao.deleteAllCart(uid);
	    
	    response.sendRedirect("cart?uid="+uid);
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
