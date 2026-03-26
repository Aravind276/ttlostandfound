package com.lostandfound.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lostandfound.entity.FoundEntity;
import com.lostandfound.service.FoundService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/found")
public class FoundController {

    @Autowired
    private FoundService foundService;

    @PostMapping
    public FoundEntity addFoundItem(@RequestBody FoundEntity foundItem) {
        return foundService.saveFoundItem(foundItem);
    }

    @GetMapping
    public List<FoundEntity> getAllFoundItems() {
        return foundService.getAllFoundItems();
    }

    @DeleteMapping("/{id}")
    public String deleteFoundItem(@PathVariable Long id) {
        foundService.deleteFoundItem(id);
        return "Found item deleted successfully";
    }

    @PutMapping("/{id}")
    public FoundEntity updateFoundItem(@PathVariable Long id, @RequestBody FoundEntity foundItem) {
        return foundService.updateFoundItem(id, foundItem);
    }
}