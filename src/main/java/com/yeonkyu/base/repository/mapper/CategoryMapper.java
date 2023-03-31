package com.yeonkyu.base.repository.mapper;

import com.yeonkyu.base.domain.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CategoryMapper {

    void saveCategory(@Param("category") Category category);

    Optional<Category> findById(@Param("categoryId") Long categoryId);

    Optional<Category> findByCategoryName(@Param("categoryName") String categoryName);

    List<Category> findAll();

    void updateCategory(@Param("categoryId") Long categoryId, @Param("categoryName") String categoryName);
}
