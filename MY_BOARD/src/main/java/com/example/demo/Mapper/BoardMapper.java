package com.example.demo.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.DTO.Article;
import com.example.demo.DTO.Comment;

@Mapper
public interface BoardMapper {
	  
	  @Insert("insert into article(writer_id,nickname,title,description,writer_image,image)"
	  		+ "values(#{article.writer_id} ,#{article.nickname}, #{article.title},"
	  		+ "#{article.description}, #{article.writer_image},#{article.image})")
	  Boolean createArticle(@Param("article") Article article);
	  
	  @Select("select * from article order by id desc limit #{start_num},30 ")
	  List<Article> getArticleLists(@Param("start_num")int start_num);
	  
	  @Select("select COUNT(*) from article")
	  int getArticleCount();
	  
	  @Select("select * from article where id = #{id}")
	  Article getArticle(@Param("id") int id);
	  
	  @Update("update article set see=see+1 where id=#{id}")
	  Boolean plusSee(@Param("id") int id);
	  
	  @Select("select COUNT(*) from comment where article_id=#{article_id}")
	  int getCommentCount(@Param("article_id")int article_id);
	  
	  @Select("select * from comment where article_id=92  order by parent_id limit #{start_num},15")
	  List<Comment> getCommentLists(@Param("start_num")int start_num);
}
