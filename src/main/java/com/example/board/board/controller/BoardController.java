package com.example.board.board.controller;

import com.example.board.board.entity.BoardEntity;
import com.example.board.board.service.BoardService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @RequestMapping(value = "/board", method = RequestMethod.GET)
    public ModelAndView openBoardList(ModelMap model) throws Exception{
        ModelAndView mv = new ModelAndView("/board/boardList");
        List<BoardEntity> list = boardService.selectBoardList();
        mv.addObject("list",list);
        return mv;
    }

    @RequestMapping(value = "/board/write", method = RequestMethod.GET)
    public String openBoardWrite() throws Exception{
        return "/board/boardWrite";
    }

    @RequestMapping(value = "/board/write", method = RequestMethod.POST)
    public String writeBoard(BoardEntity board) throws Exception{
        boardService.saveBoard(board);
        return "redirect:/board";
    }

    @RequestMapping(value = "/board/{boardIdx}", method = RequestMethod.GET)
    public ModelAndView openBoardDetail(@PathVariable("boardIdx") int boardIdx) throws Exception{
        ModelAndView mv = new ModelAndView("/board/boardDetail");
        BoardEntity board = boardService.selectBoardDetail(boardIdx);
        mv.addObject("board", board);
        return mv;
    }

    @RequestMapping(value = "/board/{boardIdx}", method = RequestMethod.PUT)
    public String updateBoard(BoardEntity board) throws Exception{
        boardService.saveBoard(board);
        return "redirect:/board";
    }

    @RequestMapping(value = "/board/{boardIdx}", method = RequestMethod.DELETE)
    public String deleteBoard(@PathVariable("boardIdx") int boardIdx) throws Exception{
        boardService.deleteBoard(boardIdx);
        return "redirect:/board";
    }
}
