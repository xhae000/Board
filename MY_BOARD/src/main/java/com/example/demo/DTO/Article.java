package com.example.demo.DTO;

public class Article {
	
	int id;
	Short writer_id;
	String nickname;

	String title;
	String description;
	String uploadtime;
	Short Category_id;
	int likes;
	int see;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Short getWriter_id() {
		return writer_id;
	}
	public void setWriter_id(Short writer_id) {
		this.writer_id = writer_id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUploadtime() {
		return uploadtime;
	}
	public void setUploadtime(String uploadTime) {
		this.uploadtime = uploadTime;
	}
	public Short getCategory_id() {
		return Category_id;
	}
	public void setCategory_id(Short category_id) {
		Category_id = category_id;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public int getSee() {
		return see;
	}
	public void setSee(int see) {
		this.see = see;
	}
	
	
}
