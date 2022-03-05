package com.example.demo.DTO;

public class Article {
	
	int id;
	Integer writer_id;
	String nickname;
	String title;
	String description;
	String uploadtime;
	Short Category_id;
	int likes;
	int see;
	String writer_image;
	String image;
	
	public Article(Integer writer_id,String nickname,String title,String description,String writer_image,String image) {
		this.writer_id=writer_id;
		this.nickname=nickname;
		this.title=title;
		this.description=description;
		this.writer_image=writer_image;
		this.image = image;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getWriter_id() {
		return writer_id;
	}
	public void setWriter_id(Integer writer_id) {
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
	public String getWriter_image() {
		return writer_image;
	}
	public void setWriter_image(String writer_image) {
		this.writer_image = writer_image;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
}
