package com.example.app.service.impl;

import com.example.app.dto.PirataDto;
import com.example.app.entity.Pirata;
import com.example.app.repository.PirataRepository;
import com.example.app.service.PirataService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service

public class PirataServiceImpl implements PirataService {

    private PirataRepository pirataRepository;

    public PirataServiceImpl(PirataRepository pirataRepository){
        this.pirataRepository = pirataRepository;
    }


    @Override
    public List<Pirata> findAll() {
        return List.of();
    }

    @Override
    public Pirata findById(UUID id) {
        return pirataRepository.findById(id).orElse(null);
    }

    @Override
    public void deletedById(UUID id) {
        pirataRepository.deleteById(id);

    }

    @Override
    public Pirata create(PirataDto data) {
        Pirata pirata = new Pirata();

        pirata.setName(data.getName());
        pirata.setCrew(data.getCrew());
        pirata.setBounty(data.getBounty());
        pirata.setIsActive(data.getIsActive());

        return pirataRepository.save(pirata);
    }

    @Override
    public Pirata update(UUID id, PirataDto data) {
        var pirata = pirataRepository.findById(id).orElse(null);

        if (pirata == null) return null;

        pirata.setName(data.getName());
        pirata.setCrew(data.getCrew());
        pirata.setBounty(data.getBounty());
        pirata.setIsActive(data.getIsActive());

        return pirataRepository.save(pirata);
    }
}
