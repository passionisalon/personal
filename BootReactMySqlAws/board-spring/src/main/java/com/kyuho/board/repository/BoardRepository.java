package com.kyuho.board.repository;



import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kyuho.board.entity.BoardEntity;



@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {

	public abstract List<BoardEntity> findTop3ByBoardWriteDateAfterOrderByBoardLikesCountDesc(Date boardWriteDate);
	
	public abstract List<BoardEntity> findByOrderByBoardWriteDateDesc();
	
	public abstract List<BoardEntity> findByBoardTitleContains(String boardTitle);
}	// end interface
