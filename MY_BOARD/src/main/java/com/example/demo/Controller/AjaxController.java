package com.example.demo.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.DTO.Article;
import com.example.demo.DTO.Comment;
import com.example.demo.DTO.User;
import com.example.demo.Mapper.BoardMapper;
import com.example.demo.Mapper.UserMapper;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class AjaxController {
	
	@Autowired
	UserMapper userMapper;
	@Autowired
	BoardMapper boardMapper;
	
	
	@RequestMapping("/isAvailableUsername")
	@ResponseBody
	public String isAvailableUsername(@RequestParam String username) {
		return userMapper.getUserId(username)==null?"available":"using";
	}
	
	@RequestMapping("/getArticles")
	@ResponseBody
	public List<Article> loadArticles(@RequestParam int page){
		return boardMapper.getArticleLists(page*30-30);
	}
	
	@RequestMapping("/commentProccess")
	@ResponseBody
	public Map<String, Object> commentProccess(@RequestParam("articleId") int id,@RequestParam("comment")String comment,
			Authentication auth, Model model) {
		User user = userMapper.getUserInfo(auth.getName());
		Comment cmt = new Comment(user.getId(), id, comment, user.getImage(),
				user.getNickname());
		boardMapper.createComment(cmt);
		boardMapper.addArticleComment(id);
		// 댓글 등록과 동시에 댓글 업데이트		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("comments",  boardMapper.getCommentLists(id,0));
		map.put("commentCount", boardMapper.getCommentCount(id));
		return map;
	}
	
	@RequestMapping("/articleLike/{id}")
	@ResponseBody
	public String articleLike(@PathVariable int id,Authentication auth){
		if (auth==null)
			return "need_login";
		else if(boardMapper.isLike(auth.getName(),id,"article")!=null)
			return "already_like";
		else { 
			boardMapper.likePost(auth.getName(), id, "article");
			boardMapper.addArticleLike(id);
			return Integer.toString(boardMapper.getLikeCount(id));
				
		}

	}
}