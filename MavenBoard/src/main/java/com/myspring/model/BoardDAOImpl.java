package com.myspring.model;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("mDao")
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSession sqlMap;

	@Override
	public void insert(String sqlid, BoardDTO dto) {
		// TODO Auto-generated method stub
		sqlMap.insert(sqlid, dto);
	}

	@Override
	public List<BoardDTO> getBoardList(String sqlid, HashMap<String, Object> hm) {
		// TODO Auto-generated method stub
		List<BoardDTO> boardlist = sqlMap.selectList(sqlid, hm);
		return boardlist;
	}

	@Override
	public void update(String sqlid, BoardDTO dto) {
		// TODO Auto-generated method stub
		sqlMap.update(sqlid, dto);
	}

	@Override
	public void delete(String sqlid, int seq) {
		// TODO Auto-generated method stub
		sqlMap.delete(sqlid, seq);
	}

	@Override
	public BoardDTO findBySeq(String sqlid, int seq) {
		// TODO Auto-generated method stub
		BoardDTO dto = sqlMap.selectOne(sqlid, seq);
		return dto;
	}
	
	@Override
	public int passcheck(String sqlid, HashMap<String, Object> hm) {
		// TODO Auto-generated method stub
		int flag = sqlMap.selectOne(sqlid, hm);
		return flag;
	}

	@Override
	public int countList(String sqlid, HashMap<String, Object> hm) {
		// TODO Auto-generated method stub
		int count = sqlMap.selectOne(sqlid, hm);
		return count;
	}

	@Override
	public void hitcount(String sqlid, int seq) {
		// TODO Auto-generated method stub
		sqlMap.update(sqlid, seq);
	}

	@Override
	public void reply(String sqlid, BoardDTO dto) {
		// TODO Auto-generated method stub
		sqlMap.insert(sqlid, dto);
	}

	@Override
	public void steps(String sqlid, BoardDTO dto) {
		// TODO Auto-generated method stub
		sqlMap.update(sqlid, dto);
	}

	public void insertcmt(String sqlid, CommentDTO cdto) {
		// TODO Auto-generated method stub
		sqlMap.insert(sqlid ,cdto);
	}

	public List<CommentDTO> listcmt(String sqlid, int bnum) {
		// TODO Auto-generated method stub
		List<CommentDTO> cmtlist = sqlMap.selectList(sqlid, bnum);
		return cmtlist;
	}

}
