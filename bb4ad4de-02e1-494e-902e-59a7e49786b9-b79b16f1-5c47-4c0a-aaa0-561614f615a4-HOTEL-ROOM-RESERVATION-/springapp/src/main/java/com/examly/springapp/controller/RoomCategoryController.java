package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.RoomCategory;
import com.examly.springapp.service.RoomCategoryService;

@RestController
@RequestMapping("/api/room-categories")
public class RoomCategoryController {

    @Autowired
    private RoomCategoryService service;
    @PostMapping
    public ResponseEntity<RoomCategory> addCategory(
            @RequestBody(required = false) RoomCategory category) {

        if (category == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        RoomCategory saved = service.addCategory(category);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RoomCategory>> getAllCategories() {

        List<RoomCategory> list = service.getAllCategories();

        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCategoryById(@PathVariable Integer id) {

        RoomCategory category = service.getCategoryById(id);

        if (category == null) {
            return new ResponseEntity<>("Room category not found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoomCategory> updateCategory(
            @PathVariable Integer id,
            @RequestBody RoomCategory category) {

        RoomCategory updated = service.updateCategory(id, category);

        if (updated == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
    @GetMapping("/page/{page}/{size}")
    public ResponseEntity<Page<RoomCategory>> getCategoriesWithPagination(
            @PathVariable int page,
            @PathVariable int size) {

        Page<RoomCategory> result =
                service.getCategoriesWithPagination(page, size);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Integer id) {
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

}
