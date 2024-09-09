package com.laptop.dto;

import com.laptop.entity.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDTO {
    private Integer id;
    private String categoryName;

    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.categoryName = category.getName();
    }
}
