package com.raysi.springboot3.service;

import com.raysi.springboot3.entity.Position;
import com.raysi.springboot3.exceptions.PositionNotFoundException;
import com.raysi.springboot3.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PositionServiceImplementation implements PositionService{

    private final PositionRepository positionRepository;

    @Autowired
    public PositionServiceImplementation(PositionRepository positionRepository){
        this.positionRepository = positionRepository;
    }

    @Override
    public List<Position> fetchPosts() {
        return positionRepository.findAll();
    }

    @Override
    public Position fetchPostById(Long id) throws PositionNotFoundException {
        Optional<Position> position = positionRepository.findById(id);
        if(position.isEmpty()){
            throw new PositionNotFoundException("Bhai position nahi mila matlab db me nahi hai ye position");
        }
        return position.get();
    }

    @Override
    public void savePost(Position position) {
        positionRepository.save(position);
    }

    @Override
    public void savePosts(List<Position> positions) {
        positionRepository.saveAll(positions);
    }
}
