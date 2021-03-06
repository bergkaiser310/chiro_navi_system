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
 * Servlet implementation class ProductsEdit
 */
@WebServlet("/products/edit")
public class ProductsEdit extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductsEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        EntityManager em = DBUtil.createEntityManager();

        Product p = em.find(Product.class, Integer.parseInt(request.getParameter("id")));

        em.close();

        request.setAttribute("_token", request.getSession().getId());
        request.setAttribute("product", p);
        request.getSession().setAttribute("product_id", p.getId());

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/products/edit.jsp");
        rd.forward(request, response);
    }
 }