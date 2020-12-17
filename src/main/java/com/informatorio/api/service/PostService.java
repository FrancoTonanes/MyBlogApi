package com.informatorio.api.service;

import com.informatorio.api.model.Post;
import com.informatorio.api.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public ArrayList<Post> getAllPosts(){
        return (ArrayList<Post>) postRepository.findAll();
    }
    public Post savePost(Post post){
        Date fecha = new Date();
        post.setDateCreated(fecha);
        return postRepository.save(post);
    }
}
