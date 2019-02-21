package com.myspring.board;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myspring.model.BoardDTO;
import com.myspring.model.BoardService;
import com.myspring.model.CommentDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Resource(name = "mService")
	private BoardService mService;

	@RequestMapping("/")
	public String home() {
		return "home";
	}

	// write-form
	@RequestMapping("write")
	public String write() {
		return "boardWrite";
	}

	// write
	@RequestMapping(value = "write", method = RequestMethod.POST)
	public String write(BoardDTO dto) {
		mService.insert(dto);
		return "redirect:list";
	}

	// reply-form
	@RequestMapping("reply")
	public String reply(Model model, int groups, int levels, int steps) {
		model.addAttribute("groups", groups);
		model.addAttribute("levels", levels);
		model.addAttribute("steps", steps);
		return "boardReply";
	}

	// reply
	@RequestMapping(value = "reply", method = RequestMethod.POST)
	public String reply(BoardDTO dto) {
		mService.steps(dto);
		mService.reply(dto);
		return "redirect:list";
	}

	// list
	@RequestMapping("list")
	public String list(Model model, String field, String word, String pageNum) {
		field = field == null ? "" : field.trim();
		word = word == null ? "" : word.trim();
		pageNum = pageNum == null ? "1" : pageNum.trim();

		int currentPage = Integer.parseInt(pageNum);
		int pageSize = 10;
		int startRow = ((currentPage - 1) * pageSize) + 1;
		int endRow = currentPage * pageSize;

		HashMap<String, Object> hm = new HashMap<>();
		hm.put("field", field);
		hm.put("word", word);
		hm.put("startRow", startRow);
		hm.put("endRow", endRow);

		List<BoardDTO> lists = mService.list(hm);
		int count = mService.count(hm);

		int totpage = count / pageSize + (count % pageSize == 0 ? 0 : 1);
		int blockpage = 5;
		int startpage = ((currentPage - 1) / blockpage) * blockpage + 1;
		int endpage = startpage + blockpage - 1;

		if (endpage > totpage)
			endpage = totpage;

		model.addAttribute("field", field);
		model.addAttribute("word", word);

		model.addAttribute("totpage", totpage);
		model.addAttribute("startpage", startpage);
		model.addAttribute("endpage", endpage);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("blockpage", blockpage);

		model.addAttribute("lists", lists);
		model.addAttribute("count", count);

		return "boardList";
	}

	// detail
	@RequestMapping("detail")
	public String detail(Model model, int seq) {
		BoardDTO dto = mService.detail(seq);
		mService.hit(seq);
		List<CommentDTO> cmt = mService.listcmt(seq);
		model.addAttribute("dto", dto);
		model.addAttribute("cmt", cmt);
		return "boardDetail";
	}

	// passcheck
	@RequestMapping("passcheck")
	@ResponseBody
	public String update(Model model, int seq, String password) {
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("seq", seq);
		hm.put("password", password);
		int flag = mService.passcheck(hm);
		return flag + "";
	}

	// update-from
	@RequestMapping("update")
	public String updatefrom(Model model, int seq) {
		BoardDTO dto = mService.detail(seq);
		model.addAttribute("dto", dto);
		return "boardUpdate";
	}

	// update
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(BoardDTO dto) {
		mService.update(dto);
		return "redirect:detail?seq=" + dto.getSeq();
	}

	// delete
	@RequestMapping("delete")
	public String delete(int seq, String password) {
		mService.delete(seq);
		return "redirect:list";
	}
	
	// insertcomment
	@RequestMapping("insertcmt")
	public String insertcmt(CommentDTO cdto) {
		mService.insertcmt(cdto);
		return "redirect:detail?seq="+cdto.getBnum();
	}
}
