package com.raysi.springboot3.controller;

import com.raysi.springboot3.entity.Position;
import com.raysi.springboot3.exceptions.PositionNotFoundException;
import com.raysi.springboot3.service.EmployeeService;
import com.raysi.springboot3.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PositionController {

    private final PositionService positionService;

    @Autowired
    public PositionController(PositionService positionService){
        this.positionService = positionService;
    }

    @GetMapping("/api/post")
    public List<Position>  fetchPosts(){
        return positionService.fetchPosts();
    }

    @GetMapping("/api/post/{id}")
    public Position fetchPostById(@PathVariable Long id) throws PositionNotFoundException {
        return  positionService.fetchPostById(id);
    }

    @PostMapping("/api/posts")
    public String savePosts(@RequestBody List<Position> positions){
        positionService.savePosts(positions);
        return positions.toString();
    }

    @PostMapping("/api/post")
    public String savePost(@RequestBody Position position){
        positionService.savePost(position);
        return position.toString();
    }
}
