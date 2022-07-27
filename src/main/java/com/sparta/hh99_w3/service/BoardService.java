package com.sparta.hh99_w3.service;


import com.sparta.hh99_w3.models.Board;
import com.sparta.hh99_w3.models.BoardRepository;
import com.sparta.hh99_w3.models.BoardRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public String update(Long id, BoardRequestDto requestDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        if(board.getPassword().equals(requestDto.getPassword())){
            board.update(requestDto);
            return "수정 되었습니다.";
        }else{
            return "비밀번호가 다릅니다.";
        }
    }

    @Transactional
    public String check(Long id, BoardRequestDto requestDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        if(board.getPassword().equals(requestDto.getPassword())){
            board.update(requestDto);
            return "비밀번호가 일치합니다.";
        }else{
            return "비밀번호가 다릅니다.";
        }
    }

    @Transactional
    public String delete(Long id, BoardRequestDto requestDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        if(board.getPassword().equals(requestDto.getPassword())){
            board.delete(requestDto);
            return "삭제 되었습니다.";
        }else{
            return "비밀번호가 다릅니다.";
        }
    }

}
