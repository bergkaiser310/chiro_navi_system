package controllers.products;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Product;
import utils.DBUtil;

/**
 * Servlet implementation class ProductsDestroy
 */
@WebServlet("/products/destroy")
public class ProductsDestroy extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductsDestroy() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        EntityManager em = DBUtil.createEntityManager();

        Product product = em.find(Product.class,(Integer)(request.getSession().getAttribute("product_id")));

        em.getTransaction().begin();
        em.remove(product);
        em.getTransaction().commit();
        em.close();

        request.getSession().setAttribute("flush", "削除しました。");
        request.getSession().removeAttribute("product_id");
        response.sendRedirect(request.getContextPath() + "/products/index");
        }

    }
