package control;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.DAO;

/**
 * Servlet implementation class ExcecuteUpdateControl
 */
@MultipartConfig
@WebServlet("/execute")
public class ExcecuteUpdateControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcecuteUpdateControl() {
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
		HttpSession session = request.getSession();
		
		String name; 
		String decs ;
		String oldimg = (String) session.getAttribute("primg");
		double price ;
		
		if(!(request.getParameter("editname") == null)) {
			 name = request.getParameter("editname");
		}else {
			 name = (String) session.getAttribute("prname");
		}
		
		if(!(request.getParameter("editdecs") == null)) {
			 decs = request.getParameter("editdecs");
		}else {
			 decs = (String) session.getAttribute("prdecs");
		}
		
		if(!(request.getParameter("editprice") == null)) {
			 price = Double.parseDouble(request.getParameter("editprice")) ;
		}else {
			 price = (Double) session.getAttribute("prprice");
		}
		
		
		int id = (int) session.getAttribute("prid");
		

		Part part = request.getPart("editimage");

		System.out.println("id"+id);
		System.out.println("name"+name);
		System.out.println("decs"+decs);
		System.out.println("old"+oldimg);
		System.out.println("price"+price);
		System.out.println("part"+part);
		
		DAO dao = new DAO(); 
		if(part.getSize() == 0) {
			System.out.println("yess");
			dao.updateProduct(id, name, decs, oldimg, price);
		}else {
			String realPath = "E:/java file/JavaWebProject/src/main/webapp/uploads";

			String filename = Path.of(part.getSubmittedFileName()).getFileName().toString();
			
			dao.updateProduct(id, name, decs, filename, price);
			
			File fileToDelete = new File(realPath, oldimg);
		    part.write(realPath+"/"+filename);
		    
		}
		
		request.getRequestDispatcher("dashboard").forward(request, response);
		
		
	}

}
