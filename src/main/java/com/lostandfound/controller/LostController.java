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

import com.lostandfound.entity.LostEntity;
import com.lostandfound.service.LostService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/lost")
public class LostController {

    @Autowired
    private LostService lostService;

    @PostMapping
    public LostEntity addLostItem(@RequestBody LostEntity lostItem) {
        return lostService.saveLostItem(lostItem);
    }

    @GetMapping
    public List<LostEntity> getAllLostItems() {
        return lostService.getAllLostItems();
    }

    @DeleteMapping("/{id}")
    public String deleteLostItem(@PathVariable Long id) {
        lostService.deleteLostItem(id);
        return "Lost item deleted successfully";
    }

    @PutMapping("/{id}")
    public LostEntity updateLostItem(@PathVariable Long id, @RequestBody LostEntity lostItem) {
        return lostService.updateLostItem(id, lostItem);
    }
}