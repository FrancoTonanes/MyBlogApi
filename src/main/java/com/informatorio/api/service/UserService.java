package com.informatorio.api.service;

import com.informatorio.api.model.Comment;
import com.informatorio.api.model.Post;
import com.informatorio.api.model.User;
import com.informatorio.api.repository.CommentRepository;
import com.informatorio.api.repository.PostRepository;
import com.informatorio.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private BCryptPasswordEncoder encoder;

    public ArrayList<User> getUsers(){
        return (ArrayList<User>) userRepository.findAll();
    }

    public ArrayList<User> getCity(){
        return (ArrayList<User>) userRepository.findByCityName("Resistencia");
    }

    public User saveUser(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        Date fecha = new Date();
        user.setFecha_alta(fecha);
        return userRepository.save(user);
    }

    public ArrayList<User> getUsDate(String fecha){
        return (ArrayList<User>) userRepository.findByAfterDate(fecha);
    }

    public User editUser(Long userId, User user){
        user.setPassword(encoder.encode(user.getPassword()));
        User userEdit = userRepository.getOne(userId);
        userEdit.setName(user.getName());
        userEdit.setLastName(user.getLastName());
        userEdit.setEmail(user.getEmail());
        userEdit.setPassword(user.getPassword());
        userEdit.setCityName(user.getCityName());
        userEdit.setStateName(user.getStateName());
        userEdit.setCountry(user.getCountry());

        return userRepository.save(userEdit);
    }

    public void delete(Long userId){
        ArrayList<Comment> comentarios = commentRepository.findByCommentUser(userId);
        commentRepository.deleteAll(comentarios);
        ArrayList<Post> post = postRepository.findByPost(userId);
        postRepository.deleteAll(post);
        User userDelete = userRepository.findById(userId).get();
        userRepository.delete(userDelete);
    }

}
