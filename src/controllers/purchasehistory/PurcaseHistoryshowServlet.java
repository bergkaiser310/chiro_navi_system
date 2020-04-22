package controllers.purchasehistory;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.PurchaseHistory;
import utils.DBUtil;

/**
 * Servlet implementation class PurcaseHistoryshowServlet
 */
@WebServlet("/purcasehistory/show")
public class PurcaseHistoryshowServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PurcaseHistoryshowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        EntityManager em = DBUtil.createEntityManager();

        PurchaseHistory h  = em.find(PurchaseHistory.class, Integer.parseInt(request.getParameter("id")));

        em.close();

        request.setAttribute("history", h);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/purchaseHistory/show.jsp");
        rd.forward(request, response);
    }




}
