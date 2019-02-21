package com.myspring.model;

import java.util.HashMap;
import java.util.List;

public interface BoardDAO {
	// ��ü����
	List<BoardDTO> getBoardList(String sqlid, HashMap<String, Object> hm);

	// ī��Ʈ
	int countList(String sqlid, HashMap<String, Object> hm);

	// �߰�
	void insert(String sqlid, BoardDTO dto);

	// ����
	void update(String sqlid, BoardDTO dto);

	// ����
	void delete(String sqlid, int seq);

	// �󼼺���
	BoardDTO findBySeq(String sqlid, int seq);

	// �н����� üũ
	int passcheck(String sqlid, HashMap<String, Object> hm);
	
	// ��ȸ��
	void hitcount(String sqlid, int seq);
	
	// ���
	void reply(String sqlid, BoardDTO dto);
	
	// ��ۼ���
	void steps(String sqlid, BoardDTO dto);
}
