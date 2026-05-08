package com.example.app.repository;

import com.example.app.entity.Pirata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


public interface PirataRepository extends JpaRepository<Pirata, UUID>{
}
