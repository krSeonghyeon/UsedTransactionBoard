package com.example.board.repository;

import com.example.board.domain.Board;
import com.example.board.domain.Hashtag;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {
    List<Board> findAllByOrderByBoardIdAsc();
    List<Board> findTop5ByOrderByCreatedAtDesc(Pageable pageable);
    List<Board> findTop5ByOrderByBoardViewsDesc(Pageable pageable);
    List<Board> findByBoardTitleContaining(String title);
    List<Board> findByUserUserId(int userId);
    List<Board> findByCategoryCategoryId(int categoryId);
    @Query("SELECT bh.hashtag FROM BoardHasHashtag bh WHERE bh.board.boardId = :boardId")
    List<Hashtag> findHashtagsByBoardId(int boardId);
}
