package com.psy.notepad.service;

import com.psy.notepad.vo.NotePadListVO;
import com.psy.notepad.vo.NotePadVO;

public interface NotePadService {

	public NotePadListVO getAllNote();

	public NotePadVO getNoteById(String notePadId);

	public boolean addNewNote(NotePadVO notePadVO);

	public boolean deleteNote(String notePadId);

	public boolean doModifyNote(NotePadVO notePadVO, String notePadId);

	public NotePadVO getNoteByIdForModify(String notePadId);

}
