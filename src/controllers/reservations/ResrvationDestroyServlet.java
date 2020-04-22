package controllers.reservations;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Reservation;
import utils.DBUtil;

/**
 * Servlet implementation class ResrvationDestroyServlet
 */
@WebServlet("/resrvation/destroy")
public class ResrvationDestroyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResrvationDestroyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EntityManager em = DBUtil.createEntityManager();

        Reservation r = em.find(Reservation.class,(Integer)(request.getSession().getAttribute("reservation_id")));


        em.getTransaction().begin();
        em.remove(r);
        em.getTransaction().commit();
        em.close();

        request.getSession().setAttribute("flush", "削除しました。");
        request.getSession().removeAttribute("reservation_id");
        response.sendRedirect(request.getContextPath() + "/reservation/index");
        }
    }