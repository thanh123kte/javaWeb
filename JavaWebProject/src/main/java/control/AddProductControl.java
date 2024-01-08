package control;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.DAO;

/**
 * Servlet implementation class AddProductControl
 */
@MultipartConfig
@WebServlet("/addproduct")

public class AddProductControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductControl() {
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
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String decs = request.getParameter("decs");
		double price = Double.parseDouble(request.getParameter("price"));
		Part part = request.getPart("image");
		
		String realPath = "E:/java file/JavaWebProject/src/main/webapp/uploads";

		String filename = Path.of(part.getSubmittedFileName()).getFileName().toString();
		
		System.out.println(name);
		System.out.println(decs);
		System.out.println(price);
		System.out.println(part);
		System.out.println(filename);
		System.out.println(realPath);
		
		DAO dao = new DAO(); 
		
		
		if(dao.addProduct(name, decs, filename, price) == true) {
	        part.write(realPath+"/"+filename);
			response.sendRedirect(request.getContextPath() + "/admin/addProduct.jsp?mess=Add+succeed");
		}else {
			response.sendRedirect(request.getContextPath() + "/admin/addProduct.jsp?mess=Add+failed");

			
		}
		

		
	}

}
