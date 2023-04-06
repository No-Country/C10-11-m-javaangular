package com.app.restoland.serviceImpl;

import com.app.restoland.JWT.JwtFilter;
import com.app.restoland.POJO.Category;
import com.app.restoland.constants.RestoConstants;
import com.app.restoland.dao.CategoryDAO;
import com.app.restoland.service.ICategoryService;
import com.app.restoland.utils.RestoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    CategoryDAO categoryDAO;

    @Autowired
    JwtFilter jwtFilter;

    @Override
    public ResponseEntity<String> addNewCategory(Map<String, String> requestMap) {
        try {
            if(jwtFilter.isAdmin()){
                if(validateCategoryMap(requestMap, false)){
                    categoryDAO.save(getCategoryFromMap(requestMap, false));
                }
            }else {
                return RestoUtils.getResponseEntity(RestoConstants.SOMETHING_WENT_WRONG, HttpStatus.UNAUTHORIZED);
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return RestoUtils.getResponseEntity(RestoConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private boolean validateCategoryMap(Map<String, String> requestMap, boolean validateId) {
        if(requestMap.containsKey("name")){
            if(requestMap.containsKey("id") && validateId){
                return true;
            }else if(!validateId) {
                return true;
            }
        }
        return false;
    }

    public Category getCategoryFromMap(Map<String, String> requestMap, boolean isAdd){
        Category category = new Category();
        if(isAdd){
            category.setId(Long.valueOf(requestMap.get("id")));
        }
        category.setName(requestMap.get("name"));
        return category;
    }
}
