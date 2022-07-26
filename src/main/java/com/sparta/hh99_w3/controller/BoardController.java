package com.sparta.hh99_w3.controller;

import com.sparta.hh99_w3.models.Board;
import com.sparta.hh99_w3.models.BoardRepository;
import com.sparta.hh99_w3.models.BoardRequestDto;
import com.sparta.hh99_w3.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardRepository boardRepository;
    private final BoardService boardService;

    @PostMapping("/api/boards")
    public Board createBoard(@RequestBody BoardRequestDto requestDto) {
        Board board = new Board(requestDto);
        return boardRepository.save(board);
    }

    @GetMapping("/api/boards")
    public List<Board> getBoards() {
        return boardRepository.findAllByOrderByModifiedAtDesc();
    }

    @GetMapping("/api/boards/{id}")
    public Optional<Board> getBoards(@PathVariable Long id) {
        return boardRepository.findById(id);
    }

    @PutMapping("/api/boards/{id}")
    public String updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
        String result = boardService.update(id, requestDto);
        return result;
    }

    @DeleteMapping("/api/boards/{id}")
    public String deleteBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
        String result = boardService.delete(id, requestDto);
        return result;
    }
}