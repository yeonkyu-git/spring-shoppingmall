package com.yeonkyu.base.repository.repository;

import com.yeonkyu.base.domain.Category;
import com.yeonkyu.base.repository.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CategoryRepository {

    private final CategoryMapper categoryMapper;


    public void saveCategory(Category category) {
        categoryMapper.saveCategory(category);
    }

    public Optional<Category> findById(Long categoryId) {
        return categoryMapper.findById(categoryId);
    }

    public Optional<Category> findByCategoryName(String categoryName) {
        return categoryMapper.findByCategoryName(categoryName);
    }

    public List<Category> findCategories() {
        return categoryMapper.findAll();
    }

    public void updateCategory(Long categoryId, String categoryName) {
        categoryMapper.updateCategory(categoryId, categoryName);
    }
}
