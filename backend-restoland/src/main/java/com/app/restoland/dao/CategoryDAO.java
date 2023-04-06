package com.app.restoland.dao;

import com.app.restoland.POJO.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDAO extends JpaRepository<Category, Long> {
}
