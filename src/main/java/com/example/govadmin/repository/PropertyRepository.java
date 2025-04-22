package com.example.govadmin.repository;

import com.example.govadmin.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Integer> {}