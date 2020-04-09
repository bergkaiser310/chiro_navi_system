package models.validators;

import java.util.ArrayList;
import java.util.List;

import models.Product;

public class ProductValidator {


   public List<String> validate(Product p){
    List<String> errors = new ArrayList<String>();

    String modelCode_error = _validateModelCode(p.getModelCode());
    if(!modelCode_error.equals("")){
        errors.add(modelCode_error);
    }

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

   private String _validateModelCode(String modelCode){
       if(modelCode == null || modelCode.equals("")){
           return "型番を入力してください。";
       }
       return "";
   }

    private String _validateName(String name){
        if(name == null || name.equals("")){
            return "商品名を入力してください。";
        }
        return "" ;
    }

     private String _validateCategory(String category){
         if(category == null || category.equals("")){
             return "カテゴリーを選択してください";
         }
         return "" ;
     }

}
