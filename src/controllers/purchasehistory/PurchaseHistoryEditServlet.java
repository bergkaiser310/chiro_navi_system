package controllers.purchasehistory;

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
import models.PurchaseHistory;
import utils.DBUtil;

/**
 * Servlet implementation class PurchaseHistoryEditServlet
 */
@WebServlet("/purchasehistory/edit")
public class PurchaseHistoryEditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PurchaseHistoryEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        EntityManager em = DBUtil.createEntityManager();

        PurchaseHistory h = em.find(PurchaseHistory.class, Integer.parseInt(request.getParameter("id")));

        List<Product> products = em.createNamedQuery("getAllProducts",Product.class)
                .getResultList();

        request.setAttribute("products", products);
        request.setAttribute("history", h);
        request.setAttribute("_token", request.getSession().getId());
        request.getSession().setAttribute("history_id", h.getId());

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/purchaseHistory/edit.jsp");
        rd.forward(request, response);

    }

}
