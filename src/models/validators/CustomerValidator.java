package models.validators;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import models.Customer;


public class CustomerValidator{

    private ServletContext context;

    public CustomerValidator(ServletContext context) {
         super();
         this.context = context;
     }

        public List<String> validate(Customer c){
            List<String> errors = new ArrayList<String>();


            if(isEmpty(c.getName())){
                errors.add((String)context.getAttribute("Error0002"));
             }

            if(isEmpty(c.getAdress())){
                errors.add((String)context.getAttribute("Error0003"));
            }

            if(isEmpty(c.getTel())){
                errors.add((String)context.getAttribute("Error0004"));
            }

            if(isEmpty(c.getBirthYear())){
                errors.add((String)context.getAttribute("Error0005"));
            }

            if(isEmpty(c.getBirthMonth())){
                errors.add((String)context.getAttribute("Error0006"));
            }

            if(isEmpty(c.getBirthDay())){
                errors.add((String)context.getAttribute("Error0007"));
            }

            if(isEmpty(c.getFamily())){
                errors.add((String)context.getAttribute("Error0008"));
            }

            if(isEmpty(c.getIllness())){
                errors.add((String)context.getAttribute("Error0009"));
             }

            if(isEmpty(c.getPurpose())){
                errors.add((String)context.getAttribute("Error0010"));
             }

            return errors;
       }

               public  boolean isEmpty(String customer_item) {
            if(customer_item == null || customer_item.equals("")) {
                return true;
            }
            return false;
        }
}