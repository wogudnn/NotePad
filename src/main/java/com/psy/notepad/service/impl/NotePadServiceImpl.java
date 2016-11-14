package com.psy.notepad.service.impl;

import com.psy.notepad.biz.NotePadBiz;
import com.psy.notepad.service.NotePadService;
import com.psy.notepad.vo.NotePadListVO;
import com.psy.notepad.vo.NotePadVO;

public class NotePadServiceImpl implements NotePadService {

	private NotePadBiz notePadBiz;

	public void setNotePadBiz(NotePadBiz notePadBiz) {
		this.notePadBiz = notePadBiz;
	}
	
	@Override
	public NotePadListVO getAllNote() {
		return notePadBiz.getAllNote();
	}
	
	@Override
	public NotePadVO getNoteById(String notePadId) {
		
		NotePadVO noteVO = notePadBiz.getNoteById(notePadId);
		String content = noteVO.getContent();
		content.replaceAll("<br/>", "\n");
		
		noteVO.setContent(content);
		
		return noteVO;
	}
	
	@Override
	public boolean addNewNote(NotePadVO notePadVO) {
		
		String content = notePadVO.getContent();
		
		content.replaceAll("\n", "<br/>")
			   .replaceAll("\r","");
		
		notePadVO.setContent(content);
		
		return notePadBiz.addNewNote(notePadVO);
	}
	
	@Override
	public boolean deleteNote(String notePadId) {
		return notePadBiz.deleteNote(notePadId);
	}
	
	@Override
	public NotePadVO getNoteByIdForModify(String notePadId) {
		
		NotePadVO noteVO = notePadBiz.getNoteById(notePadId);
		String content = noteVO.getContent();
		content.replaceAll("<br/>", "\n");
		
		noteVO.setContent(content);
		
		return noteVO;
	}
	
	@Override
	public boolean doModifyNote(NotePadVO notePadVO, String notePadId) {
		
		String content = notePadVO.getContent();
		
		content.replaceAll("\n", "<br/>")
			   .replaceAll("\r","");
		
		notePadVO.setContent(content);
		
		return notePadBiz.doModifyNote(notePadVO,notePadId);
	}
}
