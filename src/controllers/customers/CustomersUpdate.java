package controllers.customers;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Customer;
import models.validators.CustomerValidator;
import utils.DBUtil;

/**
 * Servlet implementation class CustomersUpdate
 */
@WebServlet("/customers/update")
public class CustomersUpdate extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomersUpdate() {
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

            Customer customer = em.find(Customer.class, (Integer)(request.getSession().getAttribute("customer_id")));

            customer.setName(request.getParameter("name"));
            customer.setPostalCode(request.getParameter("postalCode"));
            customer.setAdress(request.getParameter("adress"));
            customer.setTel(request.getParameter("tel"));
            customer.setMail(request.getParameter("mail"));
            customer.setBirthYear(request.getParameter("birthYear"));

            String month = String.format("%2s" , request.getParameter("birthMonth")).replace(" ", "0");
            customer.setBirthMonth(month);

            String day = String.format("%2s" , request.getParameter("birthDay")).replace(" ", "0");
            customer.setBirthDay(day);

            customer.setFamily(request.getParameter("family"));
            customer.setIllness(request.getParameter("illness"));
            customer.setPurpose(request.getParameter("purpose"));
            customer.setIntroduce(request.getParameter("introduce"));
            customer.setContent(request.getParameter("content"));
            customer.setUpdated_at(new Timestamp(System.currentTimeMillis()));

            CustomerValidator customerValidator = new CustomerValidator(this.getServletContext());
            List<String> errors = customerValidator.validate(customer);
            if(errors.size() > 0){
                em.close();

                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("customer",customer);
                request.setAttribute("errors",errors);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/customers/edit.jsp");
                rd.forward(request, response);

            }else{

                em.getTransaction().begin();
                em.getTransaction().commit();
                em.close();
                request.getSession().setAttribute("flush", "更新が完了しました。");
                response.sendRedirect(request.getContextPath() + "/customers/index");
            }
    }
   }
}