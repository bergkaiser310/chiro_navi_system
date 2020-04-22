package controllers.purchasehistory;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.PurchaseHistory;
import utils.DBUtil;

/**
 * Servlet implementation class PurchaseHistoryDestory
 */
@WebServlet("/purchasehistory/destory")
public class PurchaseHistoryDestory extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PurchaseHistoryDestory() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String _token = (String)request.getParameter("_token");
        if(_token != null && _token.equals(request.getSession().getId())){

        EntityManager em = DBUtil.createEntityManager();

        PurchaseHistory h = em.find(PurchaseHistory.class,(Integer)(request.getSession().getAttribute("history_id")));


        em.getTransaction().begin();
        em.remove(h);
        em.getTransaction().commit();
        em.close();

        request.getSession().setAttribute("flush", "削除しました。");
        request.getSession().removeAttribute("history_id");
        response.sendRedirect(request.getContextPath() + "/customers/index");

        }
    }
}
