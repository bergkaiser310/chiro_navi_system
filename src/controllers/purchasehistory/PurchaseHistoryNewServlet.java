package controllers.purchasehistory;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Customer;
import models.Product;
import models.PurchaseHistory;
import utils.DBUtil;

/**
 * Servlet implementation class PurchaseHistoryNewServlet
 */
@WebServlet("/purchasehistory/new")
public class PurchaseHistoryNewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PurchaseHistoryNewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

       EntityManager em = DBUtil.createEntityManager();

       List<Product> products = em.createNamedQuery("getAllProducts",Product.class)
                                .getResultList();


       Customer c = em.find(Customer.class, Integer.parseInt(request.getParameter("id")));

       em.close();

        PurchaseHistory h = new PurchaseHistory();
        h.setSold_at(new Date(System.currentTimeMillis()));

        request.setAttribute("products", products);
        request.setAttribute("history", h);
        request.setAttribute("_token", request.getSession().getId());
        request.getSession().setAttribute("customer", c );
        request.getSession().setAttribute("customer_id", c.getId());

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/purchaseHistory/new.jsp");
        rd.forward(request, response);
    }




}
