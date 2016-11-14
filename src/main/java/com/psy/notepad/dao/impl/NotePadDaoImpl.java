package com.psy.notepad.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.psy.notepad.dao.NotePadDao;
import com.psy.notepad.vo.NotePadVO;

public class NotePadDaoImpl extends SqlSessionDaoSupport implements NotePadDao {

	private Logger logger = LoggerFactory.getLogger(NotePadDaoImpl.class);
	
	@Override
	public List<NotePadVO> getAllNote() {
		return getSqlSession().selectList("notePadDao.getAllNote");
	}
	
	@Override
	public NotePadVO getNoteById(String notePadId) {
		return getSqlSession().selectOne("notePadDao.getNoteById", notePadId);
	}
	
	@Override
	public int addNewNote(NotePadVO notePadVO) {
		return getSqlSession().insert("notePadDao.addNewNote", notePadVO);
	}
	
	@Override
	public int deleteNote(String notePadId) {
		return getSqlSession().delete("notePadDao.deleteNote", notePadId);
	}
	
	@Override
	public int doModifyNote(NotePadVO notePadVO, String notePadId) {
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("notePadId", notePadId);
		parameter.put("content", notePadVO.getContent());
		return getSqlSession().update("notePadDao.doModifyNote",parameter);
	}
}
