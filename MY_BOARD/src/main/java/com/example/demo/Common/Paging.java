package com.example.demo.Common;

public class Paging {
	public int getTotalPageCount(int articleCount) { //20개 단위로 보여줄것
		return articleCount%20==0 ? articleCount/20 : articleCount/20+1;
	}
}
