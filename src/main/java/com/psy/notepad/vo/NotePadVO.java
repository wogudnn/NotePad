package com.psy.notepad.vo;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class NotePadVO {
	
	private String notePadId;
	@NotNull(message="내용이비었습니다.")
	@NotEmpty(message="내용이비었습니다.")
	private String content;
	private String createdDate;
	public String getNotePadId() {
		return notePadId;
	}
	public void setNotePadId(String notePadId) {
		this.notePadId = notePadId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	
	
	
}
