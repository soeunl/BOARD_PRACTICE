package org.choongang.board.service;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.choongang.board.controllers.BoardController;
import org.choongang.board.controllers.RequestBoard;
import org.choongang.board.entities.BoardData;
import org.choongang.board.repositories.BoardDataRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final HttpServletRequest request;
    private final BoardDataRepository boardDataRepository;
    private final BoardController boardController;

    public void save(RequestBoard requestBoard) {
        BoardData boardData = BoardData.saveBoardData(requestBoard);
        boardDataRepository.save(boardData);
    }

    public List<RequestBoard> findList() {
        List<BoardData> boardDataList = boardDataRepository.findAll();
        List<RequestBoard> requestBoardList = new ArrayList<>();
        for (BoardData boardData : boardDataList) {
           requestBoardList.add(RequestBoard.toRequestBoard(boardData));
        }
        return requestBoardList;
    }
}

