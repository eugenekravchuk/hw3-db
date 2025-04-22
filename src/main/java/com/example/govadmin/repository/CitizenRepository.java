package com.example.govadmin.repository;

import com.example.govadmin.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitizenRepository extends JpaRepository<Citizen, Integer> {}