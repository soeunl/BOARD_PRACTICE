package org.choongang.board.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.choongang.board.services.BoardService;
import org.choongang.board.validator.BoardValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardValidator boardValidator;
    private final BoardService boardService;

    @GetMapping("/") // 메인 화면
    public String boardList(@ModelAttribute RequestBoard form, Model model) {

    model.addAttribute("addCss", new String[] {"list"});

        return "board/list";
    }

    @GetMapping("/view")
    public String boardView(@ModelAttribute RequestBoard form) {


        return "board/view";
    }

    @GetMapping("/create")
    public String createBoard(@ModelAttribute RequestBoard form) {

        return "board/create";
    }

    @PostMapping("/create")
    public String createBoardPs(@Valid RequestBoard form, Errors errors) {

        boardValidator.validate(form, errors);

        if (errors.hasErrors()) {

            return "board/create";
        }

        boardService.save(form);

        return "redirect:/board/";
    }

    @GetMapping("/modify")
    public String modifyBoard(@ModelAttribute RequestBoard form) {

        return "board/modify";
    }

    @PostMapping("/modify")
    public String modifyBoardPs(@Valid RequestBoard form, Errors errors) {

        boardValidator.validate(form, errors);

        if (errors.hasErrors()) {

            return "board/modify";
        }

        boardService.save(form);

        return "redirect:/board/";
    }
}
