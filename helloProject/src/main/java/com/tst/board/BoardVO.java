package com.tst.board;

import lombok.Getter;
import lombok.Setter;

//글제목, 글내용, 작성자, 작성일자, 방문횟수
//VO(value Object)
@Getter@Setter
public class BoardVO {
	private int boardId;
	private String title;
	private String content;
	private String writer;
	private String createDate;
	private int cnt;
	
	public BoardVO() {}

	public BoardVO(int boardId, String title, String content, String writer, String createDate, int cnt) {
		super();
		this.boardId=boardId;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.createDate = createDate;
		this.cnt = cnt;
	}
	
}
