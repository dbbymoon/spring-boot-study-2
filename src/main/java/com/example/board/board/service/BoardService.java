package com.example.board.board.service;

import com.example.board.board.entity.BoardEntity;

import java.util.List;

public interface BoardService {
    List<BoardEntity> selectBoardList() throws Exception;
    void saveBoard(BoardEntity board) throws Exception;
    BoardEntity selectBoardDetail(int boardIdx) throws Exception;
    void deleteBoard(int boardIdx) throws Exception;
}
