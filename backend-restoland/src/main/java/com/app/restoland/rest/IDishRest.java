package com.app.restoland.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RequestMapping(path = "/dish")
public interface IDishRest {

    @PostMapping(path = "/add")
    ResponseEntity<String> addNewDish(@RequestBody Map<String, String> requestMap);
}