package com.app.restoland.restImpl;

import com.app.restoland.constants.RestoConstants;
import com.app.restoland.rest.ICategoryRest;
import com.app.restoland.service.ICategoryService;
import com.app.restoland.utils.RestoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public class CategoryRestImpl implements ICategoryRest {

    @Autowired
    ICategoryService serviceCategory;

    @Override
    public ResponseEntity<String> addNewCategory(Map<String, String> requestMap) {
        try {

            return serviceCategory.addNewCategory(requestMap);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return RestoUtils.getResponseEntity(RestoConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
