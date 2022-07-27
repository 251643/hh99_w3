package com.sparta.hh99_w3.controller;

import com.sparta.hh99_w3.models.*;
import com.sparta.hh99_w3.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<BoardResponseDto.ListResponseDto> getBoards() {
        return boardService.readList();
    }

    @GetMapping("/api/boards/{id}")
    public BoardResponseDto.DetailResponseDto getBoards(@PathVariable Long id) {
        return boardService.readDetail(id);
    }

    @GetMapping("/api/boards/check/{id}")
    public String checkPassword(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
        return boardService.check(id, requestDto);
    }

    @PutMapping("/api/boards/{id}")
    public String updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) { //@PathVariable -> param으로 보내는거
        return boardService.update(id, requestDto);
    }

    @DeleteMapping("/api/boards/{id}")
    public String deleteBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
        return boardService.delete(id, requestDto);
    }
}