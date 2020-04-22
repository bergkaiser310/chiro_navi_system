package models.validators;

import java.util.ArrayList;
import java.util.List;

import models.Customer;


public class CustomerValidator{


        public static List<String> validate(Customer c){
            List<String> errors = new ArrayList<String>();

            //String name_error = _validateName(c.getName());
            //if(!name_error.equals("")){
            //    errors.add(name_error);
            // }

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

        //private   String _validateName(String name){
            //if(isEmpty(name)){
                    //return  applicationScope.Error2;
            //}
            //return "";
        //}

        private  static String _validateAdress(String adress){
            if(adress == null || adress.equals("")){
              return  "住所を入力してください。";
            }
            return "";
        }

        private  static String _validateTel(String tel){
            if(tel == null || tel.equals("")){
              return  "電話番号を入力してください。";
            }
            return "";
        }

        private  static String _validateBirthYear(String birthYear){
            if(birthYear == null || birthYear.equals("")){
              return  "生年月日（年）を選択してください。";
            }
            return "";
        }

        private  static String _validateBirthMonth(String birthMonth){
            if(birthMonth == null || birthMonth.equals("")){
              return  "生年月日（月）を選択してください。";
            }
            return "";
        }

        private  static String _validateBirthDay(String birthDay){
            if(birthDay == null || birthDay.equals("")){
              return  "生年月日（日）を選択してください。";
            }
            return "";
        }

        private  static String _validateFamily(String family){
            if(family == null || family.equals("")){
              return  "家族構成を選択してください。";
            }
            return "";
        }

        private  static String _validateIllness(String illness){
            if(illness == null || illness.equals("")){
              return  "持病を入力してください。";
            }
            return "";
        }

        private   static String _validatePurpose(String purpose){
            if(purpose == null || purpose.equals("")){
              return  "受診の目的を入力してください。";
            }


            return "";
        }

        //public  boolean isEmpty(String str) {
          //  if(str == null || str.equals("")) {
            //    return true;
            //}
            //return false;
        //}
}