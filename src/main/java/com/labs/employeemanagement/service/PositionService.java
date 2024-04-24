package com.labs.employeemanagement.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.labs.employeemanagement.model.Position;
import com.labs.employeemanagement.repository.PositionRepository;
import com.labs.employeemanagement.service.dto.PositionDTO;

import jakarta.transaction.Transactional;

@Service
public class PositionService {
    @Autowired
    private PositionRepository positionRepository;

    @Transactional
    public Position createPosition(Position payload) {
        Position position = new Position();
        position.setPositionName(payload.getPositionName());
        return positionRepository.save(position);
    }

    public List<Position> findAllPositions() {
        return positionRepository.findAll();
    }

    public Position findPositionById(Long id) {
        return positionRepository.findById(id).orElseThrow(() -> new RuntimeException("Position not found"));
    }

    @Transactional
    public void updatePosition(Position payload, Long id) {
        Position position = positionRepository.findById(id)
                                        .orElseThrow(() -> new ResourceNotFoundException("Position not found with id : " + id));
        position.setPositionName(payload.getPositionName());
        positionRepository.save(position);
    }

    @Transactional
    public void removePosition(Long id) {
        positionRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Position not found with id : " + id));
        positionRepository.deleteById(id);
    }
}
