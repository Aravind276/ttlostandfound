package com.lostandfound.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lostandfound.entity.FoundEntity;
import com.lostandfound.repository.FoundRepo;

@Service
public class FoundService {

    @Autowired
    private FoundRepo foundRepo;

    public FoundEntity saveFoundItem(FoundEntity foundItem) {
        return foundRepo.save(foundItem);
    }

    public List<FoundEntity> getAllFoundItems() {
        return foundRepo.findAll();
    }

    public void deleteFoundItem(Long id) {
        foundRepo.deleteById(id);
    }

    public FoundEntity updateFoundItem(Long id, FoundEntity foundItem) {

        FoundEntity existingItem = foundRepo.findById(id).orElseThrow();

        existingItem.setItemName(foundItem.getItemName());
        existingItem.setDescription(foundItem.getDescription());
        existingItem.setLocation(foundItem.getLocation());
        existingItem.setContactNumber(foundItem.getContactNumber());

        return foundRepo.save(existingItem);
    }
}