package org.choongang.board.controllers;

import lombok.RequiredArgsConstructor;
import org.choongang.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/")
    public String boardIndex() {

        return "board/index";
    }

    @GetMapping("/save")
    public String saveForm() {

        return "board/save";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute RequestBoard requestBoard) {
        boardService.save(requestBoard);
        return "board/index";
    }

    @GetMapping("/")
    public String boardList(Model model) {
     List<RequestBoard> requestBoardList = boardService.findList();
     model.addAttribute("boardList", requestBoardList);
     return "board/list";
    }
}
