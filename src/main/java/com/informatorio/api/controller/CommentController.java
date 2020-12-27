package com.informatorio.api.controller;

import com.informatorio.api.model.Comment;
import com.informatorio.api.repository.CommentRepository;
import com.informatorio.api.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/comment")
public class CommentController {


    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private CommentService commentService;

    @GetMapping
    public ArrayList<Comment> allComments (){
        return (ArrayList<Comment>) commentRepository.findAll();
    }

    @PostMapping("/{idPost}/user={idUser}")
    public ResponseEntity<?> saveComment(@PathVariable Long idPost,@PathVariable Long idUser, @RequestBody Comment comment){
        return new ResponseEntity<>(commentService.saveComment(idPost ,idUser, comment), HttpStatus.CREATED);
    }


    @PutMapping("/edit/{idComment}")
    public Comment editComment(@PathVariable Long idComment, @RequestBody Comment comment){
        return commentService.editComment(idComment, comment);
    }

    @DeleteMapping("/delete/{idComment}")
    public void deleteComment(@PathVariable Long idComment){
        commentService.deleteComment(idComment);
    }



}
