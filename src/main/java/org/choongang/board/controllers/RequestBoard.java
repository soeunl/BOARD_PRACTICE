package org.choongang.board.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.choongang.board.entities.BoardData;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestBoard {

    private Long seq;

    private String userName;

    private String userPassword;

    private String title;

    private String content;

    public static RequestBoard toRequestBoard(BoardData boardData) {
        RequestBoard requestBoard = new RequestBoard();
        requestBoard.setSeq(boardData.getSeq());
        requestBoard.setUserName(boardData.getUserName());
        requestBoard.setUserPassword(boardData.getUserPassword());
        requestBoard.setTitle(boardData.getTitle());
        requestBoard.setContent(boardData.getContent());
        return requestBoard;
    }
}
