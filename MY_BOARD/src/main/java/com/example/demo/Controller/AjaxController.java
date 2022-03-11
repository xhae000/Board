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
	
	@RequestMapping("/commentProcess")
	@ResponseBody
	public Map<String, Object> commentProcess(@RequestParam("articleId") int id,@RequestParam("comment")String comment,
			Authentication auth, Model model) {
		User user = userMapper.getUserInfo(auth.getName());
		Comment cmt = new Comment(user.getId(), id, comment, user.getImage(),
				user.getNickname());
		if(comment.length()<=200) { // 글자수 200 제한
			boardMapper.createComment(cmt);
			boardMapper.addArticleComment(id);
		}
		// 댓글 등록과 동시에 댓글 업데이트		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("comments",  boardMapper.getCommentLists(id));
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
			return Integer.toString(boardMapper.getArticleLikeCount(id));
				
		}
	}
		
		@RequestMapping("/commentLike/{id}")
		@ResponseBody
		public String commentLike(@PathVariable int id,Authentication auth){
			if (auth==null)
				return "need_login";
			else if(boardMapper.isLike(auth.getName(),id,"comment")!=null)
				return "already_like";
			else { 
				boardMapper.likePost(auth.getName(), id, "comment");
				boardMapper.addCommentLike(id);
				return Integer.toString(boardMapper.getCommentLikeCount(id));
					
			}

	}
	@RequestMapping("/replyProcess")
	@ResponseBody
	public Map<String,Object> replyProcess(Authentication auth,
			@RequestParam("parent_id")Integer parent_id,@RequestParam("des") String des,
			@RequestParam("article_id")Integer article_id,@RequestParam("comment_id")Integer comment_id){
		User user =userMapper.getUserInfo(auth.getName());
		
		if(des.length()<=200) {	
			String toUser = "<span style=\"color:#088400\">"+boardMapper.getNicknameByComment(comment_id)+"</span> ";
			des = toUser + des;
			Comment comment = new Comment(user.getId(),article_id,des,user.getImage(),user.getNickname());
			comment.setParent_id(parent_id);
			boardMapper.createReply(comment);
			boardMapper.addArticleComment(article_id);

		}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("comments",  boardMapper.getCommentLists(article_id));
		map.put("commentCount", boardMapper.getCommentCount(article_id));
		return map;	
	}
	
	@RequestMapping("/deleteComment/{id}")
	@ResponseBody
	public String  deleteComment(@PathVariable int id, Authentication auth) {
		String resultMSG = "";
		int article_id = boardMapper.getComment(id).getArticle_id();

		if(auth!=null || boardMapper.getComment(id).getWriter_id()==userMapper.getUserId(auth.getName())) {
			if(boardMapper.isReply(id).equals("1")) {
				boardMapper.minusArticleComment(article_id, 1);			
				boardMapper.deleteComment(id);
				resultMSG = "normal";
			}else {
				int parent_id = boardMapper.getComment(id).getParent_id();						
				if (boardMapper.getCountParent(parent_id, article_id) == 1) {
					boardMapper.deleteComment(id);
					resultMSG = "normal";
				}
				else {
					boardMapper.deleteParent(id);
					resultMSG = "parent";
				}
				boardMapper.minusArticleComment(article_id, 1);				
			}


		}
		return resultMSG;
	}
	
	
	
	
				
}