package com.example.board.board.service;

import com.example.board.board.entity.BoardEntity;
import com.example.board.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Override
    public List<BoardEntity> selectBoardList() throws Exception {
        return boardRepository.findAllByOrderByBoardIdxDesc();
    }

    @Override
    public void saveBoard(BoardEntity board) throws Exception {
        board.setCreatorId("admin");
        boardRepository.save(board);
    }

    @Override
    public BoardEntity selectBoardDetail(int boardIdx) throws Exception {
        Optional<BoardEntity> optional = boardRepository.findById(boardIdx);
        if(optional.isPresent()){
            BoardEntity board = optional.get();
            board.setHitCnt(board.getHitCnt()+1);
            boardRepository.save(board);
            return board;
        }else
            throw new NullPointerException();
    }

    @Override
    public void deleteBoard(int boardIdx) throws Exception {
        boardRepository.deleteById(boardIdx);
    }
}
