package com.app.restoland.restImpl;

import com.app.restoland.constants.RestoConstants;
import com.app.restoland.rest.IDishRest;
import com.app.restoland.service.IDishService;
import com.app.restoland.utils.RestoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DishRestImpl implements IDishRest {

    @Autowired
    IDishService dishService;

    @Override
    public ResponseEntity<String> addNewDish(Map<String, String> requestMap) {
        try {
            return dishService.addNewDish(requestMap);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return RestoUtils.getResponseEntity(RestoConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
