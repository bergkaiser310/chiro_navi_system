package controllers.products;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class ProductsIndex
 */
@WebServlet("/products/index")
public class ProductsIndex extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductsIndex() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        EntityManager em = DBUtil.createEntityManager();

        int page = 1;

        try{
            page = Integer.parseInt(request.getParameter("page"));
        }catch(NumberFormatException e){
            List<Product> products = em.createNamedQuery("getAllProducts",Product.class)
                                .setFirstResult(15 * (page - 1))
                                .setMaxResults(15)
                                .getResultList();


        Long product_count = (Long)em.createNamedQuery("getProductsCount", Long.class)
                            .getSingleResult();

        em.close();

        request.setAttribute("products", products);
        request.setAttribute("page", page);
        request.setAttribute("product_count", product_count);

        if(request.getSession().getAttribute("flush") != null){
            request.setAttribute("flush", request.getSession().getAttribute("flush"));
            request.getSession().removeAttribute("flush");
        }

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/products/index.jsp");
        rd.forward(request,response);

        }
    }
}