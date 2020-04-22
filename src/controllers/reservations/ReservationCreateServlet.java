package controllers.reservations;

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
import models.Reservation;
import utils.DBUtil;

/**
 * Servlet implementation class ReservationCreateServlet
 */
@WebServlet("/reservation/create")
public class ReservationCreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationCreateServlet() {
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

            Reservation r = new Reservation();

            r.setCustomer((Customer)request.getSession().getAttribute("customer"));
            r.setReserve_at(Date.valueOf(request.getParameter("reserve_at")));

            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
            r.setCreated_at(currentTime);
            r.setUpdated_at(currentTime);

            em.getTransaction().begin();
            em.persist(r);
            em.getTransaction().commit();
            em.close();

            request.getSession().setAttribute("flush","登録が完了しました。");
            request.getSession().removeAttribute("customer");

            response.sendRedirect(request.getContextPath() + "/customers/index");
        }
    }

}
