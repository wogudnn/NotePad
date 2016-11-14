package com.psy.notepad.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.psy.notepad.service.NotePadService;
import com.psy.notepad.vo.NotePadListVO;
import com.psy.notepad.vo.NotePadVO;

@Controller
public class NotePadController {

	private NotePadService notePadService;

	private Logger logger = LoggerFactory.getLogger(NotePadController.class);
	
	public void setNotePadService(NotePadService notePadService) {
		this.notePadService = notePadService;
	}
	
	@RequestMapping("/list")
	public ModelAndView viewListPage(){
		ModelAndView view = new ModelAndView();
		
		NotePadListVO notePadList = notePadService.getAllNote();
		view.setViewName("list");
		view.addObject("notePadList", notePadList);
		return view;
	}
	
	@RequestMapping("/detail/{notePadId}")
	public ModelAndView viewDetailPage(@PathVariable String notePadId){
		ModelAndView view = new ModelAndView();
		
		NotePadVO noteVO = notePadService.getNoteById(notePadId);
		view.setViewName("list");
		view.addObject("noteVO", noteVO);
		return view;
	}
	
	@RequestMapping("/write")
	public String viewWritePage(){
		return "write";
	}
	
	@RequestMapping(value="/doWrite",method=RequestMethod.POST)
	public ModelAndView doWrite(@Valid NotePadVO notePadVO, Errors errors){
		ModelAndView view = new ModelAndView();
		
		
		if(errors.hasErrors()){
			view.setViewName("write");
		}
		else{
			boolean isSuccess = notePadService.addNewNote(notePadVO);
			view.setViewName("redirect:/list");
		}
		return view;
	}
	
	@RequestMapping("/delete/{notePadId}")
	public ModelAndView deleteNote(@PathVariable String notePadId){
		ModelAndView view = new ModelAndView();
		
		boolean isSuccess = notePadService.deleteNote(notePadId);
		view.setViewName("redirect:/list");
		return view;
	}
	
	@RequestMapping("/modify/{notePadId}")
	public ModelAndView viewModifyPage(@PathVariable String notePadId){
		ModelAndView view = new ModelAndView();
		NotePadVO note = notePadService.getNoteByIdForModify(notePadId);
		view.setViewName("write");
		view.addObject("note", note);
		return view;
	}
	
	@RequestMapping(value="/doModify/{notePadId}",method=RequestMethod.POST)
	public ModelAndView doModifyNote(@Valid NotePadVO notePadVO, Errors errors, @PathVariable String notePadId){
		ModelAndView view = new ModelAndView();
		
		if(errors.hasErrors()){
			view.setViewName("write");
		}
		else{
			boolean isSuccess = notePadService.doModifyNote(notePadVO,notePadId);
			view.setViewName("redirect:/list");
		}
		return view;
		
	}
}
