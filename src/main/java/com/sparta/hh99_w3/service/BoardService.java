package com.sparta.hh99_w3.service;


import com.sparta.hh99_w3.models.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

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

    @Transactional
    public List<BoardResponseDto.ListResponseDto> readList(){
        List<Board> boardList = boardRepository.findAllByOrderByModifiedAtDesc();
        List<BoardResponseDto.ListResponseDto> boardResponseDtoList = new ArrayList<>();
        for(Board board : boardList){
            boardResponseDtoList.add(new BoardResponseDto.ListResponseDto(board));
        }
        return boardResponseDtoList;
    }

    @Transactional
    public BoardResponseDto.DetailResponseDto readDetail(Long id){
        Board boardDetail = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        return new BoardResponseDto.DetailResponseDto(boardDetail);
    }

}
