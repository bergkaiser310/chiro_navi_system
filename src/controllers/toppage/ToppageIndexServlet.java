package controllers.toppage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
 * Servlet implementation class ToppageIndexServlet
 */
@WebServlet("/index.html")
public class ToppageIndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToppageIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
       EntityManager em = DBUtil.createEntityManager();


        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        cal.add(Calendar.DATE,1);
        Date d1 = cal.getTime();


        List<Reservation> latestReserves = em.createNamedQuery("getLatestReservation",Reservation.class)
                                    .setParameter("fromDate", new Date())
                                    .setParameter("toDate",d1)
                                    .getResultList();

        SimpleDateFormat d2 =new SimpleDateFormat("MM");
        String thisMonth = d2.format(date);

        List<Customer> latestCustomers = em.createNamedQuery("getThisBirth", Customer.class)
                                    .setParameter("thisMonth", thisMonth)
                                    .getResultList();

        em.close();

        request.setAttribute("latestReservations", latestReserves);
        request.setAttribute("latestCustomers", latestCustomers);
        request.setAttribute("today",date);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/toppage/index.jsp");
        rd.forward(request, response);
    }

}
