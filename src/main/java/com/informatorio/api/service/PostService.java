package com.informatorio.api.service;

import com.informatorio.api.model.Post;
import com.informatorio.api.model.User;
import com.informatorio.api.repository.PostRepository;
import com.informatorio.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

    public ArrayList<Post> getAllPosts(){
        return (ArrayList<Post>) postRepository.findAll();
    }

    public Post savePost(Long idUser, Post post){
        User user = userRepository.getOne(idUser);
        Date fecha = new Date();
        post.setDateCreated(fecha);
        post.setAuthor(user);
        return postRepository.save(post);
    }
}
