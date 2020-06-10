package models.validators;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import models.Product;

public class ProductValidator{

    private ServletContext context;

   public ProductValidator(ServletContext context) {
        super();
        this.context = context;
    }

public List<String> validate(Product p){
    List<String> errors = new ArrayList<String>();

    if(isEmpty(p.getName())){
        errors.add((String)context.getAttribute("Error0010"));
    }

    if(isEmpty(p.getCategory())){
        errors.add((String)context.getAttribute("Error0011"));
    }

return errors;

   }


     public boolean isEmpty(String product_item){
         if(product_item == null || product_item.equals("")){
             return true;
         }
         return false;
     }
}
