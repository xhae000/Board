package com.example.demo.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
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
	  int getArticleLikeCount(@Param("id")int id);
	  
	  @Select("select likes from comment where id = #{id}")
	  int getCommentLikeCount(@Param("id")int id);

	  @Update("update article set likes = likes + 1 where id = #{id}")
	  Boolean addArticleLike(@Param("id")int id);
	 
	  @Update("update comment set likes = likes + 1 where id = #{id}")
	  Boolean addCommentLike(@Param("id")int id);
	  
	  @Update("update article set comments = comments+1 where id= #{id}")
	  Boolean addArticleComment(@Param("id")int id);
	  
	  @Delete("delete from article where id=#{id}")
	  Boolean DeleteArticle(@Param("id")int id);
	  
	  @Update("update article set title = #{title}, description=#{des}, image=#{image} where id=#{id}")
	  Boolean updateArticle(@Param("id")int id ,
			  @Param("title")String title, @Param("des")String des ,@Param("image")String image);
	  
	  @Insert("insert into comment(writer_id,article_id,description,writer_image,nickname,parent_id,upload_time,isReply)"+
	  		 "values(#{comment.writer_id}, #{comment.article_id}, #{comment.description},"
	  		 + " #{comment.writer_image}, #{comment.nickname},"
	  		 + "#{comment.parent_id},now(),true)")
	  Boolean createReply(@Param("comment")Comment comment);	 
	  
	@Select("select nickname from comment where id = #{id}")
	String getNicknameByComment(@Param("id")int id);

	@Delete("delete from comment where id=#{id}")
	Boolean deleteComment(@Param("id")int id);
	
	@Select("select * from comment where id=#{id}")
	Comment getComment(@Param("id")int id);
	
	@Update("update article set comments = comments - #{delete} where id = #{id}")
	Boolean minusArticleComment(@Param("id")int id,@Param("delete")int delete);
	
	@Select("select isReply from comment where id=#{id}")
	String isReply(@Param("id") int id);
	
	@Select("select parent_id from comment where id=#{id}")
	int getParent_id(@Param("id")int id);
	

	@Select("select count(*) from comment where parent_id=#{parent_id}")
	int getCountParent(@Param("parent_id")int parent_id);
	
	@Update("update comment set writer_id=0,description=0,upload_time=0,likes=0,writer_image=0,"
			+ "nickname=0 where id=#{id}")
	Boolean deleteParent(@Param("id")int id);
}

