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


    String name_error = _validateName(p.getName());
    if(!name_error.equals("")){
        errors.add(name_error);
    }

    String category_error = _validateCategory(p.getCategory());
    if(!category_error.equals("")){
        errors.add(category_error);

    }

return errors;

   }

    private String _validateName(String name){
        if(isEmpty(name)){
          return (String)context.getAttribute("Error0010");
        }
        return "" ;
    }

     private  String _validateCategory(String category){
         if(isEmpty(category)){
             return (String)context.getAttribute("Error0011");
         }
         return "";
     }


     public boolean isEmpty(String str){
         if(str == null || str.equals("")){
             return true;
         }
         return false;
     }
}
