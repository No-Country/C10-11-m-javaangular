package com.app.restoland.serviceImpl;

import com.app.restoland.JWT.JwtFilter;
import com.app.restoland.POJO.Category;
import com.app.restoland.POJO.Dish;
import com.app.restoland.constants.RestoConstants;
import com.app.restoland.dao.DishDAO;
import com.app.restoland.service.IDishService;
import com.app.restoland.utils.RestoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DishServiceImpl implements IDishService {

    @Autowired
    DishDAO dishDAO;

    @Autowired
    JwtFilter jwtFilter;

    @Override
    public ResponseEntity<String> addNewDish(Map<String, String> requestMap) {
        try {
            if(jwtFilter.isAdmin()){
                if(validateDishMap(requestMap, false)){
                    dishDAO.save(getDishFromMap(requestMap, false));
                }
                return RestoUtils.getResponseEntity(RestoConstants.INVALID_DATA, HttpStatus.BAD_REQUEST);
            }else {
                return RestoUtils.getResponseEntity(RestoConstants.UNAUTHORIZED_ACCESS, HttpStatus.UNAUTHORIZED);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return RestoUtils.getResponseEntity(RestoConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private boolean validateDishMap(Map<String, String> requestMap, boolean validateId) {
        if(requestMap.containsKey("name")){
            if(requestMap.containsKey("id") && validateId){
                return true;
            }else if(!validateId){
                return true;
            }
        }
        return false;
    }

    private Dish getDishFromMap(Map<String, String> requestMap, boolean isAdd) {
        Category category = new Category();
        category.setId(Long.valueOf(requestMap.get("id")));

        Dish dish = new Dish();
        if(isAdd){
            dish.setId(Long.valueOf(requestMap.get("id")));
        }else {
            dish.setStatus("true");
        }
        dish.setCategory(category);
        dish.setName(requestMap.get("name"));
        dish.setDescription(requestMap.get("description"));
        dish.setPrice(Double.valueOf(requestMap.get("price")));
        dish.setQualification(Integer.valueOf(requestMap.get("qualification")));
        dish.setHealtScore(Integer.valueOf(requestMap.get("healtScore")));
        dish.setPreparationTime(requestMap.get("preparationTime"));

        return dish;

    }
}
