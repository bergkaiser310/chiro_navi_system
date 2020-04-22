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

import models.Product;
import models.PurchaseHistory;
import utils.DBUtil;

/**
 * Servlet implementation class PurachaseHistoryUpdateServlet
 */
@WebServlet("/purachasehistory/update")
public class PurchaseHistoryUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PurchaseHistoryUpdateServlet() {
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

            PurchaseHistory h = em.find(PurchaseHistory.class, (Integer)(request.getSession().getAttribute("history_id")));

            h.setSold_at(Date.valueOf(request.getParameter("sold_at")));

            Product p = em.find(Product.class , Integer.parseInt(request.getParameter("product")));
            h.setProduct(p);

            h.setContent(request.getParameter("content"));
            h.setUpdated_at(new Timestamp(System.currentTimeMillis()));

            //List<String> errors = PurchaseHistoryValidator.validate(h);
            //if(errors.size() > 0){
            //    em.close();

            //    request.setAttribute("_token", _token);
            //    request.setAttribute("errors", errors);
            //    request.setAttribute("history", h);

            //    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/purchaseHistory/edit.jsp");
            //    rd.forward(request,response);
            //}else{

                em.getTransaction().begin();
                em.getTransaction().commit();
                em.close();

                request.getSession().setAttribute("flush", "更新が完了しました。");
                request.getSession().removeAttribute("history_id");

                response.sendRedirect(request.getContextPath() + "/customers/index");
            }
        }
    }

//}
