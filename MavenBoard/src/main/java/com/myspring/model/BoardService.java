package com.myspring.model;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("mService")
public class BoardService {

	@Resource(name = "mDao")
	private BoardDAOImpl mDao;

	// Write
	public void insert(BoardDTO dto) {
		mDao.insert("writeBoard", dto);
	}

	// List
	public List<BoardDTO> list(HashMap<String, Object> hm) {
		List<BoardDTO> boardlist = mDao.getBoardList("listBoard", hm);
		return boardlist;
	}

	// Detail
	public BoardDTO detail(int seq) {
		// TODO Auto-generated method stub
		BoardDTO dto = mDao.findBySeq("detailBoard", seq);
		return dto;
	}

	// Update
	public void update(BoardDTO dto) {
		// TODO Auto-generated method stub
		mDao.update("updateBoard", dto);
	}

	// Delete
	public void delete(int seq) {
		// TODO Auto-generated method stub
		mDao.delete("deleteBoard", seq);
	}

	// passCheck
	public int passcheck(HashMap<String, Object> hm) {
		int flag = mDao.passcheck("passcheck", hm);
		return flag;
	}

	// listCount
	public int count(HashMap<String, Object> hm) {
		// TODO Auto-generated method stub
		int count = mDao.countList("countBoard", hm);
		return count;
	}
	
	// hitCount
	public void hit(int seq) {
		mDao.hitcount("hit", seq);
	}

	public void reply(BoardDTO dto) {
		// TODO Auto-generated method stub
		mDao.reply("replyBoard", dto);
	}

	public void steps(BoardDTO dto) {
		// TODO Auto-generated method stub
		mDao.steps("stepsBoard", dto);
	}

	public void insertcmt(CommentDTO cdto) {
		// TODO Auto-generated method stub
		mDao.insertcmt("insertComment", cdto);
	}

	public List<CommentDTO> listcmt(int bnum) {
		// TODO Auto-generated method stub
		List<CommentDTO> cmtlist = mDao.listcmt("listComment", bnum);
		return cmtlist;
	}
}
