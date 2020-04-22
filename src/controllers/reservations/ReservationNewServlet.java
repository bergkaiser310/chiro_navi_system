package controllers.reservations;

import java.io.IOException;
import java.sql.Date;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Customer;
import models.Reservation;
import utils.DBUtil;

/**
 * Servlet implementation class ReservationNewServlet
 */
@WebServlet("/reservation/new")
public class ReservationNewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationNewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        EntityManager em = DBUtil.createEntityManager();

        Customer c = em.find(Customer.class, Integer.parseInt(request.getParameter("id")));

        em.close();

        Reservation r = new Reservation();
        r.setReserve_at(new Date(System.currentTimeMillis()));

        request.setAttribute("_token",request.getSession().getId());
        request.setAttribute("reservation", r);
        request.getSession().setAttribute("customer", c);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/reservation/new.jsp");
        rd.forward(request, response);
    }

}
