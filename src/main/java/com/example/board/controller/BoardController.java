package com.example.board.controller;

import com.example.board.domain.Board;
import com.example.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/boards")
public class BoardController {
    private final BoardService boardService;
    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }
    @PostMapping
    public Board insertBoard(@RequestBody Board board) throws SQLException {
        return boardService.insertBoard(board);
    }
    @GetMapping
    public List<Board> getAllBoards() throws SQLException {
        return boardService.getAllBoards();
    }
    @GetMapping("/{boardId}")
    public Board getBoardByBoardId(@PathVariable Integer boardId) throws SQLException {
        return boardService.getBoardByBoardId(boardId);
    }
    @GetMapping("/latest")
    public List<Board> getLatestBoards() throws SQLException {
        return boardService.getLatestBoards();
    }
    @GetMapping("/popular")
    public List<Board> getPopularBoards() throws SQLException {
        return boardService.getPopularBoards();
    }
    @GetMapping(params = "title")
    public List<Board> getBoardsByTitleContaining(@RequestParam String title) throws SQLException{
        return boardService.getBoardsByTitleContaining(title);
    }

    @PutMapping("/{boardId}/title")
    public void updateBoardTitle(@PathVariable Integer boardId, @RequestBody String newTitle) throws SQLException {
        boardService.updateBoardTitle(boardId, newTitle);
    }

    @PutMapping("/{boardId}/price")
    public void updateBoardPrice(@PathVariable Integer boardId, @RequestBody String newPrice) throws SQLException {
        boardService.updateBoardPrice(boardId, newPrice);
    }

    @PutMapping("/{boardId}/content")
    public void updateBoardContent(@PathVariable Integer boardId, @RequestBody String newContent) throws SQLException {
        boardService.updateBoardContent(boardId, newContent);
    }

    @PutMapping("/{boardId}/status")
    public void updateBoardStatus(@PathVariable Integer boardId, @RequestBody String newStatus) throws SQLException {
        boardService.updateBoardStatus(boardId, newStatus);
    }

    @PutMapping("/{boardId}/category")
    public void updateBoardCategory(@PathVariable Integer boardId, @RequestBody Integer newCgNum) throws SQLException {
        boardService.updateBoardCategory(boardId, newCgNum);
    }

    @DeleteMapping("/{boardId}")
    public void deleteBoard(@PathVariable Integer boardId) throws SQLException {
        boardService.deleteBoard(boardId);
    }
}