package com.sathya;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
@WebServlet("/productservlets")
public class productservlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		String ProId = request.getParameter("proId");
	    String ProName  =request.getParameter("proName");
	    
	    double ProPrice = Double.parseDouble(request.getParameter("proPrice"));
	      String ProBrand = request.getParameter("proBrand");
	      String ProMadeIn = request.getParameter("proMadeIn");
	      
	    Date ProMfgDate    =  Date.valueOf(request.getParameter("proMfgDate"));
	    Date ProExpDate   =  Date.valueOf(request.getParameter("proExpDate"));
	    
	     Part part= request.getPart("proImage");
	     InputStream ProImage  = part.getInputStream();
	
	// place the into object
	Product product = new Product();
	product.setProId(ProId);
	product.setProName(ProName);
	product.setProPrice(ProPrice);
	product.setProBrand(ProBrand);
	product.setProMadeIn(ProMadeIn);
	product.setProMfgDate(ProMfgDate);
	product.setProExpDate(ProExpDate);
	product.setProImage(ProImage);
	

   // send the data in dao layer
	ProductDao dao = new ProductDao();
	   int result= dao.saveProduct(product);
	   
	   if(result==1)
	   {
		   RequestDispatcher dispatcher= request.getRequestDispatcher("ProductList.jsp");
	  dispatcher.forward(request, response);
	   }
	   
	   else
	   {
	   response.setContentType("text/html");
	   PrintWriter writer =response.getWriter();
	   
	   writer.println(" product not saved please check one");
	   RequestDispatcher dispatcher =request.getRequestDispatcher("Product.html");
	dispatcher.include(request, response);
	
}

	}


	}


