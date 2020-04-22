package controllers.purchasehistory;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
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
 * Servlet implementation class PurchaseHistoryCreateServlet
 */
@WebServlet("/purchasehistory/create")
public class PurchaseHistoryCreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PurchaseHistoryCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String _token = (String)request.getParameter("_token");
        if(_token != null && _token.equals(request.getSession().getId())){

            EntityManager em = DBUtil.createEntityManager();

            PurchaseHistory h = new PurchaseHistory();

            Product p = em.find(Product.class , Integer.parseInt(request.getParameter("product")));

            h.setCustomer((Customer)request.getSession().getAttribute("customer"));
            h.setProduct(p);
            h.setSold_at(Date.valueOf(request.getParameter("sold_at")));
            h.setContent(request.getParameter("content"));
            h.setCreated_at(new Timestamp(System.currentTimeMillis()));
            h.setUpdated_at(new Timestamp(System.currentTimeMillis()));

            em.getTransaction().begin();
            em.persist(h);
            em.getTransaction().commit();
            em.close();

            request.getSession().setAttribute("flush","登録が完了しました。");

            response.sendRedirect(request.getContextPath() + "/customers/index");

        }
    }
}
