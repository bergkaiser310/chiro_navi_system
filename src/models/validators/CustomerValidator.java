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


            String name_error = _validateName(c.getName());
            if(!name_error.equals("")){
                errors.add(name_error);
             }

            String adress_error = _validateAdress(c.getAdress());
            if(!adress_error.equals("")){
                errors.add(adress_error);
             }

            String tel_error = _validateTel(c.getTel());
            if(!tel_error.equals("")){
                errors.add(tel_error);
             }

            String birthYear_error = _validateBirthYear(c.getBirthYear());
            if(!birthYear_error.equals("")){
                errors.add(birthYear_error);
             }

            String birthMonth_error = _validateBirthMonth(c.getBirthMonth());
            if(!birthMonth_error.equals("")){
                errors.add(adress_error);
             }

            String birthDay_error = _validateBirthDay(c.getBirthDay());
            if(!birthDay_error.equals("")){
                errors.add(birthDay_error);
             }

            String family_error = _validateFamily(c.getFamily());
            if(!family_error.equals("")){
                errors.add(family_error);
             }

            String illness_error = _validateIllness(c.getIllness());
            if(!illness_error.equals("")){
                errors.add(illness_error);
             }

            String purpose_error = _validatePurpose(c.getPurpose());
            if(!purpose_error.equals("")){
                errors.add(purpose_error);
             }

            return errors;
       }

        private String _validateName(String name){
            if(isEmpty(name)){
               return  (String)context.getAttribute("Error0002");
            }
            return "";
        }

        private String _validateAdress(String adress){
            if(isEmpty(adress)){
              return  (String)context.getAttribute("Error0003");
            }
            return "";
        }

        private String _validateTel(String tel){
            if(isEmpty(tel)){
              return  (String)context.getAttribute("Error0004");
            }
            return "";
        }

        private String _validateBirthYear(String birthYear){
            if(isEmpty(birthYear)){
              return  (String)context.getAttribute("Error0005");
            }
            return "";
        }

        private String _validateBirthMonth(String birthMonth){
            if(isEmpty(birthMonth)){
              return  (String)context.getAttribute("Error0005");
            }
            return "";
        }

        private String _validateBirthDay(String birthDay){
            if(isEmpty(birthDay)){
              return  (String)context.getAttribute("Error0005");
            }
            return "";
        }

        private String _validateFamily(String family){
            if(isEmpty(family)){
              return  (String)context.getAttribute("Error0006");
            }
            return "";
        }

        private String _validateIllness(String illness){
            if(isEmpty(illness)){
              return  (String)context.getAttribute("Error0007");
            }
            return "";
        }

        private  String _validatePurpose(String purpose){
            if(isEmpty(purpose)){
              return  (String)context.getAttribute("Error0008");
            }


            return "";
        }

        public  boolean isEmpty(String str) {
            if(str == null || str.equals("")) {
                return true;
            }
            return false;
        }
}