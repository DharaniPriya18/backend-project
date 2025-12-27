package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.RoomCategory;
import com.examly.springapp.repository.RoomCategoryRepo;

@Service
public class RoomCategoryServiceImpl implements RoomCategoryService {

    @Autowired
    private RoomCategoryRepo repo;

    @Override
    public RoomCategory addCategory(RoomCategory category) {
        return repo.save(category);
    }

    @Override
    public List<RoomCategory> getAllCategories() {
        return repo.findAll();
    }

    @Override
    public RoomCategory getCategoryById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public RoomCategory updateCategory(Integer id, RoomCategory category) {
        RoomCategory existing = repo.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setCategoryName(category.getCategoryName());
        return repo.save(existing);
    }

    @Override
    public Page<RoomCategory> getCategoriesWithPagination(int page, int size) {
        return repo.findAll(PageRequest.of(page, size));
    }
}
