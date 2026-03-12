package com.lostandfound.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lostandfound.entity.LostEntity;
import com.lostandfound.repository.LostRepo;

@Service
public class LostService {

    @Autowired
    private LostRepo lostRepo;

    public LostEntity saveLostItem(LostEntity lostItem) {
        return lostRepo.save(lostItem);
    }

    public List<LostEntity> getAllLostItems() {
        return lostRepo.findAll();
    }

    public void deleteLostItem(Long id) {
        lostRepo.deleteById(id);
    }

    public LostEntity updateLostItem(Long id, LostEntity lostItem) {

        LostEntity existingItem = lostRepo.findById(id).orElseThrow();

        existingItem.setItemName(lostItem.getItemName());
        existingItem.setDescription(lostItem.getDescription());
        existingItem.setLocation(lostItem.getLocation());
        existingItem.setContactNumber(lostItem.getContactNumber());

        return lostRepo.save(existingItem);
    }
}