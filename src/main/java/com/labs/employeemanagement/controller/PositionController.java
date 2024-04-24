package com.labs.employeemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labs.employeemanagement.model.Position;
import com.labs.employeemanagement.service.PositionService;

@RestController
@RequestMapping("/api/v1/position")
public class PositionController {
    
    @Autowired
    private PositionService positionService;

    @PostMapping("/create")
    public ResponseEntity<?> createPosition(@RequestBody Position payload) {
        Position createdPosition = positionService.createPosition(payload);
        return ResponseEntity.ok("Position: " + createdPosition.getPositionName() + " has been created!");
    }

    @GetMapping()
    public List<Position> getAllPositions() {
        return positionService.findAllPositions();
    }

    @GetMapping("/search/{id}")
    public Position getPositionById(@PathVariable("id") Long id ) {
        return positionService.findPositionById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePositionName(@PathVariable("id") Long id, @RequestBody Position payload) {
        positionService.updatePosition(payload, id);
        return ResponseEntity.ok("Position has been updated!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> removePosition(@PathVariable("id") Long id) {
        positionService.removePosition(id);
        return ResponseEntity.ok("Position with id " + id + " has been deleted!");
    }
}
