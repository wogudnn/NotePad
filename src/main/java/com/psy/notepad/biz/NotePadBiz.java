package com.psy.notepad.biz;

import com.psy.notepad.vo.NotePadListVO;
import com.psy.notepad.vo.NotePadVO;

public interface NotePadBiz {

	public NotePadListVO getAllNote();

	public NotePadVO getNoteById(String notePadId);

	public boolean addNewNote(NotePadVO notePadVO);

	public boolean deleteNote(String notePadId);

	public boolean doModifyNote(NotePadVO notePadVO, String notePadId);

}
