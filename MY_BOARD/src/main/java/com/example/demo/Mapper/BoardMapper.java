package com.example.demo.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.demo.DTO.Article;

@Mapper
public interface BoardMapper {
	  
	  @Insert("insert into article(writer_id,nickname,title,description,category_id)"
	  		+ "values(1 ,#{article.nickname}, #{article.title},"
	  		+ "#{article.description}, #{article.category_id})")
	  Boolean createArticle(@Param("article") Article article);
	  
	  @Select("select * from article")
	  List<Article> getArticleLists();
	  
	  @Select("select COUNT(*) from article")
	  int getArticleCount();
}
