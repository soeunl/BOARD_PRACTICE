package org.choongang.board.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestBoard { // 여기는 커맨드 객체

    private Long seq;

    private String userName;

    private String userPassword;

    private String title;

    private String content;

}
