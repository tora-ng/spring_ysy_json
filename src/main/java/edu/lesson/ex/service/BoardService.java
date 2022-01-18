package edu.lesson.ex.service;

import java.util.List;

import edu.lesson.ex.vo.BoardVO;

public interface BoardService {
	List<BoardVO> getList();
	BoardVO get(int bid);
	void register(BoardVO board);
	void registerReply(BoardVO board);
	void remove(int bid);
	void modify(BoardVO boardVO);
	void upHit(int bid);
	
	
}