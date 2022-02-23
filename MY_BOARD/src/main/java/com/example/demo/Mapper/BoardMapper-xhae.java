package com.example.demo.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.DTO.Article;

@Mapper
public interface BoardMapper {
	  
	  @Insert("insert into article(writer_id,nickname,title,description,category_id)"
	  		+ "values(1 ,#{article.nickname}, #{article.title},"
	  		+ "#{article.description}, #{article.category_id})")
	  Boolean createArticle(@Param("article") Article article);
	  
	  @Select("select * from article limit #{start_num},30")
	  List<Article> getArticleLists(@Param("start_num")int start_num);
	  
	  @Select("select COUNT(*) from article")
	  int getArticleCount();

	  
}
