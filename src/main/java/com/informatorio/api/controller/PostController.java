package com.informatorio.api.controller;

import com.informatorio.api.model.Post;
import com.informatorio.api.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping
    public ArrayList<Post> getPost(){
        return (ArrayList<Post>) postService.getAllPosts();
    }
    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody Post post){
        return new ResponseEntity<>(postService.savePost(post), HttpStatus.CREATED);
    }

}
