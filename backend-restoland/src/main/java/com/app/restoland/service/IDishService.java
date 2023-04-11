package com.app.restoland.service;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface IDishService {

    ResponseEntity<String> addNewDish(Map<String, String> requestMap);
}
