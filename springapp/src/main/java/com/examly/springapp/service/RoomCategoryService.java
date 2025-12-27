package com.examly.springapp.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.examly.springapp.model.RoomCategory;

public interface RoomCategoryService {

    RoomCategory addCategory(RoomCategory category);

    List<RoomCategory> getAllCategories();

    RoomCategory getCategoryById(Integer id);

    RoomCategory updateCategory(Integer id, RoomCategory category);

    Page<RoomCategory> getCategoriesWithPagination(int page, int size);
}
