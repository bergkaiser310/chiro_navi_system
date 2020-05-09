package controllers.products;

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

import models.Product;
import models.validators.ProductValidator;
import utils.DBUtil;

/**
 * Servlet implementation class ProductsUpdate
 */
@WebServlet("/products/update")
public class ProductsUpdate extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductsUpdate() {
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

            Product p = em.find(Product.class, (Integer)request.getSession().getAttribute("product_id"));

            p.setName(request.getParameter("name"));
            p.setModelCode(request.getParameter("modelCode"));
            p.setCategory(request.getParameter("category"));

            String stock = request.getParameter("stock");
            if(stock != null && stock.equals("")){
            p.setStock(Integer.parseInt(stock));
            }else{
            p.setStock(null);
            }

            p.setContent(request.getParameter("content"));
            p.setUpdated_at(new Timestamp(System.currentTimeMillis()));



        ProductValidator productValidator = new ProductValidator(this.getServletContext());
        List<String> errors = productValidator.validate(p);

        if(errors.size()>0){

            em.close();

            request.setAttribute("_token",request.getSession().getId());
            request.setAttribute("product", p );
            request.setAttribute("errors", errors);

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/products/edit.jsp");
            rd.forward(request, response);

        }else{

            em.getTransaction().begin();
            em.getTransaction().commit();
            em.close();

            request.getSession().setAttribute("flush", "登録が完了しました。");
            response.sendRedirect(request.getContextPath() + "/products/index");
        }
    }

}
}