package com.informatorio.api.repository;

import com.informatorio.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Transactional(readOnly = true)
    ArrayList<User> findByCityName(String city);
    @Query(value = "SELECT * FROM user us WHERE us.fecha_alta>=?1", nativeQuery = true)
    ArrayList<User> findByAfterDate(String date);
}

