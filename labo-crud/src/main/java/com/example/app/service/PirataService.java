package com.example.app.service;

import com.example.app.dto.PirataDto;
import com.example.app.entity.Pirata;

import java.util.List;
import java.util.UUID;

public interface PirataService {

    List<Pirata> findAll();

    Pirata findById(UUID id);

    void deletedById(UUID id);

    Pirata create(PirataDto data);

    Pirata update(UUID id, PirataDto data);
}
