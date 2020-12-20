package com.informatorio.api.service;

import com.informatorio.api.model.Comment;
import com.informatorio.api.model.Post;
import com.informatorio.api.model.User;
import com.informatorio.api.repository.CommentRepository;
import com.informatorio.api.repository.PostRepository;
import com.informatorio.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    public Comment saveComment(Long idPost, Long idUser, Comment comment){
        User user = userRepository.findById(idUser).get();
        comment.setAutor(user);
        Date fecha = new Date();
        comment.setCreationDate(fecha);
        Post post = postRepository.findById(idPost).get();
        comment.setPost(post);
        return commentRepository.save(comment);

    }


    public Comment editComment(Long idComment, Comment comment){
        Comment comentario = commentRepository.getOne(idComment);
        comentario.setComment(comment.getComment());
        return commentRepository.save(comentario);
    }

}
