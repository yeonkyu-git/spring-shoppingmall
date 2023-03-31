package com.yeonkyu.base.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category {

    private Long categoryId;
    private String categoryName;

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    /* MyBatis useGeneratedKeys 사용으로 인한 categoryId Setter 등록 */
    public void setMemberId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
