package com.woo.home.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProductDAO productDAO;
	private ProductService productService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        productDAO = new ProductDAO();
        productService = new ProductService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Product page");
		
		StringBuffer sb = request.getRequestURL();
		System.out.println("URL : "+sb);
		String uri = request.getRequestURI();
		System.out.println("URI : "+uri);
		
		uri = uri.substring(uri.lastIndexOf("/")+1);
		String path = "";
		switch(uri) {
		case "list.do":
			try {
				List<ProductDTO> ar = productService.getProductList();
				request.setAttribute("list", ar);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			path="productList.jsp";
			break;
		case "add.do":
			path="productAdd.jsp";
			break;
		case "update.do":
			path="productUpdate.jsp";
			break;
		case "delete.do":
			System.out.println("상품 삭제");
			break;
		case "detail.do":
			int num = Integer.parseInt(request.getParameter("productNum"));
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProductNum(num);
			try {
				productDTO = productService.getProductDetail(productDTO);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			path="productDetail.jsp";
			break;
		default:
			System.out.println("X");
			break;
		
		}
		
			
//		String name = request.getParameter("name");
//		System.out.println(name);
//		String detail = request.getParameter("detail");
//		System.out.println(detail);
//		ProductDTO productDTO = new ProductDTO();
//		productDTO.setProductName(name);
//		productDTO.setProductDetail(detail);
//		
//		try {
//			int result = productService.setAddProduct(productDTO, new ArrayList<ProductOptionDTO>());
//			System.out.println(result);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/product/"+path);
		view.forward(request, response);
	}
		
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
