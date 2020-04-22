package models.validators;

import java.util.ArrayList;
import java.util.List;

import models.Product;

public class ProductValidator {


   public static List<String> validate(Product p){
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

    private static String _validateName(String name){
        if(name == null || name.equals("")){
            return "商品名を入力してください。";
        }
        return "" ;
    }

     private static String _validateCategory(String category){
         if(category == null || category.equals("")){
             return "カテゴリーを選択してください";
         }
         return "";
     }
}