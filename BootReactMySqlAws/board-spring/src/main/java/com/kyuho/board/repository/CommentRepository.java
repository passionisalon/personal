package com.kyuho.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kyuho.board.entity.CommentEntity;
@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {

}	// end interface
