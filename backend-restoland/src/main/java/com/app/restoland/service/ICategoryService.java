package com.app.restoland.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface ICategoryService {

    ResponseEntity<String> addNewCategory(Map<String, String> requestMap);
}
