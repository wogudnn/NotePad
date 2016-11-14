package com.psy.notepad.dao;

import java.util.List;

import com.psy.notepad.vo.NotePadVO;

public interface NotePadDao {

	public List<NotePadVO> getAllNote();

	public NotePadVO getNoteById(String notePadId);

	public int addNewNote(NotePadVO notePadVO);

	public int deleteNote(String notePadId);

	public int doModifyNote(NotePadVO notePadVO, String notePadId);

}
