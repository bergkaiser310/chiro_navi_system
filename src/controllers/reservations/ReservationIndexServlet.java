package controllers.reservations;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Reservation;
import utils.DBUtil;

/**
 * Servlet implementation class ReservationIndexServlet
 */
@WebServlet("/reservation/index")
public class ReservationIndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        EntityManager em = DBUtil.createEntityManager();

        int page = 1 ;
        try{
            page = Integer.parseInt(request.getParameter("page"));
        }catch(NumberFormatException e){}

        Date date = new Date();
        List<Reservation> reservation = em.createNamedQuery("getAllReservations", Reservation.class)
                                        .setFirstResult((page-1)*15)
                                        .setMaxResults(15)
                                        .setParameter("today",date)
                                        .getResultList();

        Long r_count = em.createNamedQuery("getReservationsCount" , Long.class)
                        .setParameter("today",date)
                        .getSingleResult();
        em.close();

        request.setAttribute("page" , page);
        request.setAttribute("reservations", reservation);
        request.setAttribute("r_count", r_count);

        if(request.getSession().getAttribute("flush") != null) {
            request.setAttribute("flush", request.getSession().getAttribute("flush"));
            request.getSession().removeAttribute("flush");
        }

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/reservation/index.jsp");
        rd.forward(request,response);
    }
}

