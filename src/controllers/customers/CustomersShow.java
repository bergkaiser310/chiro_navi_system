package controllers.customers;

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

import models.Customer;
import models.PurchaseHistory;
import models.Reservation;
import utils.DBUtil;

/**
 * Servlet implementation class CustomersShow
 */
@WebServlet("/customers/show")
public class CustomersShow extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomersShow() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        EntityManager em = DBUtil.createEntityManager();

        Customer c  = em.find(Customer.class, Integer.parseInt(request.getParameter("id")));

        Date today = new Date();

        List<Reservation> myReservation = em.createNamedQuery("getMyReservation", Reservation.class)
                                        .setParameter("customer",c)
                                        .setParameter("today", today)
                                        .getResultList();

        List<PurchaseHistory> myHistory = em.createNamedQuery("getMyPurchaseHistory", PurchaseHistory.class)
                .setParameter("customer",c)
                .getResultList();

        em.close();


        request.setAttribute("customer", c);
        request.setAttribute("myReservation", myReservation);
        request.setAttribute("myHistory", myHistory);

        if(request.getSession().getAttribute("flush") != null) {
            request.setAttribute("flush", request.getSession().getAttribute("flush"));
            request.getSession().removeAttribute("flush");
        }

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/customers/show.jsp");
        rd.forward(request, response);
    }



    }
