package com.example.app.controller;

import com.example.app.dto.PirataDto;
import com.example.app.entity.Pirata;
import com.example.app.service.PirataService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;


import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/pirata")
@AllArgsConstructor
public class PirataController {
    private PirataService service;

    @PostMapping("/create")
    public ResponseEntity<Pirata> createProduct(@RequestBody PirataDto data){

        var response = service.create(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Pirata>> getAllProducts() {
        var list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Pirata> getProduct(@PathVariable UUID id){
        var data = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> removeProduct(@PathVariable UUID id){
        service.deletedById(id);
        return ResponseEntity.status(HttpStatus.OK).body("pirata deleted successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Pirata> updateProduct(@PathVariable UUID id, @RequestBody PirataDto data){
        var update = service.update(id, data);
        return ResponseEntity.status(HttpStatus.OK).body(update);
    }
}
