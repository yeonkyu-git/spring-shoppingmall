package com.yeonkyu.base.service;

import com.yeonkyu.base.domain.Category;
import com.yeonkyu.base.repository.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Transactional
    public void saveCategory(Category category) {
        Optional<Category> findCategory = categoryRepository.findByCategoryName(category.getCategoryName());

        if (findCategory.isPresent()) {
            throw new RuntimeException("이미 있는 카테고리 이름입니다.");
        }
        categoryRepository.saveCategory(category);
    }

    public Category findById(Long categoryId) {
        Optional<Category> findCategory = categoryRepository.findById(categoryId);

        if (findCategory.isEmpty()) {
            throw new RuntimeException("찾으려는 카테고리가 없습니다.");
        }

        return findCategory.get();
    }

    public List<Category> findCategories() {
        return categoryRepository.findCategories();
    }

    @Transactional
    public void updateCategory(Long categoryId, String categoryName) {
        categoryRepository.updateCategory(categoryId, categoryName);
    }
}
