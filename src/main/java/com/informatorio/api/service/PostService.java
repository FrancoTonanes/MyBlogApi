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
    public ArrayList<Post> allPostsUser(Long idUser){
        return (ArrayList<Post>) postRepository.findByPost(idUser);
    }

    public Post savePost(Long idUser, Post post){
        User user = userRepository.findById(idUser).get();
        Date fecha = new Date();
        post.setDateCreated(fecha);
        post.setAuthor(user);
        user.cargarPost(post);
        return postRepository.save(post);
    }

    public Post editPost(Long idPost, Post post){
        Post postEdit = postRepository.getOne(idPost);
        postEdit.setTitle(post.getTitle());
        postEdit.setDescription(post.getDescription());
        postEdit.setContent(post.getContent());
        postEdit.setPublished(post.getPublished());

        return postRepository.save(postEdit);
    }

    public void deletePost(Long idPost){
        Post postDelete = postRepository.getOne(idPost);
        postRepository.delete(postDelete);
    }
}
