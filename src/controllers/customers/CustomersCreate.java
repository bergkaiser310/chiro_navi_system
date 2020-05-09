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
 * Servlet implementation class CustomersCreate
 */
@WebServlet("/customers/create")
public class CustomersCreate extends HttpServlet{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomersCreate() {
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

            Customer c = new Customer();

            c.setName(request.getParameter("name"));
            c.setPostalCode(request.getParameter("postalCode"));
            c.setAdress(request.getParameter("adress"));
            c.setTel(request.getParameter("tel"));
            c.setMail(request.getParameter("mail"));
            c.setBirthYear(request.getParameter("birthYear"));

            String month = String.format("%2s" , request.getParameter("birthMonth")).replace(" ", "0");
            c.setBirthMonth(month);

            String day = String.format("%2s" , request.getParameter("birthDay")).replace(" ", "0");
            c.setBirthDay(day);

            c.setFamily(request.getParameter("family"));
            c.setIllness(request.getParameter("illness"));
            c.setPurpose(request.getParameter("purpose"));
            c.setIntroduce(request.getParameter("introduce"));
            c.setContent(request.getParameter("content"));

            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
            c.setCreated_at(currentTime);
            c.setUpdated_at(currentTime);

            CustomerValidator customerValidator = new CustomerValidator(this.getServletContext());
            List<String> errors = customerValidator.validate(c);
            if(errors.size() > 0){
                em.close();

                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("customer",c);
                request.setAttribute("errors",errors);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/customers/new.jsp");
                rd.forward(request, response);

            }else{


                em.getTransaction().begin();
                em.persist(c);
                em.getTransaction().commit();
                em.close();
                request.getSession().setAttribute("flush", "登録が完了しました。");
                response.sendRedirect(request.getContextPath() + "/customers/index");
            }


    }
    }
}
