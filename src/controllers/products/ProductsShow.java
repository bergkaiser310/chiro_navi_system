package controllers.products;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Product;
import utils.DBUtil;

/**
 * Servlet implementation class ProductsShow
 */
@WebServlet("/products/show")
public class ProductsShow extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductsShow() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        Product p  = em.find(Product.class, Integer.parseInt(request.getParameter("id")));

        em.close();

        request.setAttribute("product", p);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/products/show.jsp");
        rd.forward(request, response);
    }
}
