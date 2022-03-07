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
	  
	  @Select("select * from comment where article_id=#{article_id}  order by parent_id limit #{start_num},15")
	  List<Comment> getCommentLists(@Param("article_id")int article_id,@Param("start_num")int start_num);
	  
	  @Insert("insert into comment(writer_id,article_id,description,writer_image,nickname,parent_id,upload_time)"+
	  		 "values(#{comment.writer_id}, #{comment.article_id}, #{comment.description}, #{comment.writer_image}, #{comment.nickname},"
	  		 + "(select NUM from (select ifnull(max(parent_id),0)+1 as NUM from comment where article_id= #{comment.article_id}) A),now())")
	  Boolean createComment(@Param("comment")Comment comment);
	  
	  @Insert("insert into liker values(#{username},#{post_id},#{postType})")
	  Boolean likePost(@Param("username")String username,@Param("post_id")int post_id,@Param("postType")String articleORcomment);
	 
	  @Select("select post_id from liker "
	  		+ "where liker_name=#{username} and post_id=#{post_id} and postType=#{postType}")
	  Integer isLike(@Param("username")String username,@Param("post_id")int post_id, @Param("postType")String articleORcomment);
	  
	  @Select("select likes from article where id=#{id}")
	  int getLikeCount(@Param("id")int id);

	  @Update("update article set likes = likes + 1 where id = #{id}")
	  Boolean addArticleLike(@Param("id")int id);
	  
	  @Update("update article set comments = comments+1 where id= #{id}")
	  Boolean addArticleComment(@Param("id")int id);
	  
}

