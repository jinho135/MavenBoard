package com.myspring.model;

import java.util.HashMap;
import java.util.List;

public interface BoardDAO {
	// 전체보기
	List<BoardDTO> getBoardList(String sqlid, HashMap<String, Object> hm);

	// 카운트
	int countList(String sqlid, HashMap<String, Object> hm);

	// 추가
	void insert(String sqlid, BoardDTO dto);

	// 수정
	void update(String sqlid, BoardDTO dto);

	// 삭제
	void delete(String sqlid, int seq);

	// 상세보기
	BoardDTO findBySeq(String sqlid, int seq);

	// 패스워드 체크
	int passcheck(String sqlid, HashMap<String, Object> hm);
	
	// 조회수
	void hitcount(String sqlid, int seq);
	
	// 답글
	void reply(String sqlid, BoardDTO dto);
	
	// 답글순서
	void steps(String sqlid, BoardDTO dto);
}
