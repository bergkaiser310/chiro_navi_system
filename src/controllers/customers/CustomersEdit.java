package controllers.customers;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Customer;
import utils.DBUtil;

/**
 * Servlet implementation class CustomersEdit
 */
@WebServlet("/customers/edit")
public class CustomersEdit extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomersEdit() {
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

        request.setAttribute("_token", request.getSession().getId());
        request.setAttribute("customer", c);
        request.getSession().setAttribute("customer_id", c.getId());

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/customers/edit.jsp");
        rd.forward(request, response);



    }

}
