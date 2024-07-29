package org.choongang.board.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    @GetMapping("/list")
    public String boardList() {



        return "board/list";
    }

    @GetMapping("/create")
    public String createBoard(@ModelAttribute RequestBoard form) {

        return "board/create";
    }

    @PostMapping("/create")
    public String createBoardPs() {

        return "redirect:/board/list";
    }

    @GetMapping("/modify")
    public String modifyBoard(@ModelAttribute RequestBoard form) {

        return "board/modify";
    }

    @PostMapping("/modify")
    public String modifyBoardPs() {

        return "redirect:/board/list";
    }
}
