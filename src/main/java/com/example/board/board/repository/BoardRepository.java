package com.example.board.board.repository;

import com.example.board.board.entity.BoardEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BoardRepository extends CrudRepository<BoardEntity, Integer> {
    List<BoardEntity> findAllByOrderByBoardIdxDesc();
}
