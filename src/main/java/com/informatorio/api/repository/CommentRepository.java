package com.informatorio.api.repository;

import com.informatorio.api.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(value = "SELECT * FROM comentario c WHERE c.autor_id_user=?1", nativeQuery = true)
    ArrayList<Comment> findByCommentUser(Long idUser);

    @Query(value = "SELECT * FROM comentario c WHERE c.post_id=?1", nativeQuery = true)
    ArrayList<Comment> findByCommentsPost(Long idUser);

    @Query(value = "SELECT * FROM comentario c WHERE c.post_id=?1 LIMIT ?2", nativeQuery = true)
    ArrayList<Comment> findByComments(Long idUser, Long limit);

}
