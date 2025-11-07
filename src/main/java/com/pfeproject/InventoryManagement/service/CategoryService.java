package com.pfeproject.InventoryManagement.service;

import com.pfeproject.InventoryManagement.dto.CategoryDTO;
import com.pfeproject.InventoryManagement.dto.Response;

public interface CategoryService {
    Response createCategory(CategoryDTO categoryDTO);
    Response getAllCategories();
    Response getCategoryById(Long id);
    Response updateCategory(Long id, CategoryDTO categoryDTO);
    Response deleteCategory(Long id);
}
