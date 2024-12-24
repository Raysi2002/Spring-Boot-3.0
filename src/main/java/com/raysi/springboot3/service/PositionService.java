package com.raysi.springboot3.service;

import com.raysi.springboot3.entity.Position;
import com.raysi.springboot3.exceptions.PositionNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PositionService {
    List<Position> fetchPosts();
    Position fetchPostById(Long id) throws PositionNotFoundException;
    void savePost(Position position);
    void savePosts(List<Position> positions);
}
