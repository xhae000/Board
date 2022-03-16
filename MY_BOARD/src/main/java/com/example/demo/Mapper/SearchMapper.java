package com.example.demo.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.demo.DTO.Article;

@Mapper
public interface SearchMapper {
	@Select("select * from article where instr(title,#{keyword})>0 or instr(nickname,#{keyword})>0 order by id desc")
	List<Article> searchArticle(@Param("keyword")String keyword);
	
}
