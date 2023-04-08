package com.app.restoland.dao;

import com.app.restoland.POJO.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishDAO extends JpaRepository<Dish, Long> {
}
