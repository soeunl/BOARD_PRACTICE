package org.choongang.board.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.choongang.board.controllers.RequestBoard;
import org.choongang.global.entities.BaseEntity;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class BoardData extends BaseEntity {
    @Id @GeneratedValue
    private Long seq;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String userPassword;

    @Column(nullable = false)
    private String title;

    @Lob
    @Column(nullable = false)
    private String content;

    public static BoardData saveBoardData(RequestBoard requestBoard) {
        BoardData boardData = new BoardData();
        boardData.setSeq(requestBoard.getSeq());
        boardData.setUserName(requestBoard.getUserName());
        boardData.setUserPassword(requestBoard.getUserPassword());
        boardData.setTitle(requestBoard.getTitle());
        boardData.setContent(requestBoard.getContent());
        return boardData;

    }
}
