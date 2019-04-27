package com.example.board.board.controller;

import com.example.board.board.entity.BoardEntity;
import com.example.board.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoardApiController {

    @Autowired
    private BoardService boardService;

    @RequestMapping(value = "/api/board", method = RequestMethod.GET)
    public List<BoardEntity> openBoardList(ModelMap model) throws Exception{
        return boardService.selectBoardList();
    }

    @RequestMapping(value = "/api/board/write", method = RequestMethod.POST)
    public void writeBoard(@RequestBody BoardEntity board) throws Exception{
        boardService.saveBoard(board);
    }

    @RequestMapping(value = "/api/board/{boardIdx}", method = RequestMethod.GET)
    public BoardEntity openBoardDetail(@PathVariable("boardIdx") int boardIdx) throws Exception{
        return boardService.selectBoardDetail(boardIdx);
    }

    @RequestMapping(value = "/api/board/{boardIdx}", method = RequestMethod.PUT)
    public String updateBoard(@RequestBody BoardEntity board) throws Exception{
        boardService.saveBoard(board);
        return "redirect:/board";
    }

    @RequestMapping(value = "/api/board/{boardIdx}", method = RequestMethod.DELETE)
    public String deleteBoard(@PathVariable("boardIdx") int boardIdx) throws Exception{
        boardService.deleteBoard(boardIdx);
        return "redirect:/board";
    }
}
