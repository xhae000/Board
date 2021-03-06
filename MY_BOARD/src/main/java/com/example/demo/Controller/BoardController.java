package com.example.demo.Controller;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Common.Paging;
import com.example.demo.DTO.Article;
import com.example.demo.DTO.Comment;
import com.example.demo.DTO.User;
import com.example.demo.Mapper.BoardMapper;
import com.example.demo.Mapper.SearchMapper;
import com.example.demo.Mapper.UserMapper;

@Controller
public class BoardController {

	@Autowired
	private BoardMapper boardMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private SearchMapper searchMapper;
    private static final Logger LOGGER  = LogManager.getLogger(BoardController.class);
	
	@GetMapping("/")
	public String index(Model model,Principal pri,Authentication auth,
			@RequestParam(value="keyword", required=false)String keyword) {
		List<Article> articles;
		if(keyword==null || keyword.equals("")) {
			articles = new ArrayList<Article>(boardMapper.getArticleLists(0));
			model.addAttribute("articles",articles);
		}		
		else  {
			LinkedHashSet<Article> searchedArticle = 
					new LinkedHashSet<Article>(searchMapper.searchArticle(keyword));
			articles = new ArrayList<Article>(searchedArticle);
			model.addAttribute("articles",articles);
		}
		int articleCount = articles.size();
		
		if(articleCount == 0)
			model.addAttribute("searchMSG","<div style='text-align:center;color:#575757;padding:21.5px;'>?????? ????????? ????????????</div>.");
		else
			model.addAttribute("searchMSG","");
		
		if(auth==null) LOGGER.info("????????? ?????????.");
		else LOGGER.info("?????? ?????? ????????? ?????????/?????? : "+auth.getName()+"/"+auth.getAuthorities());		
		Paging p = new Paging();
		
		model.addAttribute("totalPageCount",
				p.getTotalPageCount(articles.size()));
		model.addAttribute("articleCount",articles.size());
		
		return "/index";
	}

	@GetMapping(value = "/write")
	public String write() {
		return "/write";
	}
	
	@PostMapping(value = "/writeProcess")
	public String writeProcess(@ModelAttribute("file")MultipartFile file,@ModelAttribute("title") String title,
			@ModelAttribute("description")String des, Principal pri) throws IllegalStateException, IOException {
		String filename = "no-image";
		
		if(title.length()>20||des.length()>1100)
			return "redirect:/";
		
		if(!file.isEmpty()) {
			filename = UUID.randomUUID().toString()+"_."+FilenameUtils.getExtension(file.getOriginalFilename());
			File newFile = new File(filename);
			file.transferTo(newFile);
			filename="/image/"+filename;
		}		
		
		User user = userMapper.getUserInfo(pri.getName());
		Article article =new Article(user.getId(),user.getNickname(),
				title,des,user.getImage(),filename);
		
		boardMapper.createArticle(article);		
		return "redirect:/";
	}

	@GetMapping(value="/article/{id}")
	public String article(@PathVariable int id,Model model,Authentication auth, HttpSession session) {
		boardMapper.plusSee(id); //?????????+=1
		
		Article article = boardMapper.getArticle(id);
		model.addAttribute("article",article);
		model.addAttribute("commentCount",boardMapper.getCommentCount(id));
		List<Comment> comments = boardMapper.getCommentLists(id);
		for(Comment c : comments) { 
			if(c.getWriter_id()==0) {
				boardMapper.DeleteArticle(c.getId());
			}
		}
		
		model.addAttribute("comments",comments);
		Boolean isWriter = false;
		if(auth!=null && userMapper.getUserId(auth.getName()) == article.getWriter_id() )
			isWriter = true;
		model.addAttribute("isWriter",isWriter);
		if(auth != null) {
			session.setAttribute("userId",userMapper.getUserId(auth.getName()));
			System.out.println(session.getAttribute("userId"));
		}	
		else
			session.setAttribute("userId", 0);
		return "/article";
	}
	
	@GetMapping(value="/deleteArticle/{id}")
	public String deleteArticle(@PathVariable int id, Authentication auth) {
		if(userMapper.getUserId(auth.getName())==
				boardMapper.getArticle(id).getWriter_id()) //????????? ?????? (?????? ???)
			boardMapper.DeleteArticle(id);
		return "redirect:/";
	}
	
	@GetMapping(value="/editArticle/{id}")
	public String editArticle(@PathVariable int id, Authentication auth, Model model) {
		if(userMapper.getUserId(auth.getName())!=
				boardMapper.getArticle(id).getWriter_id())  //????????? ?????? (?????? ???)
			return "redirect:/";
		model.addAttribute("article",boardMapper.getArticle(id));
		return "/edit";
	}
	
	@PostMapping(value="/editArticle/{id}")
	public String editArticleProcess(@ModelAttribute("title")String title,@ModelAttribute("description")String des,
			@ModelAttribute("isImageEdit")String isImageEdit, @ModelAttribute("file")MultipartFile file , 
			@PathVariable int id, Authentication auth) throws IllegalStateException, IOException {
		String filename = "";
		if(title.length()>20||des.length()>1100)
			return "redirect:/";
		
		if(!file.isEmpty()) {
			filename = UUID.randomUUID().toString()+"_"+FilenameUtils.getExtension(file.getOriginalFilename());
			File newFile = new File(filename);
			file.transferTo(newFile);
			filename="/image/"+filename;
		}		
		else filename = isImageEdit.equals("true")?"no-image":boardMapper.getArticle(id).getImage(); //????????? ???????????? ?????? ????????? ???????????? ??????
		
		
		boardMapper.updateArticle(id,title,des,filename);
		return "redirect:/article/"+id	;
	}
	
	@GetMapping(value="/search")
	public String searchArticle() {
		return "";
	}
}

