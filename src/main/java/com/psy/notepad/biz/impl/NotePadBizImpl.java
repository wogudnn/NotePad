package com.psy.notepad.biz.impl;


import com.psy.notepad.biz.NotePadBiz;
import com.psy.notepad.dao.NotePadDao;
import com.psy.notepad.vo.NotePadListVO;
import com.psy.notepad.vo.NotePadVO;

public class NotePadBizImpl implements NotePadBiz {

	private NotePadDao notePadDao;

	public void setNotePadDao(NotePadDao notePadDao) {
		this.notePadDao = notePadDao;
	}
	
	@Override
	public NotePadListVO getAllNote() {
		
		NotePadListVO notePadList = new NotePadListVO();
		notePadList.setNotePadList(notePadDao.getAllNote());
		
		return notePadList;
	}
	
	@Override
	public NotePadVO getNoteById(String notePadId) {
		return notePadDao.getNoteById(notePadId);
	}
	
	@Override
	public boolean addNewNote(NotePadVO notePadVO) {
		return notePadDao.addNewNote(notePadVO)>0;
	}
	
	@Override
	public boolean deleteNote(String notePadId) {
		return notePadDao.deleteNote(notePadId)>0;
	}
	
	@Override
	public boolean doModifyNote(NotePadVO notePadVO, String notePadId) {
		return notePadDao.doModifyNote(notePadVO, notePadId)>0;
	}
	
}
