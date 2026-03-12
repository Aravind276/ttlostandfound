package com.lostandfound.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lostandfound.entity.FoundEntity;

public interface FoundRepo extends JpaRepository<FoundEntity, Long> {
}