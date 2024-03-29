package com.informatorio.api.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.informatorio.api.model.Post;
import com.informatorio.api.model.User;
import com.informatorio.api.repository.PostRepository;
import com.informatorio.api.repository.UserRepository;
import com.informatorio.api.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @GetMapping
    public ArrayList<Post> getPost(){
        return (ArrayList<Post>) postService.getAllPosts();
    }
    @GetMapping("/user/{idUser}")
    public ArrayList<Post> getUserPost(@PathVariable Long idUser){
        return (ArrayList<Post>) postService.allPostsUser(idUser);
    }

    @GetMapping("/title={palabra}")
    public ArrayList<Post> getPostTitle(@PathVariable String palabra){
        return (ArrayList<Post>) postService.getPostTitle(palabra);
    }
    @GetMapping("/unpublished")
    public ArrayList<Post> getPostUnpublished(){
        return (ArrayList<Post>) postService.getPostUnpublished();
    }

    @PostMapping("/{idUser}")
    public ResponseEntity<?> createPost(@PathVariable Long idUser, @RequestBody Post post){

        return new ResponseEntity<>(postService.savePost(idUser, post), HttpStatus.CREATED);
    }

    @PutMapping("/edit/{idPost}")
    public ResponseEntity<?> editPost(@PathVariable Long idPost, @RequestBody Post post){
        return new ResponseEntity<>(postService.editPost(idPost, post), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idPost}")
    public ResponseEntity<?> deletePost(@PathVariable Long idPost){
        postService.deletePost(idPost);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
