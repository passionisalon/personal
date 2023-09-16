package com.kyuho.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kyuho.board.entity.PopularSearchEntity;
@Repository
public interface PopularSearchRepository extends JpaRepository<PopularSearchEntity, String> {

}
