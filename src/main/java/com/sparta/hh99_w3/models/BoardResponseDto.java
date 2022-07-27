package com.sparta.hh99_w3.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


public class BoardResponseDto {

    @Getter
    @NoArgsConstructor
    public static class ListResponseDto{ //static? 바로가지고올수있다?
        private String title;
        private String username;
        private LocalDateTime modifiedAt;


        //public BoardResponseDto(){}

        public ListResponseDto(Board board) {
            this.title = board.getTitle();
            this.username = board.getUsername();
            this.modifiedAt = board.getModifiedAt();
        }
    }

    @Getter
    @NoArgsConstructor
    public static class DetailResponseDto {
        private String title;
        private String username;
        private LocalDateTime modifiedAt;
        private String contents;


        //public BoardResponseDto(){}

        public DetailResponseDto(Board board) {
            this.title = board.getTitle();
            this.username = board.getUsername();
            this.modifiedAt = board.getModifiedAt();
            this.contents = board.getContents();
        }
    }
}



