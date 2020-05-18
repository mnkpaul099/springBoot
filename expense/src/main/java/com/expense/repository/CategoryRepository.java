package com.expense.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expense.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	Category findByName(String name);
}
