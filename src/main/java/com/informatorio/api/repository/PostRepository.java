package com.informatorio.api.repository;

import com.informatorio.api.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM post ps WHERE ps.author_id_user=?1")
    ArrayList<Post> findByPost(Long idUser);
    @Query(nativeQuery = true, value = "SELECT * FROM post ps WHERE ps.title LIKE %?1%")
    ArrayList<Post> findByTitleLike(String palabra);
    @Query(nativeQuery = true, value = "SELECT * FROM post ps WHERE ps.published=false")
    ArrayList<Post> findByPostUnpublished();
}
